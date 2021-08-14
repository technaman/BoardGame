GameController
- can start a game
- can pause/end a game
- add players to a game
- remove players from a game

Player
- belongs to a game
- can join/exit a game
- can generate a move
- is a User

-----------------------------------
Game
- has Players
- has GameStats
- has a Board
- has a ruleSet
- has GameElements
- can validate a move
- can execute a move
- can changePlayerTurn
- can getPlayerMove

GameElements   

Board
- belongs to a game
- has Cells
- has a currentState

Cell 
- is a Point

Move
- has a roll value

RuleSet
- can validate a move
______________________________________

SnakeAndLadderGame
- is a Game
- has a SnakeAndLadderBoard
- has Players
- has SnakeAndLadderGameStats
- has SnakeAndLadderRuleSet
- has Snakes
- has Ladders

Snake
- is a GameElement

Ladder
- is a GameElement

SnakeAndLadderBoard
- is a Board
- has SnakeAndLadderCells

SnakeAndLadderCell
- is a Cell

SnakeAndLadderMove
- is a Move

______________________________________

