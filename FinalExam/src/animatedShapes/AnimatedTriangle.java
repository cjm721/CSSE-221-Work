package animatedShapes;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 * This class constructs animated triangles that are able to move across their
 * containing window, grow and shrink, and change their colors.
 * 
 * @author Steve Chenoweth & Delvin Defoe. Created Oct 26, 2012.
 */
public class AnimatedTriangle extends AnimatedShape{

	/**
	 * To be used for an animated triangle
	 */
	private Polygon polygon;
	

	/**
	 * 
	 * Constructs an animated triangle using the given parameters
	 * 
	 * @param x
	 *            x-coordinate of the starting point of this triangle
	 * @param y
	 *            y-coordinate of the starting point of this triangle
	 * @param world 
	 * 			the world in which this triangle will be displayed
	 */
	public AnimatedTriangle(int x, int y, JPanel world) {
		super(x, y, world);
		this.polygon= new Polygon();
		this.polygon.addPoint(x, y);

		this.polygon.addPoint(x + this.getWidth(), y);
		this.polygon.addPoint(x + this.getWidth(), y + this.getHeight());

	}


	@Override
	public void updateSize(double scaleFactor){
		this.setScaleFactor(this.getScaleFactor() * scaleFactor);
		int x = this.polygon.xpoints[0];
		int y = this.polygon.ypoints[0];
		this.polygon = new Polygon();
		this.polygon.addPoint(x, y);
		int width = (int) (this.getWidth() * this.getScaleFactor());
		int height = (int) (this.getHeight() * this.getScaleFactor());
		this.polygon.addPoint(x + width, y);
		this.polygon.addPoint(x + width, y + height);
	}


	@Override
	public void checkCollision() {
		int maxWorldX = this.getWorld().getWidth();
		int maxWorldY = this.getWorld().getHeight();
		int[] xCoords = Arrays.copyOf(this.polygon.xpoints, this.polygon.xpoints.length);
		Arrays.sort(xCoords);
		int[] yCoords = Arrays.copyOf(this.polygon.ypoints, this.polygon.ypoints.length);
		Arrays.sort(yCoords);
		if (xCoords[0] < 0 && !this.isxSpeedPositive()){
			this.setxSpeed(this.getxSpeed() * -1);
			this.setxSpeedPositive(true);
		}
		else if (xCoords[xCoords.length - 1] > maxWorldX && this.isxSpeedPositive()){
			this.setxSpeed(this.getxSpeed() * -1);
			this.setxSpeedPositive(false);
		}
		
		if (yCoords[0] < 0  && !this.isySpeedPositive()){
			this.setySpeed(this.getySpeed() * -1);
			this.setySpeedPositive(true);
		}
		else if (yCoords[yCoords.length - 1] > maxWorldY && this.isySpeedPositive()){
			this.setySpeed(this.getySpeed() * -1);
			this.setySpeedPositive(false);
		}
	}



	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(this.getFillColor());
		g2.fillPolygon(this.polygon);
		g2.setColor(this.getOutlineColor());
		g2.drawPolygon(this.polygon);		
	}


	@Override
	public void move() {
		this.polygon.translate(this.getxSpeed(), this.getySpeed());
		
	}
}
