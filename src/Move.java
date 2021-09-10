import java.util.Scanner;

/**
 * This class contains all the methods which will allow a player to move their pieces
 */
public class Move {
    Scanner in = new Scanner(System.in);
    private Animal piece;
    private GameBoard board = new GameBoard();

    /**
     * Ask the player for an input to determine which piece he/she desires to move and to where
     *
     * @param board  GameBoard object
     * @param player Current player move
     */
    public void move(GameBoard board, boolean player, int direction) {
        boolean validPiece = false;
        for (int row = 0; row < board.getBlock().length; row++) {
            for (int col = 0; col < board.getBlock()[row].length; col++) {
                if (board.getBlock()[row][col].getPiece() != null) {
                  /*  if (board.getBlock()[row][col].getPiece().getSymbol()
                            .equals(symbol) &&
                            board.getBlock()[row][col].getPiece().isBlue() ==
                                    player) {*/
                        validPiece = true;
                        boolean hasMoved = false;
                        switch (direction) {
                            case 0:
                                if (checkBounds(board, row - 1, col)) {
                                    if (board.getBlock()[row - 1][col]
                                            .getSpecial() != null) {
                                        if (board.getBlock()[row][col]
                                                .getPiece().getSymbol()
                                                .equals("T") &&
                                                board.getBlock()[row - 1][col]
                                                        .getSpecial()
                                                        .getSymbol()
                                                        .equals("=")) { // Tiger special block condition
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row -
                                                            4][col]);
                                            hasMoved = true;
                                        }
                                    }
                                    if (!hasMoved) {
                                        if (checkValid(board, row, col, row - 1,
                                                col, player))
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row -
                                                            1][col]);
                                    }
                                }
                                break;

                            case 1:
                                if (checkBounds(board, row + 1, col)) {
                                    if (board.getBlock()[row + 1][col]
                                            .getSpecial() != null) {
                                        if (board.getBlock()[row][col]
                                                .getPiece().getSymbol()
                                                .equals("T") &&
                                                board.getBlock()[row + 1][col]
                                                        .getSpecial()
                                                        .getSymbol()
                                                        .equals("=")) { // Tiger special block condition
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row +
                                                            3][col]);
                                            hasMoved = true;
                                        }
                                    }
                                    if (!hasMoved) {
                                        if (checkValid(board, row, col, row + 1,
                                                col, player)) {
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row +
                                                            1][col]);
                                            row = board.getBlock().length - 1;
                                        }
                                    }
                                }

                                break;

                            case 2:
                                if (checkBounds(board, row, col - 1)) {
                                    if (board.getBlock()[row][col - 1]
                                            .getSpecial() != null) {
                                        if (board.getBlock()[row][col]
                                                .getPiece().getSymbol()
                                                .equals("T") &&
                                                board.getBlock()[row][col - 1]
                                                        .getSpecial()
                                                        .getSymbol()
                                                        .equals("=")) { // Tiger special block condition
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row][col -
                                                            3]);
                                            hasMoved = true;
                                        }
                                    }
                                    if (!hasMoved) {
                                        if (checkValid(board, row, col, row,
                                                col - 1, player))
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row][col -
                                                            1]);
                                    }
                                }

                                break;

                            case 3:
                                if (checkBounds(board, row, col + 1)) {
                                    if (board.getBlock()[row][col + 1]
                                            .getSpecial() != null) {
                                        if (board.getBlock()[row][col]
                                                .getPiece().getSymbol()
                                                .equals("T") &&
                                                board.getBlock()[row][col + 1]
                                                        .getSpecial()
                                                        .getSymbol()
                                                        .equals("=")) { // Tiger special block condition
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row][col +
                                                            3]);
                                            hasMoved = true;
                                            col = board.getBlock()[row].length -
                                                    1;
                                        }
                                    }
                                    if (!hasMoved) {
                                        if (checkValid(board, row, col, row,
                                                col + 1, player)) {
                                            updatePos(
                                                    board.getBlock()[row][col],
                                                    board.getBlock()[row][col +
                                                            1]);
                                            col = board.getBlock()[row].length -
                                                    1;
                                        }
                                    }
                                }

                                break;

                            default:
                                System.out.println("Invalid input");
                                board.setPlayer(!board.isPlayer());
                        }
                    //}
                }
            }
        }
        if (!validPiece) {
            System.out.println("Invalid input");
            board.setPlayer(!board.isPlayer());
        }
        board.setPlayer(!board.isPlayer()); // Next player move
    }

    /**
     * Transfers an Animal object from one block to another
     *
     * @param from Block object where the piece is originally located
     * @param to   Block object where the piece desires to go
     */
    public void updatePos(BlockCoords from, BlockCoords to) {
        to.setPiece(from.getPiece());
        from.setPiece(null);
    }

    /**
     * Checks if a move that will be made is within the bounds of the board
     *
     * @param board  GameBoard object
     * @param newRow Row coordinate where the animal object desires to go
     * @param newCol Column coordinate where the animal object desires to go
     * @return
     */
    public boolean checkBounds(GameBoard board, int newRow, int newCol) {
        if (newRow < 0 || newRow >= board.getBlock().length ||
                newCol >= board.getBlock()[newRow].length ||
                newCol < 0) {
            System.out.println("Invalid move");
            board.setPlayer(!board.isPlayer()); // Reset player move if invalid
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
    public boolean checkValid(GameBoard board, int oldRow, int oldCol,
                              int newRow, int newCol, boolean player) {
        if(checkBounds(board, newRow,newCol)){
            if (board.getBlock()[oldRow][oldCol].getPiece() != null &&
                    board.getBlock()[newRow][newCol].getPiece() != null) {
                if (board.getBlock()[oldRow][oldCol].getPiece().getRank() <
                        board.getBlock()[newRow][newCol].getPiece().getRank()) {
                    System.out.println("Invalid move");
                    board.setPlayer(
                            !board.isPlayer()); // Reset player move if invalid
                    return false;
                }
            }

            if (board.getBlock()[oldRow][oldCol].getPiece() != null &&
                    board.getBlock()[newRow][newCol].getPiece() !=
                            null) { // Animal same player condition; can not eat own piece
                if (board.getBlock()[oldRow][oldCol].getPiece().isBlue() ==
                        board.getBlock()[newRow][newCol].getPiece().isBlue()) {
                    System.out.println("Invalid move");
                    board.setPlayer(
                            !board.isPlayer()); // Reset player move if invalid
                    return false;
                }
            }

            if (board.getBlock()[newRow][newCol].getSpecial() !=
                    null) { // Check if special block
                if (board.getBlock()[newRow][newCol].getSpecial().getSymbol()
                        .equals("=")) {
                    System.out.println("Invalid move");
                    board.setPlayer(
                            !board.isPlayer()); // Reset player move if invalid
                    return false;
                }
            }

            if (board.getBlock()[newRow][newCol].getSpecial() !=
                    null) { // Can not take own den
                if (board.getBlock()[newRow][newCol].getSpecial().isBlue() ==
                        player) {
                    System.out.println("Invalid move");
                    board.setPlayer(
                            !board.isPlayer()); // Reset player move if invalid
                    return false;
                }
            }
        }
        return true;
    }

    public void fullMove(Move model, testGrid view, int x, int y, int choice){
        int newX1=0;
        int newX2=0;
        int newY1=0;
        int newY2=0;
        if(choice == 0){
            newX1=x-1;
            newX2=x-4;
            newY1=y;
            newY2=y;
        }
        else if(choice==1){
            newX1=x+1;
            newX2=x+4;
            newY1=y;
            newY2=y;
        }
        else if(choice==2){
            newX1=x;
            newX2=x;
            newY1=y-1;
            newY2=y-3;
        }
        else if(choice==3){
            newX1=x;
            newX2=x;
            newY1=y+1;
            newY2=y+3;
        }
        BlockCoords modelSwitcher;
        if(checkValid(model.getBoard(), x, y, newX1, newY1, model.getBoard().isPlayer())){
            System.out.println("in");
            if (model.getBoard().getBlock()[newX1][newY1].getTemp() != null && model.getBoard().getBlock()[newX1][newY1].getTemp().contains("=")) {
                //Tiger Move Special Condition:
                if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                    view.move(view.getButton(x, y), view.getButton(newX2, y)); // up
                    modelSwitcher = model.getBoard().getBlock()[newX2][newY2];
                    model.getBoard().getBlock()[newX2][newY2] = model.getBoard().getBlock()[x][y];
                    model.getBoard().getBlock()[x][y] = modelSwitcher;
                }
                else
                    //Turn should not change. Display invalid move.
                    view.emptyButtonAlert();
            }
            else {
                view.move(view.getButton(x, y), view.getButton(newX1, newY1)); // up
                modelSwitcher = model.getBoard().getBlock()[newX1][newY1];
                model.getBoard().getBlock()[newX1][newY1] = model.getBoard().getBlock()[x][y];
                model.getBoard().getBlock()[x][y] = modelSwitcher;
            }
        }
        else
            view.emptyButtonAlert();
    }

    public GameBoard getBoard() {
        return board;
    }
}