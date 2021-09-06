public class Base extends Special{
    public Base(boolean bBlue) { // add String source
        super(bBlue);
        setSymbol("@"); // temporary

        if(bBlue)
            setImage("assets/lion1.png");
        else
            setImage("assets/lion2.png");
    }
}
