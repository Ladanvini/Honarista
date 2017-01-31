import java.util.Vector;

import entity.*;
import Service.*;


public class Test {

	private UserService us;
	private ShopService _ss;

	public Test(){
		us = new UserService();
		_ss = new ShopService();
	}

	public boolean testGetUserFromId(){
		User u = us.getUserFromId(7);
		System.out.println(u.toString());
		return true;
	}
	public boolean testGetAllUsers(){
		for(int i=0; i<us.getAllUsers().size(); i++){
			System.out.println(us.getAllUsers().elementAt(i).toString());
		}
		return true;
	}
	public boolean testgetShopWithId(int x){
	//getShopWithId(int) : Shop
		System.out.println(_ss.getShopWithId(x).toString());

		return true;
	}
	public boolean testcreateNewShop (){
		System.out.println(_ss.createNewShop("Banana", "101 Rvk", "1234567", "This shop is "
				+ "delicious and yellow. They are banana!"
				+ "I was made specifically for the purpose of testing this system", null));
		System.out.println(_ss.createNewShop(null, null, null, null, null));//Creating Null shop
		System.out.println(_ss.createNewShop("Apple", "101 Rvk", "1234567", "This shop tastes funny"
				, null));
		System.out.println(_ss.createNewShop("Paintings", "303 Island", "Nine", "Selling paintings"
				+" I need to test more things out!", null));
		System.out.println(_ss.createNewShop("Fishy", "The sea", "Blub", "All things related to "+
				"FISH", null));
		return true;

		//Keeps incrementing the ID(think it tried to create them all, didnt create those that
		//already existed but kept incimenting the ID
		//cant dublicate shop named Null
	}

	public boolean testgetAllShops(){
	//getAllShops()
		Vector<Shop> shops = _ss.getAllShops();
		for(int i=0; i<shops.size(); i++)
			System.out.println(shops.elementAt(i).toString());
		return true;
	}

	public boolean testdeleteShop(int x){
		System.out.println(_ss.deleteShop(x));
		//Should it update the ID list? Deleted correct otherwise
		//The ID list is still incrementing
		return true;
	}
	public boolean testeditShop(){
		//_ss.editShop(9, "Paintings R Us", "Somewhere", "Nine", "Indi painters selling their works!");
		_ss.editShop(75, "Test2000", "new place", "Trials", "New editline");
		_ss.editShop(77, "Test2000", "new place", "Trials", "New editline");
		//Didnt manage to create a random shop here :D !!
		//Didnt dublicate based on names
		//Disorginizes the list, puts the edited in the front if calling getAllShops
		return true;
	}
	public boolean testbeFavouredBy(){
		System.out.println(_ss.beFavouredBy(_ss.getShopWithId(4), us.getUserFromId(0)));
		return true;
	}
	public boolean testsetFavourites(){
		Shop s = _ss.getShopWithId(1);
		_ss.setFavourites(s);
		Vector<User> users = s.getFavourites();
		for(int i=0; i<users.size(); i++)
			System.out.println(users.elementAt(i).toString());
		return true;
	}

	public boolean testaddOwnerTo(){
		return true;
	}
	public boolean testisVisited(){
		return true;
	}
	public boolean testaddItemTo(){
		return true;
	}

	public boolean testsetOwners(){
		return true;
	}
	public boolean testsetVisited(){
		return true;
	}
	public boolean testsetItems(){
		return true;
	}
	public boolean testgetItemsIn(){
		return true;
	}


	/*
	 *ShopService()

getAllShops()
createNewShop(String, String, String, String, Date)
deleteShop(int)
editShop(int, String, String, String, String)
setFavourites(Shop)
setOwners(Shop)
setVisited(Shop)
setItems(Shop)
getItemsIn(Shop)
beFavouredBy(Shop, User)
addOwnerTo(Shop, User)
isVisited(Shop, User, int, String)
addItemTo(Shop, Item)
	 */
}
