import java.awt.Color;

public class Star implements PartyShape {
    public void draw(Turtle t) {
        // TODO: Change this color to your favorite!
        t.setColor(Color.YELLOW);

        // Draw a 5-pointed star
        for (int i = 0; i < 5; i++) {
            t.forward(50);
            t.turnRight(144);
        }
    }
}