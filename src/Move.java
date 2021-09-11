/**
 * This class contains all the methods which will allow a player to move their pieces
 */
public class Move {
    private GameBoard board = new GameBoard();

    /**
     * Ask the player for an input to determine which piece he/she desires to move and to where
     *
     * @param board  GameBoard object
     * @param player Current player move
     */

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
                              int newRow, int newCol, boolean player, int direction) {
        if(checkBounds(board, newRow,newCol)){
            if(board.getBlock()[oldRow][oldCol].getPiece() != null){ // Untrap piece
                if((board.getBlock()[oldRow][oldCol].getPiece().isTrapped()))
                    board.getBlock()[oldRow][oldCol].getPiece().setTrapped(false);
            }
            if(board.getBlock()[oldRow][oldCol].getPiece() != null && board.getBlock()[newRow][newCol].getSpecial() != null){ // check if position will be trapped
                if(board.getBlock()[newRow][newCol].getSpecial().getSymbol().contains("+"))
                    board.getBlock()[oldRow][oldCol].getPiece().setTrapped(true);
            }

            if (board.getBlock()[oldRow][oldCol].getPiece() != null &&
                board.getBlock()[newRow][newCol].getPiece() != null) {

                if(board.getBlock()[oldRow][oldCol].getPiece().getSymbol().contains("M") && // Mouse takes Elephant condition
                board.getBlock()[newRow][newCol].getPiece().getSymbol().contains("E"));
                else if(board.getBlock()[oldRow][oldCol].getPiece().getSymbol().contains("E") && // Elephant take Mouse condition
                        board.getBlock()[newRow][newCol].getPiece().getSymbol().contains("M")){
                    System.out.println("Invalid move");
                    return false;
                }
                else if(board.getBlock()[newRow][newCol].getPiece().isTrapped()); // can take trapped animal
                else if (board.getBlock()[oldRow][oldCol].getPiece().getRank() <
                        board.getBlock()[newRow][newCol].getPiece().getRank()) {
                    System.out.println("Invalid move");
                    return false;
                }
                if (board.getBlock()[oldRow][oldCol].getPiece().isBlue() ==
                        board.getBlock()[newRow][newCol].getPiece().isBlue()) {
                    System.out.println("Invalid move");
                    return false;
                }
            }

            if (board.getBlock()[newRow][newCol].getSpecial() !=
                null) { // Check if river block
            if(board.getBlock()[oldRow][oldCol].getPiece().getSymbol().contains("M"));
            else if(board.getBlock()[oldRow][oldCol].getPiece().getSymbol().contains("T") ||
                    board.getBlock()[oldRow][oldCol].getPiece().getSymbol().contains("Li")){
                switch(direction){
                    case 0: if(board.getBlock()[oldRow-1][oldCol].getPiece() != null ||
                                board.getBlock()[oldRow-2][oldCol].getPiece() != null ||
                                board.getBlock()[oldRow-3][oldCol].getPiece() != null ||
                                board.getBlock()[oldRow-4][oldCol].getPiece() != null)
                            return false;
                            break;
                    case 1: if(board.getBlock()[oldRow+1][oldCol].getPiece() != null ||
                            board.getBlock()[oldRow+2][oldCol].getPiece() != null ||
                            board.getBlock()[oldRow+3][oldCol].getPiece() != null ||
                            board.getBlock()[oldRow+4][oldCol].getPiece() != null)
                        return false;
                        break;
                    case 2:if(board.getBlock()[oldRow][oldCol-1].getPiece() != null ||
                            board.getBlock()[oldRow][oldCol-2].getPiece() != null)
                        return false;
                        break;
                    case 3:if(board.getBlock()[oldRow][oldCol+1].getPiece() != null ||
                            board.getBlock()[oldRow][oldCol+2].getPiece() != null)
                        return false;
                        break;
                }
            }
                else if (board.getBlock()[newRow][newCol].getSpecial().getSymbol()
                        .equals("=")) {
                    System.out.println("Invalid move");
                    return false;
                }
            if (board.getBlock()[newRow][newCol].getSpecial().isBlue() ==
                player){
                System.out.println("Invalid move");
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
        switch(choice){
            case 0:
                newX1=x-1;
                newX2=x-4;
                newY1=y;
                newY2=y;
                break;
            case 1:
                newX1=x+1;
                newX2=x+4;
                newY1=y;
                newY2=y;
                break;
            case 2:
                newX1=x;
                newX2=x;
                newY1=y-1;
                newY2=y-3;
                break;
            case 3:
                newX1=x;
                newX2=x;
                newY1=y+1;
                newY2=y+3;
                break;
        }
        if(checkValid(model.getBoard(), x, y, newX1, newY1, model.getBoard().isPlayer(), choice)){
            System.out.println("in");
            if (model.getBoard().getBlock()[newX1][newY1].getTemp() != null && model.getBoard().getBlock()[newX1][newY1].getTemp().contains("=")) {
                //Tiger/Lion Move Special Condition:
                if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                    model.getBoard().setPlayer(!model.getBoard().isPlayer());
                    view.move(view.getButton(x, y), view.getButton(newX2, newY2));
                    model.getBoard().getBlock()[newX2][newY2] = model.getBoard().getBlock()[x][y];
                    model.getBoard().getBlock()[x][y] = new BlockCoords(x,y);
                }
                //Mouse Move Special Condition
                else if (model.getBoard().getBlock()[x][y].getTemp().contains("M")){ // need to generate river again
                    model.getBoard().setPlayer(!model.getBoard().isPlayer());
                    view.move(view.getButton(x, y), view.getButton(newX1, newY1));
                    model.getBoard().getBlock()[newX1][newY1] = model.getBoard().getBlock()[x][y];
                    model.getBoard().getBlock()[x][y] = new BlockCoords(x,y);
                }
                else
                    //Turn should not change. Display invalid move.
                    view.emptyButtonAlert();
            }
            else {
                model.getBoard().setPlayer(!model.getBoard().isPlayer());
                view.move(view.getButton(x, y), view.getButton(newX1, newY1));
                model.getBoard().getBlock()[newX1][newY1] = model.getBoard().getBlock()[x][y];
                model.getBoard().getBlock()[x][y] = new BlockCoords(x,y);
            }
        }
        else
            view.emptyButtonAlert();
    }

    public GameBoard getBoard() {
        return board;
    }
}