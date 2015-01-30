package sierpinski;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;
//FROM_GRADER: 25/25
/**
 * This class renders a Sierpinski triangle
 * 
 * @author <TODO: your name here> and Curt Clifton.
 */
public class SierpinskiRenderer extends JComponent {
	private static final int INSET = 30;
	private static final double HEIGHT_TO_BASE_RATIO = Math.sqrt(3) / 2.0;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Gets size of component
		final int width = this.getWidth();
		final int height = this.getHeight();
		final int left = INSET;
		final int bottom = height - INSET;
		/*
		 * Calculates an initial length for the base so that the triangle just
		 * fits as the window is resized.
		 */
		final double base = Math.min((height - 2 * INSET)
				/ HEIGHT_TO_BASE_RATIO, width - 2 * INSET);

		Graphics2D graphics = (Graphics2D) g;
		drawSierpinski(graphics, left, bottom, base,0);
	}

	/**
	 * Recursively renders the Sierpinski triangle on the given graphics object.
	 * 
	 * @param g
	 * @param left
	 *            the x coordinate for the left most corner of the triangle
	 * @param bottom
	 *            the y coordinate for the bottom edge of the triangle
	 * @param base
	 *            the length of the triangle's base
	 */
	private void drawSierpinski(Graphics2D g, double left, double bottom,
			double base, int counter) {
		
		if(counter++ > 6) return;
		
		// Draws the first equilateral triangle called for by the algorithm.
		Point2D p1 = new Point2D.Double(left, bottom);
		Point2D p2 = new Point2D.Double(left + base, bottom);
		Point2D p3 = new Point2D.Double(left + base / 2.0, bottom - base
				* HEIGHT_TO_BASE_RATIO);
		Shape triangle = makeTriangle(p1, p2, p3);
		g.setColor(Color.RED);
		g.fill(triangle);
		g.setColor(Color.BLACK);
		
//		g.drawString("p1", (int)left, (int)bottom);
//		g.drawString("p2", (int)(left+base), (int)bottom);
//		g.drawString("p3", (int)(left+base/2.0), (int)(bottom-base * HEIGHT_TO_BASE_RATIO));
		
		
		Point2D wP1 = new Point2D.Double(left+base/4, bottom-base * HEIGHT_TO_BASE_RATIO/2);
		Point2D wP2 = new Point2D.Double(left + base*3/4, bottom-base * HEIGHT_TO_BASE_RATIO/2);
		Point2D wP3 = new Point2D.Double(left + base / 2.0, bottom);
		
//		g.drawString("wP1", (int)wP1.getX(), (int)wP1.getY());
//		g.drawString("wP2", (int)wP2.getX(), (int)wP2.getY());
//		g.drawString("wP3", (int)wP3.getX(), (int)wP3.getY());
		
		Shape whiteTriangle = makeTriangle(wP1,wP2,wP3);
		g.setColor(Color.WHITE);
		g.fill(whiteTriangle);
		
		drawSierpinski(g, left, bottom, base/2,counter);
		drawSierpinski(g, left+base/4, wP1.getY(), base/2, counter);
		drawSierpinski(g, left+base/2, bottom, base/2, counter);
		
	}

	/**
	 * Constructs a triangle connecting the three given points.
	 * 
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return a new triangle shape
	 */
	private Shape makeTriangle(Point2D p1, Point2D p2, Point2D p3) {
		Path2D triangle = new Path2D.Double();
		triangle.moveTo(p1.getX(), p1.getY());
		triangle.lineTo(p2.getX(), p2.getY());
		triangle.lineTo(p3.getX(), p3.getY());
		triangle.lineTo(p1.getX(), p1.getY());
		return triangle;
	}
}
