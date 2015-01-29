public class Solution {
	public String convertToTitle(int n) {
		if ( n <= 0) return "";
		StringBuilder res = new StringBuilder();
		while (n != 0) {
			res.insert(0, (char) ('A' + (n - 1) % 26));
			n = (n - 1) / 26;
		}
		return res.toString();
	}
}
