/**
 * This class represents the Leopard pieces in the board
 */
public class Leopard extends Animal {
    /**
     *
     * @param isBlue for which side the Leopard is playing for
     */
    public Leopard(boolean isBlue) {
        super(isBlue);
        setRank(5);
        setSymbol("L");
        if (isBlue)
            setImage("assets/leopard1.png");
        else
            setImage("assets/leopard2.png");
    }
}
