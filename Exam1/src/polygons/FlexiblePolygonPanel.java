package polygons;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 * Constructs a panel on which a polygon will be created and displayed. End
 * points are added to the containing FlexiblePolygon's list of points when the
 * user releases the mouse. The FlexiblePolygon is then drawn by the Graphics
 * object associated with this panel.
 * 
 * @author defoe. Created Oct 2, 2013.
 */
public class FlexiblePolygonPanel extends JPanel implements MouseListener {

	private FlexiblePolygon polygon;

	/**
	 * Constructs a FlexiblePolygonPanel for the given FlexiblePolygon.
	 * 
	 * @param polygon
	 */
	public FlexiblePolygonPanel(FlexiblePolygon polygon) {
		this.polygon = polygon;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.polygon.draw(g2);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Nothing to do here.

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Nothing to do here.

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Nothing to do here.

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// Nothing to do here.

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.polygon.addPoint(arg0.getPoint());
		repaint();

	}

}
