/*Given a binary tree, return the postorder traversal of its nodes' values*/
// recursive
public class Solution{
	public List<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		traverse(root, result);
		return result;
	}
	private void traverse(TreeNode root, ArrayList<Integer> result) {
		if(root == null) 
			return;
		traverse(root.left, result);
		traverse(root.right, result);
		result.add(root.val);
	}
}

//Iterative
public ArrayList<Integer> postorderTraversal(TreeNode root) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	Stack<TreeNode> stack = new Stack<TreeNode>();
	TreeNode prev = null; //previously traversed node
	TreeNode curr = root;
	if(root == null) {
		return result;
	}
	stack.push(root);
	while(!stack.isEmpty()) {
		curr = stack.peek();
		if(prev == null || prev.left == curr || prev.right == curr) { // traverse down the tree
			if(curr.left != null) {
				stack.push(curr.left);
			}
			else if(curr.right != null) {
				stack.push(curr.right);
			}
		}
		else if (curr.left == prev){ //traverse up the tree from the left
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		else { //traverse up the tree from the right
			result.add(curr.val);
			stack.pop();
		}
		prev = curr;
	}
	return result;
}

