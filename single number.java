/*Given an array of integers, every element appears twice except for one.Find that single one. The solution is suitable for all even times integers*/
public class Solution {
	public int singleNumber(int[] A) {
		if( A == null || A.length == 0) return -1;
		int result = 0;
		for ( int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}
}
