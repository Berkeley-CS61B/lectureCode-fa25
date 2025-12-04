import java.awt.Color;

public class SonnyCircle implements PartyShape {

    @Override
    public void draw(Turtle t) {
        // TODO: Change this color!
        t.setColor(Color.RED);

        // Draw a circle
        for (int i = 0; i < 300; i++) {
            t.forward(10);
            t.turnRight(20);
        }
    }
}