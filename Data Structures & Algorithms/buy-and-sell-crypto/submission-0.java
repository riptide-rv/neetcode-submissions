class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;

        int currMin = prices[0];

        for(int i = 0; i < prices.length; i++ ) {
            if (prices[i] < currMin) currMin = prices[i];
            result = Math.max(prices[i] - currMin, result);
        }

        return result;
    }
}
