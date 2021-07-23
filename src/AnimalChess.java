public class AnimalChess {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Move move = new Move();

        board.createBoard();
        board.display();
        move.move(board);
        board.display();
    }
}
