package main.client;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InitialPanel extends JPanel{
	private InitialController controller;
	private GameClientController client;
	public InitialPanel(JPanel container, GameClientController gc) {
		this.setLayout(null);
		
		client = gc;
		controller = new InitialController(container);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(242, 107, 168, 51);
		btnNewButton.setActionCommand("Create");
		btnNewButton.addActionListener(controller);
		this.add(btnNewButton);
		
		//Set visibility and other values such as size
		//this.setSize(new Dimension(400, 200));
		this.setSize(new Dimension(850, 450));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(448, 107, 168, 51);
		btnLogin.setActionCommand("Login");
		btnLogin.addActionListener(controller);
		this.add(btnLogin);
		this.setVisible(true);
	}
}
