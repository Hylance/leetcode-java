//Pascal's Triangle: Given numRows, generate the first numRows of Pascal's triangle.
public class Solution{
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0) return result;
		//generate the first list
		List<Integer> previous = new ArrayList<Integer>(1);
		previous.add(1);
		result.add(previous);
		//A new List is generated based on its previous list
		for(int i = 2; i <= numRows; i++) {
			List<Integer> current = new ArrayList<Integer>(i);
			current.add(1);
			for(int j = 1; j < previous.size(); j++) {
				current.add(previous.ger(j-1) + previous.get(j));
			current.add(1);
			result.add(current);
			previous = current;
		}
		return result;
	}
}
