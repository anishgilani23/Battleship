package main.client;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JCheckBox;

public class ShipsetPanel extends JFrame{
	public ShipsetPanel(ShipsetController sc, String shipName) {
		getContentPane().setLayout(null);
		
		JLabel lblShipToSet = new JLabel("Ship To Set:");
		lblShipToSet.setBounds(102, 12, 118, 15);
		getContentPane().add(lblShipToSet);
		
		JLabel lblShip = new JLabel();
		lblShip.setText(shipName);
		lblShip.setBounds(201, 12, 66, 15);
		getContentPane().add(lblShip);
		
		JList list = new JList();
		list.setBounds(145, 39, 118, 35);
		getContentPane().add(list);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(102, 59, 66, 15);
		getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(102, 104, 66, 15);
		getContentPane().add(lblY);
		
		JList list_1 = new JList();
		list_1.setBounds(145, 86, 118, 35);
		getContentPane().add(list_1);
		
		JCheckBox chckbxHorizontal = new JCheckBox("Horizontal?");
		chckbxHorizontal.setBounds(102, 139, 126, 23);
		getContentPane().add(chckbxHorizontal);
		
		//Set visibility and other values such as size
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Battleship - Set Ships");
		this.setSize(new Dimension(400, 200));
		this.setVisible(true);
		this.setResizable(false);
	}
}
