import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AhoCorasick {

    static final int MAXS = 500;
    static final int MAXC = 26;

    static int[] out = new int[MAXS];
    static int[] f = new int[MAXS];
    static int[][] g = new int[MAXS][MAXC];

    public static int buildMatchingMachine(String[] arr, int k) {
        Arrays.fill(out, 0);
        for (int[] row : g) {
            Arrays.fill(row, -1);
        }

        int states = 1;

        for (int i = 0; i < k; ++i) {
            String word = arr[i];
            int currentState = 0;

            for (int j = 0; j < word.length(); ++j) {
                int ch = word.charAt(j) - 'a';

                if (g[currentState][ch] == -1) {
                    g[currentState][ch] = states++;
                }

                currentState = g[currentState][ch];
            }

            out[currentState] |= (1 << i);
        }

        for (int ch = 0; ch < MAXC; ++ch) {
            if (g[0][ch] == -1) {
                g[0][ch] = 0;
            }
        }

        Arrays.fill(f, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int ch = 0; ch < MAXC; ++ch) {
            if (g[0][ch] != 0) {
                f[g[0][ch]] = 0;
                q.offer(g[0][ch]);
            }
        }

        while (!q.isEmpty()) {
            int state = q.poll();

            for (int ch = 0; ch < MAXC; ++ch) {
                if (g[state][ch] != -1) {
                    int failure = f[state];

                    while (g[failure][ch] == -1) {
                        failure = f[failure];
                    }

                    failure = g[failure][ch];
                    f[g[state][ch]] = failure;
                    out[g[state][ch]] |= out[failure];
                    q.offer(g[state][ch]);
                }
            }
        }

        return states;
    }

    public static int findNextState(int currentState, char nextInput) {
        int answer = currentState;
        int ch = nextInput - 'a';

        while (g[answer][ch] == -1) {
            answer = f[answer];
        }

        return g[answer][ch];
    }

    public static void searchWords(String[] arr, int k, String text) {
        buildMatchingMachine(arr, k);
        int currentState = 0;

        for (int i = 0; i < text.length(); ++i) {
            currentState = findNextState(currentState, text.charAt(i));

            if (out[currentState] == 0) {
                continue;
            }

            for (int j = 0; j < k; ++j) {
                if ((out[currentState] & (1 << j)) != 0) {
                    System.out.println("Word " + arr[j] + " appears from " +
                            (i - arr[j].length() + 1) + " to " + i);
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = {"he", "she", "hers", "his"};
        String text = "ahishers";
        int k = arr.length;

        searchWords(arr, k, text);
    }
}


// This code implements the Aho-Corasick algorithm for string matching. Here's a breakdown of the Java code and its functionality:

// The code defines a class named AhoCorasick to encapsulate the Aho-Corasick algorithm.

// It uses arrays to represent the transition function g[][], output function out[], and failure function f[].

// The buildMatchingMachine method constructs the matching machine. It initializes the transition, output, and failure functions, and then it processes the input keywords to build the machine's state transitions.

// The findNextState method determines the next state given the current state and the next character in the input text.

// The searchWords method searches for occurrences of the keywords in the input text. It iterates through the text while updating the current state based on transitions. When a match is found, it prints the word and its location in the text.

// In the main method, a sample set of keywords and input text are defined, and the searchWords method is called to find and print the occurrences of the keywords in the text.

// The Aho-Corasick algorithm efficiently matches multiple keywords in a text and is often used in string searching applications like text editors, compilers, and antivirus software.




