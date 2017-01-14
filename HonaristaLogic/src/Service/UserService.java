package Service;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import Connection.*;
import entity.*;
/* TODO UNMASMALIZE
 * EXCEPTION HANDLING	
 * REG DATE STUFF! 
 */
public class UserService {
	private PostgreSQLJDBC _db;
	private Connection con;

	public UserService(){
		_db = new PostgreSQLJDBC();
		con = _db.getConnection(null);
	}
	public User getUserFromId(int id){
		  Statement stmnt = null;
		  User res = new User();
		  String query = "SELECT * FROM Users " +
	   		"WHERE id = " + id + " ;";
		  try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String username = rs.getString("username");
				   String fullname = rs.getString("fullname");
				   String adr = rs.getString("adr");
				   String phoneNum = rs.getString("phonenum");
				   Date regdate = rs.getDate("regdate");
				   int roleInt = rs.getInt("userrole");
				   
				   Role role = Role.UN_REG_CUSTOMER;
				   switch(roleInt){
				   case 0: role = Role.ADMIN;
				   case 1: role = Role.CONTENT_MANAGER;
				   case 3: role = Role.REG_CUSTOMER;
				   case 4: role = Role.UN_REG_CUSTOMER;
				   case 2: role = Role.VENDOR;
				   }
				   //User(int id, String username, String fullname, String phoneNum, String address, Date regdate, Role role){
				   res = (new User(id, username, fullname, phoneNum, adr, regdate, role));
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

	private boolean userExists(User u){
		for(int i=0; i<getAllUsers().size(); i++){
			if(getAllUsers().elementAt(i).getId() == u.getId()
					|| getAllUsers().elementAt(i).getUserName() == u.getUserName())
				return true;
		}
		return false;
	}
	public String modifyUserInfo(User u){ 
		int id = u.getId();
		String userName = u.getUserName();
		String fullName = u.getFullName();
		String adr = u.getUserAddress();
		String phonenum = u.getUserPhone();
		int role = u.getRoleInt();
		
		   Statement stmnt = null;
		   String query = " UPDATE Users " +
				   " SET username = '" + userName + "'," + 
				   " fullname = '" + fullName + "', " +
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
	public  String deleteUser(User u){
		if(!userExists(u))
			return "User not found\n";

		int userId = u.getId();
		Statement stmnt = null;
		String query;
		String msg = "";
		_db.addUserToTrash(userId);
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
	public String editUser(User u){
		if(!userExists(u)){
			return "User not found!";
		}
		if(!isPhoneNumber(u.getUserPhone()))
			return "Please only enter numbers";
		modifyUserInfo(u);
		return "User Changed successfully";
	}
	public boolean isPhoneNumber(String pn){
		for(int i=0; i<pn.length(); i++){
			if(!Character.isDigit(pn.charAt(i)) )
				return false;
		}
		return true;
	}
	public String createNewUser(User u){
		if(userExists(u))
			return "User already exists";
		if(!isPhoneNumber(u.getUserPhone()))
			return "Please enter numbers";
		
		String userName = u.getUserName();
		String fullName = u.getFullName();
		String adr = u.getUserAddress();
		String phonenum = u.getUserPhone();
		int role = u.getRoleInt();
		
		Statement stmnt = null;
		String query = "INSERT INTO Users" +
				"(username, fullname, adr, phoneNum, userrole)" +
		   		" VALUES ('" + userName + "', '" +  fullName + "', " +
		   		"'" + adr + "', '" + phonenum + "', " + role + ");";
		String msg = "User created successfully\n";
		
	   try {
		   stmnt = con.createStatement();
		   stmnt.executeQuery(query);
	   } catch (SQLException e) {
				// TODO Auto-generated catch block
		   msg = e.getStackTrace().toString();
	   }
		
		return msg;	   

	}

}
