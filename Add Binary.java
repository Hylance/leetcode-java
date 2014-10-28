/* Add Binary: Given two binary strings, return their sum (also a binary string).*/
public String addBinary(String a, String b){
	int m = a.length();
	int n = b.length();
	int carry = 0;
	String res = "";
	int maxLen = Math.max(m, n);
	for (int i = 0; i < maxLen; i++) {
		int p = 0;
		int q = 0;
		if (i < m) {
			p = a.charAt(m - 1 - i) - '0';
		} else {
			p = 0;
		}
		if ( i < n ) {
			q = b.charAt(n - 1 - i) - '0';
		} else {
			q = 0;
		}
		int sum = p + q + carry;
		carry = sum / 2;
		res = Integer.toString(sum % 2) + res;
	}
	if (carry != 0) {
		res += carry;
	}
	return res;
}


