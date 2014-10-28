/* Word Search:Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once. For example, Given board = [ ["ABCE"], ["SFCS"], ["ADEE"] ] word = "ABCCED", -> returns true, word = "SEE", -> returns true, word = "ABCB", -> returns false.*/
// TLE
public class Solution {
	public boolean exist (char[][] board, String word) {
		if (board == null || board.length == 0) {
			return false;
		}
		if (word.length() == 0){
			return true;
		}
		boolean rst = find(board, word, 0, 0, 0);
		return rst;
	}
	private boolean find (char[][] board, String word, int pos, int start, int count) {
		if (count == word.length()){
			return true;
		}
		if (pos < 0 || pos >= board.length || start < 0 || start >= board[0].length ) {
			return false;
		}
		boolean rst = false;
		for ( int i = pos; i < board.length; i++) {
			for (int j = start; j < board[0].length; j++){
				if (board[i][j] == word.charAt(count)){
					board[i][j] = '#';
					rst = find(board, word, pos - 1, start, count + 1) || find(board, word, pos + 1, start, count + 1) || find(board, word, pos, start - 1, count + 1) || find(board, word, pos, start + 1, count + 1);
					board[i][j] = word.charAt(count);
				}
			}
		}
		return rst;
	}
}
