package entity;

public class Item {
	//ATTRIBUTES
	private String _title;
	private int _itemId;
	private String _description;
	//CONSTRUCTORS
	public Item(){
		_title = "";
		_itemId = 0;
		_description = "";
	}
	public Item(int id, String title, String desc){
		_itemId = id;
		_title = title;
		_description = desc;
	}
	//GETTERS
	public String getTitle(){
		return _title;
	}
	public int getID(){
		return _itemId;
	}
	public String getDescription(){
		return _description;
	}
	//SETTERS
	public void setTitle(String title){
		_title = title;
	}
	public void setID(int id){
		_itemId = id;
	}
	public void setDescription(String desc){
		_description = desc;
	}

}
