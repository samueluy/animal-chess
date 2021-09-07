import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class controlGrid implements ActionListener
{
    private testGrid view;
    private GameBoard model;
    private BlockCoords[][] board;

    controlGrid()
    {
        view = new testGrid();
        model = new GameBoard();
        Move move = new Move();
        
        model.createBoard();
        model.display();
        
        view.setActionListener(this);

        while (!model.checkWin()) {
            move.move(model, model.isPlayer());
            model.display();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        boolean firstClick = true;
        boolean secondClick = true;
<<<<<<< HEAD

        BlockCoords[][] board = model.getBlock();
        int x,y;
=======
        board = model.getBlock();
        int x = 0, y = 0;
>>>>>>> 34af47522f1d3ba61ba96a2fba15969648cd0e58
        int flag = 1;

        JButton switcher;
        Object[] directions = {"Up", "Down", "Left", "Right"};
        if(e.getActionCommand().equals("Rules"))
        {
            view.instructionAlert();
        }
        ///Dont forget if Restart is clicked!
        else
        {
            //// Searching for the coordinate that was clicked.
            for(int i=0;i<9;i++)
            {
                for(int j = 0;j<7;j++)
                {
                    ///Changing Or Invalidating Move
                    if (e.getSource().equals(view.getButton(i,j))) /// Get the button that was pressed
                    {
                        //If the button clicked contains something, store x, y.
                        if(board[i][j].getTemp() != ".") {
                            if (!(board[i][j].getTemp().contains(""))) {
                                x = i;
                                y = j;
                                System.out.println(x+" " +y);
                            }
                            flag = 0;
                        }
                    }
                }
            }
            if(flag == 1)
                view.emptyButtonAlert();

            /*Adjusting pos*/
            int choice = JOptionPane.showOptionDialog(null,"Choose a Direction :>","Direction",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions,directions[0]);
<<<<<<< HEAD
            if(choice != -1) {
                System.out.println("This piece will move "+ directions[choice]+" soon!");
                switch(choice){
                    case 0: view.move(view.getButton(0,0), view.getButton(0,0));
                }
            }
            else
                System.out.println("Panget mo kabonding.");
        }
    }

    public void moveChoice()
    {
        JLabel msg = new JLabel("Choose direction");
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(msg, BorderLayout.NORTH);

        JPanel directionPanel = new JPanel();
        directionPanel.setLayout(new FlowLayout());

        JButton upButton = new JButton("Up");
        JButton DownButton = new JButton("Down");
        JButton LeftButton = new JButton("Left");
        JButton RightButton = new JButton("Right");

        directionPanel.add(upButton);
        directionPanel.add(DownButton);
        directionPanel.add(LeftButton);
        directionPanel.add(RightButton);
=======

            if(choice == 0)
            {
                if(board[x][y+1].getTemp() == null)
                {
>>>>>>> 34af47522f1d3ba61ba96a2fba15969648cd0e58

                    switcher = view.getButton(x,y+1); //board[x][y + 1];

                }
            }
        }
    }

    //Only for firstclick
    public void enableButtons()
    {
        ///How do I know yung turn shiet.
        //Turn of Player 1
        if(model.isPlayer()) {
            view.disablePlayer1(true);  //Enable Player 1 buttons
            view.disablePlayer2(false);
        }
        else if(!(model.isPlayer())) {
            view.disablePlayer2(true); // Enable Player 2 Buttons
            view.disablePlayer1(false);
        }
    }

    public static void main(String[] args) {
        controlGrid app = new controlGrid();
    }
}
