/* Given an array of integers, every element appears three times except for one.
Find that single one*/
public class Solution {
	public int singleNumber(int[]A) {
		if (A == null && A.length == 0) return -1;
		int result = 0;
		int[] bit = new int[32];
		for (int i = 0; i < 32; i++) {
			for(int j = 0; j < A.length; j++) {
				bit[i] += A[j]>>i & 1;
				bit[i] %= 3;
			}
			result |= bit[i]<<i;
		}
		return result;
	}
}
