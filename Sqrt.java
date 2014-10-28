// Sqrt(x)
public class Solution {
	public int sqrt(int x) {
		long lo = 0;
		long hi = x;
		while (hi >= lo) {
			long mid = lo + (hi - lo) / 2;
			if (x < mid * mid) { //long, mid * mid 会溢出
				hi = mid - 1;
			}   // 加上x == mid*mid will lose precision
			else {
				lo = mid + 1;
			}
		}
		return (int) hi;
	}
}
