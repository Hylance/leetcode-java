/*Longest Common Prefix: Write a function to find the longest common prefix string amongst an array of strings.*/
/不知道这题还有什么更精妙的解法。最基本的就是用前一次的longest common prefix(LCP)和下一个string去比较，一直比完所有string。
public class Solution{
	public String longestCommonPrefix(String[] strs){
		if(strs.length == 0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		String LCP = findLCPBetweenTwo(strs[0],strs[1]);
		for(int i = 2; i < strs.length; i++){
			LCP = finLCPBetweenTwo(LCP, strs[i]);
		}
		return LCP;
	}
	public String findLCPBetweenTwo(String s1, String s2){
		StringBuilder builder = new StringBuilder();
		int length = Math.min(s1.length(), s2.length());
		for(int i = 0; i < length; i++){
			if(s1.charAt(i) != s2.CharAt(i)){
				break;
			}
			else{
				builder.append(s1.charAt(i));
			}
		}
		return builder.toString();
	}
}

