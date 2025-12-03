import java.awt.Color;

public class Hexagon implements PartyShape {

    @Override
    public void draw(Turtle t) {
        // TODO: Change this color!
        t.setColor(Color.MAGENTA);

        // Draw a hexagon
        for (int i = 0; i < 6; i++) {
            t.forward(40);
            t.turnRight(60);
        }
    }
}