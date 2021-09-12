import java.net.URL;

/**
 * This class represents each block which has a special trait.
 */
public abstract class Special {
    private boolean bBlue;
    private String symbol;
    private URL imageURL;

    /**
     * Initialize Special piece with size
     * @param isBlue Side of special piece
     */
    public Special(boolean isBlue) {
        this.bBlue = isBlue;
    }

    /**
     * Initialize Special piece
     */
    public Special() {
    }

    /**
     * Retrieve the URL of the image used
     * @return URL of image
     */
    public URL getImageURL() {
        return this.imageURL;
    }

    /**
     * Returns the string representation of the Special object
     *
     * @return String representation of the piece
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns which side the Special object belongs to
     *
     * @return For which player owns the piece
     */
    public boolean isBlue() {
        return bBlue;
    }

    /**
     * Sets the string representation of the Special object
     * @param symbol Character to be used
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Sets an image to the button
     * @param source image URL
     */
    public void setImage(String source) { // to use try catch
        try {
            this.imageURL = (getClass().getResource(source));
        } catch (Exception e) {
            System.out.println("Error! \"" + source + " \"not found");
        }
    }
}