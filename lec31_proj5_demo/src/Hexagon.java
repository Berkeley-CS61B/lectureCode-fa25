import tileengine.TETile;
import tileengine.Tileset;

public class Hexagon {
    // side length s

    int topLeftX;
    int topLeftY;
    int size;
    TETile biome;
    public Hexagon(int topLeftX, int topLeftY, int s, TETile t) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        size = s;
        biome = t;
    }

    // could be pure, could be not
    // by pure I mean it has not side effects, and returns a copy
    // we picked IMPURE
    public void addHexagon(TETile[][] world) {
        // top half
        for (int rowNum = 0; rowNum < size; rowNum += 1) {
            Lec31.drawHorizontalLine(world, topLeftX - rowNum, topLeftY - rowNum, size + 2 * rowNum, biome);
        }

        // bottom half
        // first call drawHorizontalLine(x - size, y - size, 2 * size)
        // second call drawHorizontalLine(x - size + 1, y - size + 1, 2 * size - 2)
        for (int rowNum = 0; rowNum < size; rowNum += 1) {
            int firstX = topLeftX - size + 1;
            int firstY = topLeftY - size;
            int firstLength = 3 * size - 2;
            Lec31.drawHorizontalLine(world, firstX + rowNum, firstY - rowNum, firstLength - 2 * rowNum, biome);
        }

        //        drawHorizontalLine(world, 10, 10, 13, Tileset.LOCKED_DOOR);
    }

    //public Hexagon(int topLeftX, int topLefY, int s, TETile t, List<Hexagon> neighbors);
}
