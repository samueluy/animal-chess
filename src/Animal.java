public class Animal {
    int nRank;
    boolean bAlive = true;

    public Animal(int rank){
        this.nRank = rank;
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
