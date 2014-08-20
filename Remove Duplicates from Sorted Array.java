//Remove Duplicates from Sorted Array:Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.Do not allocate extra space for another array, you must do this in place with constant memory.
//O(n) time and in place space
public class Solution{
	public int removeDuplicates(int[] A) {
		int n = A.length;
		if (n <= 1) return n;
		int current = 0;
		for (int i = i; i < n; i++) {
			if(A[i] != A[i-1]) 
				A[++current] = A[i];
		}
		return current + 1;
	}
}
 
