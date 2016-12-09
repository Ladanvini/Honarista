package entity;

public class Tags {
	//ATTRIBUTES
	private String _category;
	private Item _item;
	
	//CONSTRUCTORS
	public Tags(){
		_category = "";
		_item = null;
	}
	public Tags(String category, Item item){
		_category = category;
		_item =  item;
	}
	
	//GETTERS
	public String category(){ return _category; }
	public Item getItem(){ return _item; }
	
	//SETTERS
	public setCategory(String category){ _category = category; }
	public setItem(Item item){ _item = item; }

}
