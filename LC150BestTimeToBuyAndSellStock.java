class LC150BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1, maxP = 0;
        while(r< prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(profit, maxP);
            } else {
                l = r;
            }
            r+= 1;
        }
        return maxP;
    }
}
