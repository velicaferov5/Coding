package exercises;

/* Program calculates similarity between texts */

public class CalculateSimilarity {

    /**
     * Calculates similarity score of text strings
     *
     * @param text
     * @param prefixString
     * @param suffixString
     * @return largest common text
     */
    public static String calculateScore(String text, String prefixString, String suffixString) {

        int prefixIndex = suffixString.length();
        boolean limitReached = false;

        while (prefixIndex > 0 && !limitReached) {
            if (text.contains(prefixString.substring(prefixIndex - 1))) {
                prefixIndex--;
            } else {
                limitReached = true;
            }
        }

        int suffixIndex = 0;
        limitReached = false;

        while (suffixIndex < suffixString.length() && !limitReached) {
            if (text.contains(suffixString.substring(0, suffixIndex + 1))) {
                suffixIndex++;
            } else {
                limitReached = true;
            }
        }
        String prefixMatched = prefixString.substring(prefixIndex);
        String suffixMatched = suffixString.substring(0, suffixIndex);
        if (text.matches(prefixMatched + "+\\w+" + suffixMatched)) {
            return text.substring(text.indexOf(prefixMatched), text.lastIndexOf(suffixMatched) + suffixMatched.length());
        } else if (prefixMatched.compareTo(suffixMatched) < 0) {

            return prefixMatched;
        } else return suffixMatched;
    }
}