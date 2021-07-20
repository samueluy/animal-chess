public class GameBoard {
        private Player[] Players;
        private boolean bTurn;
        private BlockCoords[][] Pieces;
		
		/*
		PLAN: Have a board for output. The numbers "00" will be replaced by what we want to see in the table.
			We'll have a seperate variable for keeping track of the objects, We'll use "Board" for printing 
				and "Pieces" will still have it's attributes.
		*/
		
		/*Test Array only. 3 x 7 */
		private String[][] Board = {{"00", "01", "02","03","04","05","06"},
							        {"10", "11", "12","13","14","15","16"},
							      	{"20", "21", "22","23","24","25","26"}};
/*		
		Problem: 
		How to Access and initialize a 2D array of objects -- Pieces.
		
		-I tried using concepts from here https://www.softwaretestinghelp.com/array-of-objects-in-java/ pero did not work.
		
		
		Pieces[][] = new BlockCoords[9][7];
		Pieces[0][0] new BlockCoords();
	*/	
	
	/*
		We have yet to do the Move Class / Eating Methods, Leopard and Lion Class.
		
		
	
	*/


}
