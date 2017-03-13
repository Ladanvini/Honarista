package TestUI;

import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

import Service.*;
import entity.Role;
import entity.Shop;
public class MainScreen {

	private Scanner sc;
	private UserService _us;
	private ShopService _ss;
	private ItemService _is;
	private Boolean _loggedin;
	
	public MainScreen() {
		sc = new Scanner(System.in);
		_us = new UserService();
		_ss = new ShopService(_us);
		_is = new ItemService();
		_loggedin = false;
		System.out.println("main page");
		runUI();
	}
	private void runUI()
	{
		printCommands();	
		String command = sc.next();
		while(!command.contains("exit")) {
		if(command.contains("login"))
			runLogin();
		else if(command.contains("register"))
			runRegister();
		else if(command.contains("browse"))
			runBrowse();
		
		printCommands();

		command = sc.next();
		}

	}
	private void printCommands() {
		System.out.println("Type in one of the following commands: ");
		System.out.println("login \n"
				+ "register \n"
				+ "browse shops \n"
				+ "browse items \n"
				+ "exit \n");
	}
	//DONE
	private void runLogin() {
		System.out.println("Enter Username:");
		String username = sc.next();
		System.out.println("\n Enter Password");
		String password = sc.next();
		
		if(_us.login(username, password)) {
			_loggedin = true;
			runUserPage(username);
		}
		else
			System.out.println("smething went wrong");
					
	}
	//Done
	private void runRegister()
	{
		System.out.println("enter username");
		String username = sc.next();
		System.out.println("enter chosen password");
		String password = sc.next();
		System.out.println("full name ");
		String fullname = sc.next();
		fullname = fullname + " " + sc.next();
		
		System.out.println("Address: ");
		String address = sc.next();
		System.out.println("Phonenumber");
		String phone = sc.next();
		System.out.println("role");
		String roleStr = sc.next();
		int role;
		if(roleStr.contains("admin"))
			role = 0;
		else if(roleStr.contains("cm"))
			role = 1;
		else if(roleStr.contains("vendor"))
			role = 2;
		else if(roleStr.contains("customer"))
			role = 3;
		else
			role = 4;

		String msg = _us.createNewUser(username, password, fullname, address, phone, role);
		System.out.println(msg);
	}
	//TODO
	private void runBrowse() {
		
		Vector<Shop> shops = _ss.getAllShops();
		int count;
		for(count = 0; count<shops.size() && count <= 5; count ++) {
			System.out.println(shops.elementAt(count).toString());
		}
		System.out.println("You can perform the following tasks: \n"
				+ "search [keyword] \n"
				+ "sort [rating/name/date] \n"
				+ "select [shopname] \n"
				+ "back \n"
				+ "more");
		String command = sc.next();
		while(!command.equals("back")){
			if(command.contains("search"))
			{
				String keyword = sc.next();
				//_ss.searchShop(keyword);
			}
			if(command.contains("sort"))
			{
				String sortVal = sc.next();
				//_ss.sortShops(sortVal);
			}
			if(command.contains("select"))
			{
				String shopname = sc.next();
				this.runShopPage(shopname);
			}
			if(command.contains("more"))
			{
				count = count + 5;
				for(int i=0; i<shops.size() && i<= count; i++)
					System.out.println(shops.elementAt(i).toString());
			}
			System.out.println("You can perform the following tasks: \n"
					+ "search [keyword] \n"
					+ "sort [rating/name/date] \n"
					+ "select [shopname] \n"
					+ "back \n"
					+ "more");
			command = sc.next();

		}
	
	}
	//TODO
	private void runUserPage(String uname)
	{
		System.out.println("Welcome " + uname);
		System.out.println("Pick a command: \n"
				+ "logout \n"
				+ "change password \n"
				+ "add \n"
				+ "browse \n"
				+ "my shops \n");
		String command = sc.next();
		while(!command.equals("logout")) 
		{
			System.out.println(_us.getMyShops().size());
			if(command.contains("add")) {
				System.out.println("create new shop \n enter shop details: ");
				System.out.println("Shop name");
				String shopName = sc.next();
				System.out.println("address");
				String adr = sc.next();
				System.out.println("phonenum");
				String phonenum = sc.next();
				System.out.println("description");
				String desc = sc.next();
				
				Date regdate = new Date();
				
				_ss.createNewShop(shopName, adr, phonenum, desc, regdate);
				/*
				 * cannot find the shop
				 */
				_us.addNewOwner(_ss.getShop(shopName));
			}
			if(command.contains("my"))
			{
				for(int i=0; i<_us.getMyShops().size(); i++)
				{
					System.out.println(_us.getMyShops().elementAt(i));
				}
			}
			System.out.println("Pick a command: \n"
					+ "logout \n"
					+ "change password \n"
					+ "add \n"
					+ "browse \n"
					+ "my shops \n");
			command = sc.next();
	
		}
		_us.logout();
	}
	//TODO
	private void runShopPage(String shopname)
	{
		System.out.println(_ss.getShopId(shopname));
		System.out.println("view - View all items in shop");
		if(_loggedin)
		{
			System.out.println("add - Add item to shop");
			System.out.println("edit shop details");
		}
		System.out.println("select [itemname]");

		
		String command = sc.next();
		if(command.equals("add"))
			runAddItem(shopname);
		if(command.equals("edit"))
			runEditShop(shopname);
		if(command.equals("select"))
		{
			String itemname = sc.next();
			runItemPage(itemname);
		}
	}
	//test
	private void runAddItem(String shopname)
	{
		System.out.println("Enter item title: ");
		String title = sc.next();
		System.out.println("description:");
		String description = sc.next();
		
		int itemid = _is.createNewItem(title, description);
		_ss.addItemTo(_ss.getShop(shopname), _is.getItemWithId(itemid));
	}
	private void runEditShop(String shopname)
	{
		
	}
	private void runItemPage(String itemname)
	{
		
	}
	
}

/*
 * 
 *     Scanner scanner = new Scanner(System.in);
    System.out.print("What is your favorite color? ");
    String name = scanner.next();
    System.out.println("Your favorite color is: " + name);
    */