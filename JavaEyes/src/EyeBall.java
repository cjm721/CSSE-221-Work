import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An EyeBall is intended to be inside an Eye.
 *
 * @author David Mutchler and many others before him.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class EyeBall {
	
	/**
	 * Color of this eyeball.
	 */
	protected Color eyeBallColor;
	
	/**
	 * Position of this eyeball, relative to the eye (in pixels).
	 */
	protected Point eyeBallPosition = new Point(25, 25);
	
	/**
	 * Radius of this eyeball.
	 */
	protected int eyeBallRadius = 6;
	
	/**
	 * Construct an eyeball with the given color.
	 * 
	 * @param eyeBallColor Color to which to set the eyeBall.
	 */
	public EyeBall(Color eyeBallColor) {
		this.eyeBallColor = eyeBallColor;
	}
	
	/**
	 * Draw this eyeball at its current position.
	 *
	 * @param graphics Graphics object onto which to draw.
	 */
	public void draw(Graphics graphics) {
		graphics.setColor(this.eyeBallColor);
		graphics.fillOval(this.eyeBallPosition.x - this.eyeBallRadius,
						  this.eyeBallPosition.y - this.eyeBallRadius,
						  2 * this.eyeBallRadius,
						  2 * this.eyeBallRadius);
	}
	
	/**
	 * Move the eyeball to the given position.
	 *
	 * @param x x-position to which to move the center of the eyeball, relative to the eye.
	 * @param y y-position to which to move the center of the eyeball, relative to the eye.
	 */
	public void look(int x, int y) {
		this.eyeBallPosition.x = x;
		this.eyeBallPosition.y = y;
		
		if (((x - y) * (x - y)) < 10) {
			if (Math.random() < 0.01) {
				/* Removed purposeful error
				// purposeful error, here for pedagogical reasons
				@SuppressWarnings("unused")
				int a = 100 / 0;
				*/
			}
		}
	}

	/**
	 * Return the radius of this EyeBall.
	 * 
	 * @return Returns the radius of this EyeBall.
	 */
	public int getRadius() {
		return this.eyeBallRadius;
	}
}