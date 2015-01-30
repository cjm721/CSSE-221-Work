package polygons;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Defines a FlexiblePolygon as a polygon with a flexible number of end points
 * specified by the user. Each time the user clicks and releases the mouse, an
 * end point, up to the number specified by the user, is added to the list of
 * points.
 * 
 * Each time a point is added, the end points and connecting lines are drawn.
 * When the last point is added, it is connected with the first point to close
 * the polygon.
 * 
 * To aid the user in remembering the number of end points for this
 * FlexiblePolygon added so far, an integer that represents the ordinal value of
 * each point is also displayed next to the point.
 * 
 * @author millerc5. Created April 30, 2011. 
 * 
 */
public class FlexiblePolygon {

	private Point[] points;
	private int nextIndex;
	/**
	 * Maximum number of points allowed
	 */
	public static int MAX_NUMBER_OF_POINTS = 19;
	/**
	 * Minimum number of points allowed
	 */
	public static int MIN_NUMBER_OF_POINTS = 3;
	private int numberOfPoints;
	private boolean enoughPoints;

	/**
	 * Constructs a default FlexiblePolygon instance.
	 * 
	 * @param n
	 *            The number of points this polygon has.
	 */
	public FlexiblePolygon(int n) {
		if(n < 3) n =3;
		if(n > 19) n =19;
		this.points = new Point[n];
		this.numberOfPoints = n;
		this.nextIndex = 0;
	}


	/**
	 * Adds the given point to this FlexiblePolygon's list of end points. No
	 * more than numberOfPoints end points will be added.
	 * 
	 * @param pt
	 *            A point to add to this FlexiblePolygon's list of end points.
	 */
	public void addPoint(Point pt) {
		if( this.nextIndex < this.numberOfPoints){
			this.points[this.nextIndex] = pt;
			this.nextIndex++;
		}
	}

	/**
	 * 
	 * Draws this FlexiblePolygon with the provided Graphics2D object.
	 * 
	 * @param g
	 *            The Graphics2D object to use to render this FlexiblePolygon.
	 */
	public void draw(Graphics2D g) {
		drawEndPoints(g);
		outlinePolygon(g);
	}

	/**
	 * 
	 * Draws the end points of this FlexiblePolygon on the provided Graphics2D
	 * object. This is done by drawing a colored circle for each point and a
	 * string that contains the ordinal value of the corresponding point. Each
	 * circle should be centered at its corresponding point and the ordinal
	 * string should be drawn near the circle.
	 * 
	 * @param g
	 *            The Graphics2D object to use to render the end points.
	 */
	public void drawEndPoints(Graphics2D g) {

		int rad = 5;
		Color c1 = g.getColor();
		Color c2 = Color.RED;

		for(Point p: this.points){
			if(p != null){
				g.setColor(c2);
				g.fillOval(p.x - rad, p.y - rad, rad * 2, rad * 2);
				g.setColor(c1);
				g.drawOval(p.x - rad, p.y - rad, rad * 2, rad * 2);
			}
		}

		
		for(int i = 0; i < this.points.length; i++){
			if(this.points[i] != null)
			g.drawString("" + (i + 1),this.points[i].x + 2 * rad, this.points[i].y + 2 * rad );
		}
	}

	/**
	 * 
	 * Draws the outline of this FlexiblePolygon on the provided Graphics2D
	 * object based on the number of end points added so far. This should only
	 * connect the last end point to the first when the polygon has enough end
	 * points.
	 * 
	 * @param g
	 *            The Graphics2D object to use to render the outline of this
	 *            FlexiblePolygon.
	 */
	public void outlinePolygon(Graphics2D g) {
		for(int i = 0; i < this.points.length-1; i++){
			if(this.points[i] != null && this.points[i+1] != null){
				Point p1 = this.points[i];
				Point p2 = this.points[i+1];
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
			}
		}
		if(this.points[0] != null && this.points[this.points.length -1] != null){
			Point p1 = this.points[0];
			Point p2 = this.points[this.points.length - 1];
			g.drawLine(p1.x, p1.y, p2.x, p2.y);
		}

	}

}
