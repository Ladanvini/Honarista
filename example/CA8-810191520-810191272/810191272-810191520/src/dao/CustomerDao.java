package dao;

import java.sql.*;
import java.util.ArrayList;

import model.Customer;

import daoInterface.CustomerDaoInterface;
import exception.RepeatedIdException;
import exception.UnknownUserIdException;

public class CustomerDao implements CustomerDaoInterface{
	
	public static final String CONN_STR = "jdbc:hsqldb:hsql://localhost";
	private Connection con = null;
	
//	ArrayList<Customer> customers;
	private static CustomerDao instance;
	
	public CustomerDao() {
//		this.customers = new ArrayList<Customer>();
		try {
			con = DriverManager.getConnection(CONN_STR);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static CustomerDaoInterface getInstance(){
		if(instance == null)
			instance = new CustomerDao();
		return instance;
	}

	static {
		try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
			} catch (ClassNotFoundException ex) {
				System.err.println("Unable to load HSQLDB JDBC driver");
		}
	}
	
	@Override
	public ArrayList<Customer> getAllCustomers() {
		
		String query = "select * from customers" ;
		ResultSet rs = queryExecutor(query);
		
		ArrayList<Customer> allCustomers = convertCustomerResultSetToCustomerArrayList(rs);
		
		return allCustomers;
	
	}

	@Override
	public Customer getCustomerById(String id) throws UnknownUserIdException {
		

		String query = "select * from customers where uid='" + id + "'" ;
		ResultSet rs = queryExecutor(query);
		
		try{
			if(rs.next()){
				return new Customer(rs.getString("uid"), rs.getString("name"), rs.getString("family"), rs.getInt("credit") , rs.getInt("cid"));
			}
			else{
				throw new UnknownUserIdException();
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		
		//Customer customer = convertCustomerResultSetToCustomer(rs);
		//return customer;
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("update customer called .... credit:" + customer.getCredit());
		
		String query = "update customers set credit = " + customer.getCredit() + " where uid='" + customer.getId() + "'";
		updateExecutor(query);
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomer(Customer customer) throws RepeatedIdException {
		//try{
		String q = "select * from customers where uid='" + customer.getId() + "'" ;
		ResultSet rs2 = queryExecutor(q);

		try{
			if(rs2.next()){
				throw new RepeatedIdException();
			}
			else{
				System.out.println("inserting...");
				
				int generatedCid = nextId();
				String query = "INSERT INTO customers (uid, name, family, credit , cid) VALUES ('" + customer.getId() + "', '" + customer.getName() + "', '" + customer.getFamily() + "', " + customer.getCredit() + ", " + generatedCid + " );";
				updateExecutor(query);
				
				customer.setCid(generatedCid);
			}
		}catch(SQLException e){
			e.printStackTrace();
			return;
		}
			//Customer temp = getCustomerById(customer.getId());
			
			//if(temp == null){
			//	System.out.println("inserting...");
			//	String query = "INSERT INTO shares (uid, name, family, credit , cid) VALUES ('" + customer.getId() + "', '" + customer.getName() + "', '" + customer.getFamily() + "', " + customer.getId() + ", " + customer.getCid() + " );";
			//	updateExecutor(query);
			//}
			//else{
			//	throw new RepeatedIdException();
			//}
		//}catch(Exception e){}
	}
	
	public void log(){
		
		ArrayList<Customer> customers = getAllCustomers();
		
		for(int i=0 ; i<customers.size() ; i++){
			Customer cs = customers.get(i);
			System.out.println(i + "\t" + cs.getId() + '\t' + cs.getCredit());
		}
		
	}

	public ResultSet queryExecutor(String query){
		System.out.println(query);
		//Connection con ;
		Statement st;
		ResultSet rs = null;
		try {
			//con = DriverManager.getConnection(CONN_STR);
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ArrayList<Customer> convertCustomerResultSetToCustomerArrayList(ResultSet rs){
		
		ArrayList<Customer> converted = new ArrayList<Customer>();
		try {
			while (rs.next()) {
				converted.add(new Customer(rs.getString("uid"), rs.getString("name"), rs.getString("family"), rs.getInt("credit") , rs.getInt("cid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return converted;
	}
	
	public Customer convertCustomerResultSetToCustomer(ResultSet rs){
		
		Customer customer = null;
		try {
			customer = new Customer(rs.getString("uid"), rs.getString("name"), rs.getString("family"), rs.getInt("credit") , rs.getInt("cid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
	
	public int updateExecutor(String query){
		System.out.println(query);
		//Connection con ;
		Statement st;
		int result  = -1;
		try {
			//con = DriverManager.getConnection(CONN_STR);
			st = con.createStatement();
			result = st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int nextId() {
		try{
			//Connection con = DriverManager.getConnection(CONN_STR);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(cid) as max_cid from customers");
			int maxId = 0;
			if (rs.next()) {
				maxId = rs.getInt("max_cid");
			}
			//con.close();
			return maxId + 1;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}