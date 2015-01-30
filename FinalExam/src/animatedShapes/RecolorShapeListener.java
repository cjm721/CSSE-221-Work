package animatedShapes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class creates listeners that recolor animated shapes
 *
 * @author defoe.
 *         Created Nov 2, 2012.
 */
public class RecolorShapeListener implements ActionListener {
	
	private AnimatedPanel world;

	/**
	 * Initializes a listener to reclor objects in the given world
	 * 
	 * @param world 
	 *
	 */
	public RecolorShapeListener(AnimatedPanel world) {
		this.world = world;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.world.recolorShapes();

	}

}
