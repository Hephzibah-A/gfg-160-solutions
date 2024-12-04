import java.util.*;
import java.io.*;

public class StringRotationsOfEachOther {
    
    public static void main(String[] args) throws IOException {

        // taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            // Creating an object of class Rotate
            Solution obj = new Solution();

            // calling areRotations method
            // of class Rotate and printing
            //"1" if it returns true
            // else "0"
            if (obj.areRotations(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
    }
}

class Solution {
    public static boolean areRotations(String s1, String s2) {
        // Check if lengths are equal; otherwise, they can't be rotations
        if (s1.length() != s2.length()) return false;

        // Concatenate the string to itself
        String combined = s1 + s1;

        // Use custom pattern matching to check if s2 is a substring
        return isPatternFound(combined, s2);
    }

    private static boolean isPatternFound(String text, String pattern) {
        int[] prefixTable = buildPrefixTable(pattern); // Precompute prefix table
        int textIndex = 0, patternIndex = 0;

        while (textIndex < text.length()) {
            if (text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;

                // If we reach the end of the pattern, it's a match
                if (patternIndex == pattern.length()) {
                    return true;
                }
            } else {
                if (patternIndex != 0) {
                    // Use the prefix table to skip redundant comparisons
                    patternIndex = prefixTable[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }
        return false;
    }

    private static int[] buildPrefixTable(String pattern) {
        int[] prefixTable = new int[pattern.length()];
        int length = 0, index = 1;

        while (index < pattern.length()) {
            if (pattern.charAt(index) == pattern.charAt(length)) {
                length++;
                prefixTable[index] = length;
                index++;
            } else {
                if (length != 0) {
                    // Fallback to the previous prefix
                    length = prefixTable[length - 1];
                } else {
                    prefixTable[index] = 0;
                    index++;
                }
            }
        }
        return prefixTable;
    }
}
