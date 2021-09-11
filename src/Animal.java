// to make abstract

import java.net.URL;

/**
 * This class represents each piece of the game.
 */
public class Animal {
    private int nRank;
    private final boolean bAlive = true;
    private final boolean bBlue;
    private boolean trapped = false;
    private boolean diverMouse = false;
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

    /**
     * This method returns the rank of an animal
     *
     * @return
     */
    public int getRank() {
        return nRank;
    }

    /**
     * This method sets the rank of an animal
     *
     * @param rank
     */
    public void setRank(int rank) {
        this.nRank = rank;
    }

    /**
     * This method returns the string representation of the animal
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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
     * This method returns which player owns the piece
     *
     * @return
     */
    public boolean isBlue() {
        return bBlue;
    }

    public boolean isTrapped() {
        return trapped;
    }

    public void setTrapped(boolean trapped) {
        this.trapped = trapped;
    }

    public URL getImageURL() {
        return this.imageURL;
    }

    public boolean isDiverMouse() {
        return diverMouse;
    }

    public void setDiverMouse(boolean diver) {
        this.diverMouse = diver;
    }
}