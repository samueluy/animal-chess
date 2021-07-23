import java.util.*;

public class GameBoard {
    private Player[] players;
    private boolean bTurn;
    BlockCoords[][] block = new BlockCoords[9][7];

    public void createBoard() {
        for (int row = 0; row < block.length; row++) { // set blanks
            for (int col = 0; col < block[row].length; col++) {
                block[row][col] = new BlockCoords(row, col);
            }
            /*P1*/
			block[0][6] = new BlockCoords(0, 6, new Animal(6, "T"));
            block[2][2] = new BlockCoords(2, 2, new Animal(5, "L"));
			
			/*P2*/
            block[8][0] = new BlockCoords(8, 0, new Animal(6, "T"));
            block[6][4] = new BlockCoords(6, 4, new Animal(5, "L"));

            // Special blocks
			block[0][3] = new BlockCoords(0, 3, new Special(3, "F"));
			block[8][3] = new BlockCoords(8, 3, new Special(3, "F"));

			
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
        }
    }

    public void display() {
        for (int row = 0; row < block.length; row++) {
            for (int col = 0; col < block[row].length; col++) {
                System.out.print(block[row][col].temp + " ");
            }
            System.out.println();
        }
    }
}
