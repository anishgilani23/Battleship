package main.client;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoginController implements ActionListener {
	  // Private data fields for the container and chat client.
	  private JPanel container;
	  private GameClientController client;
	  
	  // Constructor for the login controller.
	  public LoginController(JPanel container, GameClientController client)
	  {
	    this.container = container;
	    this.client = client;
	  }
	  
	  // Handle button clicks.
	  public void actionPerformed(ActionEvent ae)
	  {
	    // Get the name of the button clicked.
	    String command = ae.getActionCommand();

	    // The Cancel button takes the user back to the initial panel.
	    if (command == "Cancel")
	    {
	      CardLayout cardLayout = (CardLayout)container.getLayout();
	      cardLayout.show(container, "1");
	    }

	    // The Submit button submits the login information to the server.
	    else if (command == "Submit")
	    {
	      // Get the username and password the user entered.
	      LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
	      String username = loginPanel.getUsername();
	      String password = loginPanel.getPassword();
	      
	      // Check the validity of the information locally first.
	      if (username.equals("") ||password.equals(""))
	      {
	        displayError("You must enter a username and password.");
	        return;
	      }

	      // Submit the login information to the server.
	      LoginData logindata = new LoginData(username, password);
	      try
	      {
	        client.sendToServer(logindata);
	      }
	      catch (IOException e)
	      {
	        displayError("Error connecting to the server.");
	        e.printStackTrace();
	      }
	    }
	  }

	  // After the login is successful, set the User object and display the contacts screen.
	  public void loginSuccess()
	  {
	    LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
	    GameClientPanel clientGUI = (GameClientPanel)SwingUtilities.getWindowAncestor(loginPanel);
	    clientGUI.setUser(new User(loginPanel.getUsername(), loginPanel.getPassword()));
	    CardLayout cardLayout = (CardLayout)container.getLayout();
	    cardLayout.show(container, "4");
	  }

	  // Method that displays a message in the error label.
	  public void displayError(String error)
	  {
	    LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
	    loginPanel.setError(error);
	  }
}
