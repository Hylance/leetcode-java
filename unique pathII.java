/*Unique Paths II :Follow up for "Unique Paths":Now consider if some obstacles are added to the grids. How many unique paths would there be?An obstacle and empty space is marked as 1 and 0 respectively in the grid.*/
//1D DP
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[] dp = new int[n+1];
		dp[1] = 1;
		for (int i = 0; i < m ; i++) {
			for(int j = 0; j < n; j++) {
				if(obstacleGrid[i][j] == 1)
					dp[j+1] = 0;//cannot reach a cell containing obstacle
				else
					dp[j+1] = dp[j] + dp[j+1];
			}
		}
	}
}
//2D Dp
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] paths = new int[n][m];
		for (int i = 0; i < n; i++) {
			if(obstacleGrid[i][0] != 1) {
				path[i][0] = 1;
			}
			else {
				break;
			}
		}
		for (int i = 0; i < m; i++) {
			if(obstacleGrid[0][i] != 1 {
				path[0][i] = 1;
			}
			else{
				break;
			}
		}
		for(int i = 1; i < n; i++) {
			for(int j = 1; j< m; j++) {
				if(obstacleGrid[i][j] != 1) {
					paths[i][j] = paths[i-1][j] + paths[i][j-1];
				}
				else {
					paths[i][j] = 0;
				}
			}
		}
		return paths[n-1][m-1];
	}
}
