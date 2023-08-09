public class ManachersAlgorithm {

    public static String longestPalindromicSubstring(String s) {
        StringBuilder transformed = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            transformed.append(c).append('#');
        }

        int n = transformed.length();
        int[] palindromeLengths = new int[n];
        int center = 0, right = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;

            if (i < right) {
                palindromeLengths[i] = Math.min(right - i, palindromeLengths[mirror]);
            }

            // Expand around the current character
            int leftIndex = i - (palindromeLengths[i] + 1);
            int rightIndex = i + (palindromeLengths[i] + 1);

            while (leftIndex >= 0 && rightIndex < n && transformed.charAt(leftIndex) == transformed.charAt(rightIndex)) {
                palindromeLengths[i]++;
                leftIndex--;
                rightIndex++;
            }

            // Update the rightmost palindrome
            if (i + palindromeLengths[i] > right) {
                center = i;
                right = i + palindromeLengths[i];
            }
        }

        // Find the maximum palindrome length
        int maxLen = 0, maxCenter = 0;
        for (int i = 0; i < n; i++) {
            if (palindromeLengths[i] > maxLen) {
                maxLen = palindromeLengths[i];
                maxCenter = i;
            }
        }

        // Retrieve the longest palindromic substring
        int start = (maxCenter - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindrome = longestPalindromicSubstring(input);
        System.out.println("Longest palindromic substring: " + longestPalindrome);
    }
}

/*
Manacher's algorithm is a linear-time algorithm used to find the longest palindromic substring in a given string. Unlike other algorithms that solve this problem in quadratic time, Manacher's algorithm achieves linear time complexity by using the properties of already computed palindromes to avoid redundant work.

Here's a high-level overview of how Manacher's algorithm works:

Transform the input string to include special characters (#) between each character and at the beginning and end. This ensures that each palindrome, whether odd or even in length, becomes odd-length, simplifying the algorithm.

Create an array to keep track of the length of the palindrome centered at each position. Initialize all values to 0.

Iterate through the transformed string. For each position i, determine the length of the palindrome centered at i using previously computed palindrome lengths.

Keep track of the rightmost palindrome encountered so far and its center. Update the palindrome lengths as needed.

The maximum value in the palindrome length array gives the length of the longest palindromic substring.

Retrieve the longest palindromic substring using its length and center.
*/