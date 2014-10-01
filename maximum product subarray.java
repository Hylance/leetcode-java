/* Maximum Product Subarray:Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/
public class Solution {
	public int maxProduct (int[] A) {
		if (A == null || A.length == 0) {
			return Integer.MIN_VALUE;
		}
		int product = A[0];
		int max = A[0];
		int min = A[0];
		for (int i = 1; i < A.length; i++) {
			int a = max * A[i];
			int b = min * A[i];
			max = Math.max(Math.max(a, b), A[i]);
			min = Math.min(Math.min(a, b), A[i]);
			product = Math.max(product, max);
		}
		return product;
	}
}
