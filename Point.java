import java.io.Serializable;

public class Point implements Serializable{
    /*
     * Cette classe définit des points qui représenteront les coordonnées de
     * départ et d'arivée des différentes Figures.
     */

    // Si Point n'implémente pas Serializable, même si Figure le fait, nous ne
    // pourrons pas sérialiser de Figure, car elles contiennent un Point.
    protected int x;
    protected int y;

    public Point() {
        this.setX(0);
        this.setY(0);
    }

    public Point(int a, int b) {
        this.setX(a);
        this.setY(b);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
