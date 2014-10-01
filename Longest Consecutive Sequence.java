/*Longest Consecutive Sequence:Given an unsorted array of integers, find the length of the longest consecutive elements sequence. For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4. Your algorithm should run in O(n) complexity. */
public class Solution{
//sort & search:space O(1), time O(nlogn) at lease
//HashMap:space O(n), time O(n)
	public int longestconsecutive(int[] num){
		HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
		for(int i: num){
			hs.put(i, 0);//the Key is the number in num, the Value is used to identify whether this number has been calculated
		}
		int max = 1;
		for(int i: num){
			if(hs.get(i) == 1) continue; // has been calculated
			int tmp = i;
			int count = 1;
			while(hs.containsKey(tmp + 1)){
				count++;
				tmp++;
				hs.put(tmp, 1);
			}
			tmp = i;
			while(hs.containsKey(tmp - 1)){
				count++;
				tmp--;
				hs.put(tmp, 1);
			}
			max = Math.max(count, max);
		}
		return max;
	}
}

