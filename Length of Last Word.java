/* Length of Last Word: Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.If the last word does not exist, return 0.*/
public class Solution{
	public int lengthOfLastWord(String s) {
		int length = 0;
		char[] chars = s.toCharArray();//convert string to char array
		for(int i = s.length() - 1; i >= 0; i--){
			if(length == 0){
				if(char[i] == ' ') { // in case space at the end of string
					continue;
				}
				else{
					length++;
				}
			}
			else {
				if(char[i] == ' ') {
					break;
				}
				else {
					length++;
				}
			}
		}
		return length;
	}
}

