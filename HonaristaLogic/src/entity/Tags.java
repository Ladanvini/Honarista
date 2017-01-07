package entity;
/*
 * ADD A SHOP TAG
 * registered tags (?)
 */
public class Tags {
	//ATTRIBUTES
	private String _category;
	private Item _item;
	
	//CONSTRUCTORS
	public Tags(){
		_category = "";
		_item = new Item();
	}
	public Tags(Item item, String category){
		_item = item;
		_category = category;
	}
	//GETTERS
	public String getCategory(){
		return _category;
	}
	public Item getItem(){
		return _item;
	}
	
	//SETTERS
	public void setCategory(String c){
		_category = c;
	}
	public void setItem(Item i){
		_item = i;
	}
}
