/**
 * This class represents each block which has a special trait.
 */
public class Special {
    private int type;
    private String symbol;
    private boolean blue;
    private boolean free = true;

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     * @param isBlue Which color/team the Special object belongs to
     */
    public Special(int type, String symbol, boolean isBlue) {
        this.type = type;
        this.symbol = symbol;
        this.blue = isBlue;
    }

    /**
     * @param type   1: Den; 2: Trap; 3: River
     * @param symbol String representation of a Special object
     */
    public Special(int type, String symbol) {
        this.type = type;
        this.symbol = symbol;
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
        return blue;
    }

    /**
     * Returns if the Special object is taken or not
     *
     * @return
     */
    public boolean isFree() {
        return free;
    }
}
