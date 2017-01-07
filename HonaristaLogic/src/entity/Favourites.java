package entity;

public class Favourites {
	private User _user;
	private Shop _shop;
	
	public Favourites(){
		_user = new User();
		_shop = new Shop();
	}
	public Favourites(User u, Shop s){
		_user = u;
		_shop = s;
	}
	public void setUser(User u){
		_user = u;
	}
	public void setShop(Shop s){
		_shop = s;
	}
	public User getUser(){
		return _user;
	}
	public Shop getShop(){
		return _shop;
	}
}
