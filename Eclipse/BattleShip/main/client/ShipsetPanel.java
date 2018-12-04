package main.client;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class ShipsetPanel extends JPanel{
	//Private variables for comboboxes/checkboxes
	private JComboBox comboFrigrateX;
	private JComboBox comboFrigrateY;
	private JComboBox comboBattleX;
	private JComboBox comboBattleY;
	private JComboBox comboSubX;
	private JComboBox comboSubY;
	private JComboBox comboDestX;
	private JComboBox comboDestY;
	private JComboBox comboCruX;
	private JComboBox comboCruY;
	private JCheckBox frig;
	private JCheckBox battle;
	private JCheckBox sub;
	private JCheckBox dest;
	private JCheckBox cruiser;
	
	
	public ShipsetPanel(ShipsetController sc, JPanel container) {
		this.setLayout(null);
		this.setSize(new Dimension(850, 450));
		
		//Create some models
		Vector model = new Vector();
		Vector model2 = new Vector();
		
		//Populate the models
		for (int i = 1; i < 11; i++)
		{
			model.add(i);
			model2.add(i);
		}
		
		JLabel lblShipToSet = new JLabel("Ship To Set:");
		lblShipToSet.setBounds(102, 40, 118, 15);
		this.add(lblShipToSet);
		
		comboFrigrateX = new JComboBox(model);
		comboFrigrateX.setBounds(145, 67, 118, 35);
		this.add(comboFrigrateX);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(102, 87, 66, 15);
		this.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(102, 132, 66, 15);
		this.add(lblY);
		
		comboFrigrateY = new JComboBox(model2);
		comboFrigrateY.setBounds(145, 114, 118, 35);
		this.add(comboFrigrateY);
		
		frig = new JCheckBox("Horizontal?");
		frig.setBounds(102, 167, 126, 23);
		this.add(frig);
		
		JLabel lblFrigrate = new JLabel("Frigrate");
		lblFrigrate.setBounds(202, 39, 61, 16);
		add(lblFrigrate);
		
		JLabel label = new JLabel("Ship To Set:");
		label.setBounds(102, 229, 118, 15);
		add(label);
		
		comboBattleX = new JComboBox(model);
		comboBattleX.setBounds(145, 256, 118, 35);
		add(comboBattleX);
		
		JLabel label_1 = new JLabel("X:");
		label_1.setBounds(102, 276, 66, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("Y:");
		label_2.setBounds(102, 321, 66, 15);
		add(label_2);
		
		comboBattleY = new JComboBox(model);
		comboBattleY.setBounds(145, 303, 118, 35);
		add(comboBattleY);
		
		battle = new JCheckBox("Horizontal?");
		battle.setBounds(102, 356, 126, 23);
		add(battle);
		
		JLabel lblCruiser = new JLabel("Cruiser");
		lblCruiser.setBounds(195, 228, 61, 16);
		add(lblCruiser);
		
		JLabel label_4 = new JLabel("Ship To Set:");
		label_4.setBounds(388, 40, 118, 15);
		add(label_4);
		
		comboSubX = new JComboBox(model);
		comboSubX.setBounds(431, 67, 118, 35);
		add(comboSubX);
		
		JLabel label_5 = new JLabel("X:");
		label_5.setBounds(388, 87, 66, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("Y:");
		label_6.setBounds(388, 132, 66, 15);
		add(label_6);
		
		comboSubY = new JComboBox(model);
		comboSubY.setBounds(431, 114, 118, 35);
		add(comboSubY);
		
		sub = new JCheckBox("Horizontal?");
		sub.setBounds(388, 167, 126, 23);
		add(sub);
		
		JLabel lblBattleship = new JLabel("BattleShip");
		lblBattleship.setBounds(481, 39, 105, 16);
		add(lblBattleship);
		
		JLabel label_8 = new JLabel("Ship To Set:");
		label_8.setBounds(381, 230, 118, 15);
		add(label_8);
		
		comboDestX = new JComboBox(model);
		comboDestX.setBounds(424, 257, 118, 35);
		add(comboDestX);
		
		JLabel label_9 = new JLabel("X:");
		label_9.setBounds(381, 277, 66, 15);
		add(label_9);
		
		JLabel label_10 = new JLabel("Y:");
		label_10.setBounds(381, 322, 66, 15);
		add(label_10);
		
		comboDestY = new JComboBox(model);
		comboDestY.setBounds(424, 304, 118, 35);
		add(comboDestY);
		
		dest = new JCheckBox("Horizontal?");
		dest.setBounds(381, 357, 126, 23);
		add(dest);
		
		JLabel lblDestroyer = new JLabel("Destroyer");
		lblDestroyer.setBounds(474, 229, 75, 16);
		add(lblDestroyer);
		
		JLabel label_12 = new JLabel("Ship To Set:");
		label_12.setBounds(636, 40, 118, 15);
		add(label_12);
		
		comboCruX = new JComboBox(model);
		comboCruX.setBounds(679, 67, 118, 35);
		add(comboCruX);
		
		JLabel label_13 = new JLabel("X:");
		label_13.setBounds(636, 87, 66, 15);
		add(label_13);
		
		JLabel label_14 = new JLabel("Y:");
		label_14.setBounds(636, 132, 66, 15);
		add(label_14);
		
		comboCruY = new JComboBox(model);
		comboCruY.setBounds(679, 114, 118, 35);
		add(comboCruY);
		
		cruiser = new JCheckBox("Horizontal?");
		cruiser.setBounds(636, 167, 126, 23);
		add(cruiser);
		
		JLabel lblSubmarine = new JLabel("Submarine");
		lblSubmarine.setBounds(729, 39, 81, 16);
		add(lblSubmarine);
		
		JButton btnNewButton = new JButton("Place Ships");
		btnNewButton.addActionListener(sc);
		btnNewButton.setActionCommand("Submit");
		btnNewButton.setBounds(638, 264, 159, 72);
		add(btnNewButton);
		
		//Set visibility and other values such as size
		this.setVisible(true);
	}
	
	//Set getters for all comboboxes and checkboxes
	public JComboBox getComboFrigrateX()
	{
		return comboFrigrateX;
	}
	
	public JComboBox getComboFrigrateY()
	{
		return comboFrigrateY;
	}
	
	public JComboBox getComboBattleX()
	{
		return comboBattleX;
	}
	
	public JComboBox getComboBattleY()
	{
		return comboBattleY;
	}
	
	public JComboBox getComboSubX()
	{
		return comboSubX;
	}
	
	public JComboBox getComboSubY()
	{
		return comboSubY;
	}
	
	public JComboBox getComboDestX()
	{
		return comboDestX;
	}
	
	public JComboBox getComboDestY()
	{
		return comboDestY;
	}
	
	public JComboBox getComboCruX()
	{
		return comboCruX;
	}
	
	public JComboBox getComboCruY()
	{
		return comboCruY;
	}
	
	public JCheckBox getFrig() {
		return frig;
	}

	public JCheckBox getBattle() {
		return battle;
	}

	public JCheckBox getSub() {
		return sub;
	}

	public JCheckBox getDest() {
		return dest;
	}

	public JCheckBox getCruiser() {
		return cruiser;
	}
}
