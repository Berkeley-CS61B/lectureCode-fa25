import java.awt.Color;
import java.util.Random;

public class CS10Shape implements PartyShape {

    private int currentSegment = 0;
    private int totalSegments = 0;
    private int colorVelocity = 0;
    private Random r = new Random();

    @Override
    public void draw(Turtle t) {
        double length = 200;
        int depth = 3;
        colorVelocity = -5;


        totalSegments = 3 * (int)Math.pow(4, depth) - colorVelocity;

        for (int i = 0; i < 3; i++) {
            drawHelper(t, length, depth);
            t.turnRight(120);
        }
    }

    private void drawHelper(Turtle t, double length, int depth) {
        if (depth == 0) {
            float hue = 0.75f - (0.6f * (currentSegment  % totalSegments) / totalSegments);

            // High saturation (0.9) and brightness (1.0) for visibility
            t.setColor(Color.getHSBColor(hue, 0.9f, 1.0f));

            t.forward(length);
            currentSegment++;

        } else {
            double segmentLength = length / 3.0;
            
            drawHelper(t, segmentLength, depth - 1);
            t.turnLeft(60);
            drawHelper(t, segmentLength, depth - 1);
            t.turnRight(120);
            drawHelper(t, segmentLength, depth - 1);
            t.turnLeft(60);
            drawHelper(t, segmentLength, depth - 1);
        }
    }
}