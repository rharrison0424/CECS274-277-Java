//Ryan Harrison
// CECS 274-05
// Prog 6-Binary Search Tree
// Due December 11, 2018

import java.util.ArrayList;

public class BST {
	
	private Node root;
	
	public BST() {
		
		root=null;
	}
	public void add(int v) {
		
		if(root==null) {
			
			root= new Node(v);
		}
		else {
			
			addtoNode(root,v);
		}
	}
	private void addtoNode(Node n, int v) {
		
		if(v <= n.getValue()) {
			if(n.getLeft()==null) {
				
				n.lChild= new Node(v);
			}
			else {
				
				addtoNode(n.lChild, v);
			}
		}
		else {
			
			if(n.getRight()==null) {
				
				n.rChild= new Node(v);
			}
			else {
				
				addtoNode(n.rChild, v);
			}
		}
	}
	public void printInOrder() {
		
		LNRtraversal(root);
	}
	private void LNRtraversal(Node n){
		
		if(n==null) {
			
			return;
		}
		else {
			
			LNRtraversal(n.lChild);
			n.display();
			LNRtraversal(n.rChild);
		}
	}
	public int height() {
		
		return height(root);
	}
	private int height(Node n) {
		
		if(n==null) {
			
			return 0;
		}
		else {
			
			return 1 + ((height(n.lChild) > height(n.rChild))?height(n.lChild):height(n.rChild));
		}
	}
	public int heightNode(int v) {
		
		return heightNode(root, v);
	}
	private int heightNode(Node n, int v) {
		
		if(n.getValue()==v) {
			return 1;
		}
		else {
			
			if(v < n.getValue()) {
				
				return 1 + heightNode(n.lChild, v);
			}
			else {
				
				return 1 + heightNode(n.rChild, v);
			}
			
		}
	}
	public int find(int x) {
		
		return find(x, root);
	}
	private int find(int x, Node n) {
		
		if(n==null) {
			
			return 0;
		}
		else if(n.getValue()==x) {
			
			return heightNode(x);
		}
		else {
			
			if(x<n.getValue()) {
				
				return find(x, n.lChild);
			}
			else {
				
				return find(x, n.rChild);
			}
		}
	}
	public int count() {
		
		return count(root);
	}
	private int count(Node n) {
		
		if(n==null) {
			
			return 0;
		}
		else {
			
			return 1 + count(n.lChild) + count(n.rChild);
		}
	}
	public int [] BSTtoArray() {
		
		int [] valuesArray= new int[32];
		for(int i=0; i<32; i++) {
			
			valuesArray[i]=0;
		}
		return makeArray(root, 1, valuesArray);
	}
	private int [] makeArray(Node n, int i, int [] valuesArray) {
		
		if(n != null) {
			
			int height=heightNode(n.getValue());
			if(height<6) {
				
				valuesArray[i]=n.getValue();
				makeArray(n.lChild, 2*i, valuesArray);
				makeArray(n.rChild, 2*i+1, valuesArray);
			}
		}
		return valuesArray;		
	}
	public void display(int [] array) {
		
		System.out.println("                                                  " + array[1]);
		System.out.println("                                                   " + "|");
		System.out.println("                        " + array[2] + "-------------------------^----------------------- " + array[3]);
		System.out.println("                         " + "|" + "                                                   " + "|");
		System.out.println("            " + array[4] + "-----------^-----------" + array[5] + "                         " + array[6] + "-----------^-----------" + array[7]);
		System.out.println("             " + "|" + "                        " + "|" +"                          " + "|" + "                       " + "|");
		System.out.println("        " + array[8] + "----^----" + array[9] + "            " + array[10] + "----^----" + array[11] + "              " + array[12] + "----^----"+ array[13] + "           " + array[14] + "----^----" + array[15]);
		System.out.println("        " + "|" + "         " + "|" + "             " + "|" + "           " + "|" + "              " + "|" + "           " + "|" + "            "+ "|" + "          " + "|");
		System.out.println("      " + array[16] + "-^-" + array[17] + "    "+ array[18] + "-^-" +array[19] + "       " + array[20]+ "-^-" + array[21] + "     " + array[22] + "-^-" + array[23] + "        " + array[24] + "-^-" + array[25]+ "     " + array[26] + "-^-" + array[27] + "      " + array[28]+ "-^-" + array[29] + "    " + array[30] + "-^-" + array[31]);
	}
	/**
	 * 
	 */
	public void displayEmptyTree() {
		
		System.out.println("                                                  " + 0);
		System.out.println("                                                  " + "|");
		System.out.println("                        " + 0 + "-------------------------^----------------------- " + 0);
		System.out.println("                        " + "|" + "                                                  " + "|");
		System.out.println("            " + 0 + "-----------^-----------" + 0 + "                         " + 0 + "-----------^-----------" + 0);
		System.out.println("             " + "|" + "                      " + "|" +"                        " + "|" + "                        " + "|");
		System.out.println("        " + 0 + "----^----" + 0 + "            " + 0 + "----^----" + 0 + "              " + 0 + "----^----"+ 0 + "              " + 0 + "----^----" + 0);
		System.out.println("        " + "|" + "         " + "|" + "             " + "|" + "        " + "|" + "              " + "|" + "          " + "|" + "             "+ "|" + "         " + "|");
		System.out.println("      " + 0 + "-^-" + 0 + "     "+ 0 + "-^-" +0 + "         " + 0+ "-^-" + 0 + "    " + 0 + "-^-" + 0 + "          " + 0 + "-^-" + 0+ "      " + 0 + "-^-" + 0 + "          " + 0+ "-^-" + 0 + "    " + 0 + "-^-" + 0);
		
	}
	public void init() {
		
		int [] BSTarray= {48, 24, 76, 13, 35, 60, 91, 3, 19,30, 41, 53, 69, 84, 97, 2, 9, 15, 20, 27, 33, 39, 45, 50, 55, 65, 72, 80, 88, 95, 100};
		
		for(int i=0; i<31; i++) {
			
			add(BSTarray[i]);
		}
				
	}
	public void remove(int x) {
		
		remove(root, x);
	}
	private void remove(Node n, int x) {
		
		
		if(x < n.getValue() && (n.getLeft() != null)) {
	
			remove(n.lChild,x);
		}
		else if(x>n.getValue() && (n.getRight() != null)){
			
			remove(n.rChild,x);
		}
		else if(x==n.getValue()){
			
			if(root.getValue()==x && root.getLeft()==null && root.getRight()==null) {
				
				root=null;
			}
			else if(root.getValue()==x && root.getLeft()!=null && root.getRight()==null) {
				
				Node successor= root;
				successor=successor.getLeft();
				if(successor.getLeft()==null && successor.getRight()==null) {
					
					int tempInt=successor.getValue();
					successor.setValue(root.getValue());
					root.setValue(tempInt);	
					root.setLeft(null);
					
				}
				else {
				while(successor.getRight() != null) {
					
					successor=successor.getRight();
				}
				Node tempNode= parent(successor.getValue());
				int tempInt=successor.getValue();
				successor.setValue(root.getValue());
				root.setValue(tempInt);	
                if(successor.getLeft()==null && successor.getRight()==null) {
					
					if(successor.getValue() < tempNode.getValue()) {
						
						tempNode.setLeft(null);
					}
					else {
						
						tempNode.setRight(null);
					}
				}
				else if(successor.getLeft()==null || successor.getRight()==null) {
					
	                if(successor.getValue() < tempNode.getValue()) {
						if(successor.getLeft()==null) {
							
							tempNode.setLeft(successor.getRight());
						}
						else {
							tempNode.setLeft(successor.getLeft());
						}
						
					}
					else {
						if(successor.getLeft()==null) {
							
							tempNode.setRight(successor.getRight());
						}
						else {
							tempNode.setRight(successor.getLeft());
						}
				   }
				}
				}
			}
			else if(root.getValue()==x && root.getLeft()==null && root.getRight()!=null) {
				
				Node successor= root;
				successor=successor.getRight();
				if(successor.getLeft()==null && successor.getRight()==null) {
					
					int tempInt=successor.getValue();
					successor.setValue(root.getValue());
					root.setValue(tempInt);	
					root.setRight(null);
				}
				else {
					while(successor.getLeft() != null) {
						
						successor=successor.getLeft();
					}
					Node tempNode= parent(successor.getValue());
					int tempInt=successor.getValue();
					successor.setValue(root.getValue());
					root.setValue(tempInt);	
	                if(successor.getLeft()==null && successor.getRight()==null) {
						
						if(successor.getValue() < tempNode.getValue()) {
							
							tempNode.setLeft(null);
						}
						else {
							
							tempNode.setRight(null);
						}
					}
					else if(successor.getLeft()==null || successor.getRight()==null) {
						
		                if(successor.getValue() < tempNode.getValue()) {
							if(successor.getLeft()==null) {
								
								tempNode.setLeft(successor.getRight());
							}
							else {
								tempNode.setLeft(successor.getLeft());
							}
							
						}
						else {
							if(successor.getLeft()==null) {
								
								tempNode.setRight(successor.getRight());
							}
							else {
								tempNode.setRight(successor.getLeft());
							}
					   }
					}
				}
			}
				
			else if(n.getLeft()==null && n.getRight()==null) {
				
				Node p= parent(x);
				if(n.getValue() < p.getValue()) {
					
					p.setLeft(null);
				}
				else {
					
					p.setRight(null);
				}
			}
			else if(n.getLeft()==null || n.getRight()==null) {
				
				Node p= parent(x);
                if(n.getValue() < p.getValue()) {
					if(n.getLeft()==null) {
						
						p.setLeft(n.getRight());
					}
					else {
						p.setLeft(n.getLeft());
					}
					
				}
				else {
					if(n.getLeft()==null) {
						
						p.setRight(n.getRight());
					}
					else {
						p.setRight(n.getLeft());
					}
			   }
			
		   }
			else {
				
				Node successor= n;
				successor=successor.getRight();
				while(successor.getLeft() != null) {
					
					successor=successor.getLeft();
				}
				Node tempNode= parent(successor.getValue());
				int tempInt= successor.getValue();
				successor.setValue(n.getValue());
				n.setValue(tempInt);	
                if(successor.getLeft()==null && successor.getRight()==null) {
					
					if(successor.getValue() < tempNode.getValue()) {
						
						tempNode.setLeft(null);
					}
					else {
						
						tempNode.setRight(null);
					}
				}
				else if(successor.getLeft()==null || successor.getRight()==null) {
					
	                if(successor.getValue() < tempNode.getValue()) {
						if(successor.getLeft()==null) {
							
							tempNode.setLeft(successor.getRight());
						}
						else {
							tempNode.setLeft(successor.getLeft());
						}
						
					}
					else {
						if(successor.getLeft()==null) {
							
							tempNode.setRight(successor.getRight());
						}
						else {
							tempNode.setRight(successor.getLeft());
						}
				   }
				}
			}
		}
		else{
			
			System.out.println("That number was not found in the tree.");
	    }
}
	
	public Node parent(int x) {
		
		return parent(root,x);
	}
	private Node parent(Node n, int x) {
		
		if(root==null) {
			
			return null;
		}
		 if((x<n.getValue()) && (n.getLeft().getValue() != x)) {
			
			return parent(n.lChild, x);
		}
		else if(x>n.getValue() && (n.getRight().getValue() != x)){
			
			return parent(n.rChild,x);
		}
		else{
			
			return n;
		}
	}
	public void rootValue() {
		
		System.out.println(root.getValue());
	}
	public Node getRoot(){
		
		return root;
	}
	public boolean isEmpty() {
		
		if(root==null) {
			
			return true;
		}
		return false;
	}
	public class Node{
		
		private int value;
		private Node lChild;
		private Node rChild;
		
		public Node(int v) {
			
			value=v;
			rChild=null;
			lChild=null;
		}
		public int getValue() {
			
			return value;
		}
		public void setLeft(Node n) {
			
			lChild=n;
		}
		public void setRight(Node n) {
			
			rChild=n;
		}
		public void setValue(int newValue) {
			
			value=newValue;
		}
		public Node getLeft() {
			
			return lChild;
		}
		public Node getRight() {
			
			return rChild;
		}
		public void display(){
			
			System.out.print(value + " ");
		}
	}
}

