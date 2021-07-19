public class GameBoard 
{
	private Player Players[];	//Sa main dapat lalagyan ng dimensions!
    private boolean bTurn;
    private BlockCoords[][] Board;
    

	public GameBoard()
	{
		Players = new Player[2];		/*Players = new Players[2], with the 2nd Players, 
											Java tries to look for a 'Players' class 
											since there is none it flags an error. */
		bTurn = true;
		/*Board = new BlockCoords[9][7];
		BlockCoords();
		*/
	}
	
	public void display()
	{	//Need ng driver class to instantiate the block.
		int i,j;
		for(i=0; i < 9; i++)
		{
			for(j=0; j < 7;j++)
			{
				System.out.print(Board[i][j]);
			}
			System.out.println();
		}
	}
}
