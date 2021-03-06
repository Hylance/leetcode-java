/* First Missing Positive: Given an unsorted integer array, find the first missing positive integer. For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2. Your algorithm should run in O(n) time and uses constant space.*/
public class Solution {
	public int firstMissingPositive(int[] A) {
		if (A == null) {
			return 1;
		}
		for (int i = 0; i < A.length; i++) {
			while (A[i] > 0 && A[i] <= A.length && A[i] != (i + 1)) {
				int tmp = A[A[i] - 1];
				if (tmp == A[i]) {
					break;
				}
				A[A[i] - 1] = A[i];
				A[i] = tmp;
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (A[i] != i + 1) {
				return i + 1;
			}
		}
		return A.length + 1;
	}
}
