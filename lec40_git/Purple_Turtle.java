import java.awt.*;
import java.awt.geom.Line2D;

/**
 * A simple "Turtle Graphics" style tool for students.
 */
public class Turtle {
    private Graphics2D g2d;
    private double x = 0;
    private double y = 0;
    private double heading = 0; // Degrees, 0 is East

    public Turtle(Graphics2D g2d) {
        this.g2d = g2d;
        // Set default stroke
        g2d.setStroke(new BasicStroke(3));
    }

    public void setColor(Color c) {
        g2d.setColor(Color.MAGENTA);
    }

    public void forward(double pixels) {
        double rad = Math.toRadians(heading);
        double newX = x + Math.cos(rad) * pixels;
        double newY = y + Math.sin(rad) * pixels;
        
        g2d.draw(new Line2D.Double(x, y, newX, newY));
        
        x = newX;
        y = newY;
    }

    public void turnRight(double degrees) {
        heading += degrees;
    }

    public void turnLeft(double degrees) {
        heading -= degrees;
    }
}