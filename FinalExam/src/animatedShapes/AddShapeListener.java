package animatedShapes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class constructs listeners for adding new shapes to the given world
 *
 * @author defoe.
 *         Created Nov 2, 2012.
 */
public class AddShapeListener implements ActionListener {
	
	private AnimatedPanel world;

	/**
	 * Initializes a listener with the given world 
	 *
	 * @param world
	 */
	public AddShapeListener(AnimatedPanel world) {
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String[] commandStrings = ae.getActionCommand().split(" ");
		String shapeName = commandStrings[1];
		this.world.addAShape(shapeName);
	}

}
