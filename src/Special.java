public class Special {
    int type; // block type <need to implement> <1 - den; 2 - trap; 3 - water>
    String symbol;
    boolean blue;
    boolean free = true;

    public Special(int type, String symbol, boolean isBlue) {
        this.type = type;
        this.symbol = symbol;
        this.blue = isBlue;
    }

    public Special(int type, String symbol) {
        this.type = type;
        this.symbol = symbol;
    }

    public boolean isFree() {
        return free;
    }

    public int getType() {
        return type;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isBlue(){
        return blue;
    }
}
