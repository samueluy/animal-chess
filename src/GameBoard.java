public class GameBoard {
    private Player[] players;
    private boolean bTurn;
    BlockCoords[][] block = new BlockCoords[9][7];

    public void createBoard(){
        for(int row=0; row< block.length; row++){ // set blanks
            for(int col=0; col<block[row].length; col++){
                block[row][col] = new BlockCoords(row, col);
            }
            block[8][0] = new BlockCoords(8,0, new Animal(6,"T"));
            block[0][6] = new BlockCoords(0,6, new Animal(6, "T"));
            block[6][4] = new BlockCoords(6,4, new Animal(5,"L"));
            block[2][2] = new BlockCoords(2,2, new Animal(5, "L"));
        }
    }
    public void display() {
        for(int row=0; row< block.length; row++){
            for(int col=0; col<block[row].length; col++){
                System.out.print(block[row][col].temp + " ");
            }
            System.out.println();
        }
    }
}
