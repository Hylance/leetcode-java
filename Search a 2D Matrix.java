/*Search a 2D Matrix:Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:Integers in each row are sorted from left to RIGHT.The first integer of each row is greater than the last integer of the previous row.*/
//Binary Search in sorted array
public class Solution{
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length;
		int left = 0;
		int right = m * n - 1;
		while(left <= right){
			int center = (left + right) / 2;
			int i = center / n;
			int j = center % n;
			if(matrix[i][j] == target) return true;
			if(matrix[i][j] < target){
				left = center + 1;
			}
			else {
				right = center - 1;
		}
		return false;
	}
}

		
