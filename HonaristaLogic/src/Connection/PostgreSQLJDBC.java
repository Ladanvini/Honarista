package Connection;

import java.sql.*;
import java.util.*;

import entity.Role;
import entity.User;

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
   * USER ACTIONS
   */
   public User getUserWithId(int id){
	   Statement stmnt = null;
	   User res = new User();
	   String query = "SELECT * FROM Users " +
	   		"WHERE id = " + id + " ;";
	   
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
			   res = (new User(id, username, phoneNum, adr, role));
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
   public Vector<User> getAllUsers(){
	   Vector<User> res = new Vector<User>();
	   Statement stmnt = null;
	   String query = "SELECT * FROM Users;";
	   
	   try{
		   stmnt = con.createStatement();
		   ResultSet rs = stmnt.executeQuery(query);
		   while(rs.next()){
			   String username = rs.getString("username");
			   int id = rs.getInt("id");
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
			   res.add(new User(id, username, phoneNum, adr, role));
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
   public String createNewUser(String userName, String adr, String phonenum, int role){
	   Statement stmnt = null;
	   String query = "INSERT INTO Users" +
	   		"(username, adr, phoneNum, userrole)" +
	   		" VALUES ('" + userName + "', '" + adr + "', '" + phonenum + "', " + role + ");";
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
   public String deleteUser(int userId){
	   Statement stmnt = null;
	   String query;
	   String msg = "";
	   this.addUserToTrash(userId);
	   query = "DELETE FROM Users" +
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
   public String editUser(int id, String userName, String adr, String phonenum, int role){
	   Statement stmnt = null;
	   String query = " UPDATE Users " +
			   " SET username = '" + userName + "'," + 
			   " adr = '"+ adr + "'," +
			   " phonenum = '" + phonenum + "'," +
			   " userrole = " + role +
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
			   res.add(new User(id, username, phoneNum, adr, role));
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
	   User u = this.getUserWithId(userId);
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
			   res = (new User(id, username, phoneNum, adr, role));
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
   //TODO
   public void emptyTrash(){}
   
   /*
    * SHOP ACTIONS 
    */
   
}
