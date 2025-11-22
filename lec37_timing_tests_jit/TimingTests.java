import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import org.apache.commons.lang3.ArrayUtils;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by hug.
 */
public class TimingTests {
    public static NumberFormat format = NumberFormat.getInstance(Locale.US);

    private enum SortToUse {
        LSD_SORT, MSD_SORT, MERGE_SORT
    }

    private enum StringConditions {
        SAME_REFERENCE, EQUAL, ALMOST_EQUAL, RANDOM
    }


    private static String charSet;
    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i += 1) {
            sb.append((char) i);
        }
        charSet = sb.toString();
    }


        /* Generates N strings of length W, with each character between 0 and 255. */
    private static String[] randomStrings(int N, int W) {
        List<String> l = new ArrayList<>();
        StringBuilder sb;
        for (int i = 0; i < N; i += 1) {
            sb = new StringBuilder();
            for (int j = 0; j < W; j += 1) {
                sb.append((char) StdRandom.uniform(0, 256));
            }
            l.add(sb.toString());
        }

        String[] retArray = new String[l.size()];
        retArray = l.toArray(retArray);
        return retArray;
    }


    /* Generates N strings of length W, with each character between 0 and 255. */
    private static String[] equalStrings(int N, int W) {
        String[] strings = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < W; j += 1) {
            sb.append("A");
        }

        for (int i = 0; i < N; i += 1) {
            strings[i] = new String(sb.toString());
        }
        ArrayUtils.shuffle(strings);

        return strings;
    }

    private static String[] sameStrings(int N, int W) {
        String[] strings = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < W; j += 1) {
            sb.append("A");
        }

        String s = sb.toString();

        for (int i = 0; i < N; i += 1) {
            strings[i] = s;
        }

        return strings;
    }

    private static String[] almostEqualStrings(int N, int W) {
        String[] strings = new String[N];
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < W; j += 1) {
            sb.append("A");
        }

        for (int i = 0; i < N; i += 1) {
            strings[i] = new String(sb.toString()) + i;
        }

        return strings;
    }

    private static String[] getDesiredStrings(StringConditions sc, int N, int W) {
        String[] strings;
        if (sc == StringConditions.SAME_REFERENCE) {
            strings = sameStrings(N, W);
        } else if (sc == StringConditions.EQUAL) {
            strings = equalStrings(N, W);
        } else if (sc == StringConditions.ALMOST_EQUAL) {
            strings = almostEqualStrings(N, W);
        } else { // EQUAL
            strings = randomStrings(N, W);
        }
        return strings;
    }

    private static void runTest(SortToUse sort, StringConditions sc, int N, int W) {
        String[] strings = getDesiredStrings(sc, N, W);
        long opCount;

        Stopwatch sw = new Stopwatch();

        if (sort == SortToUse.MSD_SORT) {
            MSD.sort(strings);
            opCount = MSD.charConsiderations;
        } else if (sort == SortToUse.MERGE_SORT) { //MERGE
            MergeX.sort(strings);
            opCount = MergeX.compareToCalls * 2 * W;
        } else { // if (sort == SortToUse.LSD_SORT) {
            LSD.sort(strings, W);
            opCount = LSD.charConsiderations;
        }

        double elapsedTime = sw.elapsedTime();
        System.out.printf("%16s%16s%16.2f%16s\n", format.format(N), format.format(W), elapsedTime, format.format(opCount));
    }

    public static void main(String[] args) {
        SortToUse stu = SortToUse.MSD_SORT;
        StringConditions sc = StringConditions.EQUAL;
        /*int W = 100;
        int minN = 10_000;
        int maxN = 10_000_000;*/

        int W = 100;
        int minN = 1000;
        int maxN = 1_000_000;

        System.out.printf("%16s%16s%16s%16s\n", "N", "W", "Time", "# Chars");
        for (int N = minN; N <= maxN; N *= 10) {
            runTest(stu, sc, N, W);
        }
    }
}
