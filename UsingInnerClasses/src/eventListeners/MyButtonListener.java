package eventListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class responds to button clicks.
 *
 * @author Curt Clifton.
 *         Created Oct 7, 2008.
 */
public class MyButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Ow! Too hot!");
	}

}