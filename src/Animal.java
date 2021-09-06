// to make abstract

import javax.swing.*;
import java.awt.*;

/**
 * This class represents each piece of the game.
 */
public class Animal
{
    private int nRank;
    private boolean bAlive = true;
    private boolean bBlue;
    private String symbol; // temp
    ImageIcon image;

    /**
     * @param rank   Given rank of a piece
     * @param symbol Character to distinguish a piece
     * @param isBlue For which player owns the piece
     */
    public Animal(int rank, String symbol, boolean isBlue)
    {
        this.nRank = rank;
        this.symbol = symbol;
        this.bBlue = isBlue;
    }

    public Animal(boolean isBlue){
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
     * This method returns the string representation of the animal
     *
     * @return
     */
    public String getSymbol() {
        return symbol;
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
     * This method returns if the animal is still alive
     *
     * @return
     */
    public boolean isAlive() {
        return bAlive;
    }

    /**
     * This method sets an image to an animal
     *
     * @param source Location of image file
     */
    public void setImage(String source){ // to use try catch
        try{
            this.image = new ImageIcon(new ImageIcon((getClass().getResource(source))).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        }
        catch(Exception e){
            System.out.println("Error! \"" + source + " \"not found");
        }
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    /**
     * This method returns which player owns the piece
     *
     * @return
     */
    public boolean isBlue() {
        return bBlue;
    }
}