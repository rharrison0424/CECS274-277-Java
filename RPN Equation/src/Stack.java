
public class Stack {
	
	private node head;    //declare a private node head that represents the beginning of the link list
	
	public Stack() {
		
		head=null;
	}
	public int size() {    //this function returns the size of the link list
		int count=0;
		node curr=head;
		while (curr != null) {
			count++;
			curr=curr.getNext();
		}
		return count;
	}
	public boolean isEmpty() {   //this function will check to see if the list is empty
		if (head==null) {
			return true;
		}
		return false;
	}
	public void pop() {           //this function will remove a value from the list
		node curr=head;
		head=curr.getNext();
	}
	
	public void addtoFront(String c) {
		node temp= new node(c);
		temp.setNext(head);
		head=temp;
	}
	public void addIntToFront(double v) {
		node temp= new node(v);
		temp.setNext(head);
		head=temp;
	}
	public double topNumber() {
		return head.getInteger();
	}
	
	public String topOperator() {
		return head.getOperator();
	}
}
