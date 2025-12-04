import java.awt.*;

public class AnselTriangle implements PartyShape {
    public void draw(Turtle t) {
        // TODO: Change this color to your favorite!
        t.setColor(Color.BLUE);

        // Draw a triangle
        for (int i = 0; i < 3; i++) {
            t.forward(60);
            t.turnRight(120);
        }
    }
}