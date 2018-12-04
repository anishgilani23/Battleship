package main.server;

import javax.swing.*;

import main.boardmechanics.Board;
import main.boardmechanics.Coordinate;
import main.client.CreateAccountData;
import main.client.LoginData;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameServerController extends AbstractServer implements ActionListener
{
	private ConnectionToClient winner;
	private List<ConnectionToClient> clients;
	private GameServerData data;
	private ConnectionToClient lastMove;
	private static GameServerPanel panel;
	private boolean running;
	private DB db;
	
	public GameServerController()
	{
	    super(12345);
	    clients = new ArrayList<ConnectionToClient>();
	    this.setTimeout(500);
		data = new GameServerData();
		data.setPort(8300);
		data.setTimeout(500);
		try {
			db = new DB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clientConnected(ConnectionToClient client)
	{
		//Displays client connection in server log
		data.addToLog("Client " + Long.toString(client.getId()) + " Connected\n");
		panel.getTextArea().append("Client " + Long.toString(client.getId()) + " Connected\n");
		clients.add(client);
	}
	
	public void clientDisconnected(ConnectionToClient client)
	{
		data.addToLog("Client " + Long.toString(client.getId()) + " Disconnected\n");
		panel.getTextArea().append(("Client " + Long.toString(client.getId()) + " Disconnected\n"));
		clients.remove(client);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if (command == "Listen")
		{
			try {
				setPort(data.getPort());
				setTimeout(data.getTimeout());
				listen();
				running = true;
				data.addToLog("Server Listening\n");
				panel.getTextArea().append("Server Listening\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if (command == "Close")
		{
			if (!isListening())
			{
				data.addToLog("Server not currently started\n");
				panel.getTextArea().append("Server not currently started\n");
			}
			else if (isListening())
			{
				try
				{
					close();
					running = false;
					data.addToLog("Server Closed\n");
					panel.getTextArea().append("Server Closed\n");
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
		else if (command == "Stop")
		{
			if (!isListening())
    		{
    			data.addToLog("Server not currently started\n");
    			panel.getTextArea().append("Server not currently started\n");
    		}
    		else if (isListening())
    		{
    			stopListening();
    			running = false;
    			data.addToLog("Server Stopped\n");
    			panel.getTextArea().append("Server Stopped\n");
    		}
		}
		else 
		{
			System.out.println("Something went wrong...");
		}
	}
	
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
	    // If we received LoginData, verify the account information.
	    if (arg0 instanceof LoginData)
	    {
	      // Check the username and password with the database.
	      LoginData data = (LoginData)arg0;
	      Object result;
	      if (db.verifyAccount(data.getUsername(), data.getPassword()))
	      {
	        result = "LoginSuccessful";
	        panel.getTextArea().append("Client " + arg1.getId() + " successfully logged in as " + data.getUsername() + "\n");
	      }
	      else
	      {
	        result = new Error("The username and password are incorrect.");
	        panel.getTextArea().append("Client " + arg1.getId() + " failed to log in\n");
	      }
	      
	      // Send the result to the client.
	      try
	      {
	        arg1.sendToClient(result);
	      }
	      catch (IOException e)
	      {
	        return;
	      }
	    }
	    
	    // If we received CreateAccountData, create a new account.
	    else if (arg0 instanceof CreateAccountData)
	    {
	      // Try to create the account.
	      CreateAccountData data = (CreateAccountData)arg0;
	      Object result = null;
	      try {
			if (db.createNewAccount(data.getUsername(), data.getPassword()))
			  {
			    result = "CreateAccountSuccessful";
			    panel.getTextArea().append("Client " + arg1.getId() + " created a new account called " + data.getUsername() + "\n");
			  }
			  else
			  {
			    result = new Error("The username is already in use.");
			    panel.getTextArea().append("Client " + arg1.getId() + " failed to create a new account\n");
			  }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	      
	      // Send the result to the client.
	      try
	      {
	        arg1.sendToClient(result);
	      }
	      catch (IOException e)
	      {
	        return;
	      }
	    }
	    
	    //If we recieve a coordinate, then we know there was an attack and we should send it
	    else if (arg0 instanceof Coordinate)
	    {
	    	//Make sure the attack is sent to the appropriate client
	    	try {
	    		if (clients.get(0).equals(arg1))
	    		{
	    			clients.get(1).sendToClient(arg0);
	    			lastMove = clients.get(0);
	    		}
	    		else
	    		{
	    			clients.get(0).sendToClient(arg0);
	    			lastMove = clients.get(1);
	    		}
	    		Coordinate coord = (Coordinate)arg0;
	    		panel.getTextArea().append("Client " + arg1.getId() + " Sent an attack to coordinate (" + coord.getX() + "," + coord.getY() + ")\n");
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    
	    //If we recieve a string, know that there was a hit and send to the appropriate client that there was indeed a hit
	    else if (arg0.equals("Hit"))
	    {
	    	boolean hit = true;
	    	try {
	    		lastMove.sendToClient(hit);
	    	}
	    	catch (Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
    }
	
	public void gameOver()
	{
		//Gets called when someone wins..  Calls declareWinner() and shuts down the server
		this.declareWinner(winner);
	}
	
	public void declareWinner(ConnectionToClient winner)
	{
		//Sends a message to both clients saying who won
		String msg = "Client - " + winner.getId() + " is the winner!";
		this.sendToAllClients(msg);
	}
	
	public boolean isRunning()
	{
		return running;
	}
	
	public static void main(String[] args)
	{
		//Set the GameServerPanel
		panel = new GameServerPanel(new GameServerController());
	}
	
}
