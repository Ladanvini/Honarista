import java.sql.*;

import Connection.*;

public class Main {

	public static void main(String[] args)
	{
		PostgreSQLJDBC db = new PostgreSQLJDBC();
		Connection con = db.getConnection(args);

	}
}