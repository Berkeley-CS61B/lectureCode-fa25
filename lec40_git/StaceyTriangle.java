import java.awt.Color;

public class StaceyTriangle implements PartyShape {
public void draw(Turtle t) {
    
    Color purpColor = new Color(200, 200, 255);

    t.setColor(purpColor);

    for (int i = 0; i < 2; i++) {
        t.forward(20);
        t.turnRight(60);
        t.forward(10);
        t.turnRight(120);
    }
}

}