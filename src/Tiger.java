public class Tiger extends Animal {
    public Tiger(boolean isBlue) {
        super(isBlue);
        setRank(6);
        setSymbol("T");

        if (isBlue)
            setImage("assets/tiger1.png");
        else
            setImage("assets/tiger2.png");
    }
}
