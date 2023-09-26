

public class KMPAlgorithm {

    public static int[] computeFailureFunction(String pattern) {
        int[] failure = new int[pattern.length()];
        failure[0] = 0;
        
        int j = 0;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                failure[i] = j;
            } else if (j > 0) {
                j = failure[j - 1];
                i--; // Retry the comparison with the same character in pattern
            } else {
                failure[i] = 0;
            }
        }
        
        return failure;
    }

    public static void searchPattern(String text, String pattern) {
        int[] failure = computeFailureFunction(pattern);
        
        int i = 0; // Index for text
        int j = 0; // Index for pattern
        
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    System.out.println("Pattern found at index: " + (i - j));
                    j = failure[j];
                } else {
                    i++;
                    j++;
                }
            } else if (j > 0) {
                j = failure[j - 1];
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        
        searchPattern(text, pattern);
    }
}

/*

The Knuth-Morris-Pratt (KMP) algorithm is a string searching algorithm that efficiently finds occurrences of a substring (pattern) within a longer string (text). It's particularly useful when searching for occurrences of a specific pattern within a large text, as it offers better performance than some other naive string search methods.

The key idea behind the KMP algorithm is to utilize the information gained from previous comparisons to avoid unnecessary backtracking. It achieves this by constructing a "failure function" or "partial match table" that indicates how much to shift the pattern when a mismatch occurs, instead of going back to the beginning of the pattern for each mismatch.

Here's a high-level overview of how the KMP algorithm works: 

1. Preprocess the pattern to construct the failure function (partial match table). This table helps to decide how much to shift the pattern when a mismatch occurs.

2. Start comparing the pattern against the text from left to right.

3. If a mismatch occurs at position j in the pattern, use the value from the failure function to determine the new position to compare against in the pattern.

4. Repeat the process until either a match is found or the end of the text is reached.

Using the KMP algorithm, you can efficiently search for occurrences of a pattern within a text without having to backtrack the pattern unnecessarily.
*/

