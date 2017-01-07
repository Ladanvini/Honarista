package Service;
import Connection.*;
import entity.*;

public class UserService {
	private PostgreSQLJDBC _db;
	
	public UserService(){
		_db = new PostgreSQLJDBC();
	}
	public User getUserFromId(int id){
		//TODO
		return new User();
		
	}

	public Boolean modifyUserInfo(User u){ 
		return true;
	}
	public  Boolean deleteUser(User u){
		
		return false;
	}
	public boolean removeUserbyAdmin(User u){
		return false;
	}
}
