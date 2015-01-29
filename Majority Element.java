public class Solution {
	public int majorityElement(int[] num) {
		int candidate, count = 0;
		for (int i = 0; i < num.length; i++) {
			if (count == 0) {
				candidate = num[i];
				count++;
			}
			else {
				if (candidate == num[i]) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		return candidate;
	}
}
