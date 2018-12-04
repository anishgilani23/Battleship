package test.client;

import static org.junit.Assert.*;

import org.junit.Test;

import main.client.User;

public class UserTest {

	@Test
	public void getUsernameTest() 
	{
		//Some variables
		String username = "myUsername";
		String password = "myPassword";
		User user = new User(username, password);
		
		//Try getting the username
		String userna = user.getUsername();
	
		//Assert the string you got is the one you entered
		assertEquals(username, userna);
	}
	
	@Test
	public void getPasswordTest()
	{
		//Some variables
		String username = "myUsername";
		String password = "myPassword";
		User user = new User(username, password);
		
		//Try getting the password
		String pass = user.getPassword();
	
		//Assert the string you got is the one you entered
		assertEquals(password, pass);
	}
	
	@Test
	public void setUsernameTest()
	{
		//Some variables
		String username = "myUsername";
		String password = "myPassword";
		User user = new User(username, password);
		
		//Now try setting the username to something different
		user.setUsername("username");
		
		//Now assert that username does not equal the original and it does equal the second
		assertNotEquals(username, user.getUsername());
		assertEquals("username", user.getUsername());
	}
	
	@Test
	public void setPasswordTest()
	{
		//Some variables
		String username = "myUsername";
		String password = "myPassword";
		User user = new User(username, password);
		
		//Now try setting the password to something different
		user.setPassword("password");
		
		//Now assert that password does not equal the original and it does equal the second
		assertNotEquals(password, user.getPassword());
		assertEquals("password", user.getPassword());
	}

}
