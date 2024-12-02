import java.util.*;
import java.io.*;

public class KMPAlgorithm {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}



class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        // Step 1: Compute the LPS (Longest Prefix Suffix) array for the pattern
        int[] lps = computeLPSArray(pat, m);

        // Step 2: Search the pattern in the text
        int i = 0; // Pointer for txt
        int j = 0; // Pointer for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                // Match found, store starting index
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] computeLPSArray(String pat, int m) {
        int[] lps = new int[m];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS of the first character is always 0

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
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
