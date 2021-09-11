public class Leopard extends Animal {
    public Leopard(boolean isBlue) {
        super(isBlue);
        setRank(5);
        setSymbol("L"); // temporary

        if (isBlue)
            setImage("assets/leopard1.png");
        else
            setImage("assets/leopard2.png");
    }
}
