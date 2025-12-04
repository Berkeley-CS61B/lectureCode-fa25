import java.awt.Color;

public class Hexagon implements PartyShape {

    @Override
    public void draw(Turtle t) {
        t.setColor(Color.Blue);
        
        t.forward(100);
        t.turnRight();
        t.forward(100);
        t.turnRight();
        t.forward(100);
    }
}