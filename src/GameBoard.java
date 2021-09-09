/**
 * This class is the main board of the game.
 */
public class GameBoard {
    BlockCoords[][] block = new BlockCoords[9][7];
    private boolean player = true;

    /**
     * Returns a block object
     *
     * @return
     */
    public BlockCoords[][] getBlock() {
        return block;
    }

    /**
     * Sets a boolean which determines player turn
     *
     * @param player
     */
    public void setPlayer(boolean player) {
        this.player = player;
    }

    /**
     * Creates a new board with each piece in its standard location
     */
    public void createBoard() {
        for (int row = 0; row < block.length; row++) { // Set blanks
            for (int col = 0; col < block[row].length; col++) {
                block[row][col] = new BlockCoords(row, col);
            }
            // Animal blocks
            block[8][0] = new BlockCoords(8, 0, new Animal(6, "T", true));
            block[0][6] = new BlockCoords(0, 6, new Animal(6, "T", false));
            block[6][4] = new BlockCoords(6, 4, new Animal(5, "L", true));
            block[2][2] = new BlockCoords(2, 2, new Animal(5, "L", false));

            block[7][5] = new BlockCoords(7,5,new Animal(4,"D",true));
            block[1][1] = new BlockCoords(1,1,new Animal(4,"D",false));
            block[7][1] = new BlockCoords(7,1,new Animal(2,"C",true));
            block[1][5] = new BlockCoords(1,5,new Animal(2,"C",false));

            block[6][6] = new BlockCoords(6,6,new Animal(1,"M",true));
            block[2][0] = new BlockCoords(2,0,new Animal(1,"M",false));
            block[6][2] = new BlockCoords(6,2,new Animal(3,"W",true));
            block[2][4] = new BlockCoords(2,4,new Animal(3,"W",false));

            block[6][0] = new BlockCoords(6,0,new Animal(8,"E",true));
            block[2][6] = new BlockCoords(2,6,new Animal(8,"E",false));
            block[8][6] = new BlockCoords(8,6,new Animal(7,"Li",true));
            block[0][0] = new BlockCoords(0,0,new Animal(7,"Li",false));

            /*

        buttons[2][6] = new JButton(elephant2);
        buttons[6][0] = new JButton(elephant1);

        buttons[0][0] = new JButton(lion2);
        buttons[8][6] = new JButton(lion1);
        */
            // Special blocks
            block[3][1] = new BlockCoords(3, 1, new Special(3, "="));
            block[3][2] = new BlockCoords(3, 2, new Special(3, "="));
            block[4][1] = new BlockCoords(4, 1, new Special(3, "="));
            block[4][2] = new BlockCoords(4, 2, new Special(3, "="));
            block[5][1] = new BlockCoords(5, 1, new Special(3, "="));
            block[5][2] = new BlockCoords(5, 2, new Special(3, "="));

            block[3][4] = new BlockCoords(3, 4, new Special(3, "="));
            block[3][5] = new BlockCoords(3, 5, new Special(3, "="));
            block[4][4] = new BlockCoords(4, 4, new Special(3, "="));
            block[4][5] = new BlockCoords(4, 5, new Special(3, "="));
            block[5][4] = new BlockCoords(5, 4, new Special(3, "="));
            block[5][5] = new BlockCoords(5, 5, new Special(3, "="));

            block[8][3] = new BlockCoords(8, 3, new Special(1, "@", true));
            block[0][3] = new BlockCoords(0, 3, new Special(1, "@", false));
        }
    }

    /**
     * Displays the current state of the board
     */
    public void display() {
        for (int row = 0; row < block.length; row++) {
            for (int col = 0; col < block[row].length; col++) {
                if (block[row][col].getPiece() != null) {
                    System.out.print(block[row][col].getPiece().getSymbol() +
                            "\t");
                } else if (block[row][col].getSpecial() != null) {
                    System.out
                            .print(block[row][col].getSpecial().getSymbol() + "\t");
                } else {
                    System.out.print(".\t");
                }
            }
            System.out.println(9 - row);
        }
        System.out.println("1\t2\t3\t4\t5\t6\t7");
    }

    /**
     * Check for multiple win conditions such as:<br>
     * 1. Den taken<br>
     * 2. Player has no pieces left to play
     *
     * @return
     */
    public boolean checkWin() {
        int playerOneCount = 0;
        int playerTwoCount = 0;
        if (block[8][3].getPiece() != null) { // Den taken
            System.out.println("Player 2 wins!");
            return true;
        }
        if (block[0][3].getPiece() != null) { // Den taken
            System.out.println("Player 1 wins!");
            return true;
        }
        for (int row = 0; row < block.length;
             row++) { // Check amount of pieces per player
            for (int col = 0; col < block[row].length; col++) {
                if (block[row][col].getPiece() != null) {
                    if (block[row][col].getPiece().isBlue())
                        playerOneCount++;
                    if (!block[row][col].getPiece().isBlue())
                        playerTwoCount++;
                }
            }
        }
        if (playerOneCount == 0) {
            System.out.println("Player 2 wins!");
            return true;
        }

        if (playerTwoCount == 0) {
            System.out.println("Player 1 wins!");
            return true;
        }

        return false;
    }

    /**
     * Returns a boolean which determines the player turn
     *
     * @return
     */
    public boolean isPlayer() {
        return player;
    }
}