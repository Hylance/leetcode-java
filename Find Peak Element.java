public class Solution {
	public int findPeakElement(int[] num){
		int l = 0;
		int r = num.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (l == r) {
				return mid;
			}
			else if (num[mid] < num[mid + 1] ) {
				l = mid + 1;
			}
			else {
				r = mid;
			}
		}
		return - 1;
	}
}
