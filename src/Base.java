public class Base extends Special{
    public Base(boolean bBlue) { // add String source
        super(bBlue);
        setSymbol("@"); // temporary

        if(bBlue)
            setImage("assets/base.png");
        else
            setImage("assets/base.png");
    }
}
