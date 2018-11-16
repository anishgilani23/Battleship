package boardmechanics;

import java.util.ArrayList;

public class Ship
{
	private String type;
	ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();
	private int length;
	private boolean sunk;
	
	public Ship(String type, int length)
	{
		this.type = type;
		this.length = length;
		this.sunk = false;
	}
	
	public void sink()
	{
		sunk = true;
	}
	
	public boolean isSunk()
	{
		sunk = true;
		
		//Go through the ships coordinates and if not all have been hit, set sunk to false
		for(int i=0;i<coordinates.size();i++)
		{
			if(!coordinates.get(i).getHit())
			{
				sunk = false;
			}
		}
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
	
	public String getType()
	{
		return type;
	}
	
	public void setType()
	{
		this.type = type;
	}
	
	public ArrayList<Coordinate> getCoordinates()
	{
		return coordinates;
	}
	
	public void setCoordinates(ArrayList<Coordinate> coords)
	{
		this.coordinates = coords;
	}
}
