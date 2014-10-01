/*Combinations:Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.*/
/*A general idea to solve the problem is similar to that in LeetCode - Permutations I and LeetCode - Permutations II. You are welcome to jump to these posts so as to get the idea. To avoid duplicate combinations, we can use an extra parameter indicating the number of the last selection; the recursive subroutine will consider only numbers after that.*/
public class Solution{
	public List<List<Integer>> combine(int n, int k){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n == 0 || k == 0)
			return result;
		recursiveCombine(n, k, 0, new Stack<Integer>(), result);
		return result;
	}
	/**
     * Recursive method for obtaining a list of combinations
     * @param n selection range [1...n]
     * @param k the number of selections needed
     * @param last last selection
     * @param current a stack containing current combination
     * @param result the list to record all combinations
     */
	private void recursiveCombine(int n, int k, int last, Stack<Integer> current, ArrayList<ArrayList<Integer>> result){
	 // No more selection is needed; put the current combination into result
		if (k == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
	 // Separately add a number after the last selection, and work recursively
		for(int i = last + 1; i <= n; i++){
			current.push(i);
			recursiveCombine(n, k - 1, current, result);//use k to control # of recursive
			current.pop();
		}
	}
}

		
