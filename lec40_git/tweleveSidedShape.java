import java.awt.Color;

public class twelveSidedShape implements PartyShape {

    @Override
    public void draw(Turtle t) {
        // TODO: Change this color!
        t.setColor(Color.MAGENTA);

        // Draw a hexagon
        for (int i = 0; i < 12; i++) {
            t.forward(40);
            t.turnRight(150);
        }
    }
}