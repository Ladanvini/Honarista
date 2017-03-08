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
			   String pass = rs.getString("pass");
			   String fullname = rs.getString("fullname");
			   // User(int id, String username, String phoneNum, String address, Role role){
			   Role role = Role.UN_REG_CUSTOMER;
			   switch(roleInt){
			   case 0: role = Role.ADMIN;
			   case 1: role = Role.CONTENT_MANAGER;
			   case 2: role = Role.REG_CUSTOMER;
			   case 3: role = Role.UN_REG_CUSTOMER;
			   case 4: role = Role.VENDOR;
			   }
			   res.add(new User(id, username, pass, fullname, phoneNum, adr, new Date(), role));
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
			   String fullname = rs.getString("fullname");
			   String pass = rs.getString("pass");
			   Role role = Role.UN_REG_CUSTOMER;
			   switch(roleInt){
			   case 0: role = Role.ADMIN;
			   case 1: role = Role.CONTENT_MANAGER;
			   case 2: role = Role.REG_CUSTOMER;
			   case 3: role = Role.UN_REG_CUSTOMER;
			   case 4: role = Role.VENDOR;
			   }
			   res = (new User(id, username, pass, fullname, phoneNum, adr, new Date(), role));
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
   

   
}
