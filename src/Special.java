import javax.swing.*;
import java.awt.*;

/**
 * This class represents each block which has a special trait.
 */
public class Special {
    private int type;
    private String symbol;
    private boolean bBlue;
    private boolean free = true;
    private ImageIcon image;

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     * @param isBlue Which color/team the Special object belongs to
     */
    public Special(int type, String symbol, boolean isBlue)
    {
        this.type = type;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     */
    public Special(int type, String symbol)
    {
        this.type = type;
        this.symbol = symbol;
    }

    public Special(boolean isBlue){
        this.bBlue = isBlue;
    }

    /**
     * Returns the type of Special object
     *
     * @return
     */
    public int getType() {
        return type;
    }

    /**
     * Returns the String representation of the Special object
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns which side the Special object belongs to
     *
     * @return
     */
    public boolean isBlue() {
        return bBlue;
    }

    /**
     * Returns if the Special object is taken or not
     *
     * @return
     */
    public boolean isFree() {
        return free;
    }

    // temp
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    public void setImage(String source){ // to use try catch
        try{
            this.image = new ImageIcon(new ImageIcon((getClass().getResource(source))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        }
        catch(Exception e){
            System.out.println("Error! \"" + source + " \"not found");
        }
    }

    public ImageIcon getImage(){
        return this.image;
    }
}