package animatedShapes;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

/**
/**
 * This class constructs animated shapes that are able to move across their
 * containing window, grow and shrink, and change their colors.
 * 
 * @author defoe. Created Nov 2, 2012.
 */ 

public abstract class AnimatedShape implements Runnable {

	private Color outlineColor;
	private Color fillColor;

	private int xSpeed;
	private int ySpeed;
	private JPanel world;
	private boolean xSpeedPositive;
	private boolean ySpeedPositive;
	private int width;
	private int height;
	private double scaleFactor;

	private static Random rad = new Random();
	private static int SLEEP_TIME = 20;

	private static int minWidth = 40;
	private static int minHeight = 30;
	private static int maxSize = 150;
	private static int minSpeed = 1;
	private static int maxSpeed = 5;

	/**
	 * Initializes an animated shape using the given parameters
	 * 
	 * @param x
	 *            x-coordinate of the starting point of this shape
	 * @param y
	 *            y-coordinate of the starting point of this shape
	 * @param world
	 *            the world in which this shape will be displayed
	 */
	public AnimatedShape(int x, int y, JPanel world) {
		this.setWorld(world);
		this.setWidth(AnimatedShape.minWidth
				+ AnimatedShape.rad.nextInt(AnimatedShape.maxSize));
		this.setHeight(AnimatedShape.minHeight
				+ AnimatedShape.rad.nextInt(AnimatedShape.maxSize));
		this.setxSpeed(Math.max(AnimatedShape.minSpeed,
				AnimatedShape.rad.nextInt(AnimatedShape.maxSpeed)));
		this.setySpeed(Math.max(AnimatedShape.minSpeed,
				AnimatedShape.rad.nextInt(AnimatedShape.maxSpeed)));
		this.setxSpeedPositive((this.getxSpeed() > 0) ? true : false);
		this.setySpeedPositive((this.getySpeed() > 0) ? true : false);
		this.setScaleFactor(1.0);
		this.reColor();
	}

	/**
	 * Changes the fill and outline colors of this animated shape
	 * 
	 */
	public void reColor() {
		int colorMaxVal = 256;
		this.setOutlineColor(new Color(rad.nextInt(colorMaxVal), rad
				.nextInt(colorMaxVal), rad.nextInt(colorMaxVal)));

		this.setFillColor(new Color(rad.nextInt(colorMaxVal), rad
				.nextInt(colorMaxVal), rad.nextInt(colorMaxVal)));

	}

	@Override
	public void run() {
		while (true) {
			try {
				checkCollision();
				this.move();
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// Do nothing.
			}
		}
	}

	/**
	 * Draws this animated shape
	 * 
	 * @param g2
	 */
	public abstract void draw(Graphics2D g2);

	/**
	 * Grows or shrinks this animated shape by the given scale factor
	 * 
	 * @param scaleFactor
	 */
	public abstract void updateSize(double scaleFactor);

	/**
	 * Determines whether any point on this animated shape collides with its
	 * containing world and reverses the x and y directions as needed
	 * 
	 */
	public abstract void checkCollision();

	/**
	 * Moves this animated shape in the x and y directions as determined by its
	 * speed in each direction
	 * 
	 */
	public abstract void move();

	/**
	 * Returns the value of the field called 'outlineColor'.
	 * 
	 * @return Returns the outlineColor.
	 */
	public Color getOutlineColor() {
		return this.outlineColor;
	}

	/**
	 * Sets the field called 'outlineColor' to the given value.
	 * 
	 * @param outlineColor
	 *            The outlineColor to set.
	 */
	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	/**
	 * Returns the value of the field called 'fillColor'.
	 * 
	 * @return Returns the fillColor.
	 */
	public Color getFillColor() {
		return this.fillColor;
	}

	/**
	 * Sets the field called 'fillColor' to the given value.
	 * 
	 * @param fillColor
	 *            The fillColor to set.
	 */
	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * Returns the value of the field called 'width'.
	 * 
	 * @return Returns the width.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the field called 'width' to the given value.
	 * 
	 * @param width
	 *            The width to set.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the value of the field called 'height'.
	 * 
	 * @return Returns the height.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the field called 'height' to the given value.
	 * 
	 * @param height
	 *            The height to set.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Returns the value of the field called 'scaleFactor'.
	 * 
	 * @return Returns the scaleFactor.
	 */
	public double getScaleFactor() {
		return this.scaleFactor;
	}

	/**
	 * Sets the field called 'scaleFactor' to the given value.
	 * 
	 * @param scaleFactor
	 *            The scaleFactor to set.
	 */
	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	/**
	 * Returns the value of the field called 'world'.
	 * 
	 * @return Returns the world.
	 */
	public JPanel getWorld() {
		return this.world;
	}

	/**
	 * Sets the field called 'world' to the given value.
	 * 
	 * @param world
	 *            The world to set.
	 */
	public void setWorld(JPanel world) {
		this.world = world;
	}

	/**
	 * Returns the value of the field called 'xSpeedPositive'.
	 * 
	 * @return Returns the xSpeedPositive.
	 */
	public boolean isxSpeedPositive() {
		return this.xSpeedPositive;
	}

	/**
	 * Sets the field called 'xSpeedPositive' to the given value.
	 * 
	 * @param xSpeedPositive
	 *            The xSpeedPositive to set.
	 */
	public void setxSpeedPositive(boolean xSpeedPositive) {
		this.xSpeedPositive = xSpeedPositive;
	}

	/**
	 * Returns the value of the field called 'ySpeedPositive'.
	 * 
	 * @return Returns the ySpeedPositive.
	 */
	public boolean isySpeedPositive() {
		return this.ySpeedPositive;
	}

	/**
	 * Sets the field called 'ySpeedPositive' to the given value.
	 * 
	 * @param ySpeedPositive
	 *            The ySpeedPositive to set.
	 */
	public void setySpeedPositive(boolean ySpeedPositive) {
		this.ySpeedPositive = ySpeedPositive;
	}

	/**
	 * Returns the value of the field called 'xSpeed'.
	 * 
	 * @return Returns the xSpeed.
	 */
	public int getxSpeed() {
		return this.xSpeed;
	}

	/**
	 * Sets the field called 'xSpeed' to the given value.
	 * 
	 * @param xSpeed
	 *            The xSpeed to set.
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	/**
	 * Returns the value of the field called 'ySpeed'.
	 * 
	 * @return Returns the ySpeed.
	 */
	public int getySpeed() {
		return this.ySpeed;
	}

	/**
	 * Sets the field called 'ySpeed' to the given value.
	 * 
	 * @param ySpeed
	 *            The ySpeed to set.
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

}
