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

public class GameClientController extends AbstractClient implements ActionListener{
	private GameClientData data;
	private static GameClientPanel gui;
	
	public GameClientController()
	{
		super("localhost", 8000);
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
		// TODO Auto-generated method stub
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
	}

	public void setLoginControl(LoginController controller) {
		// TODO Auto-generated method stub
		
	}
}
