//Maximum subarray:Find the contiguous subarray within an array (containing at least one number) which has the largest sum. For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6. click to show more practice. More practice: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
// DP
public class Solution{
	public int maxSubArray(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}
}

// Divide and Conquer
public class Solution {
    public int maxSubArray(int[] A) {
        int maxV = Integer.MIN_VALUE;
        int n = A.length;
        return maxArray(A, 0, n-1, maxV);
    }
    int maxArray(int[] A, int left, int right, int maxV) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }
        int mid = (right + left)/2;
        int maxl = maxArray(A, left, mid-1, maxV);
        int maxr = maxArray(A, mid+1, right, maxV);
        maxV = Math.max(maxl, maxV);
        maxV = Math.max(maxr, maxV);
        int sum = 0;
        int mlmax = 0;
        for (int i = mid-1; i >= left; i--) {
            sum += A[i];
            mlmax = Math.max(sum, mlmax);
        }
        sum = 0;
        int mrmax = 0;
        for (int i = mid+1; i <= right; i++){
            sum += A[i];
            mrmax = Math.max(sum, mrmax);
        }
        maxV = Math.max(maxV, mrmax + mlmax + A[mid]);
        return maxV;
        
    }
    
}
