package Service;
import entity.*;

import java.sql.*;
import java.util.*;
import java.util.Date;

import Connection.PostgreSQLJDBC;
public class ShopService {
	private PostgreSQLJDBC _db;
	private Connection con;
	private UserService _us;
	private ItemService _is;
	public ShopService(UserService us){
		_db = new PostgreSQLJDBC();
		con = _db.getConnection(null);
		_us = us;
	}
	   /*
	    * SHOP ACTIONS 
	    */
	   public int getShopId(String title) {
		   
		   Statement stmnt = null;
		   int res = 0;
		   String query = "SELECT id FROM Shops " +
		   		"WHERE shopname = '" + title + "' ;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   res = rs.getInt("id");
			   }
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
			   System.err.println(e.getStackTrace());
		   } finally {
			   if(stmnt != null)
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }

		   return res;

	   }
	   public Shop getShopWithId(int id){
		   Statement stmnt = null;
		   Shop res = new Shop();
		   String query = "SELECT * FROM Shops " +
		   		"WHERE id = " + id + " ;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String shopname = rs.getString("shopname");

				   String adr = rs.getString("adr");
				   String phoneNum = rs.getString("phonenum");
				   String description = rs.getString("description");
				   Date regDate = rs.getDate("regdate");
			   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
				   res = (new Shop(shopname, id, adr, phoneNum, description, regDate));
			   }
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
			   System.err.println(e.getStackTrace());
		   } finally {
			   if(stmnt != null)
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }

		   return res;

	   }
	   public Vector<Shop> getAllShops(){
		   Vector<Shop> res = new Vector<Shop>();
		   Statement stmnt = null;
		   String query = "SELECT * FROM Shops;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String shopname = rs.getString("shopname");
				   int id = rs.getInt("id");
				   String adr = rs.getString("adr");
				   String phoneNum = rs.getString("phonenum");
				   Date regdate = rs.getDate("regdate");
				   String description = rs.getString("description");
				   Shop newS =new Shop(shopname, id, adr, phoneNum, description, regdate); 
				   this.setFavourites(newS);
				   this.setItems(newS);
				   this.setOwners(newS);
				   this.setVisited(newS);
				   res.add(newS);
			   }
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
			   System.err.println(e.getStackTrace());
		   } finally {
			   if(stmnt != null)
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   return res;
	   }
	   public String createNewShop(String shopName, String adr, String phonenum, String desc, Date regdate){
		   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
		   Statement stmnt = null;
		   String query = "INSERT INTO Shops" +
		   		"(shopname, adr, phoneNum, description)" +
		   		" VALUES ('" + shopName + "', '" +  adr + "', " +
		   		"'" + phonenum + "', '" + desc + "');";
		   String msg = "0";

			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
			}

		return msg;	   
	   }
	   public String deleteShop(int userId){
		   Statement stmnt = null;
		   String query;
		   String msg = "";
		  // this.addUserToTrash(userId);
		   query = "DELETE FROM Shops" +
		   		" WHERE id = " + userId + " ;";
		   
			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
			}
		return msg;	   

	   }
	   public String editShop(int id, String shopName, String adr, String phonenum, String description){
		   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
		   Statement stmnt = null;
		   String query = " UPDATE Shops " +
				   " SET shopname = '" + shopName + "'," + 
				   " adr = '"+ adr + "'," +
				   " phonenum = '" + phonenum + "'," +
				   " description = '" + description + "'  " +
				   " WHERE id = " + id + " ; ";

		   String msg = "0";

			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
				e.printStackTrace();
			}
		return msg;	   

	   }
/*
	private Vector<ShopTag> _tags;

 */
	   public String setFavourites(Shop s){
			String msg = "";
			
			   Statement stmnt = null;
			   Vector<User> res = new Vector<User>();
			   String query = "SELECT * FROM Users U " +
			   		"JOIN Favourites F " +
			   		"ON U.id = F.userId " +
			   		"WHERE F.shopid = " + s.getID() +
			   		";";
			   
			   try{
				   stmnt = con.createStatement();
				   ResultSet rs = stmnt.executeQuery(query);
				   while(rs.next()){
					   String username = rs.getString("username");
					   String fullname = rs.getString("fullname");
					   int id = rs.getInt("id");
					   String adr = rs.getString("adr");
					   String phoneNum = rs.getString("phonenum");
					   Date regdate = rs.getDate("regdate");
					   int roleInt = rs.getInt("userrole");
					   // User(int id, String username, String fullname, String phoneNum, String address, Date regdate, Role role){
					   Role role = Role.UN_REG_CUSTOMER;
					   switch(roleInt){
					   case 0: role = Role.ADMIN;
					   case 1: role = Role.CONTENT_MANAGER;
					   case 3: role = Role.REG_CUSTOMER;
					   case 4: role = Role.UN_REG_CUSTOMER;
					   case 2: role = Role.VENDOR;
					   }
					   res.add(new User(id, username, "", fullname, phoneNum, adr, regdate, role));
				   }
			   }catch(SQLException e){
				   msg = msg + (e.getMessage());
				   msg = msg + (e.getStackTrace());
			   } finally {
				   if(stmnt != null)
					try {
						stmnt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						msg = msg + e.getStackTrace();
					}
			   }
			   s.setFavourites(res);
			return msg;

	   }
	   public Shop getShop(String shopName){
		   Vector<Shop> shops = this.getAllShops();
		   
		   for(int i=0; i<shops.size(); i++)
		   {
			   if(shops.elementAt(i).getName().equals(shopName)) 
			   {
				   return shops.elementAt(i);
			   }
	   		}

		   return null;
	   }
	   
	   public String setOwners(Shop s){
			String msg = "";
			   Statement stmnt = null;
			   Vector<User> res = new Vector<User>();
			   String query = "SELECT * FROM Users U JOIN Owns O " +
			   		"ON U.id = O.vendorId " +
			   		"WHERE O.shopid = " + s.getID() +
			   		" ;";
			   
			   try{
				   stmnt = con.createStatement();
				   ResultSet rs = stmnt.executeQuery(query);
				   while(rs.next()){
					   String username = rs.getString("username");
					   String fullname = rs.getString("fullname");
					   int id = rs.getInt("id");
					   String adr = rs.getString("adr");
					   String phoneNum = rs.getString("phonenum");
					   Date regdate = rs.getDate("regdate");
					   int roleInt = rs.getInt("userrole");
					   // User(int id, String username, String fullname, String phoneNum, String address, Date regdate, Role role){
					   Role role = Role.UN_REG_CUSTOMER;
					   switch(roleInt){
					   case 0: role = Role.ADMIN;
					   case 1: role = Role.CONTENT_MANAGER;
					   case 3: role = Role.REG_CUSTOMER;
					   case 4: role = Role.UN_REG_CUSTOMER;
					   case 2: role = Role.VENDOR;
					   }
					   res.add(new User(id, username, "", fullname, phoneNum, adr, regdate, role));
				   }
			   }catch(SQLException e){
				   msg = msg + (e.getMessage());
				   msg = msg + (e.getStackTrace());
			   } finally {
				   if(stmnt != null)
					try {
						stmnt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						msg = msg + e.getStackTrace();
					}
			   }
			   s.setOwners(res);

			
			return msg;

		   
	   }
	   public String setVisited(Shop s){
			String msg = "";
			   Statement stmnt = null;
			   Vector<ShoppedAt> res = new Vector<ShoppedAt>();
			   String query = "SELECT * FROM ShoppedAt S " +
			   		"WHERE S.shopid = " + s.getID() +
			   		";";
			   
			   try{
				   stmnt = con.createStatement();
				   ResultSet rs = stmnt.executeQuery(query);
				   while(rs.next()){
					   String review = rs.getString("review");
					   int userid = rs.getInt("userid");
					   int rate = rs.getInt("rating");
					   // ShoppedAt(Shop shop, User user, String review, int rate){
					   res.add(new ShoppedAt( s, _us.getUserFromId(userid), review, rate));
				   }
			   }catch(SQLException e){
				   msg = msg + (e.getMessage());
				   msg = msg + (e.getStackTrace());
			   } finally {
				   if(stmnt != null)
					try {
						stmnt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						msg = msg + e.getStackTrace();
					}
			   }

			  s.setVisited(res);
			  
			return msg;

	   }
	   public String setItems(Shop s){
			String msg = "";
			   Statement stmnt = null;
			   Vector<IsSelling> res = new Vector<IsSelling>();
			   String query = "SELECT * FROM IsSelling I " +
			   		"WHERE I.shopId = " + s.getID() +
			   		";";
			   
			   try{
				   stmnt = con.createStatement();
				   ResultSet rs = stmnt.executeQuery(query);
				   while(rs.next()){
					   int shopid = rs.getInt("shopid");
					   int itemid = rs.getInt("itemid");
					   int count = rs.getInt("count");
					   //IsSelling(Shop shop, Item item, int count)
					   res.add(new IsSelling(this.getShopWithId(shopid), _is.getItemWithId(itemid), count));
				   }
			   }catch(SQLException e){
				   msg = msg + (e.getMessage());
				   msg = msg + (e.getStackTrace());
			   } finally {
				   if(stmnt != null)
					try {
						stmnt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						msg = msg + e.getStackTrace();
					}
			   }
			   if(!res.isEmpty()){
				   s.setItems(res);
			   }

			   return msg;


	   }

	   public Vector<Item> getItemsIn(Shop s){
		   setItems(s);
		   Vector<IsSelling> temp = s.getItems();
		   Vector<Item> res = new Vector<Item>();
		   for(int i=0; i<temp.size(); i++){
			   res.add(temp.elementAt(i).getItem());
		   }
		   return res;
	   }
	   
	   public String beFavouredBy(Shop s, User u){
		   String msg = "";
		   s.addToFavourites(u);
					
		   Statement stmnt = null;
		
		   String query = "INSERT INTO Favourites(shopid, userid)" +
		   		" VALUES (" + s.getID() +
		   		", " + u.getId() +
		   		");";
			   
		   try {
			stmnt = con.createStatement();
			stmnt.executeQuery(query);
		   } catch (SQLException e) {
			msg = msg + e.getLocalizedMessage();
			msg = msg + "\n" + e.getStackTrace();
		}
		 			

		   return msg;
	   }
//NOT USED ANUMORE 	   
	   public String addOwnerTo(Shop s, User u){
		   s.addNewOwner(u);
		   System.out.println("HEEEEEEEEEEEEEREEE");
		   String msg = "";
					
		   Statement stmnt = null;
		
		   String query = "INSERT INTO Owns(shopid, vendorid)" +
		   		" VALUES (" + s.getID() +
		   		", " + u.getId() +
		   		");";
			   
		   try {
			stmnt = con.createStatement();
			stmnt.executeQuery(query);
		   } catch (SQLException e) {
			msg = msg + e.getLocalizedMessage();
			msg = msg + "\n" + e.getStackTrace();
		}
		   
		   return msg;
	   }

	   public String isVisited(Shop s, User u, int rating, String review){
		   ShoppedAt sa = new ShoppedAt(s, u, review, rating);
		   Vector<ShoppedAt> sv = s.getVisited();
		   sv.add(sa);
		   s.setVisited(sv);

		   String msg = "";
					
		   Statement stmnt = null;

		   String query = "INSERT INTO ShoppedAt(shopid, userid, rating, review)" +
		   		" VALUES (" + s.getID() +
		   		", " + u.getId() +
		   		", " + rating +
		   		", '" + review +
		   		"');";
			   
		   try {
			stmnt = con.createStatement();
			stmnt.executeQuery(query);
		   } catch (SQLException e) {
			msg = msg + e.getLocalizedMessage();
			msg = msg + "\n" + e.getStackTrace();
		}
		   
		   return msg;
   
		   
	   }
	   
	   public String addItemTo(Shop s, Item item){
		   String msg = "";
		   Vector<IsSelling> selling = s.getItems();
		   int count = 1;
		   for(int i=0; i<selling.size(); i++){
			   if(selling.elementAt(i).getItem().equals(item)){
				   count = selling.elementAt(i).getCount() + 1;
				   selling.elementAt(i).setCount(count);
				   Statement stmnt = null;					
				   String query = "UPDATE isSelling " +
				   		"SET count = " + count + " " +
				   				"WHERE itemid = " + item.getID() + ";";
				   try {
						stmnt = con.createStatement();
						stmnt.executeQuery(query);
					   } catch (SQLException e) {
						msg = msg + e.getLocalizedMessage();
						msg = msg + "\n" + e.getStackTrace();
					}
					   
					   return msg;
			   }
		   }

			
		   Statement stmnt = null;
		
		   String query = "INSERT INTO isSelling(count, shopid, itemid)" +
		   		" VALUES (" + count + ", " + s.getID() +
		   		", " + item.getID() +
		   		");";
			   
		   try {
			stmnt = con.createStatement();
			stmnt.executeQuery(query);
		   } catch (SQLException e) {
			msg = msg + e.getLocalizedMessage();
			msg = msg + "\n" + e.getStackTrace();
		}
		   
		   return msg;

	   }
	  
}
