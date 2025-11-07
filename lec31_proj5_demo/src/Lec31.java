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
    public static final int WIDTH = 50;
    public static final int HEIGHT = 50;
    public static final int HEX_SIZE = 3;


    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        int columnStartX = 10;
        int columnStartY = 35;
        drawVerticalHexagons(columnStartX, columnStartY, HEX_SIZE, 3, world);
        columnStartX += HEX_SIZE * 2 - 1;
        columnStartY += HEX_SIZE;
        drawVerticalHexagons(columnStartX, columnStartY, HEX_SIZE, 4, world);
        columnStartX += HEX_SIZE * 2 - 1;
        columnStartY += HEX_SIZE;
        drawVerticalHexagons(columnStartX, columnStartY, HEX_SIZE, 5, world);
        columnStartX += HEX_SIZE * 2 - 1;
        columnStartY -= HEX_SIZE;
        drawVerticalHexagons(columnStartX, columnStartY, HEX_SIZE, 4, world);
        columnStartX += HEX_SIZE * 2 - 1;
        columnStartY -= HEX_SIZE;
        drawVerticalHexagons(columnStartX, columnStartY, HEX_SIZE, 3, world);


        int x = 30;
        int y = 30;
        TETile previousSpace = world[x][y];
        world[x][y] = Tileset.AVATAR;
        ter.renderFrame(world);

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char keyPressed = StdDraw.nextKeyTyped();
                world[x][y] = previousSpace;
                switch (keyPressed) {
                    case 'w': y = y + 1; break;
                    case 'a': x = x - 1; break;
                    case 'd': x = x + 1; break;
                    case 's': y = y - 1; break;
                    default: break;
                }
                previousSpace = world[x][y];
                world[x][y] = Tileset.AVATAR;
                ter.renderFrame(world);
            }
        }
    }


    public static void drawHorizontalLine(TETile[][] world, int x, int y, int size, TETile t) {
        for (int xOffset = 0; xOffset < size; xOffset += 1)
            world[x + xOffset][y] = TETile.colorVariant(t, 32, 32, 32, new Random());
    }

    public static void drawVerticalHexagons(int topLeftX, int topLeftY, int size, int N, TETile[][] world) {
        for (int i = 0; i < N; i += 1){
            int curX = topLeftX;
            int curY = topLeftY - i * 2 * size;
            Hexagon currentHexagon = new Hexagon(curX, curY, size, randomBiome());
            currentHexagon.drawHexagon(world);
        }
    }

    public static TETile randomBiome() {
        int i = StdRandom.uniformInt(5);
        switch (i) {
            case 0: return Tileset.MOUNTAIN;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.FLOWER;
            case 3: return Tileset.TREE;
            case 4: return Tileset.SAND;
            default: return null;
        }
    }



}