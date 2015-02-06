// Maximal Rectangle
public class Solution {
	public int maximalRectangle(char[][] matrix) {
		int n = matrix.length;
		if(n == 0) return 0;
		int m = matrix[0].length;
		if(m == 0) return 0;
		int[][] height = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) 
					height[i][j] = (matrix[i][j] == '1') ? 1 : 0;
				else 
					height[i][j] = (matrix[i][j] == '1') ? height[i - 1][j] + 1 : 0;
			}
		}
		int answer = 0;
		for (int i = 0; i < n; j++) {
			Stack<Integer> stack = new Stack<Integer>();
			for ( int j = 0; j < m; j++) {
				while (!stack.isEmpty() && height[i][j] < height[i][stack.peek()]) {
					int pos = stack.peek;
					stack.pop();
					answer = Math.max(answer, height[i][pos] * (stack.isEmpty() ? j : j - stack.peek() - 1));
				}
				stack.push(j);
			}
			while(!stack.isEmpty()) {
				int pos = stack.peek();
				stack.pop();
				answer = Math.max(answer, height[i][pos] * (stack.isEmpty() ? m : m - stack.peek() - 1);
			}
		}
		return answer;
	}
}

