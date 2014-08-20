//Sort Colors :Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//solution one: 3-way quick sort:used to deal with equal numbers
public class Solution{
	public void sortColors(int[] A) {
		int n = A.length;
		sort(A, 0, n-1);
	}
	private void sort(int[] A, int lo, int hi) {
		if (hi <= lo) return;
		int tt = lo;
		int gt = hi;
		int v = A[lo];
		int i = lo;
		while ( i <= gt) {
			if (A[i] < v) exch(A, tt++, i++);
			else if (A[i] > v) exch(A, i, gt--);
			else i++;
		}
		sort (A, lo, tt-1);
		sort (A, gt + 1, hi);
	}
	private void exch(int[] A, int a, int b) {
		int swap = A[a];
		A[a] = A[b];
		A[b] = swap;
	}
}

//solution 2: counting sort: used to deal with integer sorting with small distinct values
public class Solution {
	public void sortColors(int[] A) {
		if (A == null || A.length == 0)
            return;
        // A[0...redIndex] are all 0's;
        // A[redIndex+1...whiteIndex] are all 1's
        int redIndex = -1, whiteIndex = -1;
        // Advancing redIndex and whiteIndex according to A[i]
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {    // Found a red object
                // Advance both redIndex and whiteIndex and update A; note the assignment sequence
                A[i] = 2;
                A[++whiteIndex] = 1;
                A[++redIndex] = 0;
            } else if (A[i] == 1) {     // Found a white object
                // Advance whiteIndex and update A
                A[i] = 2;
                A[++whiteIndex] = 1;
            }
        }
    }
}

//solution 3: direct taversal
public class Solution {
    public void sortColors(int[] a) {
        if(a == null || a.length <= 1)
            return;
        
        int pl = 0;
        int pr = a.length - 1;
        int i = 0;
        while(i <= pr){
            if(a[i] == 0){
                swap(a, pl, i);
                pl++;
                i++;
            }else if(a[i] == 1){
                i++;
            }else{
                swap(a, pr, i);
                pr--;
            }
        }
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

