package sample;

public class Movement extends Controller{
    private int x6;                                 // Used for checking the edge cases

    /**
     * Used when the down Operation is called.
     * @return "d" if the operation is valid, otherwise it returns "n"
     */
    public String down() {
        x6 = 0;
        // Loop for the block number 12, 13, 14 and 15
        for(int i = 12; i < 16; i++)
            // Check the blocks in each column in bottom to top manner
            checkZerosInListOfBlocks(i, i-4, i-8, i-12);
        if ( x6 == 4 )
            return "d";
        return "n";
    }

    /**
     * Used when the left Operation is called.
     * @return "l" if the operation is valid, otherwise it returns "n"
     */
    public String left() {
        x6 = 0;
        // Loop for the block number 0, 4, 8 and 12
        for(int i = 0; i <= 12; i += 4)
            // Check the blocks in each row in left to right manner
            checkZerosInListOfBlocks(i, i+1, i+2, i+3);
        if ( x6 == 4 )
            return "l";
        return "n";
    }

    /**
     * Used when the right Operation is called.
     * @return "r" if the operation is valid, otherwise it returns "n"
     */
    public String right() {
        x6 = 0;
        // Loop for the block number 3, 7, 11 and 15
        for(int i = 3; i <= 15; i += 4)
            // Check the blocks in each row in right to left manner
            checkZerosInListOfBlocks(i, i-1, i-2, i-3);
        if ( x6 == 4 )
            return "r";
        return "n";
    }

    /**
     * Used when the up Operation is called.
     * @return "u" if the operation is valid, otherwise it returns "n"
     */
    public String up() {
        x6 = 0;
        // Loop for the block number 0, 1, 2 and 3
        for(int i = 0; i <= 3; i++)
            // Check the blocks in each column in top to bottom manner
            checkZerosInListOfBlocks(i, i+4, i+8, i+12);
        if ( x6 == 4 )
            return "u";
        return "n";
    }

    public void checkZerosInListOfBlocks(int i, int i1, int i2, int i3) {
        int sum = getGrid(i) + getGrid(i1)+ getGrid(i2) + getGrid(i3);
        switch (sum) {
            case 4:
                noZero(i, i1, i2, i3);
                break;
            case 3:
                singleZero(i, i1, i2, i3);
                break;
            case 2:
                doubleZero(i, i1, i2, i3);
                break;
            case 1:
                tripleZero(i, i1, i2, i3);
                break;
            case 0:
                x6++;
        }
    }
    public void noZero(int i, int i1, int i2, int i3) {
        if( getA(i) == getA(i1) && getA(i2) == getA(i3) ) {
            updateBlocks(i, i1, i2, i3, getA(i) + getA(i1), getA(i2) + getA(i3), 0, 0);
            updateScore(getA(i) + getA(i1));
            return;
        }
        if( getA(i) != getA(i1) && getA(i1) == getA(i2) ) {
            updateBlocks(i, i1, i2, i3, getA(i), getA(i1) + getA(i2), getA(i3), 0);
            updateScore(getA(i1));
            return;
        }
        if( getA(i) == getA(i1) && getA(i2) != getA(i3) ) {
            updateBlocks(i, i1, i2, i3, getA(i) + getA(i1), getA(i2), getA(i3), 0);
            updateScore(getA(i));
            return;
        }
        if( getA(i) != getA(i1) && getA(i2) == getA(i3) ) {
            updateBlocks(i, i1, i2, i3, getA(i), getA(i1), getA(i2) + getA(i3), 0);
            updateScore(getA(i2));
            return;
        }
        if( getA(i) != getA(i1) && getA(i1) != getA(i2) && getA(i2) != getA(i3)) {
            updateBlocks(i, i1, i2, i3, getA(i), getA(i1), getA(i2), getA(i3));
            updateScore(0);
            x6++;
        }
    }
    public void singleZeroIfCondition(int i, int i1, int i2, int i3, int a, int b, int c) {
        if( a == b ) {
            updateBlocks(i, i1, i2, i3, a + b, c, 0, 0);
            updateScore(a + b);
        } else if( b == c ) {
            updateBlocks(i, i1, i2, i3, a, b + c, 0, 0);
            updateScore(b + c);
        } else {
            updateBlocks(i, i1, i2, i3, a, b, c, 0);
            updateScore(0);
        }
    }
    public void singleZero(int i, int i1, int i2, int i3) {
        if( getA(i) == 0 && getA(i1) != 0 && getA(i2) != 0 && getA(i3) != 0 ) {
            singleZeroIfCondition(i, i1, i2, i3, getA(i1), getA(i2), getA(i3));
            return;
        }

        if( getA(i) != 0 && getA(i1) == 0 && getA(i2) != 0 && getA(i3) != 0 ) {
            singleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i2), getA(i3));
            return;
        }

        if( getA(i) != 0 && getA(i1) != 0 && getA(i2) == 0 && getA(i3) != 0 ) {
            singleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i1), getA(i3));
            return;
        }

        if( getA(i) != 0 && getA(i1) != 0 && getA(i2) != 0 && getA(i3) == 0 ) {
            if ( getA(i) != getA(i1) && getA(i1) != getA(i2) )
                x6++;
            singleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i1), getA(i2));
        }
    }
    public void doubleZeroIfCondition(int i, int i1, int i2, int i3, int a, int b) {
        if( a == b ) {
            updateBlocks(i, i1, i2, i3, a + b, 0, 0, 0);
            updateScore(a + b);
        } else {
            updateBlocks(i, i1, i2, i3, a, b, 0, 0);
            updateScore(0);
        }
    }
    public void doubleZero(int i, int i1, int i2, int i3) {
        if( getA(i) == 0 && getA(i1) == 0 && getA(i2) != 0 && getA(i3) != 0 ) {
            doubleZeroIfCondition(i, i1, i2, i3, getA(i2), getA(i3));
            return;
        }

        if( getA(i) == 0 && getA(i1) != 0 && getA(i2) == 0 && getA(i3) != 0 ) {
            doubleZeroIfCondition(i, i1, i2, i3, getA(i1), getA(i3));
            return;
        }

        if( getA(i) == 0 && getA(i1) != 0 && getA(i2) != 0 && getA(i3) == 0 ) {
            doubleZeroIfCondition(i, i1, i2, i3, getA(i1), getA(i2));
            return;
        }

        if( getA(i) != 0 && getA(i1) == 0 && getA(i2) == 0 && getA(i3) != 0 ) {
            doubleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i3));
            return;
        }

        if( getA(i) != 0 && getA(i1) == 0 && getA(i2) != 0 && getA(i3) == 0) {
            doubleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i2));
            return;
        }

        if( getA(i) != 0 && getA(i1) != 0 && getA(i2) == 0 && getA(i3) == 0 ) {
            if ( getA(i) != getA(i1) )
                x6++;
            doubleZeroIfCondition(i, i1, i2, i3, getA(i), getA(i1));
        }
    }
    public void tripleZero(int i, int i1, int i2, int i3) {
        if( getA(i) == 0 && getA(i1) == 0 && getA(i2) == 0 && getA(i3) != 0 ) {
            updateBlocks(i, i1, i2, i3, getA(i3), 0, 0, 0);
            updateScore(0);
            return;
        }
        if(getA(i)==0 && getA(i1)==0 && getA(i2)!=0 && getA(i3)==0) {
            updateBlocks(i, i1, i2, i3, getA(i2), 0, 0, 0);
            updateScore(0);
            return;
        }
        if( getA(i) == 0 && getA(i1) != 0 && getA(i2) == 0 && getA(i3) == 0 ) {
            updateBlocks(i, i1, i2, i3, getA(i1), 0, 0, 0);
            updateScore(0);
            return;
        }
        if( getA(i) != 0 && getA(i1) == 0 && getA(i2) == 0 && getA(i3) == 0 ) {
            updateBlocks(i, i1, i2, i3, getA(i), 0, 0, 0);
            updateScore(0);
            x6++;
        }
    }

}
