public class Dog extends Animal {
    public Dog(boolean isBlue) {
        super(isBlue);
        setRank(4);
        setSymbol("D"); // temporary

        if (isBlue)
            setImage("assets/dog1.png");
        else
            setImage("assets/dog2.png");
    }
}
