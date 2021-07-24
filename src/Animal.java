public class Animal {
    int nRank;
    boolean bAlive = true;
    boolean isBlue;
    String symbol;

    public Animal(int rank, String symbol, boolean isBlue) {
        this.nRank = rank;
        this.symbol = symbol;
        this.isBlue = isBlue;
    }

    public int getRank() {
        return nRank;
    }

    public boolean isAlive() {
        return bAlive;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setRank(int rank) {
        this.nRank = rank;
    }
}
