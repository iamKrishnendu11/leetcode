class Solution {
    public int maxProfit(int[] prices) {
        // min price is buy price
        int buy = prices[0];
        int profit =0;
        for(int i=0; i<prices.length; i++){
            // if the current price is less update buy price
            if(prices[i]< buy){
                buy = prices[i];
            } else{
                // check if we can sell it for max profit
                int current=prices[i]- buy;
                profit = Math.max(profit,current);
            }
        }
        return profit;
    }
}