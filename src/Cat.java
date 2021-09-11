/**
 * This class represents the Cat pieces in the board
 */
public class Cat extends Animal {
    /**
     *
     * @param isBlue for which side the Cat is playing for
     */
    public Cat(boolean isBlue) {
        super(isBlue);
        setRank(2);
        setSymbol("C");

        if (isBlue)
            setImage("assets/cat1.png");
        else
            setImage("assets/cat2.png");
    }
}
