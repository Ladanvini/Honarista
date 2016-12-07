package Connection;
import java.sql.*;

import Database.User;
public class UserDB {
	Connection _db;
	
	public UserDB(Connection db){
		_db = db;
	}
	public void addUser(User u){
		try {
			Statement st = _db.createStatement();
			st.executeQuery("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void deleteUser(User u){
		
	}
	public void editUser(User u){
		
	}
	

}
