/* Insert Interval:Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.*/
public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (newInterval == null || intervals == null) {
			return intervals;
		}
		ArrayList<Interval> results = new ArrayList<Interval>();
		int insertPos = 0;
		for (Interval interval : intervals) {
			if (interval.end < newInterval.start){
				results.add(interval);
				insertPos++;
			} else if (interval.start > newInterval.end) {
				results.add(interval);
			} else {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}
		results.add(insertPos, newInterval);
		return results;
	}
}

	
