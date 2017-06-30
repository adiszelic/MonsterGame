import java.util.ArrayList;
import java.util.List;


public class Position {
    private int xPosition;
    private int yPosition;
    private char objectType;

    public Position(int xPosition, int yPosition, char objectType) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.objectType = objectType;
    }

    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public void setPosition(int xPosition, int yPosition, String objectType) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public char getObjectType() {
        return objectType;
    }

}
