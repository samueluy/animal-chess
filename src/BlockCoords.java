public class BlockCoords {
    int x=1, y;
    String temp = "/";

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
