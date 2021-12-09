package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;


import BackEnd.CoffeeItem;
import BackEnd.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * the CoffeeOrderFrame class that constructs a GUI frame to purchase a coffee
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class CoffeeOrderFrame extends JFrame {
	
	private JButton cancelButton;
	private JButton saveButton;
	private JPanel panel;
	private JLabel instructions;
	private JTextField instructionsBox;
	
	private JComboBox<String> flavorOptions;
	private JComboBox<String> sizeOptions;
	private JComboBox<String> sugarTspOptions;
	private JComboBox<String> milkOptions;
	private JComboBox<String> tempOptions;
	
	private static final int FRAMEWIDTH = 800;
	private static final int FRAMEHEIGHT = 400;
	private static final int FIELDWIDTH = 50;
	
	private ArrayList<Item> currentOrder;
	
	/**
	 * constructs CoffeeOrderFrame based and passes in an arraylist containing the current order to be used later
	 *@param currentOrder- a array list that contains all the items in the current order
	 * **/
	public CoffeeOrderFrame(ArrayList<Item> currentOrder) {
		
		createComponents();
		this.currentOrder = currentOrder;
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setTitle("New Coffee Order");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	/**
	 * a private method that creates all the attributes of the GUI frame, including
	 * instructions. flavor options, size options, sugar options, milk options, temperature
	 * options, a special instructions box, and a save button and a cancel button
	 * **/
	public void createComponents() {
		
		instructions = new JLabel("Specify the Coffee Order: ");
		
		String [] flavors = {"Regular", "Mocha", "Hazelnut", "Vanilla"};
		flavorOptions = new JComboBox<String>(flavors);
		
		String [] sizes = {"S", "M", "L"};
		sizeOptions = new JComboBox<String>(sizes);
		
		String [] sugarTsp = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		sugarTspOptions = new JComboBox<String>(sugarTsp);
		
		String [] milk = {"whole milk", "half-and-half", "no milk"};
		milkOptions = new JComboBox<String>(milk);
		
		String [] temps = {"hot", "iced", "blended"};
		tempOptions = new JComboBox<String>(temps);
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		
		ActionListener saveListener = new SaveButtonListener();
		saveButton.addActionListener(saveListener);
		
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		
		instructionsBox = new JTextField(FIELDWIDTH);
		
		panel = new JPanel();
		panel.add(instructions);
		panel.add(new JLabel("flavor: "));
		panel.add(flavorOptions);
		panel.add(new JLabel("size: "));
		panel.add(sizeOptions);
		panel.add(new JLabel("sugar: "));
		panel.add(sugarTspOptions);
		panel.add(new JLabel("milk: "));
		panel.add(milkOptions);
		panel.add(new JLabel("type: "));
		panel.add(tempOptions);
		panel.add(new JLabel("special instructions: "));
		panel.add(instructionsBox);
		panel.add(saveButton);
		panel.add(cancelButton);
		
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
			String sweetness = (String) sugarTspOptions.getSelectedItem();
			String milk = (String) milkOptions.getSelectedItem();
			String temp = (String) tempOptions.getSelectedItem();
			String instructions = instructionsBox.getText();
			
			if (instructions.equals("")) {
				
				instructions = "none";
			}
			
			CoffeeItem coffeeOrder = new CoffeeItem(size, flavor, sweetness, milk, temp, instructions);	
			coffeeOrder.setCost(coffeeOrder.calculateCost());
			
			currentOrder.add(coffeeOrder);
			
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
