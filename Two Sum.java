/* Two Sum: Given an array of integers, find two numbers such that they add up to a specific target number. The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based. You may assume that each input would have exactly one solution. Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2*/
public class Solution{
	public int[] twoSum(int[] numbers, int target){
		if(numbers == null || numbers.length < 2){
			return null;
		}
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; i++){
			hs.put(numbers[i], i + 1);
		}
		int[] a = new int[2];
		for(int i = 0; i < numbers.length; i++){
			if(hs.containsKey(target - numbers[i])){
				int index1 = i + 1;
				int index2 = hs.get(target - numbers[i]);
				if (index1 == index2){
					continue;
				}
				a[0] = index1;
				a[1] = index2;
				return a;
			}
		}
		return a;
	}
}
//hashmap complexity O(n)
	public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int x = numbers[i];
			if (map.containsKey(target - x)) {
				return new int[] {map.get(target - x) + 1, i + 1};
			}
			map.put(x, i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

//2 sum 如果用sort以后，在前后扫描，可以时间O(nlogn + n) = O(nlogn)，空间O(1),但是此处不能用sort，因为要返回index
