import java.awt.Color;

public class Line implements PartyShape {
    public void draw(Turtle t) {

        t.setColor(Color.YELLOW);

        // draw a line
        t.forward(50);
    }
}