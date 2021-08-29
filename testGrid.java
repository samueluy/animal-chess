
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class testGrid extends JFrame
{
    private ArrayList<JButton> buttons;
    private JLabel lblheader;
    private JButton btnRules;

    public testGrid()
    {
         super("Grid Layout");
         setSize(500,300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());


        setup();
        setVisible(true);
    }

    public void setup()
    {
        buttons = new ArrayList<>(63);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        //Top Panel
        btnRules = new JButton("Rules");
        northPanel.add(btnRules);

        lblheader = new JLabel("ANIMAL CHESS");
        northPanel.add(lblheader);

        JButton btnRestart = new JButton("Restart");
        northPanel.add(btnRestart);
        add(northPanel,BorderLayout.NORTH);

        JPanel gl = new JPanel();
        gl.setLayout(new GridLayout(9,7,5,5));

        String boardlbl = "";
        for(int i = 0;i<63;i++)
        {
            if(i == 0 ||i == 6 ||i == 8 ||i == 12 ||
                    i == 14 ||i == 16 ||i == 18 ||i == 20)
                boardlbl+="Animal";

            else if(i == 22 ||i == 23 ||i == 25 ||i == 26 ||
                    i == 29 ||i == 30 ||i == 32 ||i == 33 ||
                    i == 36 ||i == 37 ||i == 39 ||i == 40)
                boardlbl+="River";

            else if(i == 42 ||i == 44 ||i == 46 ||i == 48 ||
                    i == 50 ||i == 54 ||i == 56 ||i == 62)
                boardlbl+="Animal";

            else if(i == 2 ||i == 4 ||i == 10 ||
                    i == 52 ||i == 58 ||i == 60)
                boardlbl+="Trap.";
            else if(i==3 || i==59)
                boardlbl+="Base";

            buttons.add(new JButton(boardlbl));      //Sa arraylist
            gl.add(buttons.get(i));     //Adding Buttons in the grid.
            boardlbl ="";
        }
        add(gl,BorderLayout.CENTER);
 }
    public void setActionListener(ActionListener listener)
    {
        btnRules.addActionListener(listener);
    }

    public void instructionAlert()
    {
        JLabel msg = new JLabel("You need to listen to me first. DI MO TO KAYA IPLAY.");

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(msg);

        JOptionPane.showMessageDialog(null,p,"Instructions",JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        testGrid GUI = new testGrid();
        controlGrid control = new controlGrid(GUI);
    }
}
