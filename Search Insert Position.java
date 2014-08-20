//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//solution 1
public class Solution{
	public int searchInsert(int[] A, int target) {
		int N = A.length;
		int i = 0;
		if(A[i] > target)
			return 0;
		while( i < N && A[i] <target) i++;
		return i;
	}
}

//solution 2
public class Solution{
	public int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		if(target < A[0]) {
			return 0;
		}
		while (start + 1 < end) {
			mid = start + (end - start)/2;
			if (A[mid] == target) {
				return mid;
			}
			else if (A[mid] < target) {
				start = mid;
			}
			else { 
				end = mid;
			}
		if (A[end] == target) return end;
		if (A[end] < target) return end + 1;
		if (A[start] == target) return start;
		return start + 1;
	}
}

