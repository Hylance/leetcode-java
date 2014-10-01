//3Sum:Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero. Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is: (-1, 0, 1) (-1, -1, 2)
//循环嵌套：可以 对 n-2的数做嵌套循环，因为已经sort过了，最后剩下的两维用2 sum的第二个办法
public class Solution{
	public ArrayList<ArrayList<Integer>> threeSum(int[] sum){
	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length < 3){
			return rst;
		}
		Arrays.sort(num);
		for(int i = 0; i < num.length - 2; i++){//两边扫，所以length-2
			if(i != 0 && num[i] == num[i - 1]){
				continue; // to skip duplicate numbers
			}
			int left = i + 1;
			int right = num.length - 1;
			while(left < right){
				int sum = num[left] + num[right] + num[i];
				if(sum == 0){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[i]);
					tmp.add(num[left]);
					tmp.add(num[right]);
					rst.add(tmp);
					left++;
					right--;
					while(left < right && num[left] == num[left - 1]){
						left++; //to skip duplicate
					}
					while(left < right && num[right] == num[right + 1]){
						right--; //to skip duplicate
					}
				else if(sum < 0) {
					left++;
				}
				else{
					right--;
				}
			}
		}
		return rst;
	}
}

					