package entity;

public class ShoppedAt {
	//ATTRIBUTES
	private Shop _shop;
	private User _user;
	private String _review;
	
	//CONSTRUCTERS
	public ShoppedAt(){
		_shop = null;
		_user = null;
		_review = "";
	}
	public ShoppedAt(Shop shop, User user, String review){
		_shop = shop;
		_user = user;
		_review = review;
	}
	
	//GETTERS
	public Shop getShop() {	return _shop; }
	public User getUser() { return _user; }
	public String getReview() {	return _review;	}
	
	//SETTERS
	public void setShop(Shop shop){ _shop = shop; }
	public void setUser(User user){ _user = user; }
	public void setReview(String review){ _review = review; }

}
