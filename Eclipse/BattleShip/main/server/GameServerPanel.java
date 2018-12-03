package main.server;



import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;


public class GameServerPanel extends JFrame
{

	private JButton listen;
	private JButton close;
	private JButton stop;
	private JLabel logLabel;
	private JTextArea logArea;
	
	//private GameServerController controller;
	
	public GameServerPanel(GameServerController sc)
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Battleship - Server");
		this.setResizable(false);
		
		//Create panels for the info log and the buttons
		JPanel logPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		//Create and add the buttons to the bottom of the panel
		listen = new JButton("Listen");
		close = new JButton("Close");
		stop = new JButton("Stop");
		
		//Add action listeners to all of the buttons
	    listen.addActionListener(sc);
	    close.addActionListener(sc);
	    stop.addActionListener(sc);
		
		buttonPanel.add(listen, BorderLayout.SOUTH);
	    buttonPanel.add(close, BorderLayout.SOUTH);
	    buttonPanel.add(stop, BorderLayout.SOUTH);
	    
	    //Create log and add it to the panel
		logArea = new JTextArea(20,29);
		JScrollPane pane = new JScrollPane(logArea);
		logPanel.add(pane);
	    add(logPanel, BorderLayout.CENTER);
	    
	    //Add logLabel to frame
	    logLabel = new JLabel("Activity Log:");
		JPanel labelPanel = new JPanel();
		labelPanel.add(logLabel);
		add(labelPanel, BorderLayout.NORTH);
		
	    
	    //Sets size and visibility
	    this.setSize(500,500);
		this.setVisible(true);
	}
	
	public JTextArea getTextArea()
	{
		return logArea;
	}
	
}
