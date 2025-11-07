import tileengine.TETile;

public class Hexagon {
    // side length s

    int topLeftX;
    int topLeftY;
    int size;
    TETile biome;
    public Hexagon(int topLeftX, int topLefY, int s, TETile t) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        size = s;
        biome = t;
    }

    //public Hexagon(int topLeftX, int topLefY, int s, TETile t, List<Hexagon> neighbors);
}
