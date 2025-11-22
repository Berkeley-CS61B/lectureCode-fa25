import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hug.
 */
public class TimingTestsIntegers {
    private static final Random r = new Random();

    private enum SortToUse {
        LSD_SORT, QUICK_SORT
    }

    public static int[] randomPositiveIntegers(int N) {
        int[] ints = new int[N];
        for (int i = 0; i < N; i += 1) {
            ints[i] = r.nextInt() & 0x7FFFFFF;
        }
        return ints;
    }

    private static void runTest(SortToUse sort, int N, int base) {
        int[] ints = randomPositiveIntegers(N);

        Stopwatch sw = new Stopwatch();
        if (sort == SortToUse.LSD_SORT) {
            LSD.sort(ints, base);
        } else { // if (sort == SortToUse.QUICK) {
            Arrays.sort(ints);
        }

        double elapsedTime = sw.elapsedTime();
        System.out.printf("%12d%12.2f\n", N, elapsedTime);
    }

    public static void main(String[] args) {
        SortToUse stu = SortToUse.LSD_SORT;

        int base = 2147483647;
        int minN = 100000000;
        int maxN = 100000000;

        for (int N = minN; N <= maxN; N *= 10) {
            runTest(stu, N, base);
        }
    }
}
