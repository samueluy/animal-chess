
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class testGrid extends JFrame
{
    private ArrayList<JButton> buttons;
    private JLabel lblheader;
    public testGrid()
    {
         super("Grid Layout");
         setSize(500,300);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new GridLayout(9,7,5,5));


        setup();
        setVisible(true);
    }

    public void setup()
    {
        buttons = new ArrayList<>(63);
        JPanel header = new JPanel();
        header.setLayout(new FlowLayout());

        //Top Panel
       /* lblheader = new JLabel("ANIMAL CHESS");
        header.add(lblheader);

        JButton btnRules = new JButton("Rules");
        header.add(btnRules);

        JButton btnRestart = new JButton("Restart");
        header.add(btnRestart);
        add(header);*/

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
            buttons.add(new JButton(boardlbl));      //SSa arraylist
            add(buttons.get(i));
            boardlbl ="";
        }
 }

    public static void main(String[] args) {
        testGrid GUI = new testGrid();
    }
}
