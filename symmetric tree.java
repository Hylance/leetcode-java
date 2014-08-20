//Symmetric Tree: Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
/*According to the description, a tree is symmetric if  and only if its left subtree and right subtree are mirrored, if and only if

They are empty tree;
Or their roots have the same value, and one's left subtree and another's right subtree are mirrored, and one's right subtree and another's left subtree are mirrored.
As a result, the basic idea is similar to LeetCode - Same Tree, except that we are comparing one's left/right subtree to another's right/left subtree. */
//recursive
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else 
            return isMirrored(root.left, root.right);
    }
    private boolean isMirrored(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;
        return isMirrored(p.left, q.right) && isMirrored(p.right, q.left);
    }
}
//iterative
public class Solution {
	public boolean isSymmetric (TreeNode root) {
		if(root == null) return true;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		LinkedList<TreeNode> r = new LinkedList<TreeNode>();
		l.add(root.left);
		r.add(root.right);
		while(!l.isEmpty() && !r.isEmpty()){
			TreeNode temp1 = l.poll();
			TreeNode temp2 = r.poll();
			if(temp1 == null && temp2 != null || temp1 != null && temp2 == null)
				return false;
			if (temp1 != null) {//implicitely temp2 != null
				if(temp1.val != temp2.val) return false;
				l.add(temp1.left);
				l.add(temp1.right);
				r.add(temp2.right);
				r.add(left);
			}
		}
		return true; //including temp1 == null && temp2 == null
	}
}
