package entity;

public class Owns {
	//ATTRIBUTES
	private User _vendor;
	private Shop _shop;
	
	//CONSTRUCTORS
	public Owns(){
		_vendor = null;
		_shop = null;
	}
	public Owns(){
		_vendor = vendor;
		_shop = shop;
	}
	
	//GETTERS
	public User getUser(){ return _vendor; }
	public Shop getShop(){ return _shop; }
	
	//SETTERS
	public User setUser(User vendor){ _vendor = vendor; }
	public Shop setShop(Shop shop){ _shop = shop; }
}
