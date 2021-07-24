import java.util.*;

public class Move {
    private Animal piece;            ///private Player player;
    private BlockCoords[][] from;
    private BlockCoords[][] to;
    private GameBoard board;

    Scanner in = new Scanner(System.in);
	
    public void move(GameBoard board, boolean player) { // need input checking pa
        System.out.print("Enter piece character: ");
        String symbol = in.nextLine();
        System.out.print("Enter direction (U,D,L,R): ");
        String direction = in.nextLine();

        boolean validPiece = false;
        for (int row = 0; row < board.getBlock().length; row++) {
            for (int col = 0; col < board.getBlock()[row].length; col++) {
                if (board.getBlock()[row][col].getPiece() != null) {
                    if (board.getBlock()[row][col].getPiece().symbol.equals(symbol) && board.getBlock()[row][col].getPiece().isBlue() == player){ //Whats this condition for?
                        validPiece = true;
                        boolean hasMoved = false;
                        switch (direction) {
                            case "U":
                                if(checkBounds(board, row - 1, col)){
                                    if(board.getBlock()[row-1][col].getSpecial() != null){
                                        if(board.getBlock()[row][col].getPiece().getSymbol().equals("T") && board.getBlock()[row-1][col].getSpecial().getSymbol().equals("=")){ // if tiger
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row - 4][col]);
                                            hasMoved = true;
                                        }
                                    }
                                    if(!hasMoved){
                                        if (checkValid(board, row, col, row - 1, col, player))
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row - 1][col]);
                                    }
                                }
                                break;

                            case "D":
                                if(checkBounds(board, row + 1, col)){
                                    if(board.getBlock()[row+1][col].getSpecial() != null){
                                        if(board.getBlock()[row][col].getPiece().getSymbol().equals("T") && board.getBlock()[row+1][col].getSpecial().getSymbol().equals("=")){ // if tiger
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row + 3][col]);
                                            hasMoved = true;
                                        }
                                    }
                                    if(!hasMoved){
                                        if (checkValid(board, row, col, row + 1, col, player)) {
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row + 1][col]);
                                            row = board.getBlock().length - 1; // para di paulit ulit yung loop. there has to be a better fix to this zz
                                            /*Whats the issue?*/ // masasatisfy pa rin yung loop kaya tuloy tuloy till sumagad HAHAHA
                                        }
                                    }
                                }

                                break;

                            case "L":
                                if(checkBounds(board, row, col - 1)){
                                    if(board.getBlock()[row][col-1].getSpecial() != null){
                                        if(board.getBlock()[row][col].getPiece().getSymbol().equals("T") && board.getBlock()[row][col - 1].getSpecial().getSymbol().equals("=")){ // if tiger
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row][col- 3]);
                                            hasMoved = true;
                                        }
                                    }
                                    if(!hasMoved){
                                        if (checkValid(board, row, col, row, col - 1, player))
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row][col - 1]);
                                    }
                                }

                                break;

                            case "R":
                                if(checkBounds(board, row, col + 1)){
                                    if(board.getBlock()[row][col+1].getSpecial() != null){
                                        if(board.getBlock()[row][col].getPiece().getSymbol().equals("T") && board.getBlock()[row][col + 1].getSpecial().getSymbol().equals("=")){ // if tiger
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row][col + 3]);
                                            hasMoved = true;
                                            col = board.getBlock()[row].length - 1;
                                        }
                                    }
                                    if(!hasMoved){
                                        if (checkValid(board, row, col, row, col + 1, player)) {
                                            updatePos(board.getBlock()[row][col], board.getBlock()[row][col + 1]);
                                            col = board.getBlock()[row].length - 1;
                                        }
                                    }
                                }

                                break;

                            default:
                                System.out.println("Invalid move");
                                board.setPlayer(!board.isPlayer());
                        }
                    }
                }
            }
        }
        if(!validPiece){
            System.out.println("Invalid input");
            board.setPlayer(!board.isPlayer());
        }
        board.setPlayer(!board.isPlayer()); // next player move
    }

    public void updatePos(BlockCoords from, BlockCoords to) {
        to.setPiece(from.getPiece());
        from.setPiece(null);
        //   from.setPiece(to.getPiece()); /*Swaps the locations of piece and mover if no obstacle, if someone is killed ther position is replaced by /.*/
        //   System.out.print(to.getPiece().symbol);
    }
	
    public boolean checkBounds(GameBoard board, int newRow, int newCol) {
        if (newRow < 0 || newRow >= board.getBlock().length ||
                newCol >= board.getBlock()[newRow].length ||
                newCol < 0) {
            System.out.println("Invalid move");
            board.setPlayer(!board.isPlayer()); // reset player move if invalid
            return false;
        }
        //if the newRow and Col wont be out of bounds:
        return true;
    }

    public boolean checkValid(GameBoard board, int oldRow, int oldCol, int newRow, int newCol, boolean player) {
		/*
			Confusion on usage of '==', .equals().
				-Override methods might be needed.
		*/
        // Comparing animal ranks


        if (board.getBlock()[oldRow][oldCol].getPiece() != null && board.getBlock()[newRow][newCol].getPiece() != null) {
            if (board.getBlock()[oldRow][oldCol].getPiece().getRank() < board.getBlock()[newRow][newCol].getPiece().getRank()) {
                System.out.println("Invalid move");
                board.setPlayer(!board.isPlayer()); // reset player move if invalid
                return false;
            }
        }

        if (board.getBlock()[newRow][newCol].getSpecial() != null) { // check if special block
            if (board.getBlock()[newRow][newCol].getSpecial().symbol.equals("=")) { // to edit for tiger
                System.out.println("Invalid move");
                board.setPlayer(!board.isPlayer()); // reset player move if invalid
                return false;
            }
        }

        if (board.getBlock()[oldRow][oldCol].getPiece() != null && board.getBlock()[newRow][newCol].getPiece() != null) { // animal same player condition; can not eat own piece
            if (board.getBlock()[oldRow][oldCol].getPiece().isBlue() == board.getBlock()[newRow][newCol].getPiece().isBlue()) {        //Bakit kaya gumagana to? --- true<->true = true, false<->false = true
                System.out.println("Invalid move");
                board.setPlayer(!board.isPlayer()); // reset player move if invalid
                return false;
            }
        }

        if (board.getBlock()[newRow][newCol].getSpecial() != null) { // can not take own den
            if (board.getBlock()[newRow][newCol].getSpecial().isBlue() == player) {
                System.out.println("Invalid move");
                board.setPlayer(!board.isPlayer()); // reset player move if invalid
                return false;
            }
        }

        return true;
    }
}