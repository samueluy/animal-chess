
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testGrid extends JFrame
{
    private JButton[][] buttons = new JButton[9][7];
    private JLabel lblheader;
    private JButton btnRules;
    private JButton btnRestart;

    PieceIcon base1 = new PieceIcon(new Base(true));
    PieceIcon base2 = new PieceIcon(new Base(false));

    PieceIcon cat1 = new PieceIcon(new Cat(true));
    PieceIcon cat2 = new PieceIcon(new Cat(false));
    PieceIcon dog1 = new PieceIcon(new Dog(false));
    PieceIcon dog2 = new PieceIcon(new Dog(true));
    PieceIcon elephant1 = new PieceIcon(new Elephant(false));
    PieceIcon elephant2 = new PieceIcon(new Elephant(true));
    PieceIcon leopard1 = new PieceIcon(new Leopard(false));
    PieceIcon leopard2 = new PieceIcon(new Leopard(true));
    PieceIcon lion1 = new PieceIcon(new Lion(false));
    PieceIcon lion2 = new PieceIcon(new Lion(true));
    PieceIcon mouse1 = new PieceIcon(new Mouse(false));
    PieceIcon mouse2 = new PieceIcon(new Mouse(true));
    PieceIcon tiger1 = new PieceIcon(new Tiger(false));
    PieceIcon tiger2 = new PieceIcon(new Tiger(true));
    PieceIcon wolf1 = new PieceIcon(new Wolf(false));
    PieceIcon wolf2 = new PieceIcon(new Wolf(true));

    PieceIcon trap1 = new PieceIcon(new Trap(false));
    PieceIcon trap2 = new PieceIcon(new Trap(true));

    PieceIcon river = new PieceIcon(new River());

    public testGrid()
    {
         super("Grid Layout");
         setSize(400,600);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());


        setup();
        setVisible(true);
    }

    public void setup() {
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        //Top Panel
        btnRules = new JButton("Rules");
        northPanel.add(btnRules);

        lblheader = new JLabel("ANIMAL CHESS");
        northPanel.add(lblheader);

        btnRestart = new JButton("Restart");
        northPanel.add(btnRestart);
        add(northPanel, BorderLayout.NORTH);

        JPanel gl = new JPanel();
        gl.setLayout(new GridLayout(9, 7, 5, 5));

        // set bases
        buttons[0][3] = new JButton(base2);
        buttons[8][3] = new JButton(base1);

        // set animals
        buttons[0][6] = new JButton(tiger2);
        buttons[8][0] = new JButton(tiger1);
        buttons[0][0] = new JButton(lion2);
        buttons[8][6] = new JButton(lion1);
        buttons[1][1] = new JButton(dog2);
        buttons[7][5] = new JButton(dog1);
        buttons[1][5] = new JButton(cat2);
        buttons[7][1] = new JButton(cat1);
        buttons[2][0] = new JButton(mouse2);
        buttons[6][6] = new JButton(mouse1);
        buttons[2][2] = new JButton(leopard2);
        buttons[6][4] = new JButton(leopard1);
        buttons[2][4] = new JButton(wolf2);
        buttons[6][2] = new JButton(wolf1);
        buttons[2][6] = new JButton(elephant2);
        buttons[6][0] = new JButton(elephant1);

        // set river
        buttons[3][1] = new JButton(river);
        buttons[3][2] = new JButton(river);
        buttons[3][4] = new JButton(river);
        buttons[3][5] = new JButton(river);
        buttons[4][1] = new JButton(river);
        buttons[4][2] = new JButton(river);
        buttons[4][4] = new JButton(river);
        buttons[4][5] = new JButton(river);
        buttons[5][1] = new JButton(river);
        buttons[5][2] = new JButton(river);
        buttons[5][4] = new JButton(river);
        buttons[5][5] = new JButton(river);

        // set traps/*
        buttons[0][2] = new JButton(trap2);
        buttons[0][4] = new JButton(trap2);
        buttons[8][2] = new JButton(trap1);
        buttons[8][4] = new JButton(trap1);
        buttons[1][3] = new JButton(trap2);
        buttons[7][3] = new JButton(trap1);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++)
            {
                if(buttons[i][j] == null)
                    buttons[i][j] = (new JButton());      //Sa arraylist
                gl.add(buttons[i][j]);     //Adding Buttons in the grid.
                add(gl, BorderLayout.CENTER);
            }
        }
    }
    public void setActionListener(ActionListener listener)
    {
        for(int i=0;i<9;i++)
        {
            for (int j = 0; j < 7; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
        btnRules.addActionListener(listener);
        btnRestart.addActionListener(listener);

    }

    public JButton getButton(int i, int j)
    {
        return buttons[i][j];
    }

    public void instructionAlert()
    {
        JLabel msg = new JLabel("You need to listen to me first. DI MO TO KAYA IPLAY.");
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(msg);

        JOptionPane.showMessageDialog(null,p,"Instructions",JOptionPane.INFORMATION_MESSAGE);
    }

    public void emptyButtonAlert()
    {
        JLabel msg = new JLabel("Invalid Move!");
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(msg);

        JOptionPane.showMessageDialog(null,p,"Warning!",JOptionPane.ERROR_MESSAGE);
    }

    /* I separated them muna. Nahihilo kase.*/
    public void disablePlayer2(boolean enabled)
    {
        for(int i = 0;i < 9;i++)
        {
            for (int j=0;j<7;j++) {
                if (buttons[i][j].getIcon() == tiger1)//the pieces on the top. -- Player 2.
            {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == elephant1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == lion1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == dog1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == wolf1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == cat1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == mouse1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == leopard1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == trap1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }

                else if(buttons[i][j].getIcon() == base1) {
                    buttons[i][j].setEnabled(enabled);
                buttons[i][j].setBackground(Color.BLUE);
                }
                else
                    buttons[i][j].setBackground(new JButton().getBackground());
            }
        }
    }

    public void disablePlayer1(boolean enabled)
    {
        for(int i = 0;i < 9;i++)
        {
            for (int j=0;j<7;j++) {
                if (buttons[i][j].getIcon() == tiger2)//the pieces on the top. -- Player 2.
            {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == elephant2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == lion2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == dog2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == wolf2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == cat2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == mouse2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == leopard2) {
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == trap2){
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }

                else if(buttons[i][j].getIcon() == base2){
                    buttons[i][j].setEnabled(enabled);
                    buttons[i][j].setBackground(Color.RED);
                }
                else
                    buttons[i][j].setBackground(new JButton().getBackground());
            }
        }
    }

    // TEMPORARY
    public void move(JButton from, JButton to) {
        to.setIcon(from.getIcon());
        from.setIcon(null);
    }

    public void move(JButton from, JButton to, int type){ // to reset special blocks
        to.setIcon(from.getIcon());
        switch(type){
            case 0: from.setIcon(base1);
                    break;
            case 1: from.setIcon(base2);
                    break;
            case 2: from.setIcon(trap1);
                    break;
            case 3: from.setIcon(trap2);
                    break;
            case 4: from.setIcon(river);
                    break;
        }

    }


    public static void main(String[] args) {
        testGrid GUI = new testGrid();
    }
}
