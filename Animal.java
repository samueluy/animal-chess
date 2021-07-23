public class Animal {
    private int nRank;
    private boolean bAlive = true;
    private boolean isBlue;
    public String symbol;

    public Animal(int rank, String symbol) {
        this.nRank = rank;
        this.symbol = symbol;
    }

    public int getRank() {
        return nRank;
    }

    public boolean isAlive() {
        return bAlive;
    }

    public void setRank(int rank) {
        this.nRank = rank;
    }
}
