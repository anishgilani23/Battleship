package main.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import main.boardmechanics.Coordinate;

public class BattleShipController implements ActionListener{
	private GameClientController controller;
	
	public BattleShipController(GameClientController control)
	{
		this.controller = control;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		
		//Parse the string out into x and y
		String[] str = action.split("-");
		
		//Generate a new coordinate
		Coordinate coord = new Coordinate();
		coord.setX(Integer.parseInt(str[0]));
		coord.setY(Integer.parseInt(str[1]));
		
		//Send the coordinate to the server
		try {
			controller.sendToServer(coord);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
