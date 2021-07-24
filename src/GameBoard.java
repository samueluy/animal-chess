public class GameBoard {
    private boolean player = true;
    BlockCoords[][] block = new BlockCoords[9][7];

    public void createBoard() {
        for (int row = 0; row < block.length; row++) { // set blanks
            for (int col = 0; col < block[row].length; col++) {
                block[row][col] = new BlockCoords(row, col);
            }
            block[8][0] = new BlockCoords(8, 0, new Animal(6, "T", true));
            block[0][6] = new BlockCoords(0, 6, new Animal(6, "T", false));
            block[6][4] = new BlockCoords(6, 4, new Animal(5, "L", true));
            block[2][2] = new BlockCoords(2, 2, new Animal(5, "L", false));

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

    public void display() {
        for (int row = 0; row < block.length; row++) {
            for (int col = 0; col < block[row].length; col++) {
                if (block[row][col].getPiece() != null) {
                    System.out.print(block[row][col].getPiece().symbol + "\t");
                } else if (block[row][col].getSpecial() != null) {
                    System.out.print(block[row][col].getSpecial().symbol + "\t");
                } else {
                    System.out.print("·\t");
                }
            }
            System.out.println(row + 1);
        }
        System.out.println("1\t2\t3\t4\t5\t6\t7");
    }

    public boolean checkWin() {
        int playerOneCount = 0;
        int playerTwoCount = 0;
        if (block[8][3].getPiece() != null) { // den taken
            System.out.println("Player 2 wins!");
            return true;
        }
        if (block[0][3].getPiece() != null) { // den taken
            System.out.println("Player 1 wins!");
            return true;
        }
        for (int row = 0; row < block.length; row++) { // check amount of pieces per player
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

    public BlockCoords[][] getBlock() {
        return block;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }
}