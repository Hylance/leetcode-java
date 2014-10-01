/*Subsets II:Given a collection of integers that might contain duplicates, S, return all possible subsets. */
public class Solution{
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){
		if(num == null)	return null;
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		for(int i = num.length - 1; i >= 0; i--){// get existing sets
			if(i == num.length-1 || num[i] != num[i+1] || prev.size() == 0){//when num[i] == num[i+1],don't inital a new prev to prevent duplicates in result
				prev = new ArrayList<ArrayList<Integer>>();
				for(int j = 0; j < result.size(); j++){
					prev.add(new ArrayList<Integer>(result.get(j)));
				}
			}
		//add current number to each element of the set
			for(ArrayList<Integer> temp : prev){
				temp.add(0, num[i]);//add to the first position
			}
			if(i == num.length-1 || num[i] != num[i+1]){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}
		// add all set created in this iteration
			for(ArrayList<Integer> temp : prev){
				result.add(new ArrayList<Integer>(temp));
			}
		} 
		// add empty set
		result.add(new ArrayList<Integer>());
		return result;
	}
}
