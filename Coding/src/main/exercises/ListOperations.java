package main.exercises;

import main.utils.CollectionUtils;

import java.util.List;

public class ListOperations {
    /**
     * Given the words in the magazine and the words in the ransom note,
     * prints "Yes" if ransom note can be replicated exactly using whole words from the magazine; otherwise, is printed "No".
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        // If the words are provided in same order, use checkOrderedCase method.
        checkNotOrderedCase(magazine, note);
    }

    private static void checkNotOrderedCase(List<String> magazine, List<String> note) {
        int noteSize = note.size();
        var linkedMagazine = CollectionUtils.toLinkedList(magazine);

        for (int i = 0; i < noteSize; i++) {
            if (!linkedMagazine.remove(note.get(i))) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static void checkOrderedCase(List<String> magazine, List<String> note) {
        int noteSize = note.size();
        int magazineSize = magazine.size();

        int mIndex = 0;
        for (int i = 0; i < noteSize; i++) {
            while (!note.get(i).equals(magazine.get(mIndex))) {
                mIndex++;
                if (mIndex == magazineSize) {
                    System.out.println("No");
                    return;
                }
            }
            mIndex++;
            if (mIndex == magazineSize) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
