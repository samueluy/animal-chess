import java.awt.event.*;

public class controlGrid implements ActionListener
{
    private testGrid view;

    controlGrid(testGrid gui)// Soon, add the model as an attribute and a parameter.
    {
        this.view = gui;

        gui.setActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Rules")) {
            view.instructionAlert();
            System.out.println("Why'd you press me MOFO!?");
        }

    }
}
