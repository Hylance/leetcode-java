/*Minimum Depth of Binary Tree :Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.*/
public class Solution{
	public int minDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return getMin(root);
	}
	public int getMin(TreeNode roo){
		if(root == null){ //迭代过程中遇到null返回最大值使其在Math.min中落选，root == null的初始情况不能在迭代函数中表示，要在calling函数中表示
			return Integer.MAX_VALUE;
		}
		if(root.left == null && root.right == null)	return 1;
		return Math.min(getMin(root.left), getMin(root.right)) + 1; //每迭代一次depth + 1
	}
}

