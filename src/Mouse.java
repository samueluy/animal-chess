public class Mouse extends Animal{
    public Mouse(boolean isBlue) {
        super(isBlue);
        setRank(1);
        setSymbol("M"); // temporary

        if(isBlue)
            setImage("assets/mouse1");
        else
            setImage("assets/mouse2");
    }
}
