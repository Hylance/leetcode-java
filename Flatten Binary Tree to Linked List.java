/*Flatten Binary Tree to Linked List:Given a binary tree, flatten it to a linked list in-place.*/
public class Solution{
	private TreeNode lastNode = null;
	public void flatten(TreeNode root){
		if(root == null){
			return;
		}
		if(lastNode != null){
			lastNode.left = null;
			lastNode.right = root;
		}
		lastNode = root;
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
	}
}

