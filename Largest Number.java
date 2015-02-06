public class StringComparator implements Comparator<String> {
	public int compare (String s1, String s2) {
		String s12 = s1 + s2;
		String s21 = s2 + s1;
		return (int) (Long.parseLong(s12) - Long.parseLong(s21));
	}
}
public String largestNumber(int[] num) {
	StringBuilder sb = new StringBuilder();
	List<String> numStr = new ArrayList<String>();
	for (int i : num) {
		numStr.add("" + i);
	}
	Collections.sort(numStr, new StringComparator());
	boolean HasPossibleLeading0 = true;
	for (int i = numStr.size() - 1; i >= 0; i--) {
		if (HasPossibleLeading0 && numStr.get(i).equals("0"))
			continue;
		HaspossibleLeading0 = false;
		sb.append(numStr.get(i));
	}
	if(sb.length() == 0) {
		return "0";
	}
	return sb.toString();
}
