/* Triangle:Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below. For example, given the following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ] The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). Note: Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/
public class Solution {
	private int n;
	private int[][] sum;
	private ArrayList<ArrayList<Integer>> triangle();
	
	private int search(int x, int y) {
		if (x >= n) {
			return 0;
		}
		if (sum[x][y] != Integer.MAX_VALUE) {// memory search
			return sum[x][y];
		}
		sum[x][y] = Math.min(search(x + 1, y), search(x + 1, y + 1)) + triangle.get(x).get(y);
		return sum[x][y];
	}
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0){
			return 0;
		}
		this.n = triangle.size();
		this.triangle = triangle;
		this.sum = new int[n][n];
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++) {
				sum[i][j] = Integer.MAX_VALUE;
			}
		}
		return search(0,0);
	}
}
