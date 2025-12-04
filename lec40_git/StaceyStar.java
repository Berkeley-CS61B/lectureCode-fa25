import java.awt.Color;

public class StaceyStar implements PartyShape {
    public void draw(Turtle t) {
        // TODO: Change this color to your favorite!
        t.setColor(Color.MAGENTA);

        // Draw a 8-pointed star
        for (int i = 0; i < 8; i++) {
            t.forward(50);
            t.turnRight(135);
        }
    }
}