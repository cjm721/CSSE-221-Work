import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Panel that runs an animation.
 * In particular, it contains an orbiting square.
 *
 * @author An anonymous student, David Mutchler and many others before them.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class AnimatedPanel extends JPanel implements Runnable {
	
	// Default background color of the panel.
	private static final Color DEFAULT_COLOR = Color.BLUE;
	
	// Default color of the panel's orbiting square.
	private static final Color DEFAULT_SQUARE_COLOR = Color.GREEN;
	
	// Default size of the square, as a fraction of the panel's width.
	private static final double DEFAULT_SQUARE_SIZE = 0.14;
	
	// Default radius of the square's orbit, as a fraction of the panel's width.
	private static final double DEFAULT_SQUARE_RADIUS = 0.33;
	
	// How often to change the position of the panel's orbiting square,
	// in milliseconds.
	private static final int PAUSE_TIME = 20;

	// How much to change the position of the orbiting square at each time step,
	// in radians.
	private static final double ANGLE_DELTA = 0.005;

	private double angle; // Current position of the orbiting square, in radians.
	private boolean squareIsMoving;
	private int squareSize;    // In pixels
	private int orbitRadius;   // In pixels
	private Color squareColor;
	private Point panelCenter; // in pixels
	
	/**
	 * Construct a square panel with width and height the given size
	 * and with other item sizes based on that given size.
	 *
	 * @param size Desired size (width and height) of this panel.
	 */
	public AnimatedPanel(int size) {
		// Set the panel size
		int width = size;
		int height = size;
		this.setPreferredSize(new Dimension(width, height));
		
		// Center of the panel
		this.panelCenter = new Point(width / 2, height / 2);
		
		// Size of each side of the orbiting square
		this.squareSize = (int) (width * AnimatedPanel.DEFAULT_SQUARE_SIZE);
		
		// Distance square should orbit from the center of the panel
		this.orbitRadius = (int) (size * AnimatedPanel.DEFAULT_SQUARE_RADIUS);
		
		// Orbiting square starts out at the 0 radians point and is initially stationary
		this.angle = 0.0;
		this.squareIsMoving = false;
		
		// Background color of the panel and color of the square
		this.setBackground(AnimatedPanel.DEFAULT_COLOR);
		this.squareColor = AnimatedPanel.DEFAULT_SQUARE_COLOR;
	}
	
	/**
	 * Repeatedly update the position of the square.
	 */
	@Override
	public void run() {
		System.out.println("Animation thread started.");
		
		this.squareIsMoving = true;
		while (this.squareIsMoving) {
			try {
				// Sleep so the square orbits at a reasonable speed.
				Thread.sleep(AnimatedPanel.PAUSE_TIME); 
			} catch (InterruptedException exception) {
				// Just continue the loop if you cannot sleep.
			}
		
		  // Update the square's position and redraw the panel.
		  this.angle += 2 * Math.PI * AnimatedPanel.ANGLE_DELTA;
		  this.repaint();
    	}
		
		System.out.println("Animation thread stopped.");
    }
    
    /**
     * Draw the square at its current position.
     *
     * @param graphics Graphics object to draw upon
     */
    @Override
	public void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
    	
    	// Convert from polar to rectangular coordinates
    	int x = (int) (this.panelCenter.getX() + this.orbitRadius * Math.cos(this.angle) - this.squareSize / 2);
    	int y = (int) (this.panelCenter.getY() - this.orbitRadius * Math.sin(this.angle) - this.squareSize / 2);
    	
    	// Draw the square
    	graphics.setColor(this.squareColor);
    	graphics.fillRect(x, y, this.squareSize, this.squareSize);
    }

	/**
	 * Stop the orbiting square.
	 */
	public void stop() {
		this.squareIsMoving = false;
	}
}