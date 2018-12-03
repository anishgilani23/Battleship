package main.boardmechanics;

import java.util.ArrayList;

public class Ship {
	private String type;
	private boolean sunk;
	private int length;
	private ArrayList<Coordinate> position;
	
	public Ship()
	{
		sunk = false;
		position = new ArrayList<Coordinate>();
	}
	
	public void sink()
	{
		sunk = true;
	}
	
	public boolean isSunk()
	{
		return sunk;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setPosition(ArrayList<Coordinate> position)
	{
		this.position = position;
	}
	
	public ArrayList<Coordinate> getPosition()
	{
		return position;
	}

}
