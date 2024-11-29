import java.util.*;
import java.io.*;

public class AddBinaryStrings {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }   
}

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();

        int i = s1.length() - 1; // Pointer for s1
        int j = s2.length() - 1; // Pointer for s2
        int carry = 0;

        // Traverse both strings from the end
        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0; // Get the bit from s1 or 0
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0; // Get the bit from s2 or 0

            int sum = bit1 + bit2 + carry; // Calculate sum of bits and carry
            result.append(sum % 2); // Append the resultant bit
            carry = sum / 2; // Update the carry

            i--;
            j--;
        }

        // Remove leading zeros if present
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        // Reverse to get the correct order and return as a string
        return result.reverse().toString();
    }
}
