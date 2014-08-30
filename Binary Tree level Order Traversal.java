/*Binary Tree Level Order Traversal:Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).*/
public class Solution{
	public List<List<Integer>> levelOrder(TreeNode root){
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			if(root == null)	return result;
	//used as a queue to save children nodes explored in the next level
			Queue<TreeNode> nodesInALevel = new ArrayDeque<TreeNode>();//queue is abstract cannot be initialized
			nodesInALevel.add(root);
			//values in the current level
			ArrayList<Integer> valuesInCurrentLevel = new ArrayList<Integer>();
			//remaining:number of remaining nodes in the current level;
			//newlyAdded: number of nodes for the next level
			int remaining = 1, newlyAdded = 0;
			while(remaining != 0) {
				TreeNode currentNode = nodesInALevel.poll();
				valuesInCurrentLevel.add(currentNode.val);
				remaining--;
				if(currentNode.left != null) {
					nodesInALevel.add(currentNode.left);
					newlyAdded++;
				}
				if(currentNode.right != null) {
					nodesINALevel.add(currentNode.right);
					newlyAdded++;
				}
				if(remaining == 0) {
					remaining = newlyAdded;
					newlyAdded = 0;
					result.add(valuesInCurrentLevel);
					valuesInCurrentLevel = new ArrayList<Integer>();
				}
			}
			return result;
	}
}
					
			
