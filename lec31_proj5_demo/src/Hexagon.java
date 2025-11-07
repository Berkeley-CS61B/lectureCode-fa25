import tileengine.TETile;

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

    // draws this hexagon into the world
    public void drawHexagon(TETile[][] world) {
        // draw line at topLeftX, topLeftY that is of length size
        // then draw line at topLeftX - 1, topLeftY - 1 that is of length size + 2
        // repeat
        // draw the top half
        for (int rowNum = 0; rowNum < size; rowNum += 1) {
            int xStart = topLeftX - rowNum;
            int yStart = topLeftY - rowNum;
            Lec31.drawHorizontalLine(world, xStart, yStart, rowNum*2 + size, biome);
        }

        // now start at topLeftX - size, and topLeftY - size - 1
        //     increase startX by 1 each row
        //     decrease startY by 1 each row

        for (int rowNum = 0; rowNum < size; rowNum += 1) {
            int xStart = topLeftX - size + rowNum + 1;
            int yStart = topLeftY - size - rowNum;
            int lineLength = size + (size - 1) * 2 - 2 * rowNum;
            Lec31.drawHorizontalLine(world, xStart, yStart, lineLength, biome);
        }
    }

    //public Hexagon(int topLeftX, int topLefY, int s, TETile t, List<Hexagon> neighbors);
}
