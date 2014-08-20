/* Pascal's Triangle II :Given an index k, return the kth row of the Pascal's triangle.For example, given k = 3,Return [1,3,3,1]. This is an extension of LeetCode Pascal's Triangle. The way to find the k-th row of Pascal's triangle is similar to the more general problem of finding all rows. But now we do not need the extra space to save all the rows before the k-th row. Instead, we can allocate the array for the k-th row directly, and work on the array on each row. And since each of the values in a row except the leading and trailing 1 is used twice to generate those in the next row, we need to cache it before it is overwritten.*/
public class Solution{
	public List<Integer> getRow(int rowIndex) {
		if(rowIndex < 0) return null;
		List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
		result.add(1);
		// build each row one at a time
		for(int i = 1; i <= rowIndex; i++) {
			int temp1 = 1;//leading 1
			for(int j = 1; j < i; j++) {
				int temp2 = result.get(j);//cashe the value before it is overwritten
				result.set(j, temp1 + temp2);
				temp1 = temp2;
			}
			result. add(1);//trailing 1
		}
		return result;
	}
}
