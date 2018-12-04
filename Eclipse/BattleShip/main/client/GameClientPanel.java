package main.client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameClientPanel extends JFrame {
	private User user;
	private CardLayout cardLayout = new CardLayout();
	private JPanel container = new JPanel(cardLayout);
	private GameClientController controller;
	private JPanel view1;
	private JPanel view2;
	private JPanel view3;
	private JPanel view4;
	private JPanel view5;
	
	//Default Constructor	
	public GameClientPanel()
	{
		//Setup the controller and open connection with server
		controller = new GameClientController();
	    controller.setHost("localhost");
	    controller.setPort(8300);
	    try
	    {
	      controller.openConnection();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
		
	    // Set the title and default close operation.
	    this.setTitle("Battleship - Client");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	    // Create the card layout container.
	    container = new JPanel(cardLayout);
	    
	    // Create the five views.
	    view1 = new InitialPanel(container, controller);
	    view2 = new LoginPanel(container, controller);
	    view3 = new CreateAccountPanel(container, controller);
	    view4 = new ShipsetPanel(new ShipsetController(), container);
	    view5 = new BattleShipPanel(container);
	    
	    // Add the views to the card layout container
	    container.add(view1, "1");
	    container.add(view2, "2");
	    container.add(view3, "3");
	    container.add(view4, "4");
	    container.add(view5, "5");
	    
	    // Show the initial view in the card layout.
	    cardLayout.show(container, "1");
	    
	    // Add the card layout container to the JFrame.
	    this.add(container);

	    // Show the JFrame.
	    this.setSize(850, 450);
	    this.setVisible(true);
	}

	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.user = user;
	}
	
	public static void main(String[] args) {
		// Main program - Show panels in the right order
		new GameClientPanel();
	}
}
