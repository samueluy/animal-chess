/**
 * This class represents the Dog pieces in the board
 */
public class Dog extends Animal {
    /**
     *
     * @param isBlue for which side the Dog is playing for
     */
    public Dog(boolean isBlue) {
        super(isBlue);
        setRank(4);
        setSymbol("D");

        if (isBlue)
            setImage("assets/dog1.png");
        else
            setImage("assets/dog2.png");
    }
}
