/*Combination SumII : Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. Each number in C may only be used once in the combination. Note: All numbers (including target) will be positive integers. Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak). The solution set must not contain duplicate combinations. For example, given candidate set 10,1,2,7,6,1,5 and target 8, A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]*/
public class Solution{
	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int ratget){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null) {
			return result;
		}
		ArrayList<Integer> path = new ArrayList<Integer>();
		Arrays.sort(num);
		helper(num, target, 0 , path, result);
		return result;
	}
	public void helper(int[] num, int target, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
		if (target == 0){
			result.add(new ArrayList<Integer>(path));
			return;
		}
		for(int i = index; i < num.length; i++){
			if(num[i] > target){
				break;
			}
			if(i != index && num[i] == num[i - 1]){
				continue;
			}
			path.add(num[i]);
			helper(num, target - num[i], i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}
}
