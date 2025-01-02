import java.awt.Color;

public class Square extends Rectangle{
    /*
     * Cas particulier du rectangle.
     */
    public Square() {}

    public Square(int px, int py, Color c ) {
        super(px,py,c);
        if (px<py) this.setBoundingBox(px,px);
        else this.setBoundingBox(py,py);
    }
}
