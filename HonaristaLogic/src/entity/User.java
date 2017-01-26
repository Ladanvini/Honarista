package entity;

import java.util.*;

public class User {
	//ATTRIBUTES
	private int _id;
	private String _username;
	private String _fullname;
	private String _address;
	private String _phoneNum;
	private Date _regdate;
	private Role _role;
	
	private Vector<Item> _liked;
	private Vector<Shop> _owns;
	Vector<ShoppedAt> _shops;
	private Vector<Shop> _favourites;

	
	//CONSTRUCTORS
	public User(){
		_id = 0;
		_username = "";
		_fullname = "";
		_phoneNum = "";
		_address = "Iran, ";
		_regdate = new Date();
		_role = Role.UN_REG_CUSTOMER;
		
		_owns = new Vector<Shop>();
		_shops = new Vector<ShoppedAt>();
		_favourites = new Vector<Shop>();
		_liked = new Vector<Item>();
		
	}
	public User(int id, String username, String fullname, String phoneNum, String address, Date regdate, Role role){
		_id = id;
		_username = username;
		_fullname = fullname;
		_phoneNum = phoneNum;
		_address = "Iran, " + address;
		_regdate = regdate;
		_role = role;
		
		_owns = new Vector<Shop>();
		_shops = new Vector<ShoppedAt>();
		_favourites = new Vector<Shop>();
		_liked = new Vector<Item>();
		
	}
	//GETTERS
	public int getId() { return _id; }
	public String getUserName() { return _username; }
	public String getFullName() { return _fullname; }
	public String getUserAddress() { return _address; }
	public String getUserPhone() { return _phoneNum; }
	public Date getRegDate() { return _regdate; }
	public Role getUserRole() { return _role; }
	public int getRoleInt() {
		if(_role == Role.ADMIN)
			return 0;
		else if(_role == Role.CONTENT_MANAGER)
			return 1;
		else if(_role == Role.REG_CUSTOMER)
			return 3;
		else if(_role == Role.VENDOR)
			return 2;
		return 4;

		
	}
	
	public Vector<Shop> getOwns(){ return _owns; }
	public Vector<Shop> getFavourites() { return _favourites; }
	public Vector<Item> getLikes() { return _liked; }
	//SETTERS
	public void setId(int id) { _id = id; }
	public void setUserName(String username) { _username = username; }
	public void setFullName(String fullname) { _fullname = fullname; }
	public void setPhoneNum(String phoneNum) { _phoneNum = phoneNum; }
	public void setRegDate(Date regdate) { _regdate = regdate; }
	public void setRole(Role role) { _role = role; }
	
	public void setOwns(Vector<Shop> owns) { _owns = owns; }
	public void setFavourites(Vector<Shop> favourites) { _favourites = favourites; }
	public void setLikes(Vector<Item> likes) { _liked = likes; }
	public void setShops(Vector<ShoppedAt> shops) { _shops = shops; }
	public String toString(){
		String res = "";
		res = res + "Name: " + _username + '\n';
		res = res + "Full Name: " + _fullname + '\n';

		return res;
	}
	
}
