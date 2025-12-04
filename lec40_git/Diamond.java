import java.awt.Color;

public class Diamond implements PartyShape {
    public void draw(Turtle t) {
        t.setColor(Color.GREEN);
        // Draw a diamond using primitive turtle moves
        for (int i = 0; i < 2; i++) {
            t.forward(60);
            t.turnRight(110);
            t.forward(60);
            t.turnRight(70);
        }
    }
}