//Plus One:Given a non-negative number represented as an array of digits, plus one to the number.The digits are stored such that the most significant digit is at the head of the list.
public class Solution {
	public int[] plusOne(int[] digits) {
		if(digits == null) return null;
	//processing digits in reverse order
		for (int i = digits.length - 1; i >= 0; i--) {
			if( digits[i] < 9) {
				digits[i] += 1; //adding 1 ends here
				return digits;
			}
			else digits[i] = 0; //add 1 to a higher position
		}
		//No return from the above, the digits are in form of 9..9	
		// and adding one makes it to 10...0;
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}


