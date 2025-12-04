import java.awt.Color;

// This acts as the "default" shape so the screen isn't empty.
public class Diamond implements PartyShape {

    public void draw(Turtle t) {
        t.setColor(Color.GREEN);
        // Draw a square using primitive turtle moves
        for (int i = 0; i < 2; i++) {
            t.forward(60);
            t.turnRight(110);
            t.forward(60);
            t.turnRight(70);
        }
    }
}