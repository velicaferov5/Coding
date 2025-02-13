package exercises;

class Farm {

    /**
     * Finds maximum number of apples can be collected from sequential trees of Alice and Bob that
     * don't intersect with each other
     *
     * @param A number of apples in sequential trees
     * @param K
     * @param L
     * @return maximum number of apples
     */
    public int maxApples(int[] A, int K, int L) {

        // Declaring arrays with size 2 to indicate Alice and Bob's start and end indexes
        if (K + L > A.length)
            return -1;

        K = Math.max(K, L);
        L = Math.min(K, L);

        int maxKapples = 0;
        int maxLapples = 0;
        int maxApples = 0;

        for (int index1 = 0; index1 <= A.length - K; index1++) {
            maxKapples = calculateApples(A, index1, index1 + K - 1);
            maxLapples = maxApplesOutOfIndexes(A, index1, index1 + K - 1, L);
            maxApples = Math.max(maxApples, maxKapples + maxLapples);
        }
        return maxApples;
    }

    private int maxApplesOutOfIndexes(int[] A, int startIndex, int endIndex, int sequence) {
        int maxApples = 0;

        if (sequence <= startIndex) {
            for (int index1 = 0; index1 <= startIndex - sequence; index1++) {
                int tempBefore = 0;

                for (int index2 = index1; index2 < index1 + sequence; index2++) {
                    tempBefore += A[index2];
                }

                if (tempBefore > maxApples)
                    maxApples = tempBefore;
            }
        }

        if (sequence < A.length - endIndex) {
            for (int index1 = endIndex + 1; index1 <= A.length - sequence; index1++) {
                int tempAfter = 0;
                for (int index2 = index1; index2 < index1 + sequence; index2++) {
                    tempAfter += A[index2];
                }

                if (tempAfter > maxApples)
                    maxApples = tempAfter;
            }
        }

        return maxApples;
    }

    int calculateApples(int[] A, int startIndex, int endIndex) {
        int apples = 0;
        for (int index1 = startIndex; index1 <= endIndex; index1++)
            apples += A[index1];

        return apples;
    }

}
