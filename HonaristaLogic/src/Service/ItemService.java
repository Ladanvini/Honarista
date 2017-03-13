package Service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import entity.*;

import Connection.PostgreSQLJDBC;

public class ItemService {
	private PostgreSQLJDBC _db;
	private Connection con;
	public ItemService(){
		_db = new PostgreSQLJDBC();
		con = _db.getConnection(null);
	}
	/*
	 * ITEM ACTIONS
	 */
	   public Item getItemWithId(int id){
		   Statement stmnt = null;
		   Item res = new Item();
		   String query = "SELECT * FROM Items " +
		   		"WHERE id = " + id + " ;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   String title = rs.getString("title");
				   String description = rs.getString("description");
				   //Item(int id, String title, String desc)
				   res = (new Item(id, title, description));
			   }
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
			   System.err.println(e.getStackTrace());
		   } finally {
			   if(stmnt != null)
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }

		   return res;

	   }
	   public Vector<Item> getAllItems(){
		   Vector<Item> res = new Vector<Item>();
		   Statement stmnt = null;
		   String query = "SELECT * FROM Items;";
		   
		   try{
			   stmnt = con.createStatement();
			   ResultSet rs = stmnt.executeQuery(query);
			   while(rs.next()){
				   int id = rs.getInt("id");
				   String title = rs.getString("title");
				   String description = rs.getString("description");
				   //Item(int id, String title, String desc)
				   res.add(new Item(id, title, description));
			   }
		   }catch(SQLException e){
			   System.err.println(e.getMessage());
			   System.err.println(e.getStackTrace());
		   } finally {
			   if(stmnt != null)
				try {
					stmnt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }
		   return res;
	   }
	   public int createNewItem(String title, String description){
		   // Item(int id, String title, String desc)
		   int itemid = 0;
		   Statement stmnt = null;
		   String query = "INSERT INTO Items" +
		   		"(title, description)" +
		   		" VALUES ('" + title + "', '" +  description + "');";
		   String msg = "0";

			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
			}
 		    Statement stmnt2 = null;
			
 		    String q2 = "SELECT id FROM Items WHERE (title = '" + title + "' AND description = '" + description + "');";
			try
			{
				stmnt2 = con.createStatement();
				ResultSet rs = stmnt2.executeQuery(q2);
				while(rs.next())
					itemid = rs.getInt("id");
					
			}catch(SQLException e)
			{
				msg = e.getSQLState();
				msg = msg + "\n" + e.getMessage();
			}
			   System.out.println(msg);
		return itemid;	   
	   }
	   public String deleteItem(int itemId){
		   Statement stmnt = null;
		   String query;
		   String msg = "";
		   //this.addUserToTrash(itemId);
		   query = "DELETE FROM Items" +
		   		" WHERE id = " + itemId + " ;";
		   
			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
			}
		return msg;	   

	   }
	   public String editItem(int id, String title, String description){
		   // Item(int id, String title, String desc)
		   Statement stmnt = null;
		   String query = " UPDATE Items " +
				   " SET title = '" + title + "'," + 
				   " description = '" + description + "'  " +
				   " WHERE id = " + id + " ; ";

		   String msg = "0";

			   try {
				   stmnt = con.createStatement();
				   stmnt.executeQuery(query);
			   } catch (SQLException e) {
				// TODO Auto-generated catch block
				msg = e.getStackTrace().toString();
				e.printStackTrace();
			}
		return msg;	   

	   }	
	/*
 * draft
 * rePut saved items
 * confirm by CM/ADMIN
 * suspend by CM/ADMIN
 * 
 */

}
