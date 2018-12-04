package main.client;

import java.io.Serializable;

public class LoginData implements Serializable {
	
	private String username;
	private String password;
	
	public LoginData(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	private void setPassword(String p)
	{
		password = p;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	private void setUsername(String u)
	{
		username = u;
	}
	
	public String getUsername()
	{
		return username;
	}

}
