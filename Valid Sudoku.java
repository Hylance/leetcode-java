//valid sudoku:Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
public class Solution{
	public boolean isValidSudoku(char[][] board){
		return isValidRow(board) && isValidCol(board) && isValidBox(board);
	}	
	// check row
	public boolean isValidRow(char[][] board){
		for(int i = 0; i < board.length; i++){
			int[] flag = new int[10];
			for(int j = 0; j < board[0].length; j++){
				if(!check(flag, board[i][j])){
					return flase;
				}
			}
		}
		return true;
	}
	// check column
	public boolean isValidCol(char[][] board){
		for(int j = 0; j < board[0].length; j++){
			int[] flag = new int[10];
			for(int i = 0; i < board[0].length; i++){
				if(!check(flag,board[i][j])){
					return false;
				}
			}
		}
		return true;
	}
	//check box
	public boolean isValidBox(char[][] board){
		for(int i = 0; i < board.length; i+=3){
			for(int j = 0; j < board[0].length; j+=3){
				int flag = new int[10];
				for(int k = 0; k < 9;k++){
					if(!check(flag, board[i + k/3][i + k%3])){
						return false;
					}
				}
			}
		}
		return true;
	}
	public boolean check(int[] flag, char c){
		if(c == '.'){
			return true;
		}
		if(flag[c - '0'] == 1){// already exist
			return false;
		}
		else {
			flag[c - '0'] == 1;// first time show up
			return true;
		}
	}
}
