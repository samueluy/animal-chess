/**
 * This class represents the Elephant pieces in the board
 */
public class Elephant extends Animal {
    /**
     *
     * @param isBlue for which side the Elephant is playing for
     */
    public Elephant(boolean isBlue) {
        super(isBlue);
        setRank(8);
        setSymbol("E");

        if (isBlue)
            setImage("assets/elephant1.png");
        else
            setImage("assets/elephant2.png");
    }
}
