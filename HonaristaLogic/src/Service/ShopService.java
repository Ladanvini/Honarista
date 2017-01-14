package Service;
import entity.*;
import java.util.*;
import Connection.PostgreSQLJDBC;
public class ShopService {
	private PostgreSQLJDBC _db;
	public void createShop(Shop s){
		_db.createNewShop(s.getName(), s.getAdress(), s.getPhoneNum(), s.getDesc(), new Date());
	}
	public void deleteShop(Shop s){
		_db.deleteShop(s.getID());
	}
	public void editShop(Shop s){
		_db.editShop(s.getID(), s.getName(), s.getAdress(), s.getPhoneNum(), s.getDesc());
	}

}
