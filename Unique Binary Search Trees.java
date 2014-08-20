//Unique Binary Search Trees: Given n, how many structurally unique BST's that store values 1...n?
/*
The case for 3 elements example
Count[3] = Count[0]*Count[2]  (1 as root)
              + Count[1]*Count[1]  (2 as root)
              + Count[2]*Count[0]  (3 as root)

Therefore, we can get the equation:
Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<=i-1  

*/
public int numTree(int n) {
	int[] count = new int[n+2];
	count[0] = 1;
	count[1] = 1;
	for(int i = 2; i<=n; i++){
		for(int j = 0; j<i; j++) {
			count[i] += count[j]*count[i-j-1];
		}
	}
	return count[n];
}
/*当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。*/

