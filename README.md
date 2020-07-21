# Game 2048

*This is a sample game replicating 2048.*

2048 is a single-player sliding block puzzle game designed by Italian web developer Gabriele Cirulli.
The objective of the game is to slide numbered tiles on a grid to combine them to create a tile with the number 2048; however, one can continue to play the game after reaching the goal, creating tiles with larger numbers.

2048 is played on a gray 4×4 grid, with numbered tiles that slide when a player moves them using the four arrow keys.
Every turn, a new tile will randomly appear in an empty spot on the board with a value of either 2 or 4.
Tiles slide as far as possible in the chosen direction until they are stopped by either another tile or the edge of the grid.
If two tiles of the same number collide while moving, they will merge into a tile with the total value of the two tiles that collided.
The resulting tile cannot merge with another tile again in the same move. Higher-scoring tiles emit a soft glow.

If a move causes three consecutive tiles of the same value to slide together, only the two tiles farthest along the direction of motion will combine.
If all four spaces in a row or column are filled with tiles of the same value, a move parallel to that row/column will combine the first two and last two.

A scoreboard on the upper-right keeps track of the user's score.
The user's score starts at zero, and is increased whenever two tiles combine, by the value of the new tile.
As with many arcade games, the user's best score is shown alongside the current score.

The game is won when a tile with a value of 2048 appears on the board, hence the name of the game.
After reaching the 2048 tile, players can continue to play (beyond the 2048 tile) to reach higher scores.
When the player has no legal moves (there are no empty spaces and no adjacent tiles with the same value), the game ends.
The game can only last a finite amount of moves, and the theoretical limit for the highest tile on a standard 4x4 board is 131,072.

## Functions 

### Index

This Page gives the options to the user to know a little more about the game, the instructions and the high scores stored.
With the Option to play it also shows a credit section which displays my motivation to develop this game.

### About

This section show what the game is all about.

### Instruction

This section gives the rules to play the game. It displays the rules that need to be followed and how th game functions.

### High Score

The game stores the highscores of the player in a temporary file. It is done so that next time the players has a high score to beat.

### Credit

This section gives my motivation of developing the game. It also shows my LinkdeIn profile link that maybe used to connect.

### Playing The Game

There is a scoreboard on the top right side of the screen with the highscore.
While playing the game, use the arrow keys to move in UP, DOWN, RIGHT and LEFT direction.


