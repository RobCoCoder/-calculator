package src.utilities;

public class CoordinatePair {
    private int coordinateX;
    private int coordinateY;

    public CoordinatePair(int x, int y){
        setCoordinateX(x);
        setCoordinateY(y);
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }
}
