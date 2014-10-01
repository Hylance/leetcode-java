//Jump Game: Given an array of non-negative integers, you are initially positioned at the first index of the array. Each element in the array represents your maximum jump length at that position. Determine if you are able to reach the last index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false
public class Solution{
	public boolean canJump(int[] A){
		boolean[] can = new boolean [A.length];
		can[0] = true;
		for(int i = 1; i < A.length; i++){
			for(int j = 0; j < i; j++){
				if(can[j] && j + A[j] >= i){//判断i之前的所有点能否jump到i
					can[i] = true;
					break;
				}
			}
		}
		
		return	can[A.length - 1];
	}
}

