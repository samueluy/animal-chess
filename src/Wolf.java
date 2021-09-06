public class Wolf extends Animal{
    public Wolf(boolean isBlue) {
        super(isBlue);
        setRank(3);
        setSymbol("W"); // temporary

        if(isBlue)
            setImage("assets/wolf1.png");
        else
            setImage("assets/wolf2.png");
    }
}
