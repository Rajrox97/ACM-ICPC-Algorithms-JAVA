import java.util.Scanner;

public class StringConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (T-- > 0) {
            String s = scanner.nextLine();
            String t = scanner.nextLine();

            int flag = 0;
            int m = s.length();
            int n = t.length();

            if (n <= m || s.charAt(0) != t.charAt(0)) {
                System.out.println("NO");
            } else {
                int i = 1;
                int j = 1;

                while (i < m && j < n) {
                    if (s.charAt(i) == t.charAt(j)) {
                        i++;
                        j++;
                    } else if (s.charAt(i - 1) == t.charAt(j)) {
                        j++;
                    } else {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    while (j < n) {
                        if (s.charAt(m - 1) == t.charAt(j)) {
                            j++;
                        } else {
                            flag = 1;
                            break;
                        }
                    }
                }

                if (flag == 1) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}

Question: 
Arya has 2 strings, s and t. She has been given a task to uncompress the string s and verify if string t can be constructed. While uncompressing the string s, she can repeat each letter in s any non-zero number of times, i.e for s="aab", possible uncompressed forms can be "aabbb", "aaabb" etc.

Determine if she is able to perform the task.

Input:
The first line contains an integer T, the number of test cases. For each test case, the first line contains the string s and second line contains the string t.

Sample:

2
aaa
aa
aa
aaa
Constraints:
1<=T<= 50, 1<=|s|<=200, 1<=|t|<=1000,

Output:
For each test case, print "Yes" if Arya is able to perform the task, else print "No" in a new line.

Sample

NO
YES

// Explanation of what the Java code does:

// The Java code replicates the functionality of the original C++ code.

// It reads an integer T representing the number of test cases.

// For each test case, it reads two strings s and t.

// It then checks if it's possible to convert string s to string t according to the following rules:

// You can remove characters from the beginning or end of s.
// You can change a character in s if it matches the corresponding character in t.
// It uses two pointers i and j to traverse s and t, respectively, while following the conversion rules.

// If the conversion is successful (i.e., flag remains 0), it prints "YES." Otherwise, it prints "NO."

// This process is repeated for each test case.

// In summary, the Java code takes a series of test cases, each consisting of two strings s and t, and checks if it's possible to convert s to t following the specified rules. It prints "YES" if the conversion is possible and "NO" otherwise.