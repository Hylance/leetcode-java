/*Given a binary tree, return the preorder traversal of its nodes' values*/
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		Stack<Integer> stack = new Stack<TreeNode>();
		List<Integer> preorder = new ArrayList<Integer>();
		if (root == null) {
			return preorder;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			preorder.add(node.val);
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
	}
}

//version 1: Traverse
public class Solution {
	public ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}
	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if (root == null) {
			return;
		}
		result.add(root.val);
		traverse(root.left, result);
		traverse(root.right,result);
	}
}

//Version 2: Divide and Conquer
public class Solution{
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if( root == null) {
			return result;
		}
		//Divide
		ArrayList<Integer> left = preorderTraversal(root.left);
		ArrayList<Integer> right = preorderTraveral(root.right);
		//conquer
		result.add(root.val);
		result.addAll(left);
		result.addAll(right);
		return result;
	}
}
