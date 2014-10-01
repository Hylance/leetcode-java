/*Validate Binary Search Tree :Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST is defined as follows: The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key. Both the left and right subtrees must also be binary search trees.*/
// Solution 1: traversal
public class Solution {
	private int lastVal = Integer.MIN_VALUE;
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left)) {
			return false;
		}
		if (lastVal >= root.val) {
			return false;
		}
		lastVal = root.val;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}
}
// Solution 2: divide and conquar  : 
public class Solution{
	public class ResultType {
		int maxValue;
		int minValue;
		boolean isValid;
		ResultType(int maxValue, int minValue, boolean isValid) {
			this.maxValue = maxValue;
			this.minValue = minValue;
			this.isValid = isValid;
		}
	}
	public ResultType isBST(TreeNode root){
		if(root == null) {
			return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
		}
		ResultType left = isBST(root.left);
		ResultType right = isBST(root.right);
		int max = Math.max(root.val, right.maxValue);
		int min = Math.min(root.val, left.minValue);
		if(left.isValid && right.isValid) {
			if(left.maxValue < root.val && root.val < right.minValue){
				return new ResultType(right.maxValue, left.minValue, true);
			}
		}
		else {
			return new ResultType(0, 0, false);
		}
	}
	public boolean isValidBST(TreeNode root){
		if(root == null) {
			return true;
		}
		ResultType result = isBST(root);
		return result.isValid;
	}
}	
