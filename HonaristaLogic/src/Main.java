import java.sql.*;

import entity.Role;

import Connection.*;
import TestUI.*;

public class Main {
	public static void main(String[] args)
	{
		PostgreSQLJDBC db = new PostgreSQLJDBC();
		Connection con = db.getConnection(args);

		MainScreen sys = new MainScreen();
		
	}
}
