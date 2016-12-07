package entity;

public class Owns {
	//ATTRIBUTES
	private User _vendor;
	private Shop _shop;
	
	//TODO
	
	//GETTERS
	public User getUser(){ return _vendor; }
	public Shop getShop(){ return _shop; }
	//SETTERS
	public User setUser(User vendor){ _vendor = vendor; }
	public Shop setShop(Shop shop){ _shop = shop; }
}
