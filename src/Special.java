import java.net.URL;

/**
 * This class represents each block which has a special trait.
 */
public class Special {
    private int type;
    private String symbol;
    private boolean bBlue;
    private final boolean free = true;
    private URL imageURL;

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     * @param isBlue Which color/team the Special object belongs to
     */
    public Special(int type, String symbol, boolean isBlue) {
        this.type = type;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     */
    public Special(int type, String symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    public Special(boolean isBlue) {
        this.bBlue = isBlue;
    }

    public Special() {
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

    // temp
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns which side the Special object belongs to
     *
     * @return
     */
    public boolean isBlue() {
        return bBlue;
    }
    public void setImage(String source) { // to use try catch
        try {
            this.imageURL = (getClass().getResource(source));
        } catch (Exception e) {
            System.out.println("Error! \"" + source + " \"not found");
        }
    }

    public URL getImageURL() {
        return this.imageURL;
    }
}