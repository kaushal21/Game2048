package sample;
import com.sun.marlin.stats.Histogram;
import javafx.scene.control.Control;

import java.util.List;
import java.util.Random;

public class Controller {
    long score;                          // It stores the score for the player.
    int[] a;                             // It stores the numbers present in the block from 0 to 15 in the board.
    int[] grid;                          // Stores 1 if the block id occupied, otherwise stores 0.
    long highScore;

    /**
     * Controller() initializes the board, the score and the read the high score from the csv.
     */
    public Controller() {
        a = new int[16];
        grid = new int[16];
        for(int i = 0; i < 16; i++) {
            a[i] = 0;
            grid[i] = 0;
        }
        score = 0;
        HighScore hS = new HighScore();
        List<List<String>> temp = hS.ReadScore();
        try {
            List<String> ranker = temp.get(1);
            this.highScore = Long.valueOf(ranker.get(2));
        } catch (Exception e) {
            this.highScore = 0;
            e.printStackTrace();
        }
    }

    /**
     * @param x index for which we want the value from the grid matrix.
     * @return the value for the given index in Grid matrix for the board.
     */
    public int getGrid(int x) {
        return grid[x];
    }

    /**
     * @param x index for which we want the value from the A matrix.
     * @return the value for the given index in A matrix of the board.
     */
    public int getA(int x) {
        return a[x];
    }

    /**
     * @return the score for the game
     */
    public long getScore() {
        return score;
    }

    /**
     * @return the High score that was read from the csv.
     */
    public long getHighScore() {
        return highScore;
    }

    /**
     * @param x the location of new block
     * @param val the value to for the new block
     */
    public void setA(int x, int val) {
        a[x] = val;
    }

    /**
     * @param x the location which is now occupied, and we have to update its status in grid as 1.
     */
    public void setGrid(int x) {
        grid[x] = 1;
    }

    /**
     * Number Generation Function - Generates a number between 2 and 4 randomly
     */
    public int numberGeneration() {
        Random random = new Random();
        int x = random.nextInt( 2 ) ;
        if ( x == 0 )
            return 2 ;
        else
            return 4 ;
    }

    /**
     * Block Generation Function - Generates a block in the board which is empty
     * @return int between 0 and 15 for which the block in the board in empty
     */
    public int blockGeneration() {
        int x;
        Random random = new Random();
        do {
            x = random.nextInt(16);
        } while ( grid[x] != 0 );
        return x ;
    }

    /**
     * Game Over Function
     * @return true if there is no empty space in the board i.e. Game Over, otherwise it returns false.
     */
    public boolean gameOver(){
        for(int i = 0; i < 16; i++) {
            if ( grid[i] == 0 ) {
                return false;
            }
        }
        for(int i = 12; i < 16; i++) {
            boolean val = gameOverWithNoZero(i, i - 4, i - 8, i - 12);
            if ( !val ) {
                return false;
            }
        }
        for(int i = 0; i <= 12; i += 4) {
            boolean val = gameOverWithNoZero(i, i+1, i+2, i+3);
            if ( !val ) {
                return false;
            }
        }
        for(int i = 3; i <= 15; i += 4) {
            boolean val = gameOverWithNoZero(i, i-1, i-2, i-3);
            if ( !val ) {
                return false;
            }
        }
        for(int i = 0; i <= 3; i++) {
            boolean val = gameOverWithNoZero(i, i+4, i+8, i+12);
            if ( !val ) {
                return false;
            }
        }
        return true;
    }

    /**
     * This function checks if there are same number in the neighbouring blocks or not
     * @param i Block Number for the first Block in row or column
     * @param i1 Block Number for the second Block in row or column
     * @param i2 Block Number for the third Block in row or column
     * @param i3 Block Number for the fourth Block in row or column
     * @return true if there is no possible move, otherwise it returns false.
     */
    public boolean gameOverWithNoZero(int i, int i1, int i2, int i3) {
        if( getA(i) == getA(i1) && getA(i2) == getA(i3) ) {
            return false;
        }
        if( getA(i) != getA(i1) && getA(i1) == getA(i2) ) {
            return false;
        }
        if( getA(i) == getA(i1) && getA(i2) != getA(i3) ) {
            return false;
        }
        if( getA(i) != getA(i1) && getA(i2) == getA(i3) ) {
            return false;
        }
        return true;
    }

    /**
     * It updates the board and also the grid
     * @param l the first location in the line
     * @param b the second location in the line
     * @param c the third location in the line
     * @param d the fourth location in the line
     * @param p new value to be allocated too first location
     * @param q new value to be allocated too second location
     * @param r new value to be allocated too third location
     * @param s new value to be allocated too fourth location
     */
    public void updateBlocks(int l, int b, int c, int d, int p, int q, int r, int s) {
        a[l] = p;
        a[b] = q;
        a[c] = r;
        a[d] = s;
        if ( p == 0 )
            grid[l] = 0;
        else
            grid[l] = 1;
        if ( q == 0 )
            grid[b] = 0;
        else
            grid[b] = 1;
        if ( r == 0 )
            grid[c] = 0;
        else
            grid[c] = 1;
        if ( s == 0 )
            grid[d] = 0;
        else
            grid[d] = 1;
    }

    /**
     * It updates the score of the game
     * @param addingValue the value that is generated by most recent move which is required to be added to the score
     */
    public void updateScore(int addingValue) {
        score += addingValue;
    }
}
