/* Set Matrix Zeros:Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.*/
//we can use the first row and the first column of the matrix as the indicators.

public class Solution{
	public void setZeroes(int[] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0 ) 
			return;
		int m = matrix.length
		int n = matrix[0].lenght;
	//Indicators for setting the first row/column to zeroes
		boolean setFirstRowZeroes = false;
		boolean setFirstColumnZeroes = false;
		for (int j = 0; j < n && !setFirstRowZeroes; j++)
			if(matrix[0][j] == 0)
				setFirstRowZeroes = true;
		for(int i = 0; i < m && !setFirstColumnZeroes; i++)
			if(matrix[i][0] == 0)
				setFirstColumnZeroes = true;
	//use the elements in the first row/column as indicators
		for (int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0)
					matrix[0][j] = matrix[i][0] = 0;
			}
		}
// See if the rows and columns except the first row and column
 // need to be set to zeroes
 // It is necessary to be done before considering the first row and column
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				if(matrix[i][0] == 0 || matrix[0][j] == )
					matrix[i][j] = 0;
			}
		}
		//see if the first row needs to be set to zeroes
		if (setFirstRowZeroes){
			for(int j = 0; j < n; j++)
				matrix[0][j] = 0;
		}
		//see if the first column needs to be set to zeroes
		if (setFirstColumnZeroes) {
			for(int i = 0; i < m; i++) {
				matrix[i][0] = 0;
		}
	}
}

