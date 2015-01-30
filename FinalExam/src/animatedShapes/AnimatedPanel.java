package animatedShapes;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

/**
 * An animated panel that can allow animated shapes to be drawn on it. This
 * represents the world for the animated shapes.
 * 
 * @author Steve Chenoweth & Delvin Defoe. Created Oct 24, 2012.
 */
public class AnimatedPanel extends JPanel implements MouseMotionListener {

	/**
	 * "Arbitrary polygon" per
	 * http://www.java2s.com/Code/Java/2D-Graphics-GUI/DrawaPolygon.htm
	 */
	private Polygon p = new Polygon();
	/**
	 * This flag is used to determine whether mouse is inside the polygon
	 */
	private Boolean inPolygon = false;
	/**
	 * Circle displayed on the window
	 */
	private Ellipse2D.Double cir;
	/**
	 * This flag is used to determine whether mouse is inside the circle
	 */
	private Boolean inCircle = false;

	/**
	 * Stores a collection of AnimatedShapes
	 */
	private ArrayList<AnimatedShape> movingShapes;

	/**
	 * Sleep time for this thread in ms
	 */
	private static int SLEEP_IN_MS = 1;

	/**
	 * 
	 * Constructs a panel for the animation
	 * 
	 */

	public AnimatedPanel() {
		this.addMouseMotionListener(this);
		this.movingShapes = new ArrayList<AnimatedShape>();
		// starts the thread to move things
		Thread t = new Thread(this.animatorRunnable);
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		this.setBackground(Color.LIGHT_GRAY); 
		drawShapes(g2);

	}

	/**
	 * 
	 * Adds a new AnimatedShape in a random location
	 * 
	 * @param shapeName
	 * 
	 */
	public void addAShape(String shapeName) {
		int x = (int) (Math.random()*this.getWidth());
		int y = (int) (Math.random()*this.getHeight());
		
		AnimatedShape shape;
		if(shapeName.equals("Triangle")){
			shape = new AnimatedTriangle(x,y,this);
		}else if( shapeName.equals("Rectangle")){
			shape = new AnimatedRectangle(x,y,this);
		}else if(shapeName.equals("Circle")){
			shape = new AnimatedCircle(x,y,this);
		}else{
			System.out.println("Unknown shape type.");
			shape = null;
		}
		
		this.movingShapes.add(shape);
		new Thread(shape).start();
	}

	/**
	 * 
	 * Generates new random colors for the shapes that were added
	 * 
	 */
	public void recolorShapes() {
		for(AnimatedShape shape: this.movingShapes){
			shape.reColor();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// This is auto-generated method stub - not used

	}

	/**
	 * Uses mouse-moved to detect if inside polygon (pentagon) or circle
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		int xPosn = e.getX();
		int yPosn = e.getY();
		// checks for inside polygon
		if (this.p.contains(xPosn, yPosn)) {
			this.inPolygon = true;
		} else { // not inPolygon
			this.inPolygon = false;
		}
		// checks for inside circle
		if (this.cir.contains(xPosn, yPosn)) {
			this.inCircle = true;
		} else { // not inCircle
			this.inCircle = false;
		}
	}

	/**
	 * Defines a new Animator Runnable Thread
	 */
	Runnable animatorRunnable = new Runnable() {

		@Override
		public void run() {
			try {
				while (true) {
					redrawPanel();
					checkGrowShrink();
					Thread.sleep(SLEEP_IN_MS);
				}
			} catch (InterruptedException exception) {
				exception.printStackTrace();
			}
		}
	};

	/**
	 * 
	 * Grows or shrinks shapes if necessary
	 * 
	 */
	private void checkGrowShrink() {
		// shrinks shapes
		if (this.inCircle) {
			Iterator<AnimatedShape> itr = this.movingShapes.iterator();
			while (itr.hasNext()) {
				AnimatedShape shape = itr.next();
				shape.updateSize(0.999);
			}
		}
		// grows shapes
		else if (this.inPolygon) {
			Iterator<AnimatedShape> itr = this.movingShapes.iterator();
			while (itr.hasNext()) {
				AnimatedShape shape = itr.next();
				shape.updateSize(1.001);
			}

		}

	}

	/**
	 * 
	 * Redraws this panel at the given time interval
	 * 
	 * @param timeInterval
	 */
	private void redrawPanel() {
		this.repaint();
	}

	/**
	 * 
	 * Redraws all the shapes
	 * 
	 * @param g2
	 * @param timeInterval
	 */
	private void drawShapes(Graphics2D g2) {
		// draws circle outline in middle with text
		drawCircle(g2); 
		// draws pentagon in upper left quadrant
		drawPentagon(g2); 

		// draws the list of shapes created by clicking a button to make
		// each
		Iterator<AnimatedShape> itr = this.movingShapes.iterator();
		while (itr.hasNext()) {
			AnimatedShape shape = itr.next();
			shape.draw(g2); // draws it
		}

	}

	/**
	 * 
	 * Redraws the central circle and its text
	 * 
	 * @param g2
	 */
	private void drawCircle(Graphics2D g2) {
		// draws a circle in the middle
		double midX = (this.getX() + this.getWidth()) / 2.0;
		double midY = (this.getY() + this.getHeight()) / 2.0;
		this.cir = new Ellipse2D.Double(midX - 30, midY - 30, 60, 60);
		g2.draw(this.cir);

		// puts text in the circle
		Font f = new Font("Arial", Font.PLAIN, 16);
		g2.setFont(f);
		g2.drawString("shrink", (int) midX - 19, (int) midY + 5);

	}

	/**
	 * 
	 * Redraws the pentagon and its text
	 * 
	 * @param g2
	 */
	private void drawPentagon(Graphics2D g2) {
		for (int i = 0; i < 5; i++)
			// draws the polygon
			this.p.addPoint((int) (200 + 50 * Math.cos(i * 2 * Math.PI / 5)),
					(int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));
		g2.drawPolygon(this.p);

		// puts text in the pentagon
		Font f1 = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(f1);
		g2.drawString("GROW", 165, 105);

	}

}
