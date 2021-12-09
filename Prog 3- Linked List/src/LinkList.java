public class LinkList {
	private Node head;    //declare a private node head that represents the beginning of the link list
	
	public LinkList() {
		
		head=null;
	}
	public int size() {    //this function returns the size of the link list
		int count=0;
		Node curr=head;
		while (curr != null) {
			count++;
			curr=curr.getNext();
		}
		return count;
	}
	public int average() {   //this function returns the average of all the numbers in the link list
		int sum=0;
		int count=0;
		Node curr=head;
		while (curr != null) {
			count++;
			sum+=curr.getValue();
			curr=curr.getNext();
		}
		return sum/count;
	}
	public boolean isEmpty() {   //this function will check to see if the list is empty
		if (head==null) {
			return true;
		}
		return false;
	}
	public void display() {      //this function will display each value of each node in the link list
		int count=0;
		Node curr=head;
		while (curr != null){
			while (count<10 && curr != null) {    //it will display the value in rows of 10
				curr.display();
				System.out.print(" ");
				curr=curr.getNext();
				count++;
			}
			count=0;
			System.out.print("\n");
		}
	}
	public int findNumber(int number) {      //this function will see if a number given by the user is in the link list
		Node curr=head;
		int position=0;
		while (curr.getValue()<=number && curr != null) {
			position++;
			if (curr.getValue()==number) {
				return position;
			}
			curr=curr.getNext();
		}
		return 0;
	}
	public int add(int x) {   //this function will sort and add values to the link list from smallest to largest
		Node temp=new Node(x);
		Node curr,prev;
		int position=1;
		if (head==null) {  // this is case 1, if there is currently nothing in the link list
			head=temp;
			return position;
		}
		else if (temp.getValue()<=head.getValue()) {  // case 2 is if there is only one value in the link list
			temp.setNext(head);
			head=temp;
			return position;
		}
		else {
			curr=head;
			while (curr.getValue() < x && curr != null) {   //case 3 will add a value between two other values in the link list
				prev=curr;
				position++;
				if (curr.getNext()==null) {
					prev.setNext(temp);
					temp.setNext(null);
					return position;
				}
				else{                       //case 4 is if the value is being added to the very end of the link list
					curr=curr.getNext();
					if (x<=curr.getValue() && x>=prev.getValue()) {
						prev.setNext(temp);
						temp.setNext(curr);
						return position;
					}
				}
			}
		}
		return 0;
	}
	public int remove(int p) {   //this function will remove a value from the list
		int count=1;
		Node curr,prev;
		curr=head;
		prev=null;
		while (count != p) {
			prev=curr;
			curr=curr.getNext();
			count++;
		}
		if (count==1) {
			head=curr.getNext();
		}
		else{
			prev.setNext(curr.getNext());
		}
		return curr.getValue();
	}
}
	



