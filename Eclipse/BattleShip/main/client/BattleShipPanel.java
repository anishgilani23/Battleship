package main.client;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleShipPanel extends JPanel {
	public BattleShipPanel(JPanel container)
	{
		//Set layout to absolute
		this.setLayout(null);
		
		//Add opponent board of buttons
		JLabel theirBoard = new JLabel();
		theirBoard.setText("Their Board");
		theirBoard.setBounds(12, 5, 90, 25);
		this.add(theirBoard);
		
		int x = 12;
		int y = 50;
		int height = 35;
		int width = 35;
		List<JButton> theirButtons = new ArrayList<JButton>();
		
		for (int i = 0; i < 10; i++)
		{
			x = 12;
			for (int j = 0; j < 10; j++)
			{
				JButton button = new JButton();
				theirButtons.add(button);
				button.setBounds(x, y, width, height);
				x += 35;
				this.add(button);
			}
			y += 35;
		}
		
		//Now add attack button and label for determining who's turn it is
		JLabel turn = new JLabel();
		turn.setText("Your Turn!");
		turn.setBounds(385, 200, 90, 40);
		turn.setForeground(Color.GREEN);
		this.add(turn);
		
		JButton attack = new JButton();
		attack.setText("Attack!");
		attack.setBounds(380, 250, 90, 40);
		this.add(attack);
		
		//Now add player board
		List<JButton> myButtons = new ArrayList<JButton>();
		JLabel yourBoard = new JLabel();
		yourBoard.setText("Your Board");
		yourBoard.setBounds(485, 5, 90, 25);
		this.add(yourBoard);
		
		x = 485;
		y = 50;
		
		for (int i = 0; i < 10; i++)
		{
			x = 485;
			for (int j = 0; j < 10; j++)
			{
				String b = new String("button");
				JButton button = new JButton();
				button.setBounds(x, y, width, height);
				button.setEnabled(false);
				myButtons.add(button);
				x += 35;
				this.add(button);
			}
			y += 35;
		}
		
		//Set some properties for the client panel
		this.setSize(new Dimension(850, 450));
		this.setVisible(true);
	}
}
