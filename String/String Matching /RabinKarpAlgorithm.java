class RabinKarpAlgorithm {
    // d is the number of characters in the input alphabet
    static final int d = 256;

    // pat -> pattern
    // txt -> text
    // q -> A prime number
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and the first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over the text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of the current window of text and pattern.
            // If the hash values match, then only check for characters one by one.
            if (p == t) {
                // Check for characters one by one
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // If p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate the hash value for the next window of text: Remove
            // the leading digit and add the trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // We might get a negative value of t, converting it to positive
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    // Driver program to test the above function
    public static void main(String[] args) {
        String txt = "HELLO GITHUB HELLO";
        String pat = "HELLO";
        int q = 101; // A prime number
        search(pat, txt, q);
    }
}



// This Java code implements the Rabin-Karp algorithm for string searching. Here's an overview of what it does:

// The code defines a class named RabinKarpAlgorithm to encapsulate the Rabin-Karp algorithm.

// It uses a static method search to perform the pattern matching. The method takes the pattern (pat), text (txt), and a prime number q as parameters.

// The search method calculates hash values for both the pattern and the first window of the text. It then iterates through the text while maintaining two pointers (i and j) to compare characters.

// When a potential match is found (i.e., the hash values match), the code checks characters one by one to verify if there is a real match.

// If a match is confirmed, it prints the index where the pattern starts in the text.

// The main method provides sample text and pattern strings and calls the search method to find and print the occurrences of the pattern in the text.

// The Rabin-Karp algorithm is efficient for string searching, especially when there are multiple occurrences of the pattern in the text. It leverages hash values to quickly identify potential matches before performing character comparisons.




