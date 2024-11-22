import java.util.*;
import java.io.*;


public class StockBuySellMaxOneTransaction {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int prices[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                prices[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int res = obj.maximumProfit(prices);
            System.out.println(res);
        }
    }
}

class Solution {
    public int maximumProfit(int prices[]) {
        int n = prices.length;
        if (n == 0) return 0; // Edge case: Empty prices array

        int minPrice = Integer.MAX_VALUE; // Initialize the minimum price
        int maxProfit = 0; // Initialize the maximum profit

        // Traverse through the prices array
        for (int i = 0; i < n; i++) {
            // Update the minimum price seen so far
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate profit by selling at current price and update maxProfit
            else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}
