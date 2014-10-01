/*Valid Palindrome:Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome. Note: Have you consider that the string might be empty? This is a good question to ask during an interview. For the purpose of this problem, we define empty string as valid palindrome.*/
public class Solution{
	public boolean isPalindrome(String s){
		if(s == null || s.length() == 0) {
			return true;
		}
		int front = 0;
		int end = s.length() - 1;
		while(front < end){
			while(front < s.length() && !isvalid(s.charAt(front))){// need to check range of a/b
				front++;
			}
			if(front == s.length()){//for empty string ".,,,"
				return true;
			}
			while(end >= 0 && !isvalid(s.charAt(end))){//same here, need to check border of a,b
				end--;
			}
			if(Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))){
				break;
			}else{
				front++;
				end--;
			}
		}
		return end <= front;
	}
	private boolean isvalid(char c){
		return Character.isLetter(c) || Character.isDigit(c);
	}
}
