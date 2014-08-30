//Unique Path
/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).How many possible unique paths are there?*/
//solution DP: Ways to destination point is equal to ways to up neighbor of destination point and left neighbor of destination point then we can generalize
//1D DP
public class Solution{
	public int uniquePaths(int m, int n) {
		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 || n == 0) {
			return 0;
		}
		int[] arr = new int[n];
		arr[0] = 1;
		for ( int i = 0; i < m; i++) {
			for(int j = 1; j < n; j++) {
				arr[j] = arr[j] + arr[j-1]i;//2维DP用1维实现，一行一行翻，新的元素等于本行前一个元素加上一行这一列的元素
			}
		}
		return arr[n-1];
	}
}
//2D DP
public class Solution {
	public int uniquePaths(int m, int n) {
		if(m <= 0 || n <=0) {
			return 0;
		}
		int[][] matrix = new int[m][n];
		for(int i = 0; i < m; i++){
			matrix[i][0] = 1;
		}
		for(int i = 0; i < n; i++){
			matrix[0][i] = 1;
		}
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
			}
		}
		return matrix[m-1][n-1];
	}
}
// mathematically
public class UniquePaths {
 
    // 344ms for 61 test cases
    public int uniquePaths(int m, int n) {
        // Formulation: find the number of combinations when picking m-1 (or n-1) items
        // from m+n-2 different items, which is (m+n-2)! / ((m-1)!(n-1)!)
        // = m(m+1)...(m+n-2) / (n-1)! (for ease of computation, if m is larger)
        int smaller, larger;
        if (m < n) {
            smaller = m-1;
            larger = n-1;
        } else {
            smaller = n-1;
            larger = m-1;
        }
        long denom = 1, numer = 1;      // Use "long" in case of overflow
        for (int i = 1; i <= smaller; i++) {
            denom *= i;
            numer *= larger+i;
        }
        return (int)(numer/denom);
    }
}
 
