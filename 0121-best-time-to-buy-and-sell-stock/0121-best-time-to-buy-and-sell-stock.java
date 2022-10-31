class Solution {
    public int maxProfit(int[] prices) {
        //Doesn't work for all cases eg [2,4,1]. OP should be 2 but using this method you will get 0
     /*   int min_price = Integer.MAX_VALUE;
        int max_price = Integer.MIN_VALUE;
        int pos = 0;
        
        for(int i = 0; i<prices.length; i++)
            if(min_price > prices[i]){
                min_price = Math.min(min_price, prices[i]);
                pos = i;
            }
        
        if(pos == prices.length-1)
            return 0;
        
        for(int i = pos + 1; i<prices.length; i++)
            max_price = Math.max(max_price, prices[i]);
        
        return max_price - min_price;
    */
        
        int min_price = Integer.MAX_VALUE;
        int profit_today = 0;
        int max_profit = 0;
        
        for(int i = 0; i<prices.length; i++){
            if(min_price > prices[i])
                min_price = prices[i];
            
            profit_today = prices[i] - min_price;
            
            if(max_profit < profit_today)
                max_profit = profit_today;
            
        }
        
        return max_profit;
    }
}