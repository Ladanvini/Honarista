package dao;

import java.sql.*;
import java.util.ArrayList;

import daoInterface.SymbolDaoInterface;
import exception.InvalidSymbolIdException;

public class SymbolDao implements SymbolDaoInterface{
	
	public static final String CONN_STR = "jdbc:hsqldb:hsql://localhost";
	private Connection con = null;
	
	ArrayList<String> symbols;
	private static SymbolDao instance;
	
	public SymbolDao() {
		this.symbols = new ArrayList<String>();
		try {
			con = DriverManager.getConnection(CONN_STR);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static SymbolDaoInterface getInstance(){
		if(instance == null)
			instance = new SymbolDao();
		return instance;
	}

	@Override
	public ArrayList<String> getAllSymbols() {
		
		String query = "select * from symbols" ;
		ResultSet rs = queryExecutor(query);
		
		ArrayList<String> allSymbols = convertSymbolResultSetToSymbolArrayList(rs);
		
		return allSymbols;
		
		//return symbols;
	}

	@Override
	public void deleteSymbol(String Symbol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSymbol(String symbol) {
		
		try {
			getSymbolByName(symbol);
		} catch (InvalidSymbolIdException e) {
			// the symbol is not in system and admin wants to add
			String query = "INSERT INTO symbols (sid, symbol) VALUES (" + nextId() + ", '" + symbol  + "' )";
			updateExecutor(query);
		}
		
	}

	@Override
	public String getSymbolByName(String symbol) throws InvalidSymbolIdException{
		
		String query = "select * from symbols where symbol='" + symbol + "'" ;
		ResultSet rs = queryExecutor(query);

		try {
			if (rs.next()) {
				return rs.getString("symbol");
			}
			else {
				throw new InvalidSymbolIdException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void log() {
		
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
	
	public ArrayList<String> convertSymbolResultSetToSymbolArrayList(ResultSet rs){
		
		ArrayList<String> converted = new ArrayList<String>();
		try {
			while (rs.next()) {
				converted.add(rs.getString("symbol"));
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
			ResultSet rs = st.executeQuery("select max(sid) as max_sid from symbols");
			int maxId = 0;
			if (rs.next()) {
				maxId = rs.getInt("max_sid");
			}
			//con.close();
			return maxId + 1;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}

}
