package exercises;

import java.util.List;

public class ArrayOperations {

    /*
     * Starting with a 1-indexed array of zeros and a list of operations,
     * for each operation a value is added to each the array element between two given indices, inclusive.
     * Once all operations have been performed, the maximum value in the array is returned.
     *
     * The function returns a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] result = new long[n];
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> querySub = queries.get(i);
            int end = querySub.get(1) - 1;
            int j = querySub.get(0) - 1;
            for (j = j; j <= end; j++) {
                result[j] += querySub.get(2);
            }
        }

        long max = result[0];
        for (int i = 1; i < result.length; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }
}
