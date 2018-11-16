package boardmechanics;

public class Coordinate 
{
	private int x;
	private int y;
	private boolean selected;
	private boolean hit;

	
	public Coordinate(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.selected = false;
		this.hit = false;
	}
	
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	public boolean getSelected()
	{
		return selected;
	}
	
	public void setHit(boolean hit)
	{
		this.hit = hit;
	}
	
	public boolean getHit()
	{
		return hit;
	}
}
