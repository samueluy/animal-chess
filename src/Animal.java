import java.net.URL;

/**
 * This class represents the Animal pieces of the game.
 */
public abstract class Animal {
    private final boolean bBlue;
    private boolean diverMouse = false;
    private boolean trapped = false;
    private int nRank;
    private String symbol;
    private URL imageURL;

    /**
     * @param rank   Given rank of a piece
     * @param symbol Character to distinguish a piece
     * @param isBlue For which player owns the piece
     */
    public Animal(int rank, String symbol, boolean isBlue) {
        this.nRank = rank;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    public Animal(boolean isBlue) {
        this.bBlue = isBlue;
    }

    public URL getImageURL() {
        return this.imageURL;
    }

    /**
     * This method returns the rank of an animal
     *
     * @return
     */
    public int getRank() {
        return nRank;
    }

    /**
     * This method returns the string representation of the animal
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method returns which player owns the piece
     *
     * @return
     */
    public boolean isBlue() {
        return bBlue;
    }

    public boolean isDiverMouse() {
        return diverMouse;
    }

    public boolean isTrapped() {
        return trapped;
    }

    public void setDiverMouse(boolean diver) {
        this.diverMouse = diver;
    }

    /**
     * This method sets an image to an animal
     *
     * @param source Location of image file
     */
    public void setImage(String source) { // to use try catch
        try {
            this.imageURL = (getClass().getResource(source));
        } catch (Exception e) {
            System.out.println("Error! \"" + source + " \"not found");
        }
    }

    /**
     * This method sets the rank of an animal
     *
     * @param rank
     */
    public void setRank(int rank) {
        this.nRank = rank;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setTrapped(boolean trapped) {
        this.trapped = trapped;
    }
}