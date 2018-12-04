package main.client;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
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
	private GameClientController control;
	private List<JButton> theirButtons;
	private List<Coordinate> theirCoords;
	private List<Coordinate> ourCoords;
	Map<Coordinate, JButton> map;
	
	public BattleShipPanel(JPanel container, GameClientController control)
	{
		//Create a controller for the panel
		BattleShipController controller = new BattleShipController(control);
		control.setBattleShipController(controller);
		this.control = control;
		
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
		theirButtons = new ArrayList<JButton>();
		theirCoords = new ArrayList<Coordinate>();
		
		for (int i = 0; i < 10; i++)
		{
			x = 12;
			for (int j = 0; j < 10; j++)
			{
				Coordinate coord = new Coordinate();
				coord.setX(j);
				coord.setY(i);
				theirCoords.add(coord);
				JButton button = new JButton();
				String actionCommand = i + "-" + j;
				button.setActionCommand(actionCommand);
				button.addActionListener(controller);
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
		
		//First, set the board in the backend
		Board board = new Board();
		ArrayList<Ship> ships = board.getShips();
		Ship carrier = ships.get(0);
		Ship battleship = ships.get(1);
		Ship cruiser = ships.get(2);
		Ship submarine = ships.get(3);
		Ship destroyer = ships.get(4);
		
		//Now add player board
		List<JButton> myButtons = new ArrayList<JButton>();
		JLabel yourBoard = new JLabel();
		yourBoard.setText("Your Board");
		yourBoard.setBounds(485, 5, 90, 25);
		this.add(yourBoard);
		
		x = 485;
		y = 50;
		
		//Make an arraylist of coordinates
		ourCoords = new ArrayList<Coordinate>();
		map = new HashMap<Coordinate, JButton>();
		
		
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
				coord.setX(j);
				coord.setY(i);
				button.setOpaque(true);

				//Check and see where the ships are and highlight those colors
				for (int k = 0; k < carrier.getLength(); k++)
				{
					//First the carrier
					if (carrier.getPosition().get(k).getX() == coord.getX() && carrier.getPosition().get(k).getY() == coord.getY())
					{
						button.setBackground(Color.BLUE);
						coord.markOff();
					}
				}
				
				for (int k = 0; k < battleship.getLength(); k++)
				{
					//Now the battleship
					if (battleship.getPosition().get(k).getX() == coord.getX() && battleship.getPosition().get(k).getY() == coord.getY())
					{
						button.setBackground(Color.GREEN);
						coord.markOff();
					}
				}
				
				for (int k = 0; k < cruiser.getLength(); k++)
				{
					//Now the cruiser
					if (cruiser.getPosition().get(k).getX() == coord.getX() && battleship.getPosition().get(k).getY() == coord.getY())
					{
						button.setBackground(Color.RED);
						coord.markOff();
					}
				}
				
				for (int k = 0; k < submarine.getLength(); k++)
				{
					//Now the submarine
					if (submarine.getPosition().get(k).getX() == coord.getX() && battleship.getPosition().get(k).getY() == coord.getY())
					{
						button.setBackground(Color.ORANGE);
						coord.markOff();
					}
				}
				
				for (int k = 0; k < destroyer.getLength(); k++)
				{
					//Now the destoyer
					if (destroyer.getPosition().get(k).getX() == coord.getX() && battleship.getPosition().get(k).getY() == coord.getY())
					{
						button.setBackground(Color.PINK);
						coord.markOff();
					}
				}
				ourCoords.add(coord);
				x += 35;
				this.add(button);
				button.setEnabled(false);
				myButtons.add(button);
				
				//Add to the map
				map.put(coord, button);
			}
			y += 35;
		}
		
		
		//After all of this, make the panel visible
		this.setVisible(true);
	}

	public void updateBoard(Coordinate coord) {
		//This method was called
		for (int i = 0; i < ourCoords.size(); i++)
		{
			if (ourCoords.get(i).equals(coord))
			{
				if (ourCoords.get(i).getMark() == true)
				{
					ourCoords.get(i).setHit(true);
					/*
					try {
						control.sendToServer("Hit");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
					map.get(coord).setBackground(Color.BLACK);
				}
			}
		}
	}
}
