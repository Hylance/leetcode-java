/* Surround Regions: Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded region. For example, X X X X X O O X X X O X X O X X After running your function, the board should be: X X X X X X X X X X X X X O X X*/
public class Solution {
	public void solve(char[][] board) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int row = board.length;
		int col = board[0].length;
		if (board.length == 0 || board[0].length == 0) return;
		for (int i = 0; i < row; i++ ) {
			enqueue(i , 0);
			enqueue(i, col - 1);
		}
		for (int j = 1; j < col - 1; j++) {
			enqueue(0 , j);
			enqueue(row - 1, j);
		}
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int x = cur / col;
			int y = cur % col;
			if (board[x][y] == '0') {
				board[x][y] = 'D';
			}
			enqueue( x - 1, y);	
			enqueue( x + 1, y);
			enqueue( x, y - 1);
			enqueue( x, y + 1);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'D') {
					board[i][j] = '0';
				}
				else if (board[i][j] == '0') {
					board[i][j] = 'x';
				}
			}
		}
	}
	public void enqueue (int x, int y) {
		if ( x >= 0 && x < row && y >= 0 && y < col && board[x][y] == '0') {
			queue.offer(x * col + y);
		}
	}
}
