import java.util.Scanner;

public class KMPAlgorithm {

    static final int N = 100000;
    static int[] lps = new int[N];

    public static void computeLPSArray(String pattern) {
        int i = 1, length = 0;
        lps[0] = 0;

        int n = pattern.length();

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void searchPattern(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        computeLPSArray(pattern);

        int i = 0, j = 0;
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Pattern found at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Text: ");
        String text = scanner.next();
        System.out.print("Enter Pattern: ");
        String pattern = scanner.next();
        scanner.close();

        searchPattern(text, pattern);
    }
}


// This code implements the Knuth-Morris-Pratt (KMP) string matching algorithm, which efficiently searches for occurrences of a pattern within a text.

// Here's a breakdown of the Java code and its functionality:

// The code defines a class named KMPAlgorithm to encapsulate the KMP algorithm.

// It uses an integer array lps to store the Longest Prefix Suffix (LPS) values.

// The computeLPSArray method calculates the LPS array for the given pattern. It is essentially a pre-processing step for the KMP algorithm.

// The searchPattern method performs the pattern matching. It iterates through the text and pattern while maintaining two pointers (i and j) to compare characters. When a pattern match is found, it prints the index where the pattern starts in the text.

// In the main method, the user is prompted to enter the text and pattern. The searchPattern method is then called to find and print the occurrences of the pattern in the text.

// The KMP algorithm is known for its efficiency in string searching, especially for cases where the pattern contains repeated substrings. It avoids unnecessary character comparisons, making it faster than some other string matching algorithms.




