public class StringReversal {

    public static String reverse(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("reverse")); // Output "esrever"
        System.out.println(reverse("Three can keep a secret, if two of them are dead")); // Output "daed era meht fo owt fi ,terces a peek nac eerhT"
        System.out.println(reverse("ACM-ICPC-Algorithms")); // Output "smhtiroglA-CPCI-MCA"
    }
}

