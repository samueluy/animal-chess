import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class controlGrid implements ActionListener
{
    private testGrid view;
    private GameBoard model;

    controlGrid()// Soon, add the model as an attribute and a parameter.
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
        BlockCoords[][] board = model.getBlock();
        int flag = 1;
        int x=0,y=0;
        int i=0, j = 0;

        Object[] directions = {"Up", "Down", "Left", "Right"};
        if(e.getActionCommand().equals("Rules"))
        {
            view.instructionAlert();
        }
        ///Dont forget if Restart is clicked!
        else
        {
            //// Searching for the coordinate that was clicked.
            for(i=0;i<9;i++)
            {
                for(j=0;j<7;j++)
                {
                    ///Changing Or Invalidating Move
                    if (e.getSource().equals(view.getButton(i,j))) /// Get the button that was pressed
                    {
                        //Prevents the player from choosing water or the base.
                        if(board[i][j].getTemp() != null && !(board[i][j].getTemp().contains("@")) && !(board[i][j].getTemp().contains("=")) )
                        {
                            System.out.println(board[i][j].getTemp());
                            x = i;
                            y = j;
                            flag = 0;
                        }
                        //If the button clicked contains something, store x, y.
                    }
                }
            }
            if(flag == 1)
                view.emptyButtonAlert();
            else
            {
                /*Adjusting pos*/
                int choice = JOptionPane.showOptionDialog(null, "Choose a Direction :>", "Direction",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions, directions[0]);
                if (choice != -1){
                    switch (choice) {
                        case 0 -> view.move(view.getButton(x, y), view.getButton(x - 1, y)); // up
                        case 1 -> view.move(view.getButton(x, y), view.getButton(x + 1, y)); // down
                        case 2 -> view.move(view.getButton(x, y), view.getButton(x, y - 1)); // left
                        case 3 -> view.move(view.getButton(x, y), view.getButton(x, y + 1)); // right
                    }
                }
                else
                    System.out.println("Panget mo kabonding.");
            }
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

        p.add(directionPanel,BorderLayout.CENTER);

        JOptionPane.showOptionDialog(null,p,"Direction",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new Object[]{},null);
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
