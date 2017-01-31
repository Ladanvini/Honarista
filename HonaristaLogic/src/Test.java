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
	public boolean testgetShopWithId(){
	//getShopWithId(int) : Shop
		System.out.println(_ss.getShopWithId(1).toString());
		
		return true;
	}
	public boolean testcreateNewShop (){
		System.out.println(_ss.createNewShop("Banana", "101 Rvk", "1234567", "This shop is delicious and yellow. They are banana!"
 + "It was made specifically for the purpose of testing this system", null));
		return true;
	}

	public boolean testgetAllShops(){
	//getAllShops()
		Vector<Shop> shops = _ss.getAllShops();
		for(int i=0; i<shops.size(); i++)
			System.out.println(shops.elementAt(i).toString());
				
		return true;
	}
	
	public boolean testdeleteShop(){
		return true;
	}
	public boolean testeditShop(){
		return true;
	}
	public boolean testsetFavourites(){
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
	public boolean testbeFavouredBy(){
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
