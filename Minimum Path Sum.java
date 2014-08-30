/*Minimun Path Sum:Given a m x n grid filled with non-negative numbers, find a path from top left to bottom RIGHT which minimizes the sum of all numbers along its path.Note: You can only move either down or right at any point in time.*/
public class Solution{
	public int minPathSum(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[] dp = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i == 0 && j == 0) // the first element
					dp[j] = grid[i][j];
				else if (i == 0) //cell in the first row
					dp[j] = dp[j - 1] + grid[i][j];
				else if (j == 0) //cell in the first column
					dp[j] = dp[j] + grid[i][j];
				else 
					dp[j] = Math.min(dp[j - 1],dp[j]) + grid[i][j];
			}
		}
		return dp[n - 1];
	}
}


