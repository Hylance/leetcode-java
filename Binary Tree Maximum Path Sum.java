/* Binary Tree Maximum Path Sum: Given a binary tree, find the maximum path sum. The path may start and end at any node in the tree. For example: Given the below binary tree, 1 / \ 2 3 Return 6.*/
public class Solution {
	private class ResultType{
		int singlePath, maxPath;
		ResultType(int singlePath, int maxPath){
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}
	public int maxPathSum(TreeNode root) {
		ResultType result = helper(root);
		return result.maxPaht;
	}
	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE）；
		}
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0);
		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
		return new ResultType(singlePath, maxPath);
	}
}
