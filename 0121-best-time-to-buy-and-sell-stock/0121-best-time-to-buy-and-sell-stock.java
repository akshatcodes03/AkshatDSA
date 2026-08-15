class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int x : prices) {
            if (buyPrice > x) {
                buyPrice = x;
            }

            profit = Math.max(profit, x - buyPrice);
        }

        return profit;        
    }
}