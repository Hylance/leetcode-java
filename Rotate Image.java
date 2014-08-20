// Rotate image: You are given an n x n 2D matrix representing an image.Rotate the image by 90 degrees (clockwise).(in place)
/*A simple solution is to create a new matrix  A' of the same size, and put each column A[*][j] of numbers into its corresponding row  A'[j][*] in the new matrix. However, this requires  O(n^2) space. If you look into the problem deeper (a small size matrix as an example may help), you may find that if we do this in-place,  A[i][j] ends up as A[j][n-i-1] . Furthermore, there is a loop in such replacement:

\begin{align*}A[i][j]&\rightarrow A[j][n-i-1]\\A[j][n-i-1]&\rightarrow A[n-i-1][n-j-1]\\A[n-i-1][n-j-1]&\rightarrow A[n-j-1][i]\\A[n-j-1][i]&\rightarrow A[i][j]\end{align*} where these four numbers are in individual quarter (top left, top right, bottom right, bottom left), respectively. Then all we need to do is to rotate all the quadruples in the matrix.*/
public class Solution {
	public void rotate(int[][] matrix) {
		if(matrix == null) return;
		int n = matrix.length;
		for(int i = 0; i < (n+1)/2; i++) {//include the numbers int the middle column
			for(int j = 0; j < n/2; j++) {//exclude the numbers int the middle row
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
}

			
