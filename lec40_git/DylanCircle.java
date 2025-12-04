//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;

public class DylanCircle implements PartyShape {
    public void draw(Turtle t) {
        t.setColor(Color.ORANGE);

        for(int i = 0; i < 36; ++i) {
            t.forward((double)20.0F);
            t.turnRight((double)15.0F);
        }

    }
}