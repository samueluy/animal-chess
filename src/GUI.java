import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame {
    private ArrayList<JButton> buttons;
    private JLabel lblheader;

    ImageIcon base = new ImageIcon(new ImageIcon((getClass().getResource("assets/base.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon trap = new ImageIcon(new ImageIcon((getClass().getResource("assets/trap.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon river = new ImageIcon(new ImageIcon((getClass().getResource("assets/river.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

    ImageIcon cat1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/cat1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon dog1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/dog1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon elephant1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/elephant1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon leopard1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/leopard1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon lion1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/lion1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon mouse1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/mouse1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon tiger1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/tiger1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon wolf1 = new ImageIcon(new ImageIcon((getClass().getResource("assets/wolf1.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));

    ImageIcon cat2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/cat2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon dog2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/dog2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon elephant2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/elephant2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon leopard2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/leopard2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon lion2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/lion2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon mouse2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/mouse2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon tiger2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/tiger2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    ImageIcon wolf2 = new ImageIcon(new ImageIcon((getClass().getResource("assets/wolf2.png"))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));


    public GUI() {
        super("Grid Layout");

        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        System.out.println("Working Directory = " + System.getProperty("user.dir"));


        setup();
        setVisible(true);
    }

    public void setup() {


        buttons = new ArrayList<>(63);
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());

        //Top Panel
        JButton btnRules = new JButton("Rules");
        northPanel.add(btnRules);

        lblheader = new JLabel("ANIMAL CHESS");
        northPanel.add(lblheader);

        JButton btnRestart = new JButton("Restart");
        northPanel.add(btnRestart);
        add(northPanel, BorderLayout.NORTH);

        JPanel gl = new JPanel();
        gl.setLayout(new GridLayout(9, 7, 5, 5));

        for (int i = 0; i < 63; i++) {
            // maybe may more effecient way to do this? Better if switch pero mahaba pa rin kung ganon? HAHAHA
            if (i==6)
                buttons.add(new JButton(tiger2));
            else if(i==0)
                buttons.add(new JButton(lion2));
            else if(i==8)
                buttons.add(new JButton(dog2));
            else if(i==12)
                buttons.add(new JButton(cat2));
            else if(i==14)
                buttons.add(new JButton(mouse2));
            else if(i==16)
                buttons.add(new JButton(leopard2));
            else if(i==18)
                buttons.add(new JButton(wolf2));
            else if(i==20)
                buttons.add(new JButton(elephant2));

            else if (i == 22 || i == 23 || i == 25 || i == 26 ||
                    i == 29 || i == 30 || i == 32 || i == 33 ||
                    i == 36 || i == 37 || i == 39 || i == 40)
                buttons.add(new JButton(river));

            else if(i==42)
                buttons.add(new JButton(elephant1));
            else if(i==44)
                buttons.add(new JButton(wolf1));
            else if(i==46)
                buttons.add(new JButton(leopard1));
            else if(i==48)
                buttons.add(new JButton(mouse1));
            else if(i==50)
                buttons.add(new JButton(cat1));
            else if(i==54)
                buttons.add(new JButton(dog1));
            else if(i==56)
                buttons.add(new JButton(tiger1));
            else if(i==62)
                buttons.add(new JButton(lion1));

            else if (i == 2 || i == 4 || i == 10 ||
                    i == 52 || i == 58 || i == 60)
                buttons.add(new JButton(trap));

            else if (i == 3 || i == 59)
                buttons.add(new JButton(base));
            else
                buttons.add(new JButton());      //Sa arraylist
            gl.add(buttons.get(i));     //Adding Buttons in the grid.
        }
        add(gl, BorderLayout.CENTER);
    }
}
