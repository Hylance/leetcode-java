//Blanced Binary Tree:Given a binary tree, determine if it is height-balanced.For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// The following code I wright can identify whether every node of a binary tree has two children or no child but cannot solve this problem.
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else if (root.left == null && root.right == null) return ture;
        else if (root.left == null && root.right != null) {
            if (root.right.right == null && root.right.left == null) return true;
            else {
                return false;
            }
        }
        else if (root.right == null && root.left != null) {
            if(root.left.left == null && root.left.right == null) return true;
            else {
                return false;
            }
        }
        else {
            return isBalanced(root.left) & isBalanced(root.right);
        }
    }
}

//solution 
/*By the problem description, a binary tree is height-balanced if and only if its left and right subtrees are both height-balanced, and their depths do not differ by more than 1. This is a recursive definition, and thus the problem can be recursively solved. Since the depth of a tree is necessary, we can design a recursive routine that returns the depth if a tree is height-balanced, or -1 if it is not. This negative value serves as an early indicator that the tree must be unbalanced, which avoids unnecessary computation for other subtrees at different levels*/
public class BalanceBinaryTree {

    // 516ms for 226 test cases
    public boolean isBalanced(TreeNode root) {
        if (root == null)   // Empty tree
            return true;
        if (depth(root) < 0)
            return false;
        return true;
    }

    /**
     * Calculate the depth of a tree if it is balanced, or get -1 if it is not
     * @param root the root of the tree
     * @return the depth of the tree if it is balanced; -1 otherwise
     */
    private int depth(TreeNode root) {
        if (root == null)   // Empty tree
            return 0;

        // Calculate the depth of its left tree;
        int leftDepth = depth(root.left);
        if (leftDepth < 0)      // Unbalanced left tree automatically indicates unbalance tree
            return leftDepth;

        // Calculate the depth of its right tree;
        int rightDepth = depth(root.right);
        if (rightDepth < 0)     // Unbalanced right tree automatically indicates unbalance tree
            return rightDepth;

        // The depths of the two subtrees differ by more than 1. It is unbalanced.
        if (Math.abs(leftDepth-rightDepth) > 1)
            return -1;

        // The depth of a balanced tree is equal to the larger of the depths of
        // its left and right subtrees, plus 1.
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
