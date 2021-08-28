import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{
    private JFrame displayInstructions(){
        JLabel text = new JLabel();
        JFrame instructions = new JFrame("Instructions");

        text.setHorizontalAlignment(JLabel.CENTER); // Align to center

        instructions.setLayout(new BorderLayout());
        text.setText("ISDOAJSA");
        instructions.add(text, BorderLayout.CENTER);
        instructions.setSize(400, 600);
        instructions.setVisible(true);
        return instructions;
    }

    public GUI() {
        GameBoard board = new GameBoard();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        JPanel toolbar = new JPanel();
        JButton restart = new JButton("Restart");
        JButton showInstructions = new JButton("Instructions");

        frame.add(panel,BorderLayout.CENTER);
        frame.setTitle("Animal Chess");
        frame.setSize(400,600);
        frame.setVisible(true);

        toolbar.setLayout(new FlowLayout());
        toolbar.add(showInstructions);
        toolbar.add(restart);
        frame.add(toolbar, BorderLayout.NORTH);

        displayInstructions();
    }
}
