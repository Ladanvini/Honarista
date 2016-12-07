package entity;

public class Liked {
	//ATTRIBUTES
	private Item _item;
	private User _user;
	
	//CONSTRUCTORS
	public Liked(){
		_item = null;
		_user = null;
	}
	public Liked(User user, Item item){
		_item = item;
		_user = user;
	}
	//GETTERS
	public Item getItem() {
		return _item;
	}
	public User getUser(){
		return _user;
	}
	//SETTERS
	public void setItem(Item i){
		_item = i;
	}
	public void setUser(User u){
		_user = u;
	}

}
