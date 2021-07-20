public class GameBoard {
    private Player[] players;
    private boolean bTurn;
    BlockCoords[][] block = new BlockCoords[9][7];

    public void display() {
            for(int row=0; row< block.length; row++){
                    for(int col=0; col<block[row].length; col++){
                        block[row][col] = new BlockCoords();
                        System.out.print(block[row][col].temp + " ");
                    }
                    System.out.println();
            }
    }
}
