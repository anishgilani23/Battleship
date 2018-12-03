package main.server;

import javax.swing.*;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameServerController extends AbstractServer implements ActionListener
{
	private GameServerData data;
	private static GameServerPanel panel;
	private DB db;
	
	public GameServerController()
	{
		super(12345);
		data = new GameServerData();
		db = new DB();
	}
	
	public void clientConnected(ConnectionToClient client)
	{
		//Displays client connection in server log
		data.addToLog("Client " + Long.toString(client.getId()) + " Connected\n");
	}
	
	public void clientDisconnected(ConnectionToClient client)
	{
		data.addToLog("Client " + Long.toString(client.getId()) + " Disconnected\n");
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.addToLog("Server Listening\n");
			panel.getTextArea().append("Server Listening\n");
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
		String clientMessage = (String) arg0;
		long id = arg1.getId();
		String msg = "Client " + id + ": " + clientMessage + "\n";
		data.addToLog(msg);
	}
	
	public boolean insertIntoDatabase(Object obj)
	{
		//Placeholder
		return false;
	}
	
	public Object getFromDatabase()
	{
		//Placeholder
		return null;
	}
	
	public void gameOver()
	{
		
	}
	
	public void declareWinner()
	{
		
	}
	
	public static void main(String[] args)
	{
		panel = new GameServerPanel(new GameServerController());
	}
	
}
