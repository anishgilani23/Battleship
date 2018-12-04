package main.boardmechanics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
	private ArrayList<Coordinate> Theirgrid;
	private ArrayList<Coordinate> myGrid;
	private ArrayList<Ship> ships;
	
	public Board()
	{
		ships = new ArrayList<Ship>();
		Theirgrid = new ArrayList<Coordinate>();
		myGrid = new ArrayList<Coordinate>();
	}
	
	public void initTheirGrid()
	{
		//Create an 10x10 grid (120)
		for (int i = 0; i < 10; i++)
		{
			Coordinate coord = new Coordinate();
			coord.setY(i);
			for (int j = 0; j < 10; j++)
			{
				coord.setX(j);
				Theirgrid.add(coord);
			}
		}
	}
	
	public void initMyGrid()
	{
		//Create an 10x10 grid (120)
		for (int i = 0; i < 10; i++)
		{
			Coordinate coord = new Coordinate();
			coord.setY(i);
			for (int j = 0; j < 10; j++)
			{
				coord.setX(j);
				myGrid.add(coord);
			}
		}
	}
	
	public ArrayList<Ship> getUnsunkShips()
	{
		//Loop through every ship and see if it is sunk and build a new arraylist based off this and return it
		ArrayList<Ship> unsunk = new ArrayList<Ship>();
		for (int i = 0; i < ships.size(); i++)
		{
			if (ships.get(i).isSunk() == false)
			{
				unsunk.add(ships.get(i));
			}
		}
		
		return unsunk;
	}
	
	public ArrayList<Ship> getSunkShips()
	{
		ArrayList<Ship> sunk = new ArrayList<Ship>();
		for (int i = 0; i < ships.size(); i++)
		{
			if (ships.get(i).isSunk() == true)
			{
				sunk.add(ships.get(i));
			}
		}
		
		return sunk;
	}
	
	public void setShips()
	{
		//Set the ships to a random location
		//Carrier - 5, Battleship - 4, Cruiser - 3, Submarine - 3 Destroyer - 2
		
		//First, set the carrier
		//For carrier, get a random number between 1 and 6 for x coord and if and only if it is 4,5,6 then it has a 50% chance of being horizontal
		boolean horizontal = false;
		int min = 1;
		int max = 6;
		int x = ThreadLocalRandom.current().nextInt(min, max + 1);
		int y = 1;
		
		if (x == 4 || x == 5 || x == 6)
		{
			double chance = Math.random();
			if (chance > .50)
			{
				horizontal = true;
			}
			else
			{
				horizontal = false;
			}
		}
		if (horizontal == true)
		{
			max = 10;
			y = ThreadLocalRandom.current().nextInt(min, max+ 1);
		}
		else if (horizontal = false)
		{
			min = 4;
			max = 6;
			y = ThreadLocalRandom.current().nextInt(min, max+ 1);
		}
		
		//Set the location of the carrier
		List<Coordinate> position = new ArrayList<Coordinate>();
		for (int i = 0; i < 5; i++)
		{
			Coordinate c = new Coordinate();
			c.setX(x);
			c.setY(y);
			position.add(c);
			if (horizontal)
			{
				x += 1;
			}
			else
			{
				y += 1;
			}
		}
		
		Ship carrier = new Ship();
		carrier.setLength(5);
		carrier.setType("Carrier");
		carrier.setPosition(position);
		
		//Now add Frigrate
	}
	
	public ArrayList<Ship> getShips()
	{
		return ships;
	}
	
	public void markOff(Coordinate coord)
	{
		//Check all coordinates to get a match then set it to marked off
		for (int i = 0; i < Theirgrid.size(); i++)
		{
			if (Theirgrid.get(i).equals(coord))
			{
				Theirgrid.get(i).markOff();
			}
		}
	}
	
	public void attack(Coordinate coord)
	{
		markOff(coord);
	}
	
	public boolean getAttacked(Coordinate coord)
	{
		//First, check if the point has a ship on it and declare it "hit"
		boolean hit = false; 
		List<Coordinate> position = new ArrayList<Coordinate>();
		for (int i = 0; i < ships.size(); i++)
		{
			position = ships.get(i).getPosition();
			for (int j = 0; j < position.size(); i++)
			{
				if (coord.equals(position.get(j)))
				{
					position.get(j).setHit(true);
					hit = true;
				}
			}
		}
		
		return true;
	}
}
