package boardmechanics;

import java.util.ArrayList;

public class TestBoardMechanics
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Board game = new Board();
		ArrayList<Ship> stuff = game.getShips();
		
		for(int i=0;i<stuff.size();i++)
		{
		System.out.println(stuff.get(i).getType() + " " + stuff.get(i).getLength()+ "\n");
		}
	}

}
