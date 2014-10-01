/*Path sum: Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.*/
public class Solution{
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
	//it is a leaf and its value is the path sum
		if(root.val == sum && root.left == null && root.right == null)
			return true;
	//A tree has the path sum if either its left subtree or right subtree has the path sum of (sum - root.val)
		if (hasPathSum(root.left, int sum - root.val) || hasPathSum(root.right,sum - root.val))
			return true;
		return false;
	}
}

