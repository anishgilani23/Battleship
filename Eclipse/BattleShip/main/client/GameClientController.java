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
import main.boardmechanics.Coordinate;
import main.utils.Error;

public class GameClientController extends AbstractClient implements ActionListener{
	private GameClientData data;
	private static GameClientPanel gui;
	private LoginController logincontroller;
	private CreateAccountController createaccountcontroller;
	private BattleShipController battleshipcontroller;
	private BattleShipPanel battleshippanel;
	private Coordinate attackCoord;
	
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
	
	public void setAttackCoord(Coordinate coord)
	{
		attackCoord = coord;
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
	    
	    //If we receieve a coordinate, then we know that we have been attacked and we should update our display accordingly
	    else if (arg0 instanceof Coordinate)
	    {
	    	Coordinate coord = (Coordinate)arg0;
	    	
	    	battleshippanel.updateBoard(coord);
	    }
	    
	    //If we get a boolean, we know the result of our attack and should update the board accordingly
	    else if (arg0.equals(true))
	    {
	    	
	    }
	    else if (arg0.equals(false))
	    {
	    	
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
	
	public void setBattleShipController(BattleShipController controller)
	{
		this.battleshipcontroller = controller;
	}
	
	public void setBattleShipPanel(BattleShipPanel panel)
	{
		this.battleshippanel = panel;
	}
}
