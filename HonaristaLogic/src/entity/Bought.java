package entity;

public class Bought {
	//ATTRIBUTES
	private String _review;
	private Item _item;
	private User _user;
	//CONSTRUCTORS
	public Bought() {
		_review = "";
		_item = null;
		_user = null;
	}
	public Bought(Item item, User user, String review){
		_item = item;
		_user = user;
		_review = review;
	}
	//GETTERS
	public String getReview() { return _review; }
	public Item getItem() { return _item; }
	public User getUser() { return _user; }
	
	//SETTERS
	public void setReview(String review){
		_review = review;
	}
	public void setItem(Item item){
		_item = item;
	}
	public void setUser(User user){
		_user = user;
	}
}
