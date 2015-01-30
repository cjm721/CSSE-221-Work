package pizza;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

/**
 * This class provides an action listener for the buttons in PizzaMakerMenu
 * 
 */
public class Listener implements ChangeListener, ActionListener, ItemListener {

	private Pizza myPizza;
	private PizzaMakerMenu menu;

	/**
	 * Constructs a new instance of this class
	 * 
	 * @param myPizza
	 * 
	 */

	public Listener(Pizza myPizza) {
		this.myPizza = myPizza;
	}

	/**
	 * Sets the menu that this listener will change
	 *
	 * @param menu Menu to Change
	 */
	public void setMenuToChange(PizzaMakerMenu menu) {
		this.menu = menu;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (((JSlider) e.getSource()).getName().equals("Pepperoni Amount")) {
			// add pepperoni to pizza
			this.myPizza.setPepperoniesAmount(((JSlider) e.getSource())
					.getValue());
			this.menu.setSelect("Pepperoni");
			this.myPizza.repaint();
		}

		else if (((JSlider) e.getSource()).getName().equals("Sausage Amount")) {
			// add pepperoni to pizza
			this.myPizza
					.setSausagesAmount(((JSlider) e.getSource()).getValue());
			this.menu.setSelect("Sausage");
			this.myPizza.repaint();
		}
		else if (((JSlider) e.getSource()).getName().equals("Anchovies Amount")) {
			// add pepperoni to pizza
			this.myPizza.setAnchoviesAmount(((JSlider) e.getSource())
					.getValue());
			this.menu.setSelect("Anchovies");
			this.myPizza.repaint();
		} else {
			// Nothing to do here.
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JRadioButton) {
			String command = e.getActionCommand();
			if(command.equals("Large")){
				this.myPizza.setPizzaSize(1.0);
			}else if(command.equals("Medium")){
				this.myPizza.setPizzaSize(0.80);
			}else if(command.equals("Small")){
				this.myPizza.setPizzaSize(0.60);
			}else{
				System.out.println("Unknown pizza size: " + e.getActionCommand());
			}
		}
		this.myPizza.repaint();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (((JCheckBox) e.getSource()).getActionCommand().equals("Pepperoni")) {
			this.myPizza.setPepperoniesDesired((((JCheckBox) e.getSource())
					.isSelected()));
		}
		if (((JCheckBox) e.getSource()).getActionCommand().equals("Sausage")) {
			this.myPizza.setSausagesDesired((((JCheckBox) e.getSource())
					.isSelected()));
		}
		if (((JCheckBox) e.getSource()).getActionCommand().equals("Anchovies")) {
			this.myPizza.setAnchoviesDesired((((JCheckBox) e.getSource())
					.isSelected()));
		}
		this.myPizza.repaint();
	}

}
