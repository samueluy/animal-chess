public class Elephant extends Animal {
    public Elephant(boolean isBlue) {
        super(isBlue);
        setRank(8);
        setSymbol("E"); // temporary

        if (isBlue)
            setImage("assets/elephant1.png");
        else
            setImage("assets/elephant2.png");
    }
}
