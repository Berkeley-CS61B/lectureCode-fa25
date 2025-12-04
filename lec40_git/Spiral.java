import java.awt.Color;
public class Spiral implements PartyShape {

    /**
     * Draw your shape using the provided Turtle.
     * The Turtle starts at (0,0) facing East.
     *
     * @param t
     */
    @Override
    public void draw(Turtle t) {
        t.setColor(Color.BLUE);
        double step = 0.2;

        for (int i = 0; i < 200; i++) {
            t.forward(step);
            t.turnRight(10);
            step += 0.2;
        }
    }
}
