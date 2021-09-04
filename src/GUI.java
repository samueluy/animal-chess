import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton[][] buttons = new JButton[9][7];
    private JLabel lblheader;
    private JButton btnRules;

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
        setSize(500, 300);
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

        String boardlbl = "";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j == 6) {
                    boardlbl = "Tiger";
                    buttons[i][j] = new JButton(tiger2);
                } else if (i == 0 && j == 0) {
                    boardlbl = "Lion";
                    buttons[i][j] = (new JButton(lion2));
                } else if (i == 1 && j == 1) {
                    boardlbl = "Dog";
                    buttons[i][j] = (new JButton(dog2));
                } else if (i == 1 && j == 5) {
                    boardlbl = "Cat";
                    buttons[i][j] = (new JButton(cat2));
                } else if (i == 2 && j == 0) {
                    boardlbl = "Mouse";
                    buttons[i][j] = (new JButton(mouse2));
                } else if (i == 2 && j == 2) {
                    boardlbl = "Leopard";
                    buttons[i][j] = (new JButton(leopard2));
                } else if (i == 2 && j == 4) {
                    boardlbl = "Wolf";
                    buttons[i][j] = (new JButton(wolf2));
                } else if (i == 2 && j == 6) {
                    boardlbl = "Elephant";
                    buttons[i][j] = (new JButton(elephant2));
                } else if ((i == 3 || i == 4 || i == 5) && (j == 1 || j == 2 || j == 4 || j == 5)) {
                    boardlbl = "River";
                    buttons[i][j] = (new JButton(river));

                } else if (i == 6 && j == 0) {
                    boardlbl = "Elephant";
                    buttons[i][j] = (new JButton(elephant1));
                } else if (i == 6 && j == 2) {
                    boardlbl = "Wolf";
                    buttons[i][j] = (new JButton(wolf1));
                } else if (i == 6 && j == 4) {
                    boardlbl = "Leopard";
                    buttons[i][j] = (new JButton(leopard1));
                } else if (i == 6 && j == 6) {
                    boardlbl = "Mouse";
                    buttons[i][j] = (new JButton(mouse1));
                } else if (i == 7 && j == 1) {
                    boardlbl = "Cat";
                    buttons[i][j] = (new JButton(cat1));
                } else if (i == 7 && j == 5) {
                    boardlbl = "Dog";
                    buttons[i][j] = (new JButton(dog1));
                } else if (i == 8 && j == 0) {
                    boardlbl = "Tiger";
                    buttons[i][j] = (new JButton(tiger1));
                } else if (i == 8 && j == 6) {
                    boardlbl = "Lion";
                    buttons[i][j] = (new JButton(lion1));
                } else if ((i == 0 || i == 8) && (j == 2 || j == 4)) {
                    boardlbl = "Trap";
                    buttons[i][j] = (new JButton(trap));
                } else if ((i == 1 || i == 7) && j == 3) {
                    boardlbl = "Trap";
                    buttons[i][j] = new JButton(trap);
                } else if ((i == 0 || i == 8) && j == 3) {
                    boardlbl = "Base";
                    buttons[i][j] = (new JButton(base));
                } else
                    buttons[i][j] = (new JButton());      //Sa arraylist

                gl.add(buttons[i][j]);     //Adding Buttons in the grid.
                buttons[i][j].setActionCommand(boardlbl);
                boardlbl = "";
            }
        }
        add(gl, BorderLayout.CENTER);

    }

    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                buttons[i][j].addActionListener(listener);
            }
        }
        btnRules.addActionListener(listener);
    }

    public void instructionAlert() {
        JLabel msg = new JLabel("You need to listen to me first. DI MO TO KAYA IPLAY.");

        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(msg);

        JOptionPane.showMessageDialog(null, p, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
}
