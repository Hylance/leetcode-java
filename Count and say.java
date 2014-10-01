//Count and say:The count-and-say sequence is the sequence of integers beginning as follows:1, 11, 21, 1211, 111221, ...
public class Solution{
	public String countAndSay(int n){
		String s = "1";
		for(int i = 1; i < n; i++){//count round
			int cnt = 1;
			StringBuilder tmp = new StringBuilder();
			for(int j = 1; j < s.length(); j++){
				if(s.charAt[j] == s.charAt[j - 1]){
					cnt++;
				}
				else{
					tmp.append(cnt).append(s.charAt(j-1));
					cnt = 1; // restore cnt
				}
			}
			tmp.append(cnt).append(s.charAt(s.length()-1));
			s = tmp.toString();
		}
		return s;
	}
}


