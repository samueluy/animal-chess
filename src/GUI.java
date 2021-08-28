import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{

    public GUI() {
        GameBoard board = new GameBoard();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JPanel toolbar = new JPanel();
        JButton restart = new JButton("Restart");
        JButton exit = new JButton("Exit");
        JButton showInstructions = new JButton("Instructions");

        frame.add(panel,BorderLayout.CENTER);
        frame.setTitle("Animal Chess");
        frame.setSize(400,600);
        frame.setVisible(true);

        toolbar.setLayout(new FlowLayout());
        toolbar.add(showInstructions);
        toolbar.add(restart);
        toolbar.add(exit);
        frame.add(toolbar, BorderLayout.NORTH);
    }
}
