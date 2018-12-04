package main.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShipsetController implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//First, get the command
		String command = arg0.getActionCommand();
		
		//If the command is the button, perform the necessary actions
		if (command.equals("Submit"))
		{
			System.out.println("HEREEEEEEEEEEEEEEE");
			
		}
	}

}
