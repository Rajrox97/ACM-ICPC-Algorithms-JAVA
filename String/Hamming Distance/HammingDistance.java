/**
 *
 * @author ibnahmad
 */
public class HammingDistance {
    public static void main(String args[]) throws Exception{
        
        System.out.println(compareThem("1011101", "1001001")); // Output 2
        System.out.println(compareThem("Welcome", "welcome")); // Output 0
        System.out.println(compareThem("hacking", "cryptography")); // Output "String are not of equal length."
        
    }
        
    
    /**
     *
     * @param strOne
     * @param strTwo
     * @return
     * @throws Exception
     */
    public static int compareThem(String strOne, String strTwo) throws Exception {
        int distance = 0;
        
        if(strOne.length() != strTwo.length()) throw new Exception("String are not of the same length");
        
        if(strOne.equalsIgnoreCase(strTwo)) return distance;
                
        for(int i = 0; i < strOne.length(); i ++ ) {
            if(strOne.charAt(i) != strTwo.charAt(i)) distance++;
        }
        
        return distance;
    }
}

/*
The Hamming Distance problem is a computational problem that deals with measuring the difference between two strings of equal length. It's often used in various fields such as coding theory, information theory, and bioinformatics.

In the context of binary strings (sequences of 0s and 1s), the Hamming Distance between two strings of equal length is defined as the number of positions at which the corresponding symbols (bits) are different. In other words, it measures the number of bit positions at which the two strings differ.

For example, consider the following two binary strings:

String 1: 101010
String 2: 111110

The Hamming Distance between these two strings is 2, because there are two positions where the bits differ: the 2nd and 3rd positions.

The Hamming Distance problem can also be extended to strings of different lengths by considering only the common prefix or by adding padding to make the strings of equal length.

This concept has applications in various fields, including error detection and correction in data transmission, DNA sequence analysis in bioinformatics, and more. It's an important problem with practical implications in fields where measuring the difference between sequences is crucial.
*/