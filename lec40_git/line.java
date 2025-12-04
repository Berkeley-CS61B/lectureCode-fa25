import java.awt.Color;

public class Line implements PartyShape {

    @Override
    public void draw(Turtle t) {
        t.setColor(Color.GREEN);

        
        t.forward(90)
    }
}