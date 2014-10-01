/*Trapping Rain Water:Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.*/
public class Solution{
	public int trap(int[] A){
		int sum = 0;
		int max = -1;
		int maxIndex = -1;
		int prev;
	// find the highest bar
		for(int i = 0; i < A.length; i++){
			if(max < A[i]){
				max = A[i];
				maxIndex = i;
			}
		}
	// process all bars left to the highest bar
		prev = 0;
		for(int i = 0; i < maxIndex; i++){
			if(A[i] > prev){
				sum += (A[i] - prev) * (maxIndex - i);
				prev = A[i];
			}
			sum -= A[i];
		}
	//process all bars right to the highest bar
		prev = 0;
		for(int i = A.length - 1; i > maxIndex; i--) {
			if(A[i] > prev) {
				sum += (A[i] - prev) * (i - maxIndex);
				prev = A[i];
			}
			sum -= A[i];
		}
		return sum;
	}
}

