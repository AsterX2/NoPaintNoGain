import java.awt.Color;

public class Circle extends Ellipse{
    /*
     * Cas particulier du cercle.
     */
    public Circle() {}

    public Circle(int px, int py, Color c ) {
        super(px,py,c);
        if (px<py) this.setBoundingBox(px,px);
        else this.setBoundingBox(py,py);
    }
}
