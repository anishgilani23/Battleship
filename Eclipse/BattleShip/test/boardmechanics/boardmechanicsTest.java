package test.boardmechanics;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import main.boardmechanics.Board;
import main.boardmechanics.Coordinate;
import main.boardmechanics.Ship;

public class boardmechanicsTest {
	private Board board;

	@Test
	public void IntegrationTest() {
		//Define the variables
		board = new Board();
		List<Ship> ships;
		List<Coordinate> coords;
		
		//Set the ships for the board to a random location
		board.setShips();
		
		//Now get the ships and assert not null
		ships = board.getShips();
		assertNotNull(ships);
		
		//Now get the list of coordinates of the first ship and assert not null
		coords = ships.get(0).getPosition();
		assertNotNull(coords);
		
	}

}
