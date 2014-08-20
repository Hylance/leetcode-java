/*Remove Duplicates from Sorted Array II.Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?*/
public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n <= 2) return n;
        int current = 1;
        int point = A[0];
        for (int i = 2; i < n; i++) {
            if(A[i] != point){
                point = A[i-1];//cache A[i-1] which will be compared to A[i+1] in the next loop
                A[++current] = A[i]; //this is where A[i-1] might be overwritten.
            }
            else {
                 point = A[i-1];
            }
        }
        return current + 1;
    }
}

