import java.awt.Color;

public class Star implements PartyShape {
    public void draw(Turtle t) {
        // TODO: Change this color to your favorite!
        int red = 255;
        Color tcolor = new Color(red, 0, 127);
        t.setColor(Color.PINK);

        // Draw a 5-pointed star
        for (int i = 0; i < 5; i++) {
            t.forward(50);
            red = red - 10;
            Color tcolor = new Color(red, 0, 127);
            t.turnRight(144);
        }
    }
}