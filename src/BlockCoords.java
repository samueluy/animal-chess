public class BlockCoords {
    Animal piece;
    int x, y;
    String temp = "/";

    public BlockCoords(int x, int y, Animal piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.temp = piece.symbol;
    }

    public BlockCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTemp(){
        return temp;
    }

    public void setX(int coord) {
        this.x = coord;
    } // might be wrong

    public void setY(int coord) {
        this.y = coord;
    } // might be wrong

    public void setTemp(String character) {
        this.temp = character;
    }
}
