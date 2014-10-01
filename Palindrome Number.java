//Palindrome Number:Determine whether an integer is a palindrome. Do this without extra space.
//solution !:不断地取第一位和最后一位（10进制下）进行比较，相等则取第二位和倒数第二位，直到完成比较或者中途找到了不一致的位。
public class Solution{
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int div = 1;
		while(x/div >= 10)
			div *= 10;
		while(x > 10){
			int l = x/div;//1st on the left
			int r = x%10;//1st on the right
			if(l != r) return false;
			x =( x%div)/10;//eliminate the first and last digits
			div /= 100;
		}
		return true;
	}
}
// solution 2: reverse number
public class Solution{
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		return x == reverse(x);
	}
	private int reverse(int x) {
		int rst = 0;
		while(x != 0){
			rst = rst * 10 + x % 10;
			x = x/10;
		}
		return rst;
	}
}

