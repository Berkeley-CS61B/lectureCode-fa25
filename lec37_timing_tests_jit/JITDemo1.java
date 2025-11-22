import java.util.LinkedList;

/**
 * Created by hug.
 * Code adapted from Douglas Hawkins, a JIT Developer
 * as seen in this youtube video: https://www.youtube.com/watch?v=oH4_unx8eJQ
 */
public class JITDemo1 {
    static final int NUM_LISTS = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < 500; i += 1) {
            long startTime = System.nanoTime();

            for (int j = 0; j < NUM_LISTS; j += 1) {
                LinkedList<Integer> L = new LinkedList<>();
            }

            long endTime = System.nanoTime();
            System.out.printf("%d\t%d%n", i, endTime - startTime);
        }
    }
}
