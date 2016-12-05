package Database;

import java.sql.*;

import Connection.PostgreSQLJDBC;

public class User {
	int id;
	String username;
	String address;
	String phoneNum;
	Role role;

	
	public User(){
		id = 0;
		username = "";
		phoneNum = "";
		address = "Iran, ";
		role = Role.UN_REG_CUSTOMER;
	}
	public User(int _id, String _username, Role _role){
		id = _id;
		username = _username;
		phoneNum = "";
		address = "Iran, ";
		role = _role;
		
	}
	public void addUser(Connection db){
		try {
			Statement st = db.createStatement();
			st.executeQuery("");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
