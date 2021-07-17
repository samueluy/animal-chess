import java.util.Scanner;

public class BlockCoords {
    int x, y;
    String temp;

    Scanner in = new Scanner(System.in);

    public int getX(){
        return  x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = in.nextInt();
    }

    public void setY(int y) {
        this.y = in.nextInt();
    }

    public void setTemp(){
        this.temp = temp;
    }


}
