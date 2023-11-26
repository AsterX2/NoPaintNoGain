public class Point {

    private int x;
    private int y;

    // Constructeur par défaut
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    // Constructeur avec paramètres
    public Point(int a, int b) {
        this.x = a;
        this.y = b;
    }



    // Getter pour x
    public int getX() {
        return x;
    }

    // Setter pour x
    public void setX(int x) {
        this.x = x;
    }

    // Getter pour y
    public int getY() {
        return y;
    }

    // Setter pour y
    public void setY(int y) {
        this.y = y;

    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

































}
