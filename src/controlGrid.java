import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class controlGrid implements ActionListener {
    private testGrid view;
    private Move model;
    private int first;

    controlGrid()// Soon, add the model as an attribute and a parameter.
    {
        view = new testGrid();
        model = new Move();
        model.getBoard().createBoard();
        int start = 1;
        first = chooseWhoGoesFirst();
        switch(first){
            case 1: model.getBoard().setPlayer(false);
                view.disablePlayer1(true);
                break;
            case 2: model.getBoard().setPlayer(true);
                view.disablePlayer2(true);
                break;
            default: start=0;
        }
        if (start == 1) {
            model.getBoard().display();
            view.setActionListener(this);
        }
        else {
            System.out.println("ERROR!");
        }

    }

        @Override
        public void actionPerformed (ActionEvent e)
        {
            BlockCoords modelSwitcher;
            boolean firstClick = true;
            boolean secondClick = true;
            BlockCoords[][] board = model.getBoard().getBlock();
            int flag = 1;
            int x = 0, y = 0;
            int i = 0, j = 0;

            Object[] directions = {"Up", "Down", "Left", "Right"};
            if (e.getActionCommand().equals("Rules")) {
                view.instructionAlert();
            }
            else if(e.getActionCommand().equals("Restart"))
            {
                view.setVisible(false);
                view.dispose();
                new controlGrid();
            }
            ///Dont forget if Restart is clicked!
            else {
                //// Searching for the coordinate that was clicked.
            for(i=0;i<9;i++)
            {
                for(j=0;j<7;j++)
                {
                        ///Changing Or Invalidating Move
                        if (e.getSource().equals(view.getButton(i, j))) /// Get the button that was pressed
                        {
                            //Prevents the player from choosing water, base, or trap.
                            if (board[i][j].getTemp() != null && !(board[i][j].getTemp().contains("@")) && !(board[i][j].getTemp().contains("="))
                                    && !(board[i][j].getTemp().contains("+")) && board[i][j].getPiece().isBlue() == model.getBoard().isPlayer()) {
                                System.out.println(board[i][j].getTemp());
                                x = i;
                                y = j;
                                flag = 0;
                            }
                        }
                    }
                }
                if (flag == 1)
                    view.emptyButtonAlert();
                else {
                    /*Adjusting pos*/
                    int choice = JOptionPane.showOptionDialog(null, "Choose a Direction :>", "Direction",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, directions, directions[0]);
                    if (choice != -1) {
                        switch (choice) {
                            case 0:
                                if (x - 1 >= 0)///If there is water in front.
                                    model.fullMove(model, view, x, y, choice);
                                else {
                                    view.emptyButtonAlert();
                                    flag = 1;
                                }
                                break;

                            case 1:
                                if (x + 1 < 9)///If there is water in front.
                                    model.fullMove(model, view, x, y, choice);
                                else {
                                    view.emptyButtonAlert();
                                    flag = 1;
                                }
                                break;
                            case 2:
                                if (y - 1 >= 0)
                                    model.fullMove(model, view, x, y, choice);
                                else {
                                    view.emptyButtonAlert();
                                    flag = 1;
                                }
                                break;

                            case 3:
                                if (y + 1 < 7)
                                    model.fullMove(model, view, x, y, choice);
                                else {
                                    view.emptyButtonAlert();
                                    flag = 1;
                                }
                                break;
                        }
                        model.getBoard().display();
                        //enableButtons(model.getBoard().isPlayer());
                    } else {
                        System.out.println("Bad!");
                        flag = 1;
                    }
                    ///Check If there is a winner
                    if(model.getBoard().checkWin())
                    {
                        /*Stop the game.
                        Execute DIALOG in the screen
                        * */
                        if(gameOver() == 0)
                        {
                            view.setVisible(false);
                            view.dispose();
                            //Restart.
                            new controlGrid();
                        }
                    }
                    if(flag != 1 && model.getFlag() != 1) {
                        if (first == 1) {
                            enableButtons(false);
                            first = 2;
                        }
                        else {
                            enableButtons(true);
                            first = 1;
                        }
                        flag = 0;
                        model.setFlag(0);
                    }
                }
            }
        }

        private int gameOver()
        {//8 3 0 3
            JPanel p = new JPanel();
            JLabel msg;
            p.setLayout(new FlowLayout());
            if(model.getBoard().getBlock()[8][3].getTemp().contains("@"))
                msg = new JLabel("Player 1 Won!");
            else
                msg = new JLabel("Player 2 Won!");
            p.add(msg);

            String[] options = {"Yes", "No"};
            int choice = JOptionPane.showOptionDialog(null,p, "Do you want to Play Again?",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if(choice == 1)
            {
                choice = JOptionPane.showOptionDialog(null, "Are you sure?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            }

            if(choice == 1)
            {
                choice = JOptionPane.showOptionDialog(null, "I'm sorry. My master told me you don't have a choice.\n Do you want to play Again?", "Game Over",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            }

            while(choice == 1)
                choice = JOptionPane.showOptionDialog(null, "Do you want to Play Again?", "Game Over!",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            return 0;
        }
        public void enableButtons (boolean turn)
        {
            ///How do I know yung turn shiet.
            //Turn of Player 1
            if (turn)
            {
                view.disablePlayer2(false);
                view.disablePlayer1(true);  //Enable Player 1 buttons
            }
            else
            {
                view.disablePlayer1(false);
                view.disablePlayer2(true); // Enable Player 2 Buttons
            }
        }

    /*
    Player neeeds to choose an Animal Piece.
        -- Player1 will choose from a list of Buttons and There should be no Icons.
        -- Player2 Chooses.

        -- Ranks of the chosen are compared.
        If equal
            Choose again.
    * */
        public int chooseWhoGoesFirst () {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        JPanel choices = new JPanel();
        choices.setLayout(new GridLayout(1, 8, 5, 5));

        Integer[] ranks = {1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < ranks.length; i++) {
            int index = (int) (Math.random() * ranks.length);
            int temp = ranks[i];
            ranks[i] = ranks[index];
            ranks[index] = temp;
        }

        String[] animals = {"Mouse", "Cat", "Wolf", "Dog", "Leopard", "Tiger", "Lion", "Elephant"};
        ///Create Buttons in a option dialog and randomize the numbers. setvisible to false and reveal once clicked with another dialog.

        Object[] options = {" ", " ", " ", " ", " ", " ", " ", " "};

        //Player 1. Bottom Pieces.
        int flag = 0;
        while (flag == 0) {
            int choice1 = JOptionPane.showOptionDialog(null, "Choose an Animal", "Turn Setup",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            int choice2 = JOptionPane.showOptionDialog(null, "Choose an Animal", "Turn Setup",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            choice1 = (int) (Math.random() * 7);
            choice2 = (int) (Math.random() * 7);

            if (choice1 > choice2) {
                JOptionPane.showMessageDialog(null, "Player 1 picked " + animals[choice1] + " and Player 2 picked " + animals[choice2] + " \nPlayer 1 moves first!"
                        , "Results", JOptionPane.PLAIN_MESSAGE, null);
                flag = 1;
                return 2;
            } else if (choice1 < choice2) {
                JOptionPane.showMessageDialog(null, "Player 1 picked " + animals[choice1] + " and Player 2 picked " + animals[choice2] + " \nPlayer 2 moves first!"
                        , "Results", JOptionPane.PLAIN_MESSAGE, null);
                flag = 1;
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Player 1 picked " + animals[choice1] + " and Player 2 picked " + animals[choice2] + " \nTie game! Pick again!"
                        , "Results", JOptionPane.PLAIN_MESSAGE, null);
            }
        }
        return -1;
    }

        public static void main (String[]args){
        controlGrid app = new controlGrid();

    }
}

