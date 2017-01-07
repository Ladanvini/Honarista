import java.sql.*;

import entity.Role;

import Connection.*;

public class Main {

	public static void main(String[] args)
	{
		PostgreSQLJDBC db = new PostgreSQLJDBC();
		Connection con = db.getConnection(args);
		
		db.editUser(7, "Marjan", "Ekhtiarieh", "felan", 2);
		for(int i=0; i<db.getAllUsers().size(); i++){
			System.out.println(db.getAllUsers().elementAt(i).getId());
			System.out.println(db.getAllUsers().elementAt(i).getUserName());
			System.out.println("======================================");
		}
	}
}
