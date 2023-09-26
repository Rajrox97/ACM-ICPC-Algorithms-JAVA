import java.util.Scanner;

public class SubstringSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String s = scanner.nextLine();
        String s1 = scanner.nextLine();

        int flag = 0;

        for (int i = 0; i <= n - m; i++) {
            flag = 1;
            for (int j = 0; j < m; j++) {
                if (s.charAt(i + j) != s1.charAt(j)) {
                    flag = 0;
                    break;
                }
            }

            if (flag == 1) {
                System.out.println("yes");
                break;
            }
        }

        if (flag == 0) {
            System.out.println("no");
        }
    }
}


// The Java code provided is designed to search for a given substring within a longer string and print "yes" if the substring is found or "no" if it is not found. Here's a detailed description of what the code does:

// 1. It imports the `java.util.Scanner` class to read input from the user.

// 2. The `main` method is the entry point of the program.

// 3. The program uses a `Scanner` object to read input from the standard input (keyboard).

// 4. It reads two integers, `n` and `m`, representing the lengths of the main string (`s`) and the substring (`s1`), respectively.

// 5. It consumes the newline character from the previous input line using `scanner.nextLine()`. This ensures that the subsequent `nextLine()` calls do not skip input.

// 6. The program reads two strings, `s` and `s1`, representing the main string and the substring, respectively.

// 7. It initializes a flag variable, `flag`, to 0. This flag will be used to determine whether the substring is found.

// 8. The program then enters a nested loop structure to search for the substring within the main string:

//    - The outer loop (controlled by the variable `i`) iterates from `0` to `n - m`, where `i` represents the starting position of the substring within the main string.

//    - The inner loop (controlled by the variable `j`) iterates from `0` to `m - 1`, where `j` represents the position within the substring.

//    - Within the inner loop, the program compares characters at the corresponding positions in the main string (`s`) and the substring (`s1`). If any character does not match, the `flag` is set to 0, and the inner loop breaks.

//    - If the inner loop completes without setting `flag` to 0, it means that the substring has been found at the current starting position (`i`), and the `flag` remains 1.

//    - If the `flag` is still 1 after the inner loop, the program prints "yes" to indicate that the substring was found, and the outer loop breaks.

// 9. After the outer loop completes, the program checks the value of the `flag`. If the `flag` is 0, it means that the substring was not found in any of the possible starting positions, so it prints "no."

// 10. The program then terminates.

// In summary, the Java code reads a main string and a substring, and it uses a nested loop to search for the substring within the main string. If the substring is found at any position, it prints "yes"; otherwise, it prints "no."