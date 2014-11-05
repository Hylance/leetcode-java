// Construct Binary Tree from Preorder and Inorder Traversal
//preorder的第一个数是root，找到inorder中对应的值则inorder中该数左边的数属于左子树，
//右边的数属于右子树，递归去做。inorder左边有几个数，preorder的前几个数+root就属于左子树
public class Solution {
	public TreeNode buildTree (int[] preorder, int[] inorder) {
		if (inorder.length != preorder.length) {
			return null;
		}
		return myBuildTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}
	private TreeNode myBuildTree (int[] inorder, int instart, int inend, int[] preorder, int prestart, int preend) {
		if (instart > inend) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[prestart]);
		int position = findPosition(inorder, instart, inend, preorder[prestart]);
		root.left = myBuildTree(inorder, instart, position - 1, preorder, prestart + 1, prestart + position - instart);
		root.right = myBuildTree(inorder, position + 1, inend, preorder, position - inend + preend + 1, preend);
		return root;
	}
	private int findPosition(int[] arr, int start, int end, int key) {
		int i;
		for ( i = start; i <= end; i++){
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}
}

