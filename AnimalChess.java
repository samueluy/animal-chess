/**
 * <h1>CCPROG3: MP PHASE 1</h1>
 * The AnimalChess program is a modified version of the classic game of Chess.
 * <p>Two players are to fight to take control of their opponent's den! Each animal has a rank which determines its
 * power to capture other animal. There is a river in the center of the board which prevents most of the pieces from
 * easily crossing the other side. Traps are also strategically placed to make the gameplay more enthralling.
 * </p>
 *
 * @author Deculawan, Ryan<br>Uy, Samuel Jedidiah
 * @version 1.0
 * @since 2021-07-24
 */

public class AnimalChess 
{
    public static void main(String[] args) 
	{
        new GUI();
        GameBoard board = new GameBoard();
        Move move = new Move();

        board.createBoard();
        board.display();
        while (!board.checkWin()) {
            move.move(board, board.isPlayer());
            board.display();
        }
    }
}
