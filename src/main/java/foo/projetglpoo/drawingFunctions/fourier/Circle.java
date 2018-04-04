package foo.projetglpoo.drawingFunctions.fourier;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class Circle {

    int x, y, r, cx, cy;
    double a;

    public Circle(int x, int y, int r, double a) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.a = a;
        this.cx = x+r;
        this.cy = x+r;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.PINK);
        Ellipse2D.Double circle = new Ellipse2D.Double(this.x, this.y, this.r*2, this.r*2);
        Line2D.Double line = new Line2D.Double(this.x+this.r/2, this.y,Math.cos(this.a)*this.r+this.x,Math.sin(this.a)*this.r+this.y);
        g2d.draw(circle);
        g2d.draw(line);

    }
}
