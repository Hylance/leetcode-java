/*凡是求最优解的，一般都是走DP的路线。这一题也不例外。首先求dp函数，

定义函数
D[i,n] = 区间[i,n]之间最小的cut数，n为字符串长度

 a   b   a   b   b   b   a   b   b   a   b   a
                     i                                  n
如果现在求[i,n]之间的最优解？应该是多少？简单看一看，至少有下面一个解


 a   b   a   b   b   b   a   b   b   a   b   a
                     i                   j   j+1     n

此时  D[i,n] = min(D[i, j] + D[j+1,n])  i<=j <n。这是个二维的函数，实际写代码时维护比较麻烦。所以要转换成一维DP。如果每次，从i往右扫描，每找到一个回文就算一次DP的话，就可以转换为
D[i] = 区间[i,n]之间最小的cut数，n为字符串长度， 则,

D[i] = min(1+D[j+1] )    i<=j <n

有个转移函数之后，一个问题出现了，就是如何判断[i,j]是否是回文？每次都从i到j比较一遍？太浪费了，这里也是一个DP问题。
定义函数
P[i][j] = true if [i,j]为回文

那么
P[i][j] = str[i] == str[j] && P[i+1][j-1];*/
public class Solution{
	public int minCut(String s) {
		if (s == null || s.length == 0 || s.length == 1) {
			return 0;
		}
		int[][] palindrom = new int[s.length()][s.length()];// record p[i][j] 是否是回文
		int cut[] = new int[s.length() + 1];// +1是因为下面DP要用到下一个
		for(int i = s.length() - 1; i >= 0; i--){
			cut[i] = s.length() - i; //每个字母都划分的最多可能性
			for(int j = i; j < s.length(); j++){
				if(s.charAt(i) == s.charAt(j){
					if(j - i < 2 || palindrom[i + 1][j - 1] == 1){// when j-1 > i+1
						panlindrom[i][j] == 1;
						cut[i] = Math.min(cut[i], cut[j + 1] + 1);
					}
				}
			}
		}
		return cut[0] - 1;//减去第一个字母之前的分割
	}
}
