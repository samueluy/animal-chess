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
     * Creates a new board with each piece in its standard location
     */
    public void createBoard() {
        for (int row = 0; row < block.length; row++) { // Set blanks
            for (int col = 0; col < block[row].length; col++) {
                block[row][col] = new BlockCoords(row, col);
            }
            // Animal blocks
            block[8][0] = new BlockCoords(8, 0, new Tiger(true));
            block[0][6] = new BlockCoords(0, 6, new Tiger(false));
            block[6][4] = new BlockCoords(6, 4, new Leopard(true));
            block[2][2] = new BlockCoords(2, 2, new Leopard(false));

            block[7][5] = new BlockCoords(7, 5, new Dog(true));
            block[1][1] = new BlockCoords(1, 1, new Dog(false));
            block[7][1] = new BlockCoords(7, 1, new Cat(true));
            block[1][5] = new BlockCoords(1, 5, new Cat(false));

            block[6][6] = new BlockCoords(6, 6, new Mouse(true));
            block[2][0] = new BlockCoords(2, 0, new Mouse(false));
            block[6][2] = new BlockCoords(6, 2, new Wolf(true));
            block[2][4] = new BlockCoords(2, 4, new Wolf(false));

            block[6][0] = new BlockCoords(6, 0, new Elephant(true));
            block[2][6] = new BlockCoords(2, 6, new Elephant(false));
            block[8][6] = new BlockCoords(8, 6, new Lion(true));
            block[0][0] = new BlockCoords(0, 0, new Lion(false));

            // Special blocks
            block[3][1] = new BlockCoords(3, 1, new River());
            block[3][2] = new BlockCoords(3, 2, new River());
            block[4][1] = new BlockCoords(4, 1, new River());
            block[4][2] = new BlockCoords(4, 2, new River());
            block[5][1] = new BlockCoords(5, 1, new River());
            block[5][2] = new BlockCoords(5, 2, new River());

            block[3][4] = new BlockCoords(3, 4, new River());
            block[3][5] = new BlockCoords(3, 5, new River());
            block[4][4] = new BlockCoords(4, 4, new River());
            block[4][5] = new BlockCoords(4, 5, new River());
            block[5][4] = new BlockCoords(5, 4, new River());
            block[5][5] = new BlockCoords(5, 5, new River());

            block[8][3] = new BlockCoords(8, 3, new Base(true));
            block[0][3] = new BlockCoords(0, 3, new Base(false));

            block[0][2] = new BlockCoords(0, 2, new Trap(false));
            block[0][4] = new BlockCoords(0, 4, new Trap(false));
            block[1][3] = new BlockCoords(1, 3, new Trap(false));
            block[8][2] = new BlockCoords(8, 2, new Trap(true));
            block[8][4] = new BlockCoords(8, 4, new Trap(true));
            block[7][3] = new BlockCoords(7, 3, new Trap(true));
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

    /**
     * Sets a boolean which determines player turn
     *
     * @param player
     */
    public void setPlayer(boolean player) {
        this.player = player;
    }
}