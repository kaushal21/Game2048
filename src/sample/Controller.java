package sample;
import java.util.Random;

public class Controller {
    long score;                          // It stores the score for the player.
    int[] a;                             // It stores the numbers present in the block from 0 to 15 in the board.
    int[] grid;                          // Stores 1 if the block id occupied, otherwise stores 0.

    /**
     * Controller() initializes the board, and the score.
     */
    public Controller() {
        a = new int[16];
        grid = new int[16];
        for(int i = 0; i < 16; i++) {
            a[i] = 0;
            grid[i] = 0;
        }
        score = 0;
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
     * Returns the 'x' and 'y' coordinate for the generated block
     * @param block the newly generated block where we will place a new number
     * @return int[] of x at index 0, and y at index 1. if the block is out of range then return -1, -1.
     */
    public int[] gridLocation(int block) {
        int[] location = new int[2];
        switch ( block ) {
            case 0:
                // location: (0, 0)
                return location;
            case 1:
                // location: (0, 1)
                location[1] = 1;
                return location;
            case 2:
                // location: (0, 2)
                location[1] = 2;
                return location;
            case 3:
                // location: (0, 3)
                location[1] = 3;
                return location;
            case 4:
                // location: (1, 0)
                location[0] = 1;
                return location;
            case 5:
                // location: (1, 1)
                location[0] = 1;
                location[1] = 1;
                return location;
            case 6:
                // location: (1, 2)
                location[0] = 1;
                location[1] = 2;
                return location;
            case 7:
                // location: (1, 3)
                location[0] = 1;
                location[1] = 3;
                return location;
            case 8:
                // location: (2, 0)
                location[0] = 2;
                return location;
            case 9:
                // location: (2, 1)
                location[0] = 2;
                location[1] = 1;
                return location;
            case 10:
                // location: (2, 2)
                location[0] = 2;
                location[1] = 2;
                return location;
            case 11:
                // location: (2, 3)
                location[0] = 2;
                location[1] = 3;
                return location;
            case 12:
                // location: (3, 0)
                location[0] = 3;
                return location;
            case 13:
                // location: (3, 1)
                location[0] = 3;
                location[1] = 1;
                return location;
            case 14:
                // location: (3, 2)
                location[0] = 3;
                location[1] = 2;
                return location;
            case 15:
                // location: (3, 3)
                location[0] = 3;
                location[1] = 3;
                return location;
        }
        // location: (-1, -1)
        location[0] = -1;
        location[1] = -1;
        return location;
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

    public void display() {
        int k = 0, l = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(a[k++]+" ");
            }
            System.out.print("\t\t\t");
            for(int j = 0; j < 4; j++) {
                System.out.print(grid[l++]+" ");
            }
            System.out.println();
        }
    }
}