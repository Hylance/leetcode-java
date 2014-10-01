/*Sum Root to Leaf Numbers: Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.An example is the root-to-leaf path 1->2->3 which represents the number 123.Find the total sum of all root-to-leaf numbers.*/
public class Solution{
	public int sumNumbers(TreeNode root){
		int sum = 0;
		return sumup(root, sum);
	}
	private sumup(TreeNode root, int sum){
		if(root == null) return 0;
		sum = sum*10 + root.val;
		if(root.left == null && root.right == null) return sum;
		return sumup(root.left, sum) + sumup(root.right, sum);
	}
}
