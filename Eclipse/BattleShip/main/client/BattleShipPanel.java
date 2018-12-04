package main.client;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.boardmechanics.Board;
import main.boardmechanics.Coordinate;
import main.boardmechanics.Ship;

public class BattleShipPanel extends JPanel {
	public BattleShipPanel(JPanel container)
	{
		//Set layout to absolute
		this.setLayout(null);
		this.setSize(new Dimension(850, 450));
		
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
		
		//First, set the board in the backend
		Board board = new Board();
		ArrayList<Ship> ships = new ArrayList<Ship>();
		ships = board.getShips();
		Ship carrier = ships.get(0);
		//Ship battleship = ships.get(1);
		//Ship cruiser = ships.get(2);
		//Ship submarine = ships.get(3);
		//Ship destroyer = ships.get(4);
		
		//Now add player board
		List<JButton> myButtons = new ArrayList<JButton>();
		JLabel yourBoard = new JLabel();
		yourBoard.setText("Your Board");
		yourBoard.setBounds(485, 5, 90, 25);
		this.add(yourBoard);
		
		x = 485;
		y = 50;
		
		//Make an arraylist of coordinates
		List<Coordinate> myCoords = new ArrayList<Coordinate>();
		Map<Coordinate, JButton> map = new HashMap<Coordinate, JButton>();
		
		
		//y loop
		for (int i = 1; i < 11; i++)
		{
			Coordinate coord = new Coordinate();
			x = 485;
			//x loop
			for (int j = 1; j < 11; j++)
			{
				String b = new String("button");
				JButton button = new JButton();
				button.setBounds(x, y, width, height);
				button.setEnabled(false);
				myButtons.add(button);
				coord.setX(j);
				coord.setY(i);
				
				//Check and see where the ships are and highlight those colors
				for (int k = 0; k < carrier.getLength(); k++)
				{
					button.setForeground(Color.BLUE);
				}
				
				x += 35;
				this.add(button);
				
				//Add to the map
				map.put(coord, button);
			}
			y += 35;
		}
		
		
		//After all of this, make the panel visible
		this.setVisible(true);
	}
	
}
