import java.awt.*;

public class ElaineCircle implements PartyShape {

    @Override
    public void draw(Turtle t) {
        // TODO: Change this color!
        t.setColor(Color.WHITE);

        // Draw a circle
        for (int i = 0; i < 36; i++) {
            t.forward(5);
            t.turnRight(10);
        }
    }
}