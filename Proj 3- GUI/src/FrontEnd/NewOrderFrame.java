package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import BackEnd.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * the NewOrderFrame class that constructs a GUI frame to purchase a coffee, tea, or pastry
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class NewOrderFrame extends JFrame {
	
	private JButton coffeeButton;
	private JButton teaButton;
	private JButton pastryButton;
	private JPanel panel;
	private JLabel instructions;
	private JTextArea order;
	private JButton doneButton;
	
	private double orderTotal = 0;
	
	private static final int FRAMEWIDTH = 500;
	private static final int FRAMEHEIGHT = 200;
	private static final int AREAROWS = 30;
	private static final int AREACOLUMNS = 60;
	private static final int NEWFRAMEHEIGHT = 600;
	private static final int NEWFRAMEWIDTH = 700;
	private static final double TAX = 0.10;
	
	private ArrayList<Item> currentOrder;
	
	/**
	 * constructs NewOrderFrame that has yet to add any items to the order
	 * **/
	public NewOrderFrame() {
		
		createComponents();
		this.setTitle("New Order");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * constructs NewOrderFrame based on the current items in the order
	 *@param currentOrder- a array list that contains all the items in the current order
	 * **/
	public NewOrderFrame(ArrayList<Item> currentOrder) {
		
		createComponents();
		this.currentOrder = currentOrder;
		this.setTitle("New Order");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * a private method that creates all the attributes of the GUI frame, including
	 * a coffee button, tea button, pastry button, and instructions
	 * **/
	private void createComponents() {
		
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		coffeeButton = new JButton("Coffee");
		teaButton = new JButton("Tea");
		pastryButton = new JButton("Pastry");
		instructions = new JLabel("Select an item to purchase: ");
		
		ActionListener coffeeListener = new CoffeeButtonListener();
		coffeeButton.addActionListener(coffeeListener);
		
		ActionListener teaListener = new TeaButtonListener();
		teaButton.addActionListener(teaListener);
		
		ActionListener pastryListener = new PastryButtonListener();
		pastryButton.addActionListener(pastryListener);
		
		panel = new JPanel();
		panel.add(instructions);
		panel.add(coffeeButton);
		panel.add(teaButton);
		panel.add(pastryButton);
		this.add(panel);
	}
	/**
	 * a private method that updates the GUI with new attributes, including
	 * a new width and height, a textBox and a done button
	 * **/
	public void updateComponents(){
		
		if(currentOrder.size() > 0) {
		
		    this.setSize(NEWFRAMEWIDTH, NEWFRAMEHEIGHT);
			order = new JTextArea(AREAROWS, AREACOLUMNS);
			order.setEditable(false);
			order.setText("-------------------------------------------------------------------------Current Order-------------------------------------------------------------------------\n\n");

			JScrollPane scrollPane = new JScrollPane(order);
			panel.add(scrollPane);
		}
		
			doneButton = new JButton("Done");
			
			ActionListener doneListener = new DoneButtonListener();
			doneButton.addActionListener(doneListener);
			
			panel.add(doneButton);
			this.add(panel);
	}
	/**
	 * a private method that writes the current order to the text box
	 * **/
	public void writeOrder() {
		
		for (int i = 0; i < currentOrder.size(); i++) {
			
			order.append(currentOrder.get(i).toString() + "\n\n");
			orderTotal += currentOrder.get(i).getCost();
		}
		double tax = orderTotal * TAX;
		double grandTotal = orderTotal + tax;
		
		order.append("\n\nSubtotal: \t\t" + String.format("$%.2f", orderTotal));
		order.append("\nTax: \t\t" + String.format("$%.2f", tax));
		order.append("\nGrand Total: \t\t" + String.format("$%.2f", grandTotal));
	}
	/**
	 * a class that implements action listener on the coffee button listener
	 * **/
	class CoffeeButtonListener implements ActionListener {
		
		/**
		 *checks to see if the coffee button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			CoffeeOrderFrame c = new CoffeeOrderFrame(currentOrder);
			c.setVisible(true);
			setVisible(false);
		}
	}
	/**
	 * a class that implements action listener on the tea button listener
	 * **/
	class TeaButtonListener implements ActionListener {
		
		/**
		 *checks to see if the tea button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			TeaOrderFrame t = new TeaOrderFrame(currentOrder);
			t.setVisible(true);
			setVisible(false);
		}
	}
	/**
	 * a class that implements action listener on the pastry button listener
	 * **/
	class PastryButtonListener implements ActionListener {
		
		/**
		 *checks to see if the pastry button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			PastryOrderFrame p = new PastryOrderFrame(currentOrder);
			p.setVisible(true);
			setVisible(false);
		}
	}
	/**
	 * a class that implements action listener on the done button listener
	 * **/
    class DoneButtonListener implements ActionListener {
		
    	/**
		 *checks to see if the done button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			if (currentOrder.size() == 0) {
				
				dispose();
				System.exit(1);
			}
			else {
				
				FinalizeOrderFrame finalFrame = new FinalizeOrderFrame(currentOrder);
				finalFrame.setVisible(true);
				setVisible(false);
			}
		}
	}
    /**
	 * the main implementation of the GUI that creates an array list to store all the items
	 * in the current order and creates a NewOrderFrame
	 * **/
	public static void main(String[] args) {
		
		ArrayList<Item> newOrder = new ArrayList<Item>();
		NewOrderFrame frame = new NewOrderFrame(newOrder);
		frame.setVisible(true);
	}
}
