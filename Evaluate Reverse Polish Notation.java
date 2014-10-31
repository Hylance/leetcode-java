/* Evaluate Reverse Polish Notation: Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid operators are +, -, *, /. Each operand may be an integer or another expression. Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
public class Solution{
	public int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		String operators = "+-*/";
		for(String token : tokens) {
			if (!operators.contains(token)){
				s.push(Integer.valueOf(token));
				continue;
			}
			int a = s.pop();
			int b = s.pop();
			if (token.equals("+") {
				s.push( b + a);
			}
			if (token.equals("-") {
				s.push(b - a);
			}
			if (token.equals("*") {
				s.push(b * a);
			}
			if (token.equals("/") {
				s.push( b / a);
			}
		}
		return s.pop();
	}
}
