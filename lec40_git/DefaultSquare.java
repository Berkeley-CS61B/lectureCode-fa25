import java.awt.Color;

// This acts as the "default" shape so the screen isn't empty.
public class DefaultSquare implements PartyShape {
    public void draw(Turtle t) {
        t.setColor(Color.CYAN);
        // Draw a square using primitive turtle moves
        for (int i = 0; i < 4; i++) {
            t.forward(50);
            t.turnRight(90);
        }
    }
}