package animatedShapes;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * This class constructs animated circles that are able to move across their
 * containing window, grow and shrink, and change their colors.
 * 
 * @author defoe. Created Nov 3, 2012.
 */
public class AnimatedCircle extends AnimatedShape {

	private Ellipse2D shape;

	/**
	 *  Constructs an animated circle using the given parameters
	 * 
	 * @param x
	 *             x-coordinate of the starting point of this circle
	 * @param y
	 *             y-coordinate of the starting point of this circle
	 * @param world
	 * 			the world in which this circle will be displayed
	 */
	public AnimatedCircle(int x, int y, AnimatedPanel world) {
		super(x, y, world);
		this.setHeight(this.getWidth());
		this.shape = new Ellipse2D.Double(x, y, this.getWidth(),
				this.getHeight());
	}

	// TODO 2.d - Completed this class by implementing all of the methods below.
	
	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(this.getFillColor());
		g2.fill(this.shape);
		g2.setColor(this.getOutlineColor());
		g2.draw(this.shape);		
	}
	
	@Override
	public void move() {
		int newX = (int) (this.shape.getX() + this.getxSpeed());
		int newY = (int) (this.shape.getY() + this.getySpeed());
		
		this.shape = new Ellipse2D.Double(newX, newY, this.getWidth(), this.getHeight());
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
		
		int newX = (int) (this.getWidth()*this.getScaleFactor());
		int newY = (int) (this.getHeight()*this.getScaleFactor());
		this.shape.setFrame(new Rectangle( (int)this.shape.getX(), (int) this.shape.getY(),
				newX, newY));

	}

}
