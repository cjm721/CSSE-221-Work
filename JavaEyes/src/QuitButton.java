import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * A button that the user can press to exit the application.
 *
 * @author David Mutchler and many others before him.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class QuitButton extends JButton implements ActionListener {
	
	private static final Color DEFAULT_COLOR = Color.yellow;
	private static final Dimension DEFAULT_SIZE = new Dimension(250, 50); // in pixels
	
	/**
	 * Construct the button using the specified name.
	 * Set its size and background to the defaults.
	 * Ask it to respond to its own button-presses.
	 *
	 * @param name The name to be used as the label for the button.
	 */
	public QuitButton(String name) {
		super(name);
		
		this.setPreferredSize(QuitButton.DEFAULT_SIZE);	// Size of button
		this.setBackground(QuitButton.DEFAULT_COLOR);	// Color of button
		
		this.addActionListener(this);
	}
	
	/**
	 * Exit the application when the button is pressed.
	 *
	 * @param event ActionEvent that the button experienced (presumably a button-press).
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		System.exit(0);
	}
}
