package client;

import javax.swing.*;

public class LoginPanel extends JFrame 
{
	private JButton login;
	private JTextField password;
	private JTextField username;
	private JLabel passLabel;
	private JLabel userLabel;
	
	public LoginPanel()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		this.setSize(200,200);
		this.setVisible(true);
	}
}
