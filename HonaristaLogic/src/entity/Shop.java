package entity;

public class Shop {
	//ATTRIBUTES
	private String _shopName;
	private int _id;
	private String _address;
	private String _phoneNum;
	private String _description;
	
	//CONSTRUCTORS
	public Shop(){
		_shopName = "";
		_id = 0;
		_address = "";
		_phoneNum = "";
		_description = "";
	}
	public Shop(String sn, int id, String adr, String ph, String d){
		_shopName = sn;
		_id = id;
		_address = adr;
		_phoneNum = ph;
		_description = d;

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
	

}