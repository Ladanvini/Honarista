package entity;

public class ShoppedAt {
	//ATTRIBUTES
	private Shop _shop;
	private User _user;
	private String _review;
	private int _rate;
	
	//CONSTRUCTORS
	public ShoppedAt(){
		_shop = new Shop();
		_user = new User();
		_review = "";
		_rate = 0;
	}
	public ShoppedAt(Shop shop, User user, String review, int rate){
		_shop = shop;
		_user = user;
		_review = review;
		_rate = rate;
	}

	//GETTERS
	public Shop getShop() { return _shop; }
	public User getUser() { return _user; }
	public String getReview() { return _review; }
	public int getRating() { return _rate; }
	
	//SETTERS
	public void setShop(Shop s){
		_shop = s;
	}
	public void setUser(User u){
		_user = u;
	}
	public void setReview(String r){
		_review  = r;
	}
	public void setRate(int rate){
		_rate = rate;
	}
		
}
