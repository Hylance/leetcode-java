/* Scramble String: Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively. Below is one possible representation of s1 = "great": great / \ gr eat / \ / \ g r e at / \ a t To scramble the string, we may choose any non-leaf node and swap its two children. For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat". rgeat / \ rg eat / \ / \ r g e at / \ a t We say that "rgeat" is a scrambled string of "great". Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae". rgtae / \ rg tae / \ / \ r g ta e / \ t a We say that "rgtae" is a scrambled string of "great". Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/
public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()){
			return false;
		}
		if (s1.length() == 0 || s1.equals(s2)) {
			return true;
		}
		int n = s1.length();
		boolean[][][] rst = new boolean[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				rst[0][i][j] = s1.charAt(i) == s2.charAt(j);
			}
		}
		for (int len = 2; len <= n; len++) {
			for (int i = n - len; i >=0; i--) {
				for (int j = n - len; j >= 0; j--) {
					boolean r = false;
					for (int k = 1; k < len && r == false; k++){
						r = (rst[k - 1][i][j] && rst[len - k - 1][i + k][j + k]) || (rst[k - 1][i][j + len -k] && rst[len - k - 1] && rst[len - k - 1][i + k][j]);
					}
					rst[len - 1][i][j] = r;
				}
			}
		}
		return rst[n -1][0][0];
	}
}

