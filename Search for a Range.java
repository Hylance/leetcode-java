//Search for a range:Given a sorted array of integers, find the starting and ending position of a given target value.Your algorithm's runtime complexity must be in the order of O(log n).
//If the target is not found in the array, return [-1, -1].
/*这道题是二分查找Search Insert Position的变体，思路并不复杂，就是先用二分查找找到其中一个target，然后再往左右找到target的边缘。找边缘的方法跟二分查找仍然是一样的，只是切半的条件变成相等，或者不等（往左边找则是小于，往右边找则是大于）。这样下来总共进行了三次二分查找，所以算法的时间复杂度仍是O(logn)，空间复杂度是O(1)。*/ 
public class Solution{
	public int[] searchRange(int[] A, int target){
		int res = new int[2];
		res[0] = -1;
		res[1] = -1;
		if(A == null || A.length == 0)	return res;
		int l = 0;
		int r = A.length - 1;
		int m = (l + r)/2;
		while(l <= r){
			m = (l + r)/2;
			if(A[m] == target){
				res[0] = m;
				res[1] = m;
				break;
			}
			else if(A[m] > target){
				r = m -1;
			}
			else{
				l = m + 1;
			}
		}
		if(A[m] != target)
			return res;
		int newL = m;
		int newR = A.length - 1;
		while(newL <= newR) {
			int newM = (newL + newR)/2;
			if(A[newM] == target){
				newL = newM + 1;
			}
			else {
				newR = newM - 1;
			}
		}
		res[1] = newR;//when newL == newR, newL changed,so we use newR 
		newL = 0;
		newR = m;
		while(newL <= newR){
			int newM = (newR + newL)/2;
			if(A[newM] == target){
				newR = newM - 1;
			}
			else{
				newL = newM + 1;
			}
		}
		res[0] = newL;////when newL == newR, newR changed,so we use newL
		return res;
	}
}
//实现中用到了在Search Insert Position中提到的方法，可以保证当搜索结束时，l和r所停的位置正好是目标数的后面和前面。		
