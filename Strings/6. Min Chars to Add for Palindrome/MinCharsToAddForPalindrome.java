import java.util.*;
import java.io.*;

public class MinCharsToAddForPalindrome {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }
}


class Solution {
    public static int minChar(String s) {
        // Step 1: Reverse the string
        String reversed = new StringBuilder(s).reverse().toString();
        
        // Step 2: Construct the temporary string
        String temp = s + "#" + reversed;
        
        // Step 3: Compute the LPS array
        int[] lps = computeLPSArray(temp);
        
        // Step 4: Minimum characters to add = s.length() - lps[temp.length() - 1]
        return s.length() - lps[temp.length() - 1];
    }

    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
