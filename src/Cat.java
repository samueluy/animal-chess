public class Cat extends Animal {
    public Cat(boolean isBlue) {
        super(isBlue);
        setRank(2);
        setSymbol("C"); // temporary

        if (isBlue)
            setImage("assets/cat1.png");
        else
            setImage("assets/cat2.png");
    }
}
