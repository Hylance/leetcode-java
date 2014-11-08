/* Longest Palindromic Substring:Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.*/
public class Solution {
	private char ger(String s, int i) {
		if (i % 2 == 0) {
			return '#';
		else 
			return s.charAt(i / 2);
	}
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		int length = s.length();
		int max = 0;
		String result = "":
		for (int i = 1; i <= 2 * length - 1; i++) {
			int count = 1;
			while ( i - count >= 0 && i + count <= 2 * length && get(s, i - count) == get(s, i + count);
			count--;
			if ( count > max) {
				result = s.substring((i - count) / 2, (i + count) / 2);
				max = count;
			}
		}
		return result;
	}
}
