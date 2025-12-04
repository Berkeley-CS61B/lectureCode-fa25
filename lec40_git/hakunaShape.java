import java.awt.Color;

// This acts as the "default" shape so the screen isn't empty.
public class hakunaShape implements PartyShape {

    public void draw(Turtle t) {
        t.setColor(Color.GREEN);
        // Draw a square using primitive turtle moves
        for (int i = 0; i < 8; i++) {
            t.forward(30);
            t.turnRight(25);
        }
    }
}
