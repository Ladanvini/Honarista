package entity;
/*
 * shop can have multiple owners
 */
public class Owns {
	//Attributes
	private User _vendor;
	private Shop _shop;

	//Constructors
	public Owns(){
		//_vendor = new User(0, "", Role.VENDOR);
		_shop = new Shop();
	}
	public Owns(User vendor, Shop shop){
		_vendor = vendor;
		_shop = shop;
	}
	public Owns(int vId, int sId){
		_vendor.setId(vId);
		_shop.setId(sId);
	}
	//Getters
	public User getUser() { return _vendor; }
	public Shop getShop() { return _shop; }
	//Setters
	public void setUser(User u){
		_vendor = u;
	}
	public void setShop(Shop s){
		_shop = s;
	}
}
