import entity.User;
import Service.UserService;


public class Test {

	private UserService us;
	public Test(){
		us = new UserService();
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
	
	/*
	 * create new user
	 * edit user
	 * delete user
	 * 
	 */
}
