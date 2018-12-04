# Battleship
Steps for running the project:

# First
Create the database called "sengine" (stands for software engineering).  You can also name it something else, but be sure that you update the db.properties file.  Leave your root password as blank (again, you can use a password, just update db.properties accordingly).

Now, source in battleship.sql to generate the user table in your database

# Second
Run the server.bat file found in the root folder.  This will start the server, and you should see a gui pop up.

# Third
Now that the server is up and running, you can start the clients.  Run the client.bat file found in the root folder. You should see a gui pop up and the server log should reflect this.  Next, run the client.bat file again to generate another client.  Another gui should pop up and again the server log should reflect this.

# Fourth
Play!  The ships are initialized to random locations on the board for each client.  Play until all ships of one player are sunk, then the game will be over and each player's board will be updated accordingly.  
