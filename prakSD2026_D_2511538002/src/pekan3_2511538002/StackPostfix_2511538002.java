package pekan3_2511538002; 
import java.util.Scanner;
import java.util.Stack;

public class StackPostfix_2511538002 {
public static int postfixEvaluate_8002 (String expression) {
	Stack<Integer> s_8002 = new Stack<Integer>();
	Scanner input = new Scanner(expression);
	while (input.hasNext()) { 
		if (input.hasNext());
		if (input.hasNextInt()) { // an operqnd (integer)
			s_8002.push(input.nextInt()); 
		}else {
			String operator = input.next();
			int operand2 = s_8002.pop();
			int operand1 =s_8002.pop();
			if (operator.equals("+")) {
				s_8002.push(operand1 + operand2);
			} else if (operator.equals("-")) {
				s_8002.push(operand1 - operand2);
			} else if (operator.equals("*")) { 
			s_8002.push(operand1 * operand2); 
			} else {
				s_8002.push(operand1 / operand2);
			}
		}
	}
	input.close();
	return s_8002.pop();
}
	public static void main(String[] args) { 
		System.out.println("hasil postfix = " +postfixEvaluate_8002(" 5 2 4 * + 7 -"));
		

	}

}
