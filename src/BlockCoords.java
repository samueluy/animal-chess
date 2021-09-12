/**
 * This class represent each block in the game. It may also contain an Animal object or a Special object.
 */
public class BlockCoords {
    private Animal piece;
    private Special special;
    private final int x;
    private final int y;
    private String temp;

    /**
     * This constructor initializes a block which contains an Animal object
     *
     * @param x     X coordinate of the block
     * @param y     Y coordinate of the block
     * @param piece Animal class
     */
    public BlockCoords(int x, int y, Animal piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.temp = piece.getSymbol();
    }

    /**
     * This constructor initializes a block which contains a Special object
     *
     * @param x       X coordinate of the block
     * @param y       Y coordinate of the block
     * @param special Special class
     */
    public BlockCoords(int x, int y, Special special) {
        this.x = x;
        this.y = y;
        this.special = special;
        this.temp = special.getSymbol();
    }

    /**
     * This constructor initializes an empty block
     *
     * @param x X coordinate of the block
     * @param y Y coordinate of the block
     */
    public BlockCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns an Animal object inside the block
     *
     * @return Animal object inside the block
     */
    public Animal getPiece() {
        return piece;
    }

    /**
     * Returns a Special object inside the block
     *
     * @return Special object inside the block
     */
    public Special getSpecial() {
        return special;
    }

    /**
     * Returns the String representation of a block
     *
     * @return String representation of a block
     */
    public String getTemp() {
        return temp;
    }

    /**
     * Sets an Animal object inside the block
     *
     * @param animal Animal object
     */
    public void setPiece(Animal animal) {
        this.piece = animal;
    }
}
