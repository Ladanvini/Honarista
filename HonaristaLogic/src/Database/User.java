package Database;

import java.sql.*;

import Connection.PostgreSQLJDBC;

public class User {
	//ATTRIBUTES
	private int _id;
	private String _username;
	private String _address;
	private String _phoneNum;
	private Role _role;

	//CONSTRUCTORS
	public User(){
		_id = 0;
		_username = "";
		_phoneNum = "";
		_address = "Iran, ";
		_role = Role.UN_REG_CUSTOMER;
		
	}
	public User(int id, String username, Role role){
		_id = id;
		_username = username;
		_phoneNum = "";
		_address = "Iran, ";
		_role = role;
		
	}
	//GETTERS
	public int getId() { return _id; }
	public String getUserName() { return _username; }
	public String getUserAddress() { return _address; }
	public String getUserPhone() { return _phoneNum; }
	public Role getUserRole() { return _role; }
	//SETTERS
	public void setId(int id) { _id = id; }
	public void setUserName(String username) { _username = username; }
	public void setPhoneNum(String phoneNum) { _phoneNum = phoneNum; }
	public void setRole(Role role) { _role = role; }
	
	
}
