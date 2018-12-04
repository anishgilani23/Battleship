package main.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import main.boardmechanics.Board;
import main.boardmechanics.Ship;

public class DB {
	  private Connection conn;
	  //Add any other data fields you like – at least a Connection object is mandatory
	  public DB() throws IOException
	  {
	    //Add your code here
		  Properties props = new Properties();
		  FileInputStream in = new FileInputStream("db.properties");
		  props.load(in);
		  in.close();
		  
		  String url = props.getProperty("url");
		  String username = props.getProperty("user");
		  String password = props.getProperty("password");

		  try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error initializing connection object");
		}
		  
	  }
	  
	  public ArrayList<String> query(String query) throws SQLException
	  {
	    //Add your code here
		  ArrayList<String> results = null;
		  Statement statement = conn.createStatement();
		  ResultSet rs = statement.executeQuery(query);
		  if (!rs.equals(null))
		  {
			  results = new ArrayList<String>();
		  }
		  ResultSetMetaData rsmd = rs.getMetaData(); 
		  int columnCount = rsmd.getColumnCount();
		  while (rs.next()) {
			  int i = 1;
			  while(i <= columnCount) {
				  results.add(rs.getString(i++));
			  }
		  }	  
		  return results;
	  }
	  
	  public int executeDML(String dml) throws SQLException
	  {
	    //Add your code here
		  int success = 0;
		  Statement statement =conn.createStatement();
		  success = statement.executeUpdate(dml);
		  
		  return success;
	  }

	public boolean verifyAccount(String username, String password){
		boolean yesno = false;
		ArrayList<String> results = new ArrayList<String>();
		try {
			results = query("SELECT * FROM Users WHERE name='" + username + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (results.size() > 0)
		{
			yesno = true;
		}
		return yesno;
	}

	public boolean createNewAccount(String username, String password) throws SQLException {
		boolean yesno = false;
		boolean verify = verifyAccount(username, password);
		if (verify == true)
		{
			yesno = false;;
		}
		else {
			String dml = "INSERT INTO Users VALUES ('" + username + "','" + password + "');";
			int success = executeDML(dml);
			if (success != 0)
			{
				yesno = true;
			}
		}
		return yesno;
	}
	
}
