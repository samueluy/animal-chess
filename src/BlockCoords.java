/**
 * This class represent each block in the game. It may also contain an Animal object or a Special object.
 */
public class BlockCoords {
    private Animal piece;
    private Special special;
    private int x, y;
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
        this.temp = special.symbol;
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
     * Returns the X coordinate of a block
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the Y coordinate of a block
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     * Returns the String representation of a block
     *
     * @return
     */
    public String getTemp() {
        return temp;
    }

    /**
     * Returns an Animal object inside the block
     *
     * @return
     */
    public Animal getPiece() {
        return piece;
    }

    /**
     * Returns a Special object inside the block
     *
     * @return
     */
    public Special getSpecial() {
        return special;
    }

    /**
     * Sets the X coordinate of a block
     *
     * @param coord X Coordinate of the block
     */
    public void setX(int coord) {
        this.x = coord;
    }

    /**
     * Sets the Y coordinate of a block
     *
     * @param coord Y Coordinate of the block
     */
    public void setY(int coord) {
        this.y = coord;
    }

    /**
     * Sets the String representation of a block
     *
     * @param character String representation of the block
     */
    public void setTemp(String character) {
        this.temp = character;
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