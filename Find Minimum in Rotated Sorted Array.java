public class Solution {
	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int l = 0;
		int r = num.length - 1;
		int min = num[0];
		while (l + 1 < r) {
			int m = (l + r) / 2;
			if (num[l] < num[m]) {
				min = Math.min(num[l], min);
				l = m;
			}
			else if (num[l] > num[m]) {
				min = Math.min(num[m], min);
				r = m;
			}
		}
		min = Math.min(num[r], min);
		min = Math.min(num[l], min);
		return min;
	}
}
