public class Mouse extends Animal {
    boolean diverMouse;

    public Mouse(boolean isBlue) {
        super(isBlue);
        setRank(1);
        setSymbol("M"); // temporary

        if (isBlue)
            setImage("assets/mouse1.png");
        else
            setImage("assets/mouse2.png");
    }
}
