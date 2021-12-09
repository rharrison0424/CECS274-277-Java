import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class main {
	
	public static int getPrecedence(String operator) {
		
		if(operator.equals("(")) {
			return 0;
		}
		
	 else if(operator.equals("^")) {
			return 5;
		}
		else if(operator.equals("*")) {
			return 4;
		}
		else if(operator.equals("/")) {
			return 3;
		}
		else if(operator.equals("+")) {
			return 2;
		}
		else if (operator.equals("-")) {
			return 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String expr;
		System.out.print("Enter your equation:");
		expr = in.nextLine();
		
		boolean value=false;
		while(value != true) {
			boolean enterLoop=false;
		for(int i=0; i<expr.length(); i++) {
			
			if((expr.charAt(i)=='+' || expr.charAt(i)=='-' || expr.charAt(i)=='*' || expr.charAt(i)=='/' || expr.charAt(i)=='^') && (expr.charAt(i+1)=='+' || expr.charAt(i+1)=='-' || expr.charAt(i+1)=='*' || expr.charAt(i+1)=='/' || expr.charAt(i+1)=='^')) {
				System.out.println("The equation entered is incorrect. Please enter a new equation:");
				expr = in.nextLine();
				enterLoop=true;
			}
		}
		if(enterLoop != true) {
			value=true;
		}
	}
		
		String exprCopy=expr;
		
		exprCopy = exprCopy.replaceAll("\\+", " + ");
		exprCopy = exprCopy.replaceAll("\\-", " - ");
		exprCopy = exprCopy.replaceAll("\\*", " * ");
		exprCopy = exprCopy.replaceAll("\\/", " / ");
		exprCopy = exprCopy.replaceAll("\\(", " ( ");
		exprCopy = exprCopy.replaceAll("\\)", " ) ");
		exprCopy = exprCopy.replaceAll("\\^", " ^ ");
		
		String delims = "[ ]+";
		String[] token = exprCopy.split(delims);
		
		ArrayList<String> RPN= new ArrayList<String>();
		Stack operatorStack=new Stack();
		int size;
		for(int i=0; i<token.length; i++) {
			String curr= token[i];
			
			
	        if("".equals(curr)) {
	        	operatorStack.addtoFront(curr);
	        	operatorStack.pop();
	        }
	        else if(curr.equals("(")) {
				operatorStack.addtoFront(curr);
			}
			else if(curr.equals(")")) {
				String operator=operatorStack.topOperator();
				while(!operator.equals("(")) {
					RPN.add(operator);
					operatorStack.pop();
					operator=operatorStack.topOperator();
				}
				operatorStack.pop();
			}
			else if(curr.equals("+")) {
				int plusprecedence=getPrecedence("+");
				value=false;
				while(value != true) {
					size=operatorStack.size();
				if(size==0) {
					operatorStack.addtoFront(curr);
					value=true;
				}
				else{
					String top=operatorStack.topOperator();
					int headprecedence=getPrecedence(top);
					if(plusprecedence>headprecedence) {
						operatorStack.addtoFront(curr);
						value=true;
					}
					else{
						top=operatorStack.topOperator();
						RPN.add(top);
						operatorStack.pop();
					}
					}
				}
				
			}
			else if(curr.equals("-")) {
				int minusprecedence=getPrecedence("-");
				value=false;
				while(value != true) {
					size=operatorStack.size();
				if(size==0) {
					operatorStack.addtoFront(curr);
					value=true;
				}
				else{
					String top=operatorStack.topOperator();
					int headprecedence=getPrecedence(top);
					if(minusprecedence>headprecedence) {
						operatorStack.addtoFront(curr);
						value=true;
					}
					else{
						top=operatorStack.topOperator();
						RPN.add(top);
						operatorStack.pop();
						
					}
					}
				}
				
				
			}
			else if(curr.equals("*")) {
				int timesprecedence=getPrecedence("*");
				value=false;
				while(value != true) {
					size=operatorStack.size();
				if(size==0) {
					operatorStack.addtoFront(curr);
					value=true;
				}
				else{
					String top=operatorStack.topOperator();
					int headprecedence=getPrecedence(top);
					if(timesprecedence>headprecedence) {
						operatorStack.addtoFront(curr);
						value=true;
					}
					else {
						top=operatorStack.topOperator();
						RPN.add(top);
						operatorStack.pop();
						
					}
					}
				}
				
			}
			else if(curr.equals("/")) {
				int divideprecedence=getPrecedence("/");
				value=false;
				while(value != true) {
					size=operatorStack.size();
				if(size==0) {
					operatorStack.addtoFront(curr);
					value=true;
				}
				else{
					String top=operatorStack.topOperator();
					int headprecedence=getPrecedence(top);
					if(divideprecedence>headprecedence) {
						operatorStack.addtoFront(curr);
						value=true;
					}
					else {
						top=operatorStack.topOperator();
						RPN.add(top);
						operatorStack.pop();
						
					}
					}
				}
				
			}
			else if(curr.equals("^")) {
				int exponentprecedence=getPrecedence("^");
				value=false;
				while(value != true) {
					size=operatorStack.size();
				if(size==0) {
					operatorStack.addtoFront(curr);
					value=true;
				}
				else{
					String top=operatorStack.topOperator();
					int headprecedence=getPrecedence(top);
					if(exponentprecedence>headprecedence) {
						operatorStack.addtoFront(curr);
						value=true;
					}
					else {
						top=operatorStack.topOperator();
						RPN.add(top);
						operatorStack.pop();
					
					}
					}
				}
				
			}
			else {
				RPN.add(curr);
				
			}
			
			
		}
		while(operatorStack.isEmpty()==false) {
			String operator=operatorStack.topOperator();
			RPN.add(operator);
			operatorStack.pop();
		}
		System.out.print("RPN: ");
		for(int i=0; i<RPN.size();i++) {
			System.out.print(RPN.get(i)+ " ");
		}
		Stack integerStack= new Stack();
		for(int i=0; i<RPN.size();i++) {
			
			String curr=RPN.get(i);
			
			if(curr.equals("+")) {
				
				double second= integerStack.topNumber();
				integerStack.pop();
				double first= integerStack.topNumber();
				integerStack.pop();
				double result= first + second;
				integerStack.addIntToFront(result);
			}
			else if(curr.equals("-")) {
				
				double second= integerStack.topNumber();
				integerStack.pop();
				double first= integerStack.topNumber();
				integerStack.pop();
				double result= first - second;
				integerStack.addIntToFront(result);
			}
			else if(curr.equals("*")) {
				
				double second= integerStack.topNumber();
				integerStack.pop();
				double first= integerStack.topNumber();
				integerStack.pop();
				double result= first * second;
				integerStack.addIntToFront(result);
			}
			else if(curr.equals("/")) {
				
				double second= integerStack.topNumber();
				integerStack.pop();
				double first= integerStack.topNumber();
				integerStack.pop();
				double result= first / second;
				integerStack.addIntToFront(result);
			}
			else if(curr.equals("^")) {
				
				double second= integerStack.topNumber();
				integerStack.pop();
				double first= integerStack.topNumber();
				integerStack.pop();
				double result= Math.pow(first, second);
				integerStack.addIntToFront(result);
			}
			else if(curr.equals("")) {
				RPN.remove(i);
			}
			else {
				
				double number= Integer.parseInt(curr);
				integerStack.addIntToFront(number);
			}
		}
		double answer= integerStack.topNumber();
		if(answer%2==0 || answer%2==1) {
			int Integeranswer= (int) answer;
			System.out.println("\nAnswer: " + answer);
	}
		else {
			System.out.printf("\nAnswer: %.2f",answer);
		}
	}
}
