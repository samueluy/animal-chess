public class Lion extends Animal{
    public Lion(boolean isBlue) {
        super(isBlue);
        setRank(7);
        setSymbol("Li"); // temporary

        if(isBlue)
            setImage("assets/lion1.png");
        else
            setImage("assets/lion2.png");
    }
}
