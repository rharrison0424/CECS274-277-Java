//Ryan Harrison
// CECS 274-05
// Prog 3-Linked List
// Due October 18, 2018

public class Node {
	private int value;   //declare a private integer and node for the Node class
	private Node next;
	
	public Node(int v) {
		value= v;                //the node contains a value
		next= null;
	}
	public int getValue() {
		return value;           //this returns the value for a certain node
	}
	public void setNext(Node n) {
		next=n;                   //this will have the given node point to the next node in the list 
	}
	public Node getNext() {
		return next;          //this returns the next node in the list
	}
	public void display() {
		System.out.print(value);   //this will display the value of a node
	}
}

