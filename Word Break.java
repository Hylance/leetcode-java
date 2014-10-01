/*Word Break:Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. For example, given s = "leetcode", dict = ["leet", "code"]. Return true because "leetcode" can be segmented as "leet code".*/
public class Solution {
	private int getMaxLength(Set<String> dict) {
		int maxlength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length()){
		}
		return maxLength;
	}
	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int maxLength = getMaxLength(dict);
		boolean[] can = new boolean[s.length() + 1];
		can[0] = true;
		for ( int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= maxLength && j <= i;j++) {
				if(!can[i - j]){
					continue;
				}
				String word = s.substring(i - j, i);
				if(dict.contains(word)) {
					can[i] = true;
					break;
				}
			}
		}
		return can[s.length()];
	}
}
