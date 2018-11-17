package server;

import java.util.ArrayList;
import java.util.Set;

import ocsf.server.ConnectionToClient;


public class GameServerData {
	private int port;
	private int timeout;
	private Set<ConnectionToClient> clients;
	private ArrayList<String> logInfo;
	
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
		//****ASK PROPER SYNTAX****
		clients.add(cl);
	}
	
	public void subClient(ConnectionToClient cl)
	{
		//***ASK PROPER SYNTAX****
	}
	
	public void addToLog(String stmt)
	{
		logInfo.add(stmt);
	}
	
	
}
