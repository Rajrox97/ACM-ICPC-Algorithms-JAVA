import java.util.Arrays;

public class ZAlgorithm {
    static int[] z;

    public static void main(String[] args) {
        String s = "aaaaa";
        zFunction(s);
        for (int i = 1; i < s.length(); i++) {
            System.out.println(i + ": " + z[i]);
        }
    }

    public static void zFunction(String s) {
        int n = s.length();
        z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s.charAt(r - l) == s.charAt(r)) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s.charAt(r - l) == s.charAt(r)) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
    }
}


// Explanation of what the Java code does:

// The Java code replicates the functionality of the original C++ code.

// It defines a static integer array z to store the Z-values (lengths of the longest substring starting at each position, which is also a prefix substring).

// The zFunction method calculates the Z-values for a given string s.

// It initializes variables n, l, and r. n is the length of the string, while l and r define the interval [l, r] where s[l, r] is a prefix substring.

// The method iterates through the characters of the string using a for loop.

// If i > r, it means we need to start a new interval [l, r] and find the substring starting at index i that is a prefix substring. It does so by incrementing r while the characters match.

// If i <= r, it means we can try to expand the current interval by observing the value of z[k], where k = i - l. If z[k] is less than r - i + 1, it means we can't expand beyond z[k], so z[i] is set to z[k]. Otherwise, we can expand the interval, find the new substring, and update z[i] accordingly.

// Finally, the code prints the Z-values for each position in the string.

// In summary, the Java code calculates the Z-values for a given string, which represent the lengths of the longest substrings starting at each position, where each of those substrings is also a prefix substring.