//Generate Parentheses: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
/*This problem can be properly solved by a recursive strategy. Three pieces of information are maintained during the search for all matched parentheses: the exploration prefix so far, the number opening of the remaining opening parentheses, and the number closing of the remaining closing parentheses. When both  opening and  closing (initially n ) are zero, no parenthesis is left and we have got a new match. If only  opening is zero, a new match is obtained by appending to prefix the remaining ')'s. Otherwise, we are safe to append to prefix a '(', subtract  opening by one, and carry on the process recursively. If there has been more '(' than ')' in the  prefix , we can also append to  prefix a ')', subtract  closing by one, and carry on the process recursively. By this means, all possible valid parentheses will be found*/
public class Solution{
	public List<String> generateParenthesis(int n) {
		ArrayList<String> parenthesis = new ArrayList<String>();
		genParenthesis("", n, n, Parenthesis);
		return parenthesis;
	}
	private void genParenthesis(String prefix, int opening, int closing, ArrayList<String> parenthesis) {
//the number of '('s cannot be greater than that of ')'s anytime
		if(opening > closing) return;
		if(opening == 0 && closing == 0) { //No '(' or ')' remaining
			parenthesis.add(prefix);
		}
		else if (opening == 0) { // No '(' remaining; the rest must be ')'s
			for (int i = 0; i < closing; i++)
				prefix += ")";
			parenthesis.add(prefix);
		}
		else { 
			genParenthesis(prefix + "(", opening - 1, closing, parenthesis);//adding '(' is safe all the time
			if (closing > opening)
				genParenthesis(prefix + ")", opening, closing - 1, parenthesis);		}//adding ')' only if more ')'s remaining
	}
}
			


