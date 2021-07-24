public class AnimalChess {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Move move = new Move();
        boolean player = true;

        board.createBoard();
        board.display();
        while(true){
            player = !player; // exchange between true or fasle
            move.move(board, player);
            board.display();
        }
    }
}
