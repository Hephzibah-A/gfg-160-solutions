package Strings;

import java.util.Scanner;

public class ImplementAtoi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1; // Default to positive
        long result = 0; // Use long to handle overflow temporarily

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for a sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Process digits and construct the number
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            // Step 4: Check for overflow and return limits
            if (result * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        // Step 5: Return the result with the appropriate sign
        return (int) (result * sign);
    }
}
