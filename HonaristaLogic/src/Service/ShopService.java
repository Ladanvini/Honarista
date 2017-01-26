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
	public ShopService(){
		_db = new PostgreSQLJDBC();
		con = _db.getConnection(null);
	}
	   /*
	    * SHOP ACTIONS 
	    */
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
				   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
				   res.add(new Shop(shopname, id, adr, phoneNum, description, regdate));
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
	private Vector<ShoppedAt> _visited;
	private Vector<ShopTag> _tags;
	private Vector<Item> _items;
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
					   res.add(new User(id, username, fullname, phoneNum, adr, regdate, role));
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
					   res.add(new User(id, username, fullname, phoneNum, adr, regdate, role));
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
}
