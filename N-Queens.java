//N-Queens
public class Solution {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> result = new ArrayList<String[]>();
		if (n <= 0) {
			return result;
		}
		search(n, new ArrayList<Integer>(), result);
		return result;
	}
	private void search(int n, ArrayList<Integer> cols, ArrayList<String[]>result) {
		if (cols.size() == n) {
			result.add(drawChessboard(cols));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!isValid(cols, i)){
				continue;
			}
			cols.add(i);
			search(n, cols, result);
			cols.remove(cols.size() - 1);
		}
	}
	private boolean isValid (ArrayList<Integer> cols, int col) {
		int row = cols.size();
		for (int i = 0; i < row; i++) {
			if (cols.get(i) == col) { // same column
				return false;
			}
			if (i - cols.get(i) == row - col) { // left-top to right-bottom
				return false;  // x - y 保持不变
			}
			if (i + cols.get(i) == row + col) { // right-top to left-bottom
				return false; // x + y 保持不变
			}
		}
		return true;
	}
	private String[] drawChessboard(ArrayList<Integer> cols) {
		String[] chessboard = new String[cols.size()];
		for (int i = 0; i < cols.size(); i++) {
			chessboard[i] = "";
			for (int j = 0; j < cols.size(); j++) {
				if (j == cols.get(i)){
					chessboard[i] += "Q";
				}
				else {
					chessboard[i] += ".";
				}
			}
		}
		return chessboard;
	}
}
			
