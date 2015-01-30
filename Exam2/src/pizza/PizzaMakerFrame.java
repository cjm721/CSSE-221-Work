package pizza;

import java.awt.GridLayout;
import javax.swing.JFrame;


/**
 * Frame on which to display menu and pizza
 *
 */
public class PizzaMakerFrame extends JFrame {
	
	/**
	 * Pizza to display
	 */
	private Pizza myPizza;
	/**
	 * Menu Panel
	 */
	private PizzaMakerMenu menu;
	
	/**
	 * Toppings listener that will respond to all changes that are made;
	 */
	private Listener toppingsListener;

	/**
	 * Constructs a PizzaMakerFrame
	 */
	public PizzaMakerFrame() {
		// TODO 2.a Add your name to the frame's Title.
		super("Pizza Maker, by millerc5");
		this.myPizza = new Pizza();
		this.toppingsListener = new Listener(this.myPizza);
		this.menu = new PizzaMakerMenu(this.myPizza, this.toppingsListener);
		this.toppingsListener.setMenuToChange(this.menu);

		this.setLayout(new GridLayout(2, 1));
		this.add(this.menu);
		this.add(this.myPizza);
	}
}
