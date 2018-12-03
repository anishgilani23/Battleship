package main.server;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ocsf.server.ConnectionToClient;


public class GameServerData {
	private int port;
	private int timeout;
	private Set<ConnectionToClient> clients; //instantiate with hash set
	private ArrayList<String> logInfo;
	
	public GameServerData()
	{
		clients = new HashSet<ConnectionToClient>();
		logInfo = new ArrayList<String>();
	}
	
	
	public int getPort()
	{
		return port;
	}
	
	public int getTimeout()
	{
		return timeout;
	}
	
	public Set<ConnectionToClient> getClients()
	{
		return clients;
	}
	
	public ArrayList<String> getLog()
	{
		return logInfo;
	}
	
	public void setPort(int p)
	{
		port = p;
	}
	
	public void setTimeout(int t)
	{
		timeout = t;
	}
	
	public void addClient(ConnectionToClient cl)
	{
		clients.add(cl);
	}
	
	public void subClient(ConnectionToClient cl)
	{
		clients.remove(cl);
	}
	
	public void addToLog(String stmt)
	{
		logInfo.add(stmt);
	}
	
	
}
