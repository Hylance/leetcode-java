//Binary Tree Level Order Traversal II :Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//This question is limilar to the previous one and can be solved by a little change at the bottom
public class Solution{
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int currentLevelNodeNum = 1;
		int nextLevelNodeNum = 0;
		while(currentLevelNodeNum != 0) {
			ArrayList<Integer> currentLevelResult = new ArrayList<Integer>();
			nextLevelNodeNum = 0;
			while(currentLevelNodeNum != 0) {
				TreeNode node = queue.poll();
				currentNodeNum--;
				currentLevelResult.add(node.val);
				if(node.left ! = null){
					queue.offer(node.left);
					nextLevelNodeNum++;
				}
				if(node.right != null) {
					queue.offer(node.right);
					nextLevelNodeNum++;
				}
			}
			result.add(0, currentLevelResult);//add to the first index every time
		/*  result.add(currentLevelResult);*/	
			currentLevelNodeNum = nextLevelNodeNum;
		}
		/*Collections.reverse(result);*/
		return result;
	}
}

