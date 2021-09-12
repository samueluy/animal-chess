import java.net.URL;

/**
 * This class represents the Animal pieces of the game.
 */
public abstract class Animal {
    private final boolean bBlue;
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

    /**
     *
     * @param isBlue For which player owns the piece
     */
    public Animal(boolean isBlue) {
        this.bBlue = isBlue;
    }

    /**
     * Retrieve the URL of the image used
     * @return URL of image
     */
    public URL getImageURL() {
        return this.imageURL;
    }

    /**
     * This method returns the rank of an animal
     *
     * @return rank of the animal
     */
    public int getRank() {
        return nRank;
    }

    /**
     * This method returns the string representation of the animal
     *
     * @return string representation of the animal
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method returns which player owns the piece
     *
     * @return the side of the piece
     */
    public boolean isBlue() {
        return bBlue;
    }

    /**
     *
     * @return if the piece is currently trapped
     */
    public boolean isTrapped() {
        return trapped;
    }

    /**
     * This method sets an image to an animal
     *
     * @param source location of image file
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
     * @param rank sets the rank of the animal
     */
    public void setRank(int rank) {
        this.nRank = rank;
    }

    /**
     *
     * @param symbol sets the string representation of the animal
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @param trapped sets if the current piece is trapped
     */
    public void setTrapped(boolean trapped) {
        this.trapped = trapped;
    }
}