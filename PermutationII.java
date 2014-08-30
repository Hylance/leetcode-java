public class Solution{
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length = 0)	return result;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] visited = new int[num.length];//keep track of visiting
		Arrays.sort(num);
		helper(result, list, visited, num);
		return result;
	}
	public void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] visited, int[] num){
		if(list.size() == num.length){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i = 0; i < num.length; i++){
			if((i != 0 && num[i] == num[i-1] && visited[i-1] ==0)||visited[i] ==1){
				continue;
			}//If "current" is already a permutation of "num", add it to "result";otherwise, append each unused number to "current", and recursively try next unused number
			visited[i] = 1;
			list.add(num[i]);
			helper(result, list, visited,num);
			list.remove(list.size() - 1);
			visited[i] = 0;
		}
	}
}
