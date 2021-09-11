/**
 * This class represents the Lion pieces in the board
 */
public class Lion extends Animal {
    /**
     *
     * @param isBlue for which side the Lion is playing for
     */
    public Lion(boolean isBlue) {
        super(isBlue);
        setRank(7);
        setSymbol("Li");

        if (isBlue)
            setImage("assets/lion1.png");
        else
            setImage("assets/lion2.png");
    }
}
