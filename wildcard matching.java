public class Solution{
	public boolean isMatch(String s, String p) {
		int s1 = 0, p1 = 0, ss = 0, star = -1;
		while (s1 < s.length()) {
			if (p1 < p.length()) {
				if (p.charAt(p1) == '?' || s.charAt(s1) == p.charAt(p1)){
					s1++;
					p1++;
					continue;
				}
				if (p.charAt(p1) == '*') {
					star = p1;
					p1++;
					ss = s1;
					continue;
				}
			}
			if(star != -1) {
				p1 = star + 1;
				s1 = ++ss;
				continue;
			}
			return false;
		}
		while (p1 < p.length() && p.charAt(p1) == '*') {
			p1++;
		}
		return p1 == p.length();
	}
}

