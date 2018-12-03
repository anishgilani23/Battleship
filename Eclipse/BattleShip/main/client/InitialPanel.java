package main.client;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InitialPanel extends JPanel{
	private JTextField ip;
	private JTextField port;
	public InitialPanel(JPanel container) {
		this.setLayout(null);
		
		JLabel lblIpAddress = new JLabel("Ip Address");
		lblIpAddress.setBounds(12, 34, 117, 21);
		this.add(lblIpAddress);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(12, 67, 66, 15);
		this.add(lblPort);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(12, 107, 168, 51);
		this.add(btnNewButton);
		
		ip = new JTextField();
		ip.setBounds(102, 35, 276, 19);
		this.add(ip);
		ip.setColumns(10);
		
		port = new JTextField();
		port.setBounds(101, 67, 277, 19);
		this.add(port);
		port.setColumns(10);
		
		//Set visibility and other values such as size
		this.setSize(new Dimension(400, 200));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(210, 107, 168, 51);
		add(btnLogin);
		this.setVisible(true);
	}
}