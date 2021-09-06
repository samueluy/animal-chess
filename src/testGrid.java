
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class testGrid extends JFrame
{
    private JButton[][] buttons = new JButton[9][7];
    private JLabel lblheader;
    private JButton btnRules;

    Base base1 = new Base(true);
    Base base2 = new Base(false);

    Cat cat1 = new Cat(true);
    Cat cat2 = new Cat(false);
    Dog dog1 = new Dog(true);
    Dog dog2 = new Dog(false);
    Elephant elephant1 = new Elephant(true);
    Elephant elephant2 = new Elephant(false);
    Leopard leopard1 = new Leopard(true);
    Leopard leopard2 = new Leopard(false);
    Lion lion1 = new Lion(true);
    Lion lion2 = new Lion(false);
    Mouse mouse1 = new Mouse(true);
    Mouse mouse2 = new Mouse(false);
    Tiger tiger1 = new Tiger(true);
    Tiger tiger2 = new Tiger(false);
    Wolf wolf1 = new Wolf(true);
    Wolf wolf2 = new Wolf(false);

    ImageIcon trap = new ImageIcon(new ImageIcon((getClass().getResource("assets/trap.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon river = new ImageIcon(new ImageIcon((getClass().getResource("assets/river.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

    public testGrid()
    {
         super("Grid Layout");
         setSize(500,300);
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

        JButton btnRestart = new JButton("Restart");
        northPanel.add(btnRestart);
        add(northPanel, BorderLayout.NORTH);

        JPanel gl = new JPanel();
        gl.setLayout(new GridLayout(9, 7, 5, 5));

        // set bases
        buttons[0][3] = new JButton(base1.getImage());
        buttons[8][3] = (new JButton(base2.getImage()));

        // set animals
        buttons[0][6] = new JButton(tiger2.getImage());
        buttons[8][0] = new JButton(tiger1.getImage());
        buttons[0][0] = new JButton(lion2.getImage());
        buttons[8][6] = new JButton(lion1.getImage());
        buttons[1][1] = new JButton(dog2.getImage());
        buttons[7][5] = new JButton(dog1.getImage());
        buttons[1][5] = new JButton(cat2.getImage());
        buttons[7][1] = new JButton(cat1.getImage());
        buttons[2][0] = new JButton(mouse2.getImage());
        buttons[6][6] = new JButton(mouse1.getImage());
        buttons[2][2] = new JButton(leopard2.getImage());
        buttons[6][4] = new JButton(leopard1.getImage());
        buttons[2][4] = new JButton(wolf2.getImage());
        buttons[6][2] = new JButton(wolf1.getImage());
        buttons[2][6] = new JButton(elephant2.getImage());
        buttons[6][0] = new JButton(elephant1.getImage());

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

        // set traps
        buttons[0][2] = new JButton(trap);
        buttons[0][4] = new JButton(trap);
        buttons[8][2] = new JButton(trap);
        buttons[8][4] = new JButton(trap);
        buttons[1][3] = new JButton(trap);
        buttons[7][3] = new JButton(trap);
        buttons[0][3] = new JButton(trap);
        buttons[8][3] = new JButton(trap);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if(buttons[i][j] == null)
                    buttons[i][j] = (new JButton());      //Sa arraylist
                gl.add(buttons[i][j]);     //Adding Buttons in the grid.
                //    buttons[i][j].setActionCommand(boardlbl);
                //  boardlbl = ""
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
            for (int j=0;i<7;j++)
            {
                if (buttons[i][j].getActionCommand().contains("1"))  //the pieces on the top. -- Player 2.
                    buttons[i][j].setEnabled(enabled);
            }
        }
    }

    public void disablePlayer1(boolean enabled)
    {
        for(int i = 0;i < 9;i++)
        {
            for (int j=0;i<7;j++)
            {
                if (buttons[i][j].getActionCommand().contains("2"))  //the pieces on the Bottom. -- Player 1.
                    buttons[i][j].setEnabled(enabled);
            }
        }
    }
    public static void main(String[] args) {

        testGrid GUI = new testGrid();
    }
}
