import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class controlGrid implements ActionListener
{
    private testGrid view;
    private Move model;

    controlGrid()// Soon, add the model as an attribute and a parameter.
    {
        view = new testGrid();
        model = new Move();

        model.getBoard().createBoard();
        model.getBoard().display();

        view.setActionListener(this);

        /*
        while (!model.getBoard().checkWin()) {
            model.move(model.getBoard(), model.getBoard().isPlayer());
            model.getBoard().display();
        }
         */
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        BlockCoords modelSwitcher;
        boolean firstClick = true;
        boolean secondClick = true;
        BlockCoords[][] board = model.getBoard().getBlock();
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
                        case 0:
                            ///If there is water in front.
                                if(x-1 >=0)
                                {
                                    if (model.getBoard().getBlock()[x - 1][y].getTemp() != null && model.getBoard().getBlock()[x - 1][y].getTemp().contains("=")) {
                                        //Tiger Move Special Condition:
                                        if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                                            view.move(view.getButton(x, y), view.getButton(x - 4, y)); // up
                                            modelSwitcher = model.getBoard().getBlock()[x - 4][y];
                                            model.getBoard().getBlock()[x - 4][y] = model.getBoard().getBlock()[x][y];
                                            model.getBoard().getBlock()[x][y] = modelSwitcher;
                                        } else {
                                            //Turn should not change. Displat invalid move.
                                            view.emptyButtonAlert();
                                        }
                                    } else {
                                        view.move(view.getButton(x, y), view.getButton(x - 1, y)); // up
                                        modelSwitcher = model.getBoard().getBlock()[x - 1][y];
                                        model.getBoard().getBlock()[x - 1][y] = model.getBoard().getBlock()[x][y];
                                        model.getBoard().getBlock()[x][y] = modelSwitcher;
                                    }
                                }
                                else
                                    view.emptyButtonAlert();
                            break;
                        /*
                         * why it worked: THE POINTERS WAS CHANGED. MEANING THE GUI ALSO CHANGED CUZ IT RELIES ON POINTERS.
                         * */

                        case 1:
                            if(x+1 < 9) {
                                if (model.getBoard().getBlock()[x + 1][y].getTemp() != null && model.getBoard().getBlock()[x + 1][y].getTemp().contains("=")) {
                                    //Tiger Move Special Condition:
                                    if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                                        view.move(view.getButton(x, y), view.getButton(x + 4, y)); // down
                                        modelSwitcher = model.getBoard().getBlock()[x + 4][y];
                                        model.getBoard().getBlock()[x + 4][y] = model.getBoard().getBlock()[x][y];
                                        model.getBoard().getBlock()[x][y] = modelSwitcher;
                                    } else {
                                        //Turn should not change. Displat invalid move.
                                        view.emptyButtonAlert();
                                    }
                                } else {
                                    view.move(view.getButton(x, y), view.getButton(x + 1, y)); // down
                                    modelSwitcher = model.getBoard().getBlock()[x + 1][y];
                                    model.getBoard().getBlock()[x + 1][y] = model.getBoard().getBlock()[x][y];
                                    model.getBoard().getBlock()[x][y] = modelSwitcher;
                                }
                            }
                            else
                                view.emptyButtonAlert();
                            break;
                        case 2:
                            if(y-1 >= 0)
                            {
                                if (model.getBoard().getBlock()[x][y - 1].getTemp() != null && model.getBoard().getBlock()[x][y - 1].getTemp().contains("=")) {
                                    //Tiger Move Special Condition:
                                    if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                                        view.move(view.getButton(x, y), view.getButton(x, y - 3)); // left
                                        modelSwitcher = model.getBoard().getBlock()[x][y - 3];
                                        model.getBoard().getBlock()[x][y - 3] = model.getBoard().getBlock()[x][y];
                                        model.getBoard().getBlock()[x][y] = modelSwitcher;
                                    } else {
                                        //Turn should not change. Displat invalid move.
                                        view.emptyButtonAlert();
                                    }
                                } else {
                                    view.move(view.getButton(x, y), view.getButton(x, y - 1)); // left
                                    modelSwitcher = model.getBoard().getBlock()[x][y - 1];
                                    model.getBoard().getBlock()[x][y - 1] = model.getBoard().getBlock()[x][y];
                                    model.getBoard().getBlock()[x][y] = modelSwitcher;
                                }
                            }
                            else
                                view.emptyButtonAlert();
                            break;

                        case 3:
                            if(y+1 < 7) {
                                if (model.getBoard().getBlock()[x][y + 1].getTemp() != null && model.getBoard().getBlock()[x][y + 1].getTemp().contains("=")) {
                                    //Tiger Move Special Condition:
                                    if (model.getBoard().getBlock()[x][y].getTemp().contains("T") || model.getBoard().getBlock()[x][y].getTemp().contains("Li")) {
                                        view.move(view.getButton(x, y), view.getButton(x, y + 3)); // Right
                                        modelSwitcher = model.getBoard().getBlock()[x][y + 3];
                                        model.getBoard().getBlock()[x][y + 3] = model.getBoard().getBlock()[x][y];
                                        model.getBoard().getBlock()[x][y] = modelSwitcher;
                                    } else {
                                        //Turn should not change. Displat invalid move.
                                        view.emptyButtonAlert();
                                    }
                                } else {
                                    view.move(view.getButton(x, y), view.getButton(x, y + 1)); // left
                                    modelSwitcher = model.getBoard().getBlock()[x][y + 1];
                                    model.getBoard().getBlock()[x][y + 1] = model.getBoard().getBlock()[x][y];
                                    model.getBoard().getBlock()[x][y] = modelSwitcher;
                                }
                            }
                            else
                                view.emptyButtonAlert();
                                break;
                    }
                    model.getBoard().display();
                }
                else
                    System.out.println("Bad!");
            }
        }
    }
    /*
    * Restriction: River movement. Tiger Special Ability.
    * */

    //Only for firstclick
    public void enableButtons()
    {
        ///How do I know yung turn shiet.
        //Turn of Player 1
        if(model.getBoard().isPlayer()) {
            view.disablePlayer1(true);  //Enable Player 1 buttons
            view.disablePlayer2(false);
        }
        else if(!(model.getBoard().isPlayer())) {
            view.disablePlayer2(true); // Enable Player 2 Buttons
            view.disablePlayer1(false);
        }
    }

    public static void main(String[] args) {
        controlGrid app = new controlGrid();
    }
}
