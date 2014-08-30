/* Container with most water:Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.Note: You may not slant the container.*/
//we work from both ends of the edge and move inwards
public class Solution{
	public int maxArea(int[] height) {
		int i = 0;
		int j = height.length - 1;
		int maxArea = 0;
		while(i < j) {
			int area = Math.min(height[i], height[j]) * (j - i);
			if ( area > maxArea)
				MaxArea = area;
	//to increase the current maximum area is to move the shorter inwards
			if (heigh[i] < height[j])
				i++;
			else
				j--;
		}
		return maxArea;
	}
}
		
