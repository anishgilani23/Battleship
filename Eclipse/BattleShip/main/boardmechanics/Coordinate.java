package main.boardmechanics;

import java.io.Serializable;

public class Coordinate implements Serializable {
	private int x;
	private int y;
	private boolean mark;
	private boolean hit;

	public Coordinate()
	{
		mark = false;
		hit = false;
	}

	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getMark()
	{
		return mark;
	}
	
	public void markOff()
	{
		this.mark = true;
	}
	
	public boolean getHit() 
	{
		return hit;
	}

	public void setHit(boolean hit) 
	{
		this.hit = hit;
	}
}
