package Connection;

import java.sql.*;
import java.util.*;
import java.util.Date;

import Service.UserService;

import entity.*;


public class PostgreSQLJDBC {
	Connection con;
   public Connection getConnection(String args[]) {
      con = null;
      try {
         Class.forName("org.postgresql.Driver");
         con = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/Honarista",
            "postgres", "Hamra13hlid");
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return con;
   }
/*
 * USER TRASH ACTIONS
 */
   public Vector<User> getAllUsersTrash(){
	   Vector<User> res = new Vector<User>();
	   Statement stmnt = null;
	   String query = "SELECT * FROM UsersTrash;";
	   
	   try{
		   stmnt = con.createStatement();
		   ResultSet rs = stmnt.executeQuery(query);
		   while(rs.next()){
			   String username = rs.getString("tusername");
			   int id = rs.getInt("tid");
			   String adr = rs.getString("tadr");
			   String phoneNum = rs.getString("tphonenum");
			   int roleInt = rs.getInt("tuserrole");
			   // User(int id, String username, String phoneNum, String address, Role role){
			   Role role = Role.UN_REG_CUSTOMER;
			   switch(roleInt){
			   case 0: role = Role.ADMIN;
			   case 1: role = Role.CONTENT_MANAGER;
			   case 2: role = Role.REG_CUSTOMER;
			   case 3: role = Role.UN_REG_CUSTOMER;
			   case 4: role = Role.VENDOR;
			   }
			   res.add(new User(id, username, "", phoneNum, adr, new Date(), role));
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
   public String addUserToTrash(int userId){
	   Statement stmnt = null;
	   String query;
	   String msg = "";
	   //FIX ..
	   User u = new User();
	   if(u != null)
	   {
		   query = "INSERT INTO UsersTrash" +
	   		"(tid, tusername, tadr, tphoneNum, tuserrole)" +
	   		" VALUES ("+ userId + ", '" + u.getUserName() + "', '" + u.getUserAddress() + "', '" + u.getUserPhone() + "', " + u.getUserRole().hashCode() + ");";
		   msg = "0";
		
			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
			
			}
	   }
	   return msg;
   }
   public User getTrashUserWithId(int id){
	   Statement stmnt = null;
	   User res = new User();
	   String query = "SELECT * FROM UsersTrash " +
	   		"WHERE tid = " + id + " ;";
	   
	   try{
		   stmnt = con.createStatement();
		   ResultSet rs = stmnt.executeQuery(query);
		   while(rs.next()){
			   String username = rs.getString("username");

			   String adr = rs.getString("adr");
			   String phoneNum = rs.getString("phonenum");
			   int roleInt = rs.getInt("userrole");
			   // User(int id, String username, String phoneNum, String address, Role role){
			   Role role = Role.UN_REG_CUSTOMER;
			   switch(roleInt){
			   case 0: role = Role.ADMIN;
			   case 1: role = Role.CONTENT_MANAGER;
			   case 2: role = Role.REG_CUSTOMER;
			   case 3: role = Role.UN_REG_CUSTOMER;
			   case 4: role = Role.VENDOR;
			   }
			   res = (new User(id, username, "", phoneNum, adr, new Date(), role));
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
   public String deleteUserFromTrash(int userId){
	   Statement stmnt = null;
	   String query;
	   String msg = "";
	   this.addUserToTrash(userId);
	   query = "DELETE FROM UsersTrash" +
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
   public void emptyTrash(){
	   //DELETE FROM UsersTrash;
	   Statement stmnt = null;
	   String query;
	   String msg = "";
	    query = "DELETE FROM UsersTrash;";
	   
		   try {
			   stmnt = con.createStatement();
			   stmnt.executeQuery(query);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			msg = e.getStackTrace().toString();
		}   
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
	   this.addUserToTrash(userId);
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
 * ITEM ACTIONS
 */
   public Item getItemWithId(int id){
	   Statement stmnt = null;
	   Item res = new Item();
	   String query = "SELECT * FROM Items " +
	   		"WHERE id = " + id + " ;";
	   
	   try{
		   stmnt = con.createStatement();
		   ResultSet rs = stmnt.executeQuery(query);
		   while(rs.next()){
			   String title = rs.getString("title");
			   String description = rs.getString("description");
			   //Item(int id, String title, String desc)
			   res = (new Item(id, title, description));
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
   public Vector<Item> getAllItems(){
	   Vector<Item> res = new Vector<Item>();
	   Statement stmnt = null;
	   String query = "SELECT * FROM Items;";
	   
	   try{
		   stmnt = con.createStatement();
		   ResultSet rs = stmnt.executeQuery(query);
		   while(rs.next()){
			   int id = rs.getInt("id");
			   String title = rs.getString("title");
			   String description = rs.getString("description");
			   //Item(int id, String title, String desc)
			   res.add(new Item(id, title, description));
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
   public String createNewItem(String title, String description){
	   // Item(int id, String title, String desc)
	   Statement stmnt = null;
	   String query = "INSERT INTO Items" +
	   		"(title, description)" +
	   		" VALUES ('" + title + "', '" +  description + "');";
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
   public String deleteItem(int itemId){
	   Statement stmnt = null;
	   String query;
	   String msg = "";
	   this.addUserToTrash(itemId);
	   query = "DELETE FROM Items" +
	   		" WHERE id = " + itemId + " ;";
	   
		   try {
			   stmnt = con.createStatement();
			   stmnt.executeQuery(query);
		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			msg = e.getStackTrace().toString();
		}
	return msg;	   

   }
   public String editItem(int id, String title, String description){
	   // Item(int id, String title, String desc)
	   Statement stmnt = null;
	   String query = " UPDATE Items " +
			   " SET title = '" + title + "'," + 
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
   
}
