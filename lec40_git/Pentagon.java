import java.awt.*;

public class Pentagon implements PartyShape {
    /**
     * Draw your shape using the provided Turtle.
     * The Turtle starts at (0,0) facing East.
     *
     * @param t
     */
    @Override
    public void draw(Turtle t) {
        t.setColor(Color.CYAN);
        // Draw a square using primitive turtle moves
        for (int i = 0; i < 5; i++) {
            t.forward(100);
            t.turnRight(108);
        }
    }
}
