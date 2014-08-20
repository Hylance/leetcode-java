/* Reverse digits of an integer, take care of negative numbers*/
public class Solution {
	public int reverse( int x) {
		int rst = 0;
		while (x != 0) {
			rst = rst*10 + x % 10; // -123 % 10 = -3
			x = x/10;
		}
		return rst;
	}
}

public class Solution{
	public int reverse (int x) {
		int rst = 0;
		int i = 0;
		if (x < 0) {
			i = 1;
			x = -x;
		}
		while ( x != 0) {
			rst = rst * 10 + x % 10;
			x = x/10;
		}
		if (i == 1) rst = -rst;
		return rst;
	}
}

