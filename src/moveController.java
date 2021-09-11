/**
 * This class contains all the methods which will allow a player to move their pieces
 */
public class moveController {
    private final GameBoard board = new GameBoard();
    private int flag;
    /**
     * Ask the player for an input to determine which piece he/she desires to move and to where
     *
     * @param board  GameBoard object
     * @param player Current player move
     */

    /**
     * Checks if a move that will be made is within the bounds of the board
     *
     * @param board  GameBoard object
     * @param newRow Row coordinate where the animal object desires to go
     * @param newCol Column coordinate where the animal object desires to go
     * @return
     */
    public boolean checkBounds(GameBoard board, int newRow, int newCol) {
        if (newRow < 0 || newRow >= board.getBlock().length || newCol >= board.getBlock()[newRow].length || newCol < 0) {
            System.out.println("Invalid move");
            return false;
        }
        return true;
    }

    /**
     * Checks if a move to be made is valid. This method looks into possible issues such as:<br>
     * 1. Piece takes another piece of a higher rank<br>
     * 2. Piece takes another piece of its own (color/team)<br>
     * 3. Piece moves to a river (exception made for Tiger and Mouse)<br>
     * 4. Piece takes its own (color/team) den
     *
     * @param board  GameBoard object
     * @param oldRow Row coordinate where the animal object is currently located
     * @param oldCol Column coordinate where the animal object is currently located
     * @param newRow Row coordinate where the animal object desires to go
     * @param newCol Column coordinate where the animal object desires to go
     * @param player Current player moving
     * @return
     */
    public boolean checkValid(GameBoard board, int oldRow, int oldCol, int newRow, int newCol, boolean player, int direction) {
        BlockCoords oldPiece = board.getBlock()[oldRow][oldCol];
        BlockCoords newPiece = board.getBlock()[newRow][newCol];
        if (checkBounds(board, newRow, newCol)) {
            if (oldPiece.getPiece() != null) { // Untrap piece
                if ((oldPiece.getPiece().isTrapped())) oldPiece.getPiece().setTrapped(false);

                if (newPiece.getPiece() != null) {  //Can't cant mouse
                    if (oldPiece.getPiece().getSymbol().contains("E") || oldPiece.getPiece().getSymbol().contains("M"));
                } else if (newPiece.getSpecial() == null && // Undive mouse
                        oldPiece.getPiece().getSymbol().contains("M")) {
                    ((Mouse) oldPiece.getPiece()).setDiverMouse(false);
                }
            }
            if (oldPiece.getPiece() != null && newPiece.getSpecial() != null) { // Check if piece moves to special block
                if (newPiece.getSpecial().getSymbol().contains("+")) // Check if position will be trapped
                    oldPiece.getPiece().setTrapped(true);
                else if (newPiece.getSpecial().getSymbol().contains("=") && // Set as diver mouse
                        oldPiece.getPiece().getSymbol().contains("M"))
                    ((Mouse) oldPiece.getPiece()).setDiverMouse(true);
            }

            if (oldPiece.getPiece() != null && newPiece.getPiece() != null) {
                if (oldPiece.getPiece().getSymbol().contains("M") && // Mouse takes Elephant/Mouse condition
                        (newPiece.getPiece().getSymbol().contains("M") || newPiece.getPiece().getSymbol().contains("E"))) {
                    if (((Mouse) oldPiece.getPiece()).isDiverMouse()) { // Mouse can't take Elephant when diver
                        if (!newPiece.getPiece().getSymbol().contains("E") && ((Mouse) newPiece.getPiece()).isDiverMouse());
                        else {
                            System.out.println("Invalid move");
                            return false;
                        }
                    } else if (oldPiece.getPiece().getSymbol().contains("M") && newPiece.getPiece().getSymbol().contains("M")) {
                        if (!((Mouse) oldPiece.getPiece()).isDiverMouse() && ((Mouse) newPiece.getPiece()).isDiverMouse()) {
                            System.out.println("Invalid move");
                            return false;
                        }
                    }
                } else if (oldPiece.getPiece().getSymbol().contains("E") && // Elephant take Mouse condition
                        newPiece.getPiece().getSymbol().contains("M")) {
                    System.out.println("Invalid move");
                    return false;
                } else if (newPiece.getPiece().isTrapped()) // Can take trapped animal
                    oldPiece.getPiece().setTrapped(true);
                else if (oldPiece.getPiece().getRank() < newPiece.getPiece().getRank()) {
                    System.out.println("Invalid move");
                    return false;
                }
                if (oldPiece.getPiece().isBlue() == newPiece.getPiece().isBlue()) {
                    System.out.println("Invalid move");
                    return false;
                }
            }

            if (newPiece.getSpecial() != null && newPiece.getSpecial().getSymbol().contains("=")) { // Check if river block
                if (oldPiece.getPiece().getSymbol().contains("M")) ;
                else if (oldPiece.getPiece().getSymbol().contains("T") || oldPiece.getPiece().getSymbol().contains("Li")) {
                    switch (direction) {
                        case 0:
                            if (board.getBlock()[oldRow - 1][oldCol].getPiece() != null || board.getBlock()[oldRow - 2][oldCol].getPiece() != null ||
                                board.getBlock()[oldRow - 3][oldCol].getPiece() != null || (board.getBlock()[oldRow - 4][oldCol].getPiece() != null &&
                                (oldPiece.getPiece().getRank() < board.getBlock()[oldRow - 4][oldCol].getPiece().getRank())))
                                return false;
                            break;
                        case 1:
                            if ((board.getBlock()[oldRow + 1][oldCol].getPiece() != null || board.getBlock()[oldRow + 2][oldCol].getPiece() != null ||
                                board.getBlock()[oldRow + 3][oldCol].getPiece() != null) || (board.getBlock()[oldRow + 4][oldCol].getPiece() != null &&
                                (oldPiece.getPiece().getRank() < board.getBlock()[oldRow + 4][oldCol].getPiece().getRank())))
                                return false;
                            break;
                        case 2:
                            if (board.getBlock()[oldRow][oldCol - 1].getPiece() != null || board.getBlock()[oldRow][oldCol - 2].getPiece() != null ||
                                (board.getBlock()[oldRow][oldCol - 3].getPiece() != null &&
                                (oldPiece.getPiece().getRank() < board.getBlock()[oldRow][oldCol - 3].getPiece().getRank())))
                                return false;
                            break;
                        case 3:
                            if (board.getBlock()[oldRow][oldCol + 1].getPiece() != null || board.getBlock()[oldRow][oldCol + 2].getPiece() != null ||
                                (board.getBlock()[oldRow][oldCol + 3].getPiece() != null &&
                                (oldPiece.getPiece().getRank() < board.getBlock()[oldRow][oldCol + 3].getPiece().getRank())))
                                return false;
                            break;
                    }
                } else if (newPiece.getSpecial().getSymbol().equals("=")) {
                    System.out.println("Invalid move");
                    return false;
                }
                if (!newPiece.getSpecial().getSymbol().contains("=") && newPiece.getSpecial().isBlue() == player) { // Takes same special side
                    System.out.println("Invalid move");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Moves GUI and console pieces
     * @param view GUI of the game
     * @param x X value of the piece
     * @param y Y value of the piece
     * @param choice Direction of movement
     */
    public void fullMove(GUI view, int x, int y, int choice) {
        int newX1 = 0;
        int newX2 = 0;
        int newY1 = 0;
        int newY2 = 0;
        switch (choice) {
            case 0:
                newX1 = x - 1;
                newX2 = x - 4;
                newY1 = y;
                newY2 = y;
                break;
            case 1:
                newX1 = x + 1;
                newX2 = x + 4;
                newY1 = y;
                newY2 = y;
                break;
            case 2:
                newX1 = x;
                newX2 = x;
                newY1 = y - 1;
                newY2 = y - 3;
                break;
            case 3:
                newX1 = x;
                newX2 = x;
                newY1 = y + 1;
                newY2 = y + 3;
                break;
        }
        if (checkValid(board, x, y, newX1, newY1, board.isPlayer(), choice)) {
            if (board.getBlock()[newX1][newY1].getTemp() != null && board.getBlock()[newX1][newY1].getTemp().contains("=") && !board.getBlock()[x][y].getPiece().getSymbol().contains("M")) {
                // Tiger||Lion Move Special Condition:
                if (board.getBlock()[x][y].getTemp().contains("T") || board.getBlock()[x][y].getTemp().contains("Li")) {
                    board.setPlayer(!board.isPlayer());
                    view.move(view.getButton(x, y), view.getButton(newX2, newY2));
                    board.getBlock()[newX2][newY2] = board.getBlock()[x][y];
                    board.getBlock()[x][y] = new BlockCoords(x, y);
                } else {
                    //Turn should not change. Display invalid move.
                    view.emptyButtonAlert();
                    flag = 1;
                }
            } else if (board.getBlock()[x][y].getTemp().contains("M")) { // Regenerate river
                board.setPlayer(!board.isPlayer());
                board.getBlock()[newX1][newY1] = board.getBlock()[x][y];
                if ((x == 3 && y == 1) || (x == 3 && y == 2) || (x == 4 && y == 1) || (x == 4 && y == 2) || (x == 5 && y == 1) || (x == 5 && y == 2) || (x == 3 && y == 4) || (x == 3 && y == 5) || (x == 4 && y == 4) || (x == 4 && y == 5) || (x == 5 && y == 4) || (x == 5 && y == 5)) {
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1), 4);
                    board.getBlock()[x][y] = new BlockCoords(x, y, new River());
                } else {
                    board.getBlock()[x][y] = new BlockCoords(x, y);
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1));
                }
            } else {
                board.setPlayer(!board.isPlayer());
                board.getBlock()[newX1][newY1] = board.getBlock()[x][y];
                if ((x == 0 && y == 2) || (x == 0 && y == 4) || (x == 1 && y == 3)) {
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1), 2);
                    board.getBlock()[x][y] = new BlockCoords(x, y, new Trap(false));
                } else if ((x == 8 && y == 2) || (x == 8 && y == 4) || (x == 7 && y == 3)) {
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1), 3);
                    board.getBlock()[x][y] = new BlockCoords(1, 3, new Trap(true));
                } else {
                    board.getBlock()[x][y] = new BlockCoords(x, y);
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1));
                }
            }
            flag = 0;
        } else {
            view.emptyButtonAlert();
            flag = 1;
        }
    }

    /**
     * Retrieves the current board of the game
     * @return current board
     */
    public GameBoard getBoard() {
        return board;
    }

    /**
     * Retrieves a flag value
     * @return a flag value
     */
    public int getFlag() {
        return flag;
    }

    /**
     * Sets a flag value
     * @param flag value to be set to the flag value
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }
}