package main.java.exercises;

public class BinaryGap {
    /**
     * This method returns the length of the longest '0' gap in the binary version of the decimal {@param N}.
     * The function returns 0 if N doesn't contain a binary gap.
     * For example, given N = 1041 the function should return 5,
     * because N has binary representation 10000010001 and so its longest binary gap is of length 5.
     * Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     * <p>
     * N is an integer within the range [1..2,147,483,647].
     *
     * @param N is decimal input to calculate binary gap
     * @return the length of the longest '0' gap in the binary version of the {@param N}
     */
    public int countBinaryGap(int N) {
        int[] binary = toBinary(N);
        return findBinaryGap(binary);
    }

    private int[] toBinary(int N) {
        int[] binary = new int[35];
        int id = 0;

        // Number should be positive
        while (N > 0) {
            binary[id++] = N % 2;
            N = N / 2;
        }

        return binary;
    }

    private int findBinaryGap(int[] binary) {
        int gap = 0;
        int length = binary.length;
        int i = 0;
        while (i < length - 1) {
            int j = i + 1;
            if (binary[i] == 1) {
                int tempGap = 0;
                while (j < length && binary[j] == 0) {
                    tempGap++;
                    j++;
                }
                if (j < length && binary[j] == 1 && tempGap > gap) {
                    gap = tempGap;
                }
            }
            i = j;
        }
        return gap;
    }
}
