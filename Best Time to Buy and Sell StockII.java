/* say you have an array for which the ith element is the price of a given stock on day i. Design an algorithm to find the maximum profit.You may complete as many transactions as you like.However you must sell the stock before you buy afain.*/
public class Solution{
	public int maxProfit(int[] prices){
		int profit = 0;
		for (int i = 0; i < prices.length-1; i++) {
			int diff = prices[i+1] - prices[i];
			if (diff > 0) profit += diff;
		}
		return profit;
	}
}

