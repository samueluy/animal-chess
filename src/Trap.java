/**
 * This class represents the Traps of each player
 */
public class Trap extends Special {
    /**
     * Returns which side the Trap object belongs to
     * @param bBlue For which player owns the trap
     */
    public Trap(boolean bBlue) {
        super(bBlue);
        setImage("assets/trap.png");
        setSymbol("+");
    }
}
