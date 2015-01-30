package animatedShapes;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JPanel;

/**
 * This class constructs animated rectangles that are able to move across their
 * containing window, grow and shrink, and change their colors.
 * 
 * @author defoe. Created Nov 2, 2012.
 */
public class AnimatedRectangle extends AnimatedShape {

	private Rectangle shape;

	/**
	 * Constructs an animated rectangle using the given parameters
	 * 
	 * @param x
	 *             x-coordinate of the starting point of this rectangle
	 * @param y
	 *             y-coordinate of the starting point of this rectangle
	 * @param world
	 * 			the world in which this rectangle will be displayed
	 */
	public AnimatedRectangle(int x, int y, JPanel world) {
		super(x, y, world);
		this.shape = new Rectangle(x, y, this.getWidth(), this.getHeight());

	}
	
	// TODO 2.c - Completed this class by implementing all of the methods below.

	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(this.getFillColor());
		g2.fill(this.shape);
		g2.setColor(this.getOutlineColor());
		g2.draw(this.shape);		
	}
	
	@Override
	public void move() {
		this.shape.translate(this.getxSpeed(),this.getySpeed());
	}

	@Override
	public void checkCollision() {
		int maxX = this.getWorld().getWidth();
		int maxY= this.getWorld().getHeight();
		
		int leftX = (int) this.shape.getX();
		if(leftX <= 0 && !this.isxSpeedPositive()){
			this.setxSpeed(this.getxSpeed()*-1);
			this.setxSpeedPositive(true);
		}
		
		int rightX = (int) (this.shape.getX()+this.shape.getWidth());
		if(rightX >= maxX && this.isxSpeedPositive()){
			this.setxSpeed(this.getxSpeed()*-1);
			this.setxSpeedPositive(false);
		}
		
		int topY = (int) this.shape.getY();
		if(topY <= 0 && !this.isySpeedPositive()){
			this.setySpeed(this.getySpeed()*-1);
			this.setySpeedPositive(true);
		}
		
		int bottomY = (int) (this.shape.getY()+this.shape.getHeight());
		if(bottomY >= maxY && this.isySpeedPositive()){
			this.setySpeed(this.getySpeed()*-1);
			this.setySpeedPositive(false);
		}
	}
	
	@Override
	public void updateSize(double scaleFactor) {
		this.setScaleFactor(this.getScaleFactor() * scaleFactor);
		System.out.println(this.getScaleFactor());
	
		
		int newX = (int) (this.shape.getWidth()*this.getScaleFactor());
		int newY = (int) (this.shape.getHeight()*this.getScaleFactor());

		this.shape.setSize( newX, newY);
	}

}
