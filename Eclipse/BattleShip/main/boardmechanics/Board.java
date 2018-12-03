package main.boardmechanics;

import java.util.ArrayList;
import java.util.Map;

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
		//Create an 11x11 grid (121)
		for (int i = 0; i < 11; i++)
		{
			Coordinate coord = new Coordinate();
			coord.setY(i);
			for (int j = 0; j < 11; j++)
			{
				coord.setX(j);
				Theirgrid.add(coord);
			}
		}
	}
	
	public void initMyGrid()
	{
		//Create an 11x11 grid (121)
		for (int i = 0; i < 11; i++)
		{
			Coordinate coord = new Coordinate();
			coord.setY(i);
			for (int j = 0; j < 11; j++)
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
		ArrayList<Coordinate> position = new ArrayList<Coordinate>();
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
