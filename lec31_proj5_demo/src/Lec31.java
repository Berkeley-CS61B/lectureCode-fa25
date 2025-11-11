import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import tileengine.TERenderer;
import tileengine.TETile;
import tileengine.Tileset;

import java.util.Random;

/**
 * Draws a hexagon world (or at least that's the goal).
 */
public class Lec31 {
    private static int WIDTH = 45;
    private static int HEIGHT = 45;
    private static int HEX_SIZE = 3;

    public static void main(String[] args) {

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }


        int xStart = 10;
        int yStart = 30;
        drawHexColumn(world, xStart, yStart, HEX_SIZE, 3);
        xStart += HEX_SIZE * 2 - 1;
        yStart += HEX_SIZE;
        drawHexColumn(world, xStart, yStart, HEX_SIZE, 4);
        xStart += HEX_SIZE * 2 - 1;
        yStart += HEX_SIZE;
        drawHexColumn(world, xStart, yStart, HEX_SIZE, 5);
        xStart += HEX_SIZE * 2 - 1;
        yStart -= HEX_SIZE;
        drawHexColumn(world, xStart, yStart, HEX_SIZE, 4);
        xStart += HEX_SIZE * 2 - 1;
        yStart -= HEX_SIZE;
        drawHexColumn(world, xStart, yStart, HEX_SIZE, 3);

        ter.renderFrame(world);

        int playerX = 25;
        int playerY = 25;
        TETile theStuffWhereIStanding = world[playerX][playerY];

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char c = StdDraw.nextKeyTyped();
                world[playerX][playerY] = theStuffWhereIStanding;
                if (c ==  'w') {
                    playerY += 1;
                }
                if (c == 'a') {
                    playerX -= 1;
                }
                if (c == 's') {
                    playerY -= 1;
                }
                if (c == 'd') {
                    playerX += 1;
                }

                theStuffWhereIStanding = world[playerX][playerY];
                world[playerX][playerY] = Tileset.AVATAR;
                ter.renderFrame(world);
            }
        }
    }

    // Draw a column of hexagons of hte appropriate size
    // starting from x, y as the top left of the first such hexagon
    public static void drawHexColumn(TETile[][] world, int x, int y, int size, int numHexagons) {

        for (int i = 0; i < numHexagons; i += 1) {

            int biomeNumber = StdRandom.uniformInt(5);
            TETile t = null;
            switch (biomeNumber) {
                case 0: t = Tileset.MOUNTAIN; break;
                case 1: t = Tileset.SAND; break;
                case 2: t = Tileset.GRASS; break;
                case 3: t = Tileset.FLOWER; break;
                case 4: t = Tileset.TREE; break;
                default: break;
            }

            Hexagon tempHex = new Hexagon(x, y - 2*size*i, size, t);
            tempHex.addHexagon(world);
        }
    }

    public static void drawHorizontalLine(TETile[][] world, int x, int y, int size, TETile t) {
        for (int xOffset = 0; xOffset < size; xOffset += 1) {
            world[x + xOffset][y] = TETile.colorVariant(t, 32, 32, 32, new Random());
        }
    }
}