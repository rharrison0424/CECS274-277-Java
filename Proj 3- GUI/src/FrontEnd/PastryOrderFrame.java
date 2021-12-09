package FrontEnd;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

import BackEnd.Item;
import BackEnd.PastryItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * the PastryOrderFrame class that constructs a GUI frame to purchase a pastry
 * @author-Ryan Harrison
 * @version- 1
 * @since- March 21, 2019
 * **/
public class PastryOrderFrame extends JFrame {
	
	private JButton cancelButton = new JButton("Cancel");
	private JButton saveButton = new JButton("Save");
	
	private JPanel panel;
	private JLabel instructions;
	private JCheckBox isHeated;
	
	private JComboBox<String> typeOptions;
	private JComboBox<String> flavorOptions;
	
	private static final int FRAMEWIDTH = 850;
	private static final int FRAMEHEIGHT = 400;
	
	private ArrayList<Item> currentOrder;
	
	/**
	 * constructs PastryOrderFrame based and passes in an arraylist containing the current order to be used later
	 *@param currentOrder- a array list that contains all the items in the current order
	 * **/
	public PastryOrderFrame(ArrayList<Item> currentOrder) {
		
		this.createComponents();
		this.currentOrder = currentOrder;
		this.setSize(FRAMEWIDTH, FRAMEHEIGHT);
		this.setTitle("Pastry Order");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	/**
	 * a private method that creates all the attributes of the GUI frame, including
	 * the type of pastry drop down menu and a cancel button
	 * **/
	private void createComponents() {
		
		instructions = new JLabel("heated: ");
		isHeated = new JCheckBox();
		
		String [] type = {"Muffin", "Cookie", "Cheesecake Slice", "Danish"};
		typeOptions = new JComboBox<String>(type);
		
		ActionListener cancelListener = new CancelButtonListener();
		cancelButton.addActionListener(cancelListener);
		
		ActionListener typeListener = new typeChangeListener();
		typeOptions.addActionListener(typeListener);
		
		ActionListener saveListener = new SaveButtonListener();
		saveButton.addActionListener(saveListener);
		
		panel = new JPanel();
		panel.add(typeOptions);
		panel.add(cancelButton);
		
		this.add(panel);
	}
	/**
	 * a private method that changes all the attributes of the GUI frame, adding
	 * flavor options drop down menu, heat check box, instructions, save and cancel button, 
	 * type options, and instructions
	 * **/
	private void changePastryFrame(JComboBox flavorOptions) {
		
		panel.removeAll();
		
		panel.add(typeOptions);
		panel.add(flavorOptions);
		panel.add(instructions);
		panel.add(isHeated);
		panel.add(saveButton);
		panel.add(cancelButton);
		
		add(panel);
		panel.revalidate();
		panel.repaint();
	}
	/**
	 * a class that implements action listener on the type change listener when
	 * a new type of pastry is selected from the drop down menu
	 * **/
	class typeChangeListener implements ActionListener {
		
		/**
		 *checks to see if the type of pastry drop down menu was changed
		 *@param click- an action event that checks if the type of pastry was changed in the drop down menu
		 * **/
		public void actionPerformed(ActionEvent change) {
			
			if (typeOptions.getSelectedItem().toString().equals("Muffin")) {
				
				String [] flavors = {"Banana Nut", "Blueberry", "Chocolate Chip", "Coffee Cake"};
				flavorOptions = new JComboBox<String>(flavors);
				
				changePastryFrame(flavorOptions);
			}
			else if (typeOptions.getSelectedItem().toString().equals("Cookie")) {
				
				String [] flavors = {"Oatmeal", "White Choco & Macadamias", "Chocolate Chip", "Double Fudge"};
				flavorOptions = new JComboBox<String>(flavors);
				
				changePastryFrame(flavorOptions);
			}
			else if (typeOptions.getSelectedItem().toString().equals("Cheesecake Slice")) {
				
				String [] flavors = {"Regular", "Cherry", "Blueberry"};
				flavorOptions = new JComboBox<String>(flavors);
				
				changePastryFrame(flavorOptions);
				
			}
			else {
				
				String [] flavors = {"Apple Cinnamon", "Strawberry & Cheese", "Double Cheese"};
				flavorOptions = new JComboBox<String>(flavors);
				
				changePastryFrame(flavorOptions);
				
			}
		}
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
			
			String type = (String) typeOptions.getSelectedItem();
			String flavor = (String) flavorOptions.getSelectedItem();
			
			boolean heated = isHeated.isSelected();
			
			PastryItem pastryOrder = new PastryItem(type, flavor, heated);
			
			pastryOrder.setCost(pastryOrder.calculateCost());
            currentOrder.add(pastryOrder);
			
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
