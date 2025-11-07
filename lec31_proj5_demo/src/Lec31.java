import tileengine.TERenderer;
import tileengine.TETile;
import tileengine.Tileset;

/**
 * Draws a hexagon world (or at least that's the goal).
 */
public class Lec31 {
    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(40, 40);

        TETile[][] world = new TETile[40][40];
        for (int x = 0; x < 40; x += 1) {
            for (int y = 0; y < 40; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        Hexagon demoHexagon = new Hexagon(10, 10, 4, Tileset.TREE);


        drawHorizontalLine(world, 10, 10, 13, Tileset.LOCKED_DOOR);
        ter.renderFrame(world);
    }

    public static void drawHorizontalLine(TETile[][] world, int x, int y, int size, TETile t) {
        for (int xOffset = 0; xOffset < size; xOffset += 1) {
            world[x + xOffset][y] = t;
        }
    }

}