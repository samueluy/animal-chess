/**
 * This class represents the Tiger pieces in the board
 */
public class Tiger extends Animal {
    /**
     *
     * @param isBlue for which side the Tiger is playing for
     */
    public Tiger(boolean isBlue) {
        super(isBlue);
        setRank(6);
        setSymbol("T");

        if (isBlue)
            setImage("assets/tiger1.png");
        else
            setImage("assets/tiger2.png");
    }
}
