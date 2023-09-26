import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();
        int n = scanner.nextInt();

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            wordCountMap.put(s, wordCountMap.getOrDefault(s, 0) + 1);
        }

        List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCountMap.entrySet());

        wordCountList.sort((a, b) -> {
            int cmp = Integer.compare(b.getValue(), a.getValue());
            if (cmp != 0) {
                return cmp;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        for (int i = 0; i < k && i < wordCountList.size(); i++) {
            System.out.println(wordCountList.get(i).getKey());
        }
    }
}


// The Java code reads a list of words, counts their occurrences, and then prints the top k most frequent words. Here's a detailed description of what the code does:

// 1. It imports the necessary Java classes, including `java.util.*` for various data structures and utilities.

// 2. The `main` method is the entry point of the program.

// 3. It uses a `Scanner` object to read input from the standard input.

// 4. It reads two integers, `k` and `n`, where:
//    - `k` represents the number of most frequent words to be printed.
//    - `n` represents the total number of words in the input.

// 5. It initializes a `Map` named `wordCountMap` to store word frequencies. This map will associate each word with its count.

// 6. The program enters a loop that reads `n` words and updates their counts in `wordCountMap`:
//    - For each word read, it checks if the word is already a key in the map.
//    - If the word exists in the map, it increments its count by 1.
//    - If the word is not in the map, it adds it with a count of 1.

// 7. After reading and counting all the words, the program creates a `List` named `wordCountList` to store the entries of `wordCountMap`. Each entry is a pair (key-value) representing a word and its count.

// 8. The program then sorts `wordCountList` using a custom comparator:
//    - First, it sorts by decreasing count (most frequent words first).
//    - If two words have the same count, they are sorted lexicographically in ascending order.

// 9. Finally, the program prints the top `k` most frequent words:
//    - It iterates through `wordCountList` and prints the words.
//    - The loop stops when it has printed the top `k` words or when it reaches the end of the list.

// In summary, the Java code takes an input of words, counts their occurrences, and then prints the top `k` most frequent words based on their counts. This code is commonly used to find and display the most frequent words in a given list of words.