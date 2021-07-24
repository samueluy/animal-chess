public class AnimalChess {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Move move = new Move();
        boolean player = true;
        boolean isDone = false;

        board.createBoard();
        board.display();
        while(!board.checkWin()){
            move.move(board, board.isPlayer());
            board.display();
        }
    }
}
