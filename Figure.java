import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

public abstract class Figure implements Serializable{
    /*
     * Cette classe est la classe donnant toutes leurs caractéristiques principales
     * aux différentes Figures (Rectangle, Carré, Ellipse, Cercle).
     */
    protected Color color;
    protected Point point;

    protected int width;
    protected int height;


    public Figure() {
    }

    public Figure(Color c, Point p) {
        this.color = c;
        this.point = p;
    }

    public abstract void draw(Graphics g);

    public abstract void setBoundingBox(int widthBB, int heightBB);

    public abstract void setColor(Color c);
    public abstract Color getColor();
    public abstract void setPoint(Point p);
    public abstract Point getPoint();

    @Override
    public abstract String toString();
}
