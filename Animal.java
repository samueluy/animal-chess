public class Animal {
    private int nRank;
    private boolean bAlive = true;
    public boolean bBlue;		
    public String symbol;

    public Animal(int rank, String symbol, boolean isBlue) {
        this.nRank = rank;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    public int getRank() {
        return nRank;
    }

    public String getSymbol(){
        return symbol;
    }

    public void setRank(int rank) {
        this.nRank = rank;
    }
	
    public boolean isAlive() {
        return bAlive;
    }

    public boolean isBlue() {
        return bBlue;
    }
}
