/**
 * This class represents the Wolf pieces in the board
 */
public class Wolf extends Animal {
    /**
     *
     * @param isBlue for which side the Wolf is playing for
     */
    public Wolf(boolean isBlue) {
        super(isBlue);
        setRank(3);
        setSymbol("W");

        if (isBlue)
            setImage("assets/wolf1.png");
        else
            setImage("assets/wolf2.png");
    }
}
