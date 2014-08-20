/*Given a binary tree, return the inorder traversal of its node's value*/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null)
            return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            }
            else {
                TreeNode t = stack.pop();
                ans.add(t.val);
                p = t.right;
            }
        }
        return ans;
    }
}

// solution 2
public class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return;
        traverse(root.left, result);
                result.add(root.val);
        traverse(root.right, result);

    }
}

