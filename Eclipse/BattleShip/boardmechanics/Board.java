
package boardmechanics;

import java.util.*;

public class Board 
{
	private ArrayList<Coordinate> grid = new ArrayList<Coordinate>();
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	//private HashMap<String, Ship> ships= new HashMap<String, Ship>();

	public Board()
	{
		//Add coordinates for a 10X10 board
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				grid.add(new Coordinate(i,j));
			}
		}
		
		//Initialize ships 
		ships.add(new Ship("Carrier",5));
		ships.add(new Ship("Battleship",4));
		ships.add(new Ship("Cruiser",3));
		ships.add(new Ship("Submarine",3));
		ships.add(new Ship("Destroyer",2));
		
//		ships.put("Carrier", new Ship("Carrier",5));
//		ships.put("Battleship", new Ship("Battleship",4));
//		ships.put("Cruiser", new Ship("Cruiser",3));
//		ships.put("Submarine", new Ship("Submarine",3));
//		ships.put("Destroyer", new Ship("Destroyer",2));
	}
	
	
	public ArrayList<Ship> getSunkShips()
	{
		ArrayList<Ship> temp = new ArrayList<Ship>();
		for(int i = 0;i<ships.size();i++)
		{
			if(ships.get(i).isSunk()) 
			{
				temp.add(ships.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Ship> getUnsunkShips()
	{
		ArrayList<Ship> temp = new ArrayList<Ship>();
		for(int i = 0;i<ships.size();i++)
		{
			if(!ships.get(i).isSunk()) 
			{
				temp.add(ships.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Ship> getShips()
	{
		return ships;
	}
	
	public void markOff(Coordinate coord)
	{
		for(int i =0;i<grid.size();i++)
		{
			if(grid.get(i).getX() == coord.getX() && grid.get(i).getY() == coord.getY()) 
			{
				grid.get(i).setSelected(true);//Mark that this coordinate has been selected
				
				//Go through each ship's coordinates and see if any were hit
				for(Ship ship : ships)
				{
					for(Coordinate shipCoord : ship.getCoordinates())
					{
						if(shipCoord.getX() == coord.getX() && shipCoord.getY() == coord.getY())
						{
							shipCoord.setHit(true);//Mark the ship has been hit in the ship list
							grid.get(i).setHit(true);//Mark a ship been hit on the grid
							ship.isSunk();//Check to see if ship is now sunk
						}
					}
				}
				
			}
		}
	}
	
	public void attack()
	{
		
	}
}
