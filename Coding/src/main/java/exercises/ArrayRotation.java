package main.java.exercises;

public class ArrayRotation {

    /**
     * Takes as input {@param A} array consisting of N integers.
     * Rotation of the array means that each element is shifted right by one index, and the last element of the array
     * is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6]
     * is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
     * The method rotates array {@param A} {@param K} times; that is, each element of A will be shifted to the right K times.
     *
     * @param A input array
     * @param K rotate times
     * @return rotated array
     */
    public int[] rotateArray(int[] A, int K) {
        int length = A.length;
        if (length == 0 || K == 0) {
            return A;
        }
        int rotationCount = length % K;
        if (rotationCount == 0) {
            return A;
        }

        int[] res = new int[length];
        int aIndex = rotationCount;
        int resIndex = 0;
        while (aIndex < length) {
            res[resIndex++] = A[aIndex++];
        }
        if (aIndex == length) {
            aIndex = 0;
            while (aIndex < rotationCount) {
                res[resIndex++] = A[aIndex++];
            }
        }
        return res;
    }
}
