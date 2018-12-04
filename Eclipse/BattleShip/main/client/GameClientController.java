package main.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ocsf.client.AbstractClient;

import main.utils.Error;

public class GameClientController extends AbstractClient implements ActionListener{
	private GameClientData data;
	private static GameClientPanel gui;
	private LoginController logincontroller;
	private CreateAccountController createaccountcontroller;
	
	public GameClientController()
	{
		super("localhost", 8300);
		data = new GameClientData();
	}
	
	public void close()
	{
		try {
			super.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void handleMessageFromServer(Object arg0) {
	    // If we received a String, figure out what this event is.
	    if (arg0 instanceof String)
	    {
	      // Get the text of the message.
	      String message = (String)arg0;
	      
	      // If we successfully logged in, tell the login controller.
	      if (message.equals("LoginSuccessful"))
	      {
	        logincontroller.loginSuccess();
	      }
	      
	      // If we successfully created an account, tell the create account controller.
	      else if (message.equals("CreateAccountSuccessful"))
	      {
	        createaccountcontroller.createAccountSuccess();
	      }
	    }
	    
	    // If we received an Error, figure out where to display it.
	    else if (arg0 instanceof Error)
	    {
	      // Get the Error object.
	      Error error = (Error)arg0;
	      
	      // Display login errors using the login controller.
	      if (error.getType().equals("Login"))
	      {
	        logincontroller.displayError(error.getMessage());
	      }
	      
	      // Display account creation errors using the create account controller.
	      else if (error.getType().equals("CreateAccount"))
	      {
	        createaccountcontroller.displayError(error.getMessage());
	      }
	    }
	}  
	
	public void actionPerformed(ActionEvent e)
	{
		
	}

	public void setLoginControl(LoginController controller) {
		this.logincontroller = controller;
	}
	
	public void setCreateAccountController(CreateAccountController controller)
	{
		this.createaccountcontroller = controller;
	}
}
