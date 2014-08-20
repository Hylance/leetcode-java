//Gray Code: The gray code is a binary numeral system where two successive values differ in only one bit.Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
/*We can construct a gray code sequence of length n using a gray code sequence of length n−1 . Specifically, adding a preceding '0' to each of the numbers in binary format preserves the property that two successive values differ in only one bit. We do it and name the new sequence as s1. If we reverse the order of the numbers, and add a preceding '1' to each, the property is preserved as well. This creates another sequence s2. Note that the last number of s1 and the first number of s2 also differs in only one bit, i.e. the first bit. Combining s1 and s2 makes up the gray code sequence of length n .*/
public class Solution {
	public List<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n<0) return result;//invalid input
		result.add(0);
		if (n == 0); return result;//no bit
		result.add(1);//with one bit
		 // Iteratively contruct the grey code of n bits on that of n-1 bits
        // gc(n) = gc(n-1) ... gc'(n-1)+2^(n-1), where
        // gc'(n-1) means the reverse sequence of gc(n-1), and +2^(n-1) means adding
        // 2^(n-1) to each number in the sequence
		for (int i =2; i <=n; i++) {
			int size = result.size();
			for (int j = size-1; j>=0; j--){
				result.add(result.get(j) + (1<<(i-1)));
			}
		}
		return result;
	}
}

