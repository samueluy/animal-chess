public class BlockCoords {
    private int xCoord; 
	private int yCoord;
	private String temp;
	
	private static int setXCoord = 0;
	private static int setYCoord = 0;
	
	public BlockCoords()
	{
		int i;
		int j;
		for(i=0;i<7;i++)
		{
			for(j=0;j<9;j++)
			{	
			///Initialization of array board.
				xCoord = setXCoord;
				yCoord = j;
				temp = "A";
			}
			xCoord++;
			
		}	
/*		setYCoord++;
		
		/*Pag nasa dulo na proceed to the next row.
		if(setYCoord == 7 && setXCoord != 8)
		{
			setXCoord++;
		}
	*/	
	}
	
	public void setX(int newCoord)
	{
		xCoord = newCoord;
	}
	
	public void setY(int newCoord)
	{
		yCoord = newCoord;
	}
	
	public void setTemp(String newSymb)
	{
		temp = newSymb;
	}
	
}


