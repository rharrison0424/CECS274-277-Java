package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import BackEnd.TeaItem;
import BackEnd.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * the TeaOrderFrame class that constructs a GUI frame to purchase a tea
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class TeaOrderFrame extends JFrame {
	
	private JButton cancelButton;
	private JButton saveButton;
	private JPanel panel;
	private JLabel instructions;
	private JCheckBox topping1;
	private JCheckBox topping2;
	private JCheckBox topping3;
	private JCheckBox topping4;
	private JCheckBox topping5;
	private JCheckBox topping6;
	
	private JComboBox<String> flavorOptions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sweetnessOptions;
	private JComboBox<String> milkOptions;
	
	private static final int FRAMEWIDTH = 850;
	private static final int FRAMEHEIGHT = 400;
	
	private ArrayList<Item> currentOrder;
	
	/**
	 * constructs TeaOrderFrame based and passes in an arraylist containing the current order to be used later
	 *@param currentOrder- a array list that contains all the items in the current order
	 * **/
	public TeaOrderFrame(ArrayList<Item> currentOrder) {
		
		createComponents();
		this.currentOrder = currentOrder;
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setTitle("New Tea Order");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * a private method that creates all the attributes of the GUI frame, including
	 * instructions, flavor options, size options, sweetness options, milk options, 
	 * a save button and cancel button and 6 topping check boxes
	 * **/
	private void createComponents() {
		
	    instructions = new JLabel("Specify the Tea Order: ");
		
		String [] flavors = {"Green Tea", "Black Tea", "Jasmine Green Tea", "Rose Tea", "Oolong Tea"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String [] sizes = {"S", "M", "L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String [] sweetness = {"unsweetened", "1/4", "1/2", "3/4", "full"};
		sweetnessOptions = new JComboBox<String>(sweetness);
		
		String [] milk = {"whole milk", "half-and-half", "no milk"};
		milkOptions = new JComboBox<String>(milk);
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		ActionListener saveListener = new SaveButtonListener();
		saveButton.addActionListener(saveListener);
		
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		
		topping1 = new JCheckBox("boba");
		topping2 = new JCheckBox("popping boba");
		topping3 = new JCheckBox("grass jell");
		topping4 = new JCheckBox("lychee jelly");
		topping5 = new JCheckBox("coconut jelly");
		topping6 = new JCheckBox("mini mochi");
		
		
		panel = new JPanel();
		panel.add(instructions);
		panel.add(flavorOptions);
		panel.add(new JLabel("size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("sweetness: "));
		panel.add(sweetnessOptions);
		panel.add(new JLabel("milk: "));
		panel.add(milkOptions);
		panel.add(saveButton);
		panel.add(cancelButton);
		
		panel.add(topping1);
		panel.add(topping2);
		panel.add(topping3);
		panel.add(topping4);
		panel.add(topping5);
		panel.add(topping6);
		
		this.add(panel);
	}
	/**
	 * a class that implements action listener on the save button listener
	 * **/
	class SaveButtonListener implements ActionListener {
		
		/**
		 *checks to see if the save button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			setVisible(false);
			
			String flavor = (String) flavorOptions.getSelectedItem();
			String size = (String) sizeOptions.getSelectedItem();
			String sweetness = (String) sweetnessOptions.getSelectedItem();
			String milk = (String) milkOptions.getSelectedItem();
			
			TeaItem teaOrder = new TeaItem(size, flavor, sweetness, milk);	
			
			if(topping1.isSelected()) {
				
				teaOrder.addToppings(topping1.getText());
			}
			if(topping2.isSelected()) {
				
				teaOrder.addToppings(topping2.getText());
      		}
            if(topping3.isSelected()) {
				
				teaOrder.addToppings(topping3.getText());
      		}
            if(topping4.isSelected()) {
            	
            	teaOrder.addToppings(topping4.getText());
	        }
            if(topping5.isSelected()) {
				
				teaOrder.addToppings(topping5.getText());
      		}
            if(topping6.isSelected()) {
				
				teaOrder.addToppings(topping6.getText());
      		}
            
            teaOrder.setCost(teaOrder.calculateCost());
            currentOrder.add(teaOrder);
			
			NewOrderFrame orderFrame = new NewOrderFrame(currentOrder);
			
			orderFrame.updateComponents();
			orderFrame.writeOrder();
			orderFrame.setVisible(true);
			
		}
	}
	 /**
		 * a class that implements action listener on the cancel button listener
		 * **/
	class CancelButtonListener implements ActionListener {
		
		/**
		 *checks to see if the cancel button was clicked on the GUI
		 *@param click- an action event that checks if the button was clicked
		 * **/
		public void actionPerformed(ActionEvent click) {
			
			setVisible(false);
			
            NewOrderFrame orderFrame = new NewOrderFrame(currentOrder);
			
			orderFrame.updateComponents();
			orderFrame.writeOrder();
			orderFrame.setVisible(true);
		}
	}
}
