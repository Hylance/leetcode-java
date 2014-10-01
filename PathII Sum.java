/*Path Sum II:Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.*/
public class Solution{
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return result;
		recursivePathSum(root, sum, new ArrayList<Integer>(), result);
		return result;
	}
	private void recursivePathSum(TreeNode root, int sum, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> result) {
		if(root == null) return;
	// Add the node into the current path, and store that path before recover the path
		if(root.val == sum && root.left == null && root.right =- null) {
			current.add(root.val);
			result.add(new ArrayList<Integer>(current);
			current.remove(current.size() - 1);
			return;
		}
	// Add the node into the current path, and explore its left subtree and right subtree before recover the path
		current.add(root.val);
		recursivePathSum(root.left, sum - root.val, current, result);
		recursivePathSum(root.right, sum - root.val, current, result);
		current.remove(current.size() - 1);
	}
}

