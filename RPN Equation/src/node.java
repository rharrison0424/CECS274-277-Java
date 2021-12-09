//Ryan Harrison
// CECS 274-05
// Prog 4- RPN Equation
// Due November 26, 2018
public class node {
	    private String operator;                   //declare a private integer and node for the Node class
		private node next;
		private double value;
		

		
		
		public node(String c) {
			operator=c;
			next=null;
		}
		public node(double v) {
			value=v;
			next=null;
		}
		public String getOperator() {
			return operator;
		}
		public void setNext(node n) {
			next=n;                   //this will have the given node point to the next node in the list 
		}
		public node getNext() {
			return next;          //this returns the next node in the list

		}
		public double getInteger() {
			return  value;
		}
		
	}


