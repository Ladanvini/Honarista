package entity;

import java.util.*;
/*TODO
 * how to set date as current date?
 */
public class Shop {
	//ATTRIBUTES
	private String _shopName;
	private int _id;
	private String _address;
	private String _phoneNum;
	private String _description;
	private Date _regDate;
	
	private Vector<User> _favourites;
	private Vector<User> _owners;
	private Vector<ShoppedAt> _visited;
	private Vector<ShopTag> _tags;
	private Vector<IsSelling> _items;
	
	//CONSTRUCTORS
	public Shop(){
		_shopName = "";
		_id = 0;
		_address = "";
		_phoneNum = "";
		_description = "";
		_regDate = new Date();
		
		_favourites = new Vector<User>();
		_owners = new Vector<User>();
		_visited = new Vector<ShoppedAt>();
		_tags = new Vector<ShopTag>();
		_items = new Vector<IsSelling>();
	}
	public Shop(String sn, int id, String adr, String ph, String d, Date regdate){
		_shopName = sn;
		_id = id;
		_address = adr;
		_phoneNum = ph;
		_description = d;
		_regDate = regdate;
		
		_favourites = new Vector<User>();
		_owners = new Vector<User>();
		_visited = new Vector<ShoppedAt>();
		_tags = new Vector<ShopTag>();
		_items = new Vector<IsSelling>();
	}
	//GETTERS
	public String getName(){
		return _shopName;
	}
	public String getAdress(){
		return _address;
	}
	public String getPhoneNum(){
		return _phoneNum;
	}
	public String getDesc(){
		return _description;
	}
	public int getID(){
		return _id;
	}
	//SETTERS
	public void setName(String name){
		_shopName = name;
	}
	public void setAddress(String adr){
		_address = adr;
	}
	public void setPhone(String n){
		_phoneNum = n;
	}
	public void setDesc(String d){
		_description = d;
	}
	public void setId(int id){
		_id = id;
	}

	public Vector<User> getFavourites() { return _favourites; }
	public void setFavourites(Vector<User> favourites) { _favourites = favourites; }
	public Vector<User> getOwners() { return _owners; }
	public void setOwners(Vector<User> owners) { _owners = owners; }
	public Vector<ShoppedAt> getVisited() { return _visited; }
	public void setVisited(Vector<ShoppedAt> visited) { _visited = visited; }
	public Vector<ShopTag> getTags() { return _tags; }
	public void setTags(Vector<ShopTag> tags) { _tags  = tags; }
	public Vector<IsSelling> getItems() { return _items; }
	public void setItems(Vector<IsSelling> items) { _items = items; }
	public void addToFavourites(User u)
	{
		if(!this._favourites.contains(u))
			_favourites.add(u);
	}
	public void addNewOwner(User u){
		if(!_owners.contains(u))
			_owners.add(u);
	}
	public String toString(){
		String str = "";
		str = str + " SHOPNAME    : " + _shopName;
		str = str + "\n ID          : " + _id;
		str = str + "\n ADDRESS     : " + _address;
		str = str + "\n PHONE       : " + _phoneNum;
		str = str + "\n DESCRIPTION : " + _description;
		str = str + "\n ------------------------------------------------------\n";
		return str;
	}
}
	
	
