package exercises;

import java.util.List;

/**
 * Each person wears a sticker indicating their initial position in the queue from  to .
 * Any person can swap with the near person directly in front of them, but they still wear their original sticker.
 * One person can swap at most two others.
 */
class MinimumSteps {

    /**
     * The method calculates the minimum number of swaps that took place to get to a given @param q order.
     * It prints the number of swaps, or, if anyone has swapped more than two people, print Too chaotic.
     *
     * @param q
     */
    public static void calculate(List<Integer> q) {
        int size = q.size();
        int index2 = 0;
        int index1 = 0;
        int count = 0;
        int tempCount = 1;
        if (Math.abs(q.get(size - 1) - size + 1) > 2) {
            tempCount = -1;
            index2 = size + 1;
        }
        while (tempCount > 0) {
            tempCount = 0;
            index2 = 0;
            while (index2 < size - 1) {
                if (index1 == 0 && Math.abs(q.get(index2) - index2 - 1) > 2) {
                    index2 = size;
                    tempCount = 0;
                } else if (q.get(index2) > q.get(index2 + 1)) {
                    int temp = q.get(index2);
                    q.set(index2, q.get(index2 + 1));
                    q.set(index2 + 1, temp);
                    tempCount++;
                }
                index2++;
            }
            count += tempCount;
            index1++;
        }
        System.out.println(count);
        if (index2 == size + 1) {
            System.out.println("Too chaotic");
        }
    }

    int getDifference(int value, int index) {
        return value - index - 1;
    }

}