// Max points on a line:Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
public class Solution{
	public int maxPoints(Point[] points){
		if(points == null || points.length == 0) {
			return 0;
		}
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		int max = 1;
		for (int i = 0; i < points.length; i++) {
			map.clear();
			//maybe all points contained in the list are the same points,
			//same points'k is represented by Integer.MIN_VALUE;
			map.put((Double)Integer.MIN_VALUE, 1);
			int dup = 0;
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					dup++;
					continue;
				}
				double key = points[j].x - points[i].x == 0 ? Integer.MAX_VALUE : 0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
				if (map.containsKey(key)){
					map.put(key, map.get(key) + 1);
				}
				else {
					map.put(key, 2);
				}
			}
			for (int temp : map.values()) {
				max = Math.max(max, temp + dup);
			}
		}
		return max;
	}
} 
