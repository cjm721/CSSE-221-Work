import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * TODO Auto-generated class description.
 *
 * @author David Mutchler and many others before him.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class StopButton extends JButton implements ActionListener {
	
	private static final Color DEFAULT_COLOR = Color.MAGENTA;
	private AnimatedPanel squarePanel;	// The panel to be animated

	/**
	 * Construct the button using the given name
	 * and store the given AnimatedPanel.
	 * Set the button's background to the default.
	 * Ask the button to respond to its own button-presses.
	 *
	 * @param title The name to be used as the label for the button.
	 * @param panel The panel to be stopped by pressing this button.
	 */
	public StopButton(String title, AnimatedPanel panel) {
		super(title);
		
		this.squarePanel = panel;
		this.setBackground(StopButton.DEFAULT_COLOR);
		this.addActionListener(this);
	}
	
	/**
	 * Stop the animation in this button's associated AnimatedPanel.
	 *
	 * @param event ActionEvent that the button experienced (presumably a button-press).
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		this.squarePanel.stop();
	}
}

