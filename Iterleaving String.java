/* Interleaving String: Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.*/
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) 	return false;
		if (s1.length() + s2.length() != s3.length())	return false;
		boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0] ){
				dp[i][0] = true;
			}
		}
		for (int i = 1; i <= s2.length(); i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i - 1]) {
				dp[0][i] = true;
			}
		}
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++){
				if(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) ){
					dp[i][j] = true;
				}
				if (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ) {
					dp[i][j] = true;
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}
}

