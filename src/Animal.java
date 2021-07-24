public class Animal {
    int nRank;
    boolean bAlive = true;
    boolean bBlue;
    String symbol;

    public Animal(int rank, String symbol, boolean isBlue) {
        this.nRank = rank;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    public int getRank() {
        return nRank;
    }

    public boolean isAlive() {
        return bAlive;
    }

    public boolean isBlue() {
        return bBlue;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setRank(int rank) {
        this.nRank = rank;
    }
}
