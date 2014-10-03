/*Distinct Subsequence:Given a string S and a string T, count the number of distinct subsequences of T in S. A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not). Here is an example: S = "rabbbit", T = "rabbit" Return 3.*/
public class Solution {
	public int numDistinct(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		int[][] num == new int[S.length() + 1][T.length() + 1];
		for ( int i = 0; i <= S.length(); i++) {
			num[i][0] = 1;
		}
		for (int i = 1; i <= S.length(); i ++) {
			for (int j = 1; j <= T.length(); j ++) {
				num[i][j] = num[i -1][j];
				if (S.charAt(i - 1) == T.charAt(j - 1)){
					num[i][j] += num[i - 1][j - 1];
				}
			}
		}
		return num[S.length()][T.length()];
	}
}
