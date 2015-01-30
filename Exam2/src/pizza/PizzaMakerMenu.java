package pizza;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

/**
 * This class builds a menu for the user to create his/her very own pizza!
 * 
 */

public class PizzaMakerMenu extends JPanel {
	
	private Pizza myPizza;
	private JPanel toppingsPanel;
	/**
	 * This class sets up the GUI for a {@link Pizza}
	 *
	 * @param myPizza
	 * @param listener 
	 */
	public PizzaMakerMenu(Pizza myPizza, Listener listener) {
		this.myPizza = myPizza;
		JPanel sizePanel = new JPanel();
		sizePanel.setBackground(Color.ORANGE);
		this.toppingsPanel = new JPanel();
		this.toppingsPanel.setBackground(Color.ORANGE);
		this.setBackground(Color.ORANGE);
		Listener toppingListener = listener;
		String[] pizzaSizes = { "Small", "Medium", "Large" };
		String[] pizzaToppings = {"Pepperoni", "Sausage", "Anchovies"};
		String[] toppingsAmount = {"Pepperoni Amount", "Sausage Amount", "Anchovies Amount"};

		// Add code for all GUI components here:
		ButtonGroup sizeGroup = new ButtonGroup();
		for (String size : pizzaSizes) {
			this.addPizzaSizeOptions(size, sizePanel, sizeGroup, toppingListener);
		}

		this.add(sizePanel);
		for (String topping : pizzaToppings){
			this.addPizzaToppingsOptions(topping, this.toppingsPanel, toppingListener);
		}
		this.add(this.toppingsPanel);
		
		for (String topping : toppingsAmount){
			this.addToppintsAmount(topping, toppingListener);
		}
		this.setVisible(true);
		// Click the small JRadioButton and update the pizza
		sizeGroup.getElements().nextElement().doClick();
		this.myPizza.repaint();
	}

	/**
	 * Adds the Pizza size menu options
	 *
	 * @param size
	 * @param panel
	 * @param menu
	 * @param listener
	 */
	public void addPizzaSizeOptions(String size, JPanel panel, ButtonGroup menu,
			Listener listener) {
		JRadioButton pizzaSizeButton = new JRadioButton(size);
		pizzaSizeButton.addActionListener(listener);
		menu.add(pizzaSizeButton);
		panel.add(pizzaSizeButton);
	}
	
	/**
	 * Adds the toppings options menu options
	 *
	 * @param topping
	 * @param panel
	 * @param listener
	 */
	public void addPizzaToppingsOptions(String topping, JPanel panel, Listener listener){
		JCheckBox toppingsCheckBox = new JCheckBox(topping);
		toppingsCheckBox.addItemListener(listener);
		panel.add(toppingsCheckBox);
	}
	
	/**
	 * Adds the toppings amount menu options
	 *
	 * @param topping
	 * @param listener
	 */
	public void addToppintsAmount(String topping, Listener listener){
		@SuppressWarnings("static-access")
		JSlider toppingsAmount = new JSlider(JSlider.HORIZONTAL, 1, 5, 1);
		toppingsAmount.setMajorTickSpacing(1);
		toppingsAmount.setPaintTicks(true);
		toppingsAmount.setPaintLabels(true);
		toppingsAmount.setName(topping);
		toppingsAmount.addChangeListener(listener);
		JLabel label = new JLabel(topping);
		this.add(label);
		this.add(toppingsAmount);
	}

	/**
	 * Make sure this menu component is selected
	 *
	 * @param string String that should match the text on this component.
	 */
	public void setSelect(String string) {
		Component[] components = this.toppingsPanel.getComponents();
	
		for(Component c : components){
			if (c instanceof JCheckBox && (((JCheckBox) c).getText()).equals(string)){
				JCheckBox checkbox = (JCheckBox) c;
				if (!checkbox.isSelected()){
				checkbox.doClick();
				}
				
			}
		}
		
	}

}
