package server;

import javax.swing.*;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import java.io.IOException;

import server.GameServerData;
import server.GameServerPanel;

public class GameServerController {
	
	//private JTextArea logArea; //Corresponds to logArea of Panel class
	private GameServerPanel gui;
	private GameServerData data;
	private DB db;
	
	public GameServerController()
	{
		gui = new GameServerPanel();
		data = new GameServerData();
		db = new DB();
	}
	
	public void clientConnected(ConnectionToClient client)
	{
		data.addClient(client);
		//Should this display message?
	}
	
	public void clientDisconnected(ConnectionToClient client)
	{
		
	}
	
	public void close()
	{
		//Should this be an Event handler and deal with the close button?
		this.close();
	}
	
	public void listen()
	{
		//Should this deal with the Listen button?
		this.listen();
	}
	
	public void setPort(int port)
	{
		data.setPort(port);
	}
	
	public void setTimeout(int timeout)
	{
		data.setTimeout(timeout);
	}
	
	public void stopListening()
	{
		//Make into event handler
		
		//How should this expand the 
		//AbstractServer.stopListening()?
	}
	
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1)
	{
		String clientMessage = (String) arg0;
		long id = arg1.getId();
		String msg = "Client " + id + ": " + clientMessage + "\n";
		//log.append(msg)
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
