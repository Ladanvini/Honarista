package Service;
import java.sql.*;
import java.util.Date;
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
	ShopService _ss;
	private User u;

	public void setUser(User user) {
		u = user;
	}
	public UserService(){
		_db = new PostgreSQLJDBC();
		con = _db.getConnection(null);
	}
	public User getUser(String username) {
		Vector<User> users = this.getAllUsers();
		for(int i=0; i<users.size(); i++)
		{
			if(users.elementAt(i).getUserName().contains(username))
				return users.elementAt(i);
		}
		return null;
	}
	public String login(String username, String password) {
		String msg = "";
		if(!userExists(username))
			return "username is wrong";
		if(this.getUser(username) == null)
			return "Something went wrong :/";
		u = this.getUser(username);
		if(u != null && 
				!u.getPassword().equals(password)) {
			msg = "Wrong password :/";
			u = null;
		}
		this.setUser(this.getUser(username));
		return msg;
	}
	public int getUserId(String username)
	{
		  Statement stmnt = null;
		  int res = 0;
		  String query = "SELECT id FROM Users " +
	   		"WHERE username = " + username + " ;";
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
				   String pass = rs.getString("pass");
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
				   res = (new User(id, username, pass, fullname, phoneNum, adr, regdate, role));
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
				   String pass = rs.getString("pass");
				   // User(int id, String username, String fullname, String phoneNum, String address, Date regdate, Role role){
				   Role role = Role.UN_REG_CUSTOMER;
				   switch(roleInt){
				   case 0: role = Role.ADMIN;
				   case 1: role = Role.CONTENT_MANAGER;
				   case 3: role = Role.REG_CUSTOMER;
				   case 4: role = Role.UN_REG_CUSTOMER;
				   case 2: role = Role.VENDOR;
				   }
				   res.add(new User(id, username, pass, fullname, phoneNum, adr, regdate, role));
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

	private boolean userExists(String username){
		for(int i=0; i<getAllUsers().size(); i++){
			if(getAllUsers().elementAt(i).getUserName().contains(username))
				return true;
		}
		return false;
	}
	
	public String modifyUserInfo(){ 
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
	public  String deleteUser(){
		if(!userExists(u.getUserName()))
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
	public String editUser(){
		if(!userExists(u.getUserName())){
			return "User not found!";
		}
		if(!isPhoneNumber(u.getUserPhone()))
			return "Please only enter numbers";
		modifyUserInfo();
		return "User Changed successfully";
	}
	public boolean isPhoneNumber(String pn){
		for(int i=0; i<pn.length(); i++){
			if(!Character.isDigit(pn.charAt(i)) )
				return false;
		}
		return true;
	}
	public String createNewUser(String userName, String pass, String fullName, String adr, String phonenum,
			int role){
		if(userExists(userName))
			return "User already exists";
		if(!isPhoneNumber(phonenum))
			return "Please enter numbers";
		
		Statement stmnt = null;
		String query = "INSERT INTO Users" +
				"(username, pass, fullname, adr, phoneNum, userrole)" +
		   		" VALUES ('" + userName + "', '" + pass + "', '"+  fullName + "', " +
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

	public String setLikes(){
		/*
		SELECT * FROM Items I JOIN Liked L ON I.id = L.itemId WHERE L.userId = 2;
		*/
		String msg = "";
		   Statement stmnt = null;
		   Vector<Item> res = new Vector<Item>();
		   String query = "SELECT * FROM Items I JOIN Liked L " +
		   		"ON I.id = L.itemId WHERE L.userId = " + u.getId() +
		   		";";
		   
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
			   u.setLikes(res);
		   }

		   return msg;

	   }
	public String setOwns(){
		String msg = "";
		   Statement stmnt = null;
		   Vector<Shop> res = new Vector<Shop>();
		   String query = "SELECT * FROM Shops S JOIN Owns O " +
		   		"ON S.id = O.shopId " +
		   		"WHERE O.vendorid = " + u.getId() +
		   		" ;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   int id = rs.getInt("id");
				   String shopname = rs.getString("shopname");

				   String adr = rs.getString("adr");
				   String phoneNum = rs.getString("phonenum");
				   String description = rs.getString("description");
				   Date regDate = rs.getDate("regdate");
			   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
				   res.add(new Shop(shopname, id, adr, phoneNum, description, regDate));
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
		   u.setOwns(res);

		
		return msg;
	}
	public String setShops(){
		String msg = "";
		   Statement stmnt = null;
		   Vector<ShoppedAt> res = new Vector<ShoppedAt>();
		   String query = "SELECT * FROM ShoppedAt S " +
		   		"WHERE S.userid = " + u.getId() +
		   		";";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String review = rs.getString("review");
				   int shopId = rs.getInt("shopid");
				   int rate = rs.getInt("rating");
				   // ShoppedAt(Shop shop, User user, String review, int rate){
				   res.add(new ShoppedAt(_ss.getShopWithId(shopId), u, review, rate));
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

		   u.setShops(res);
		  
		return msg;
	}
	public String setFavourites(){
		String msg = "";
		
		   Statement stmnt = null;
		   Vector<Shop> res = new Vector<Shop>();
		   String query = "SELECT * FROM Shops S " +
		   		"JOIN Favourites F " +
		   		"ON S.id = F.shopId " +
		   		"WHERE F.userid = " + u.getId() +
		   		";";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String shopname = rs.getString("shopname");
				   int id = rs.getInt("id");
				   String adr = rs.getString("adr");
				   String phoneNum = rs.getString("phonenum");
				   String description = rs.getString("description");
				   Date regDate = rs.getDate("regdate");
			   // Shop(String sn, int id, String adr, String ph, String d, Date regdate
				   res.add(new Shop(shopname, id, adr, phoneNum, description, regDate));
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
		   u.setFavourites(res);
		
		return msg;
	}

	public String likeAnItem(Item item){
		String msg = "";
		Statement stmnt = null;
		Vector<Item> likes = u.getLikes();
		if(likes.contains(item))
			return "Item has already been liked\n";
		
		likes.add(item);
		u.setLikes(likes);
		
		String query = "INSERT INTO Liked(itemid, userid)" +
				" VALUES (" + item.getID() +
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

	public String addShopToFavourites(Shop s){
		String msg = "";
		Vector<Shop> favourites = u.getFavourites();
		if(favourites.contains(s))
			return "Shop has already been added to your favourites!\n";
		favourites.add(s);
		u.setFavourites(favourites);
		msg = _ss.beFavouredBy(s, u);
		return msg;
	}

	public String startNewShop(Shop s){
		Date regDate = new Date();
		
		String msg = "";
		msg = _ss.createNewShop(s.getName(), s.getAdress(), s.getPhoneNum(), s.getDesc(), regDate);
		msg = msg + _ss.addOwnerTo(s, u);
		
		Vector<Shop> shops = u.getOwns();
		if(shops.contains(s))
			return "Shop is already owned\n";

		shops.add(s);
		u.setOwns(shops);
		
		return msg;
	}

	public String addNewOwner(Shop s){
		String msg = "";
		msg = _ss.addOwnerTo(s, u);
		Vector<Shop> shops = u.getOwns();
		if(shops.contains(s))
			return "Shop is already owned";
		shops.add(s);
		u.setOwns(shops);
		
		return msg;
			
	}

	/*
 * Shop at a shop
 *
*/

}
