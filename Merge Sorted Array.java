/*Merge Sorted Array: Given two sorted integer arrays A and B, merge B into A as one sorted array*/
//The key trick is that when using merge sort we are going to erase the element which will be used to compare later.The best solution is to work backwards for both arrays. We use the two indices as before, but initialize them to the indices of the last effective number, i.e. m-1 and n-1. Besides, we use another index k to keep track of the position to put a number in A, and initialize it to the last position of the merged list, i.e. m+n-1. During the course of working backwards, we put the larger one into A[k], and update those indices accordingly. By this means, we do not need to worry about erasing of the numbers in A; those erased numbers must have been used before.
public class Solution {
	public void merge (int A[], int m, int B[], int n) {
		if ( A == null || B == null) 
			return;
		int i = m-1, j = n - 1; k = m + n -1;
		// put the larger one into A in reverse order
		while (i >= 0 && j >=0 ) {
			if (B[j] >= A[i])
				A[k--] = B[j--];
			else
				A[k--] = A[i--];
		}
		// Remaining numbers in B are the smallest
		while (j > 0) 
			A[k--] = B[j--];
	}
}
		
