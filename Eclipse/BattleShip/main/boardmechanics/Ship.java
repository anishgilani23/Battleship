package main.boardmechanics;

import java.util.ArrayList;
import java.util.List;

public class Ship {
	private String type;
	private boolean sunk;
	private int length;
	private List<Coordinate> position;
	
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
	
	public void setPosition(List<Coordinate> location)
	{
		this.position = location;
	}
	
	public List<Coordinate> getPosition()
	{
		return position;
	}

}
