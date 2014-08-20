//Remove Element :Given an array and a value, remove all instances of that value in place and return the new length.The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//双变量
public class Solution{
	public int removeElement(int[] A, int elem) {
		int number = 0;
		for ( int i = 0; i < A.length; i++) {
			if (A[i] != elem) {
				A[number++] = A[i];
			}
		}
		return number;
	}
}
// mine
public class Solution {
    public int removeElement(int[] A, int elem) {
        int n = A.length;
        Arrays.sort(A);
        int j = 0;
        int i = 0;
        if (n == 0){
            return 0;
        }
        while(i<n && A[i] != elem) {
            i++;
        }
        while (n-1-j > i && A[n-1-j] != elem) {
            j++;
        }
        int m = n-1-j;
        int newlength = i + j;
        for (;i < n  && j>0; i++) {
                A[i] = A[n-j];
                j--;
        }
        return newlength;
    }
}

