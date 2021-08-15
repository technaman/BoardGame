SnakeLadderBoard can maintain the information of Player Location
Game can be agnostic of player locations
Game has a board. Board has locations info

Board can return playerLocation via:
Map<Player, Cell> playerLocation;
playerLocation.get(playerOne); // returns the cell for the player


How can I know if the currentCell has a player?
Or the current cell has a snake/ladder?

Cell should have info about player
Cell should have info about elements

cell.getPlayer(); // returns player present at cell or null

board.updateLocation(Player player, Cell newLocation)
// Moves the player to the newLocation
// unsets the player from the currentLocation

But, every cell will not have a element/player.
It is waste of memory to have that as a class element

We can create another map.
Map<Cell, Player> playerCellMapping; 
// We need to support duplicate keys.
// Since multiple players may hold the same cell.
board.updateLocation(player, currentLocation, newLocation)
- unset playerCellMapping.remove(currentLocation, player); 
- update playerLocation.put(player, newLocation)








