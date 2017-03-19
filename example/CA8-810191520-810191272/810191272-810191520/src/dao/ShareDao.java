package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Share;
import daoInterface.ShareDaoInterface;

public class ShareDao implements ShareDaoInterface{
	
	public static final String CONN_STR = "jdbc:hsqldb:hsql://localhost";
	private Connection con = null;
	
	//ArrayList<Share> shares;
	private static ShareDao instance;
	
	public ShareDao() {
		//this.shares = new ArrayList<Share>();
		try {
			con = DriverManager.getConnection(CONN_STR);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ShareDaoInterface getInstance(){
		if(instance == null)
			instance = new ShareDao();
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
	public ArrayList<Share> getAllShares() {
		
		String query = "select * from shares" ;
		ResultSet rs = queryExecutor(query);
		
		ArrayList<Share> allShares = convertShareResultSetToShareArrayList(rs);
		
		return allShares;
	}

	@Override
	public ArrayList<Share> getSymbolSharesByName(String symbol){
		
		String query = "select * from shares where symbol='" + symbol + "'" ;
		ResultSet rs = queryExecutor(query);
		
		ArrayList<Share> symbolShares = convertShareResultSetToShareArrayList(rs);

		return symbolShares;
	}

	@Override
	public ArrayList<Share> getCustomerSharesById(String id){
		
		String query = "select * from shares where uid='" + id + "'" ;
		ResultSet rs = queryExecutor(query);
		
		ArrayList<Share> customerShares = convertShareResultSetToShareArrayList(rs);
		
		return customerShares;

	}

	@Override
	public void updateShare(Share share) {
		System.out.println("update share called ....");
		
		String query = "update shares set quantity = '" + share.getQuantity() + "' where shid='" + share.getshid() + "'" ;
		updateExecutor(query);
	}

	@Override
	public void deleteShare(Share share) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addShare(Share share) {
		
		Share temp = getCustomerShareBySymbol(share.getUserId(), share.getSymbol());
		
		if(temp == null){
			System.out.println("inserting...");
			String query = "INSERT INTO shares (shid, uid, symbol, quantity) VALUES (" + nextId() + ", '" + share.getUserId() + "', '" + share.getSymbol() + "', " + share.getQuantity() + " );";
			updateExecutor(query);
		}
		else{
			System.out.println("updating...");
			String query = "update shares set quantity = '" + (temp.getQuantity() + share.getQuantity()) + "' where shid='" + temp.getshid() + "'" ;
			updateExecutor(query);
		}
		
	}
	
	public void log(){
		
		ArrayList<Share> shares = getAllShares();
		
		for(int i=0 ; i<shares.size() ; i++){
			Share s = shares.get(i);
			System.out.println(i + "\t" + s.getUserId() + '\t' + s.getSymbol() + '\t' + s.getQuantity());
		}
	}

	@Override
	public Share getCustomerShareBySymbol(String id, String symbol) {
		
			String query = "select * from shares where uid = '" + id + "' and symbol='" + symbol + "'" ;
			ResultSet rs = queryExecutor(query);
		
			int quantity = 0;
			int shid = -1;

			try {
				if (rs.next()) {
					quantity = rs.getInt("quantity");
					shid = rs.getInt("shid");

				}
				else {
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			
			Share loadedShare = new Share(id, symbol, quantity, shid);
			
			return loadedShare;
			
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
	
	public ArrayList<Share> convertShareResultSetToShareArrayList(ResultSet rs){
		
		ArrayList<Share> converted = new ArrayList<Share>();
		try {
			while (rs.next()) {
				converted.add(new Share(rs.getString("uid"), rs.getString("symbol"), rs.getInt("quantity"), rs.getInt("shid")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return converted;
	}
	
	public int nextId() {
		try{
			//Connection con = DriverManager.getConnection(CONN_STR);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select max(shid) as max_shid from shares");
			int maxId = 0;
			if (rs.next()) {
				maxId = rs.getInt("max_shid");
			}
			//con.close();
			return maxId + 1;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}
