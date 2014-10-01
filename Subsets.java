/*Subsets: Given a set of distinct integers, S, return all possible subsets. Note: Elements in a subset must be in non-descending order. The solution set must not contain duplicate subsets. For example, If S = [1,2,3], a solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]*/
//solution 1
public class Solution{
	public ArrayList<ArrayList<Integer>> subsets(int[] num){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num == null || num.length == 0){
			return result;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.sort(num);
		subsetsHelper(result, list, num, 0);
		return result;
	}
	private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list,int[] num, int pos){
		result.add(new ArrayList<Integer>(list));
		for(int i = pos; i < num.length; i++){//add list layer by layer
			list.add(num[i]);
			subsetsHelper(result, list, num, i + 1);//every function list get an item and result get a list
			list.remove(list.size() - 1);//layer by layer remove all the items in list
		}
	}
}
//solution 2
/*Given a set S of n distinct integers, there is a relation between Sn and Sn-1. The subset of Sn-1 is the union of {subset of Sn-1} and {each element in Sn-1 + one more element}. Therefore, a Java solution can be quickly formalized. */
public class Solution{
	public ArrayList<ArrayList<Integer>> subsets(int[] S){
		if(S == null)	return null;
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < S.length; i++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
				for(ArrayList<Integer> a : result){
					temp.add(new ArrayList<Integer>(a);
				}	//get sets that are already in result
			for(ArrayList<Integer> a : temp){
				a.add(S[i]);//add S[i] to existing sets
			}
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
			result.addAll(temp);
		}
		result.add(new ArrayList<Integer>());
		return result;
}
			
