import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Creates button that when pressed starts a thread to move the box around.
 * More clicks increases the amount the box moves.
 *
 * @author Defoe.
 *         Created Sep 10, 2013.
 */
public class StartButton extends JButton implements ActionListener {
	
	private static final Color DEFAULT_COLOR = Color.GREEN;
	private AnimatedPanel squarePanel;
	private boolean hasBeenPressed;
	
	/**
	 * Passes title to super constructor and sets up the Action Listener.
	 *
	 * @param title
	 * @param panel
	 */
	public StartButton(String title, AnimatedPanel panel) {
		super(title);
		
		this.squarePanel = panel;
		this.hasBeenPressed = false;
		
		this.setBackground(StartButton.DEFAULT_COLOR);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Create a new thread for the panel and start it running, all in one shot
		(new Thread(this.squarePanel)).start();
		
		this.hasBeenPressed = true;
	}
	
	/**
	 * Returns the current state of the button.
	 *
	 * @return boolean of hasBeenPressed
	 */
	public boolean hasBeenPressed() {
		return this.hasBeenPressed;
	}
}
