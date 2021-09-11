/**
 * This class represents the Base of each player
 */

public class Base extends Special {
    /**
     *
     * @param bBlue for which side the Base is
     */
    public Base(boolean bBlue) {
        super(bBlue);
        setImage("assets/base.png");
        setSymbol("@");
    }
}
