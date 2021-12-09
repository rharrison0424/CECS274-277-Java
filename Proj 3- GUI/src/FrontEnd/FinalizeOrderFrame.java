package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BackEnd.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

/**
 * the FinalizeOrderFrame class that constructs a GUI frame to finalize the order by displaying 
 * the grand total and allowing the user to enter a payment
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class FinalizeOrderFrame extends JFrame{
	
	private JButton paymentButton;
	private JButton exitButton;
	private JPanel panel;
	private JLabel amountDue;
	private JLabel payment;
	private JTextArea order;
	private JTextField paymentBox;
	
	private static final int FRAMEWIDTH = 700;
	private static final int FRAMEHEIGHT = 600;
	private static final int AREAROWS = 30;
	private static final int AREACOLUMNS = 60;
	private static final int FIELDWIDTH = 10;
	private static final double TAX = 0.10;
	
	private ArrayList<Item> currentOrder;
	private double orderTotal = 0;
	private double enteredPayment = 0;
	private double grandTotal = 0;
	
	/**
	 * constructs FinalizeOrderFrame based on the current items in the order
	 *@param currentOrder- a array list that contains all the items in the current order
	 * **/
	public FinalizeOrderFrame(ArrayList<Item> currentOrder) {
		
        for (int i = 0; i < currentOrder.size(); i++) {
			
			orderTotal += currentOrder.get(i).getCost();
		}
        double tax = orderTotal * TAX;
		grandTotal += orderTotal + tax;

		createComponents();
		this.setTitle("Finalize Order");
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        for (int i = 0; i < currentOrder.size(); i++) {
			
			order.append(currentOrder.get(i).toString() + "\n\n");
		}
		
		order.append("\n\nSubtotal: \t\t" + String.format("$%.2f", orderTotal));
		order.append("\nTax: \t\t" + String.format("$%.2f", tax));
		order.append("\nGrand Total: \t\t" + String.format("$%.2f", grandTotal));
	}
	/**
	 * a private method that creates all the attributes of the GUI frame, including
	 * the amount due, a box to enter the payment and a button to submit the payment
	 * **/
	private void createComponents() {
		
		amountDue = new JLabel("Amount Due: $" + String.format("%.2f", grandTotal));
		payment = new JLabel("Payment: $");
		
		paymentBox = new JTextField(FIELDWIDTH);
		
		paymentButton = new JButton("Pay");
		
		ActionListener payListener = new PayButtonListener();
		paymentButton.addActionListener(payListener);
		
		order = new JTextArea(AREAROWS, AREACOLUMNS);
		order.setEditable(false);
		order.setText("-------------------------------------------------------------------------Current Order-------------------------------------------------------------------------\n\n");

		JScrollPane scrollPane = new JScrollPane(order);
		
		panel = new JPanel();
		panel.add(amountDue);
		panel.add(scrollPane);
		panel.add(payment);
		panel.add(paymentBox);
		panel.add(paymentButton);
		this.add(panel);
     }
	/**
	 * a class that implements action listener on the pay button listener
	 * **/
     class PayButtonListener implements ActionListener {
		
    	 /**
 		 *checks to see if the pay button was clicked on the GUI
 		 *@param click- an action event that checks if the button was clicked
 		 * **/
		public void actionPerformed(ActionEvent click) {
			
			String stringPayment = paymentBox.getText();
			enteredPayment += Double.parseDouble(stringPayment);
			
			if (enteredPayment < grandTotal) {
				
				double remainingBalance = grandTotal - enteredPayment;
				amountDue.setText("Insufficient payment! Amount still due: $" + String.format("%.2f", remainingBalance));
			}
			else {
				
				double change = enteredPayment - grandTotal;
				
				amountDue.setText("Thank you!");
				
				order.append("\n\nPayment : $" + String.format("%.2f", enteredPayment));
				order.append("\nChange Due: $" + String.format("%.2f", change));
				order.append("\n-------------------------------------------------------------------------Thank You-------------------------------------------------------------------------\n\n");

				panel.remove(payment);
				panel.remove(paymentBox);
				panel.remove(paymentButton);
				
				exitButton = new JButton("Exit");
				
				ActionListener exitListener = new ExitButtonListener();
				exitButton.addActionListener(exitListener);
				
				panel.add(exitButton);
				add(panel);
				panel.revalidate();
				panel.repaint();
			}
		}
		/**
		 * a class that implements action listener on the exit button listener
		 * **/
		class ExitButtonListener implements ActionListener {
			
			 /**
	 		 *checks to see if the exit button was clicked on the GUI
	 		 *@param click- an action event that checks if the button was clicked
	 		 * **/
			public void actionPerformed(ActionEvent click) {
					
				dispose();
				System.exit(1);
			}
		}
     }
}
