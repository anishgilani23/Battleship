package test.server;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import main.server.DB;

public class DBTest {

	private DB db;
	String[] users = {"jsmith@uca.edu","msmith@uca.edu","tjones@yahoo.com","jjones@yahoo.com"};
	String[] passwords = {"hello123","pass123","123456","hello1234"};

	@Test
	public void testQuery() throws IOException {
		//Set connection object
		db = new DB();
		Connection conn = db.getConnection();
		
		//For results
		ArrayList<String> results = new ArrayList<String>();
		
		//Get random username
		int randomNum = ThreadLocalRandom.current().nextInt(0, 3 + 1);
		String randUser = users[randomNum];
		
		try {
			results = db.query("SELECT * FROM users");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(results);
	}

	@Test
	public void testExecuteDML() throws IOException, SQLException {
		//Set connection object
		db = new DB();
		Connection conn = db.getConnection();
		
		//Run dml statement
		String dml = "INSERT INTO Users VALUES('something', 'something')";
		db.executeDML(dml);
	}
}
