import java.util.*;

public class Move {
    private Animal piece;            ///private Player player;
    private BlockCoords[][] from;
    private BlockCoords[][] to;
    private GameBoard board;

    Scanner in = new Scanner(System.in);

    /*
        /*We can create the f and t objects sa driver na.
        public Move(Animal p, BlockCoords f, BlockCoords t)
        {
            piece = p;
            from = f;		//If I do this will from and f point to the same thing? or a copy is made?
            to = t;

        }

                I dont think We'll be needing this constructor.
        public Move(Animal p, int fX, int fY, int tX, int tY)
        {
            //Assign the fCoordinates and tCoordinates as a BlockCoords Object.
            from = new BlockCoords(fX,fY);
            to = new BlockCoords(tX,tY);
            piece = p;
        }


        public boolean checkValid()
        {
            /*Sa main na dapat icheckk if yung input ni user is out of bounds.

            if(isObstacle(to))	///If may water or wala.
            {
                /*Check the piece. Is it  a Lion or a Tiger. if not, di pwede yung move.
                if(piece.symbol.contains(Lion) || piece.symbol.contains(Tiger))
                    updatePos(from,to);	//Update the position. Talon sa other side.

            }
            else  //If no obstacle, we can update. Changing of turns should be done in driver/main.
                updatePos(from, to);

            /*Para lang di syntax error
            return true;
            /*Dont forget to change player turn!

        }
        public boolean isObstacle(BlockCoords toCoords)   //Checks the board if the to coordinates has an obstacle.
        {
            /*If the toCoord block is not / -- meaning may smth.
            if (toCoords.temp.contains("/"))
                return false;

            /*This means later on, check for water obstacle
            before checking if another piece is in front of the piece
            else if (!(toCoords.temp.contains("=")))
                return true;

            /*Para lang di syntax error
            return false;


        }

        public boolean isBase()
        {
            /*Checks if the to coordinates is the location of the base, ending the game.
            if(to.temp.contains("F"))
                return true;
            return false;
        }
    */
    public void updatePos(BlockCoords from, BlockCoords to) {
        to.setPiece(from.getPiece());
        from.setPiece(null);
     //   from.setPiece(to.getPiece()); /*Swaps the locations of piece and mover if no obstacle, if someone is killed ther position is replaced by /.*/
     //   System.out.print(to.getPiece().symbol);

    }

    public void move(GameBoard board, boolean player) { // need input checking pa
        System.out.print("Enter piece character: ");
        String symbol = in.nextLine();
        System.out.print("Enter direction (U,D,L,R): ");
        String direction = in.nextLine();

        for (int row = 0; row < board.getBlock().length; row++) {
            for (int col = 0; col < board.getBlock()[row].length; col++) {
                if(board.getBlock()[row][col].getPiece() != null){
                    if(board.getBlock()[row][col].getPiece().symbol.equals(symbol) && board.getBlock()[row][col].getPiece().isBlue == player){
                        switch(direction){
                            case "U": updatePos(board.getBlock()[row][col], board.getBlock()[row-1][col]);
                                break;

                            case "D": updatePos(board.getBlock()[row][col], board.getBlock()[row+1][col]);
                                row = board.getBlock().length-1; // para di paulit ulit yung loop. there has to be a better fix to this zz
                                break;

                            case "L": updatePos(board.getBlock()[row][col], board.getBlock()[row][col-1]);
                                break;

                            case "R": updatePos(board.getBlock()[row][col], board.getBlock()[row][col+1]);
                                col = board.getBlock()[row].length-1;
                                break;
                        }
                    }
                }
            }// still need to check if player 1 or 2, if special, and if may ibang character
        }
    }
}