package pizza;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 * This class represents a Pizza that can be customized and made.
 * 
 */
@SuppressWarnings("serial")
public class Pizza extends JPanel {

	private Random generator = new Random();
	private Shape crust;
	private Shape cheese;
	private int anchoviesAmount;
	private int pepperoniesAmount;
	private int sausagesAmount;
	private boolean anchoviesDesired;
	private boolean pepperoniesDesired;
	private boolean sausagesDesired;
	private double size;
	private boolean cooked;
	private static final int INSET = 10;

	/**
	 * Constructs a Pizza
	 */
	public Pizza() {
		this.setBackground(Color.lightGray);
		this.setAnchoviesAmount(1);
		this.setPepperoniesAmount(1);
		this.setSausagesAmount(1);
		this.setPizzaSize(1);
		this.setCooked(true);
		this.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawCrust(g2);
		drawCheese(g2);
		if (this.wantsPepperonies()) {
			drawPepperoni(g2);
		}
		if (this.wantsAnchovies()) {
			drawAnchovies(g2);
		}
		if (this.wantsSausages()) {
			drawSauseges(g2);
		}
	}

	/**
	 * Draws all the sausage on the Pizza, in random positions
	 * 
	 * @param g
	 */
	public void drawSauseges(Graphics2D g) {
		Color suusageColor = new Color(139, 119, 101);
		g.setColor(suusageColor);
		int sausageLength = 20;
		int sausageWidth = 10;
		for (int i = 0; i < 10 * getSausagesAmount(); i++) {
			Point2D.Float tempPoint = getRandomPointOnCheese(this.cheese,
					sausageLength, sausageWidth);
			RoundRectangle2D.Float sausage = new RoundRectangle2D.Float(
					(int) tempPoint.getX(), (int) tempPoint.getY(),
					sausageLength, sausageWidth, 3, 3);
			if (this.cheese.contains(sausage.getBounds2D())) {
				g.fill(sausage);
			}
		}
	}

	/**
	 * Draws all the anchoviesAmount on the Pizza, in random positions
	 * 
	 * @param g
	 */
	public void drawAnchovies(Graphics2D g) {
		Color anchoviesColor = new Color(32, 178, 170);
		g.setColor(anchoviesColor);
		int anchovieLength = 20;
		int anchovieWidth = 10;
		for (int i = 0; i < 10 * getAnchoviesAmount(); i++) {
			Point2D.Float tempPoint = getRandomPointOnCheese(this.cheese,
					anchovieLength, anchovieWidth);
			Ellipse2D.Float anchovie = new Ellipse2D.Float(
					(int) tempPoint.getX(), (int) tempPoint.getY(),
					anchovieLength, anchovieWidth);
			if (this.cheese.contains(anchovie.getBounds2D())) {
				g.fillOval((int) tempPoint.getX(), (int) tempPoint.getY(),
						anchovieLength, anchovieWidth);
			}
		}
	}

	/**
	 * Draws all the pepperoni on the Pizza, in random positions
	 * 
	 * @param g
	 */
	public void drawPepperoni(Graphics2D g) {
		Color pepperoniColor = new Color(205, 55, 0);
		g.setColor(pepperoniColor);
		int pepperoniSize = 15;
		for (int i = 0; i < 10 * getPepperoniesAmount(); i++) {
			Point2D.Float tempPoint = getRandomPointOnCheese(this.cheese,
					pepperoniSize, pepperoniSize);
			RoundRectangle2D.Float pepperoni = new RoundRectangle2D.Float(
					(int) tempPoint.getX(), (int) tempPoint.getY(),
					pepperoniSize, pepperoniSize, 3, 3);
			if (this.cheese.contains(pepperoni.getBounds2D())) {
				g.fill(pepperoni);
			}
		}
	}

	/**
	 * Draws the "cheesey part" of the Pizza, where the toppings can be placed.
	 * This part is circular and is smaller than the crust. The radius of the
	 * cheese is "crustThickness" shorter than the radius of the crust.
	 * 
	 * @param g
	 */
	public void drawCheese(Graphics2D g) {
		Color cheeseColor = new Color(253, 245, 230);
		g.setColor(cheeseColor);
		int crustThickness = 10;
		int cheeseWidth = (int) ((this.getWidth() - 2 * INSET- crustThickness*2) * getPizzaSize());
		int cheeseHeight = (int) ((this.getHeight() - 2 * INSET - crustThickness*2) * getPizzaSize());
		int centerX = (this.getWidth()) / 2;
		int centerY = (this.getHeight()) / 2;
		int crustX = (int) (centerX - cheeseWidth / 2.0);
		int crustY = (int) (centerY - cheeseHeight / 2.0);
		this.cheese = new Ellipse2D.Float(crustX, crustY, cheeseWidth,
				cheeseHeight);
		g.fill(this.cheese);

	}

	/**
	 * Draws the Pizza crust
	 * 
	 * @param g
	 */
	public void drawCrust(Graphics2D g) {
		Color cookedCrustColor = new Color(238, 216, 174);
		Color uncookedCrustColor = Color.WHITE;
		if (isCooked()) {
			g.setColor(cookedCrustColor);
		} else {
			g.setColor(uncookedCrustColor);
		}
		int crustWidth = (int) ((this.getWidth() - 2 * INSET) * getPizzaSize());
		int crustHeight = (int) ((this.getHeight() - 2 * INSET) * getPizzaSize());
		int centerX = (this.getWidth()) / 2;
		int centerY = (this.getHeight()) / 2;
		int crustX = (int) (centerX - crustWidth / 2.0);
		int crustY = (int) (centerY - crustHeight / 2.0);
		this.crust = new Ellipse2D.Float(crustX, crustY, crustWidth,
				crustHeight);
		g.fill(this.crust);
	}

	/**
	 * Gets a random position of the cheese to put the topping
	 * 
	 * @param cheese
	 * @param length
	 * @param width
	 * @return random point on cheese
	 */
	public Point2D.Float getRandomPointOnCheese(Shape cheese, int length,
			int width) {
		int w = (int) cheese.getBounds().getWidth();
		int h = (int) cheese.getBounds().getHeight();
		int x = (int) cheese.getBounds().getX();
		int y = (int) cheese.getBounds().getY();
		int xMin = x + INSET;
		int yMin = y + INSET;
		int xMax = x + w - length - INSET;
		int yMax = y + h - width - INSET;
		int tempX = this.generator.nextInt(xMax - xMin) + xMin;
		int tempY = this.generator.nextInt(yMax - yMin) + yMin;
		return new Point2D.Float(tempX, tempY);
	}

	/**
	 * 
	 * @return Amount of Pepperoni
	 */
	public int getPepperoniesAmount() {
		return this.pepperoniesAmount;
	}

	/**
	 * Specifies the desired amount of Pepperoni
	 * 
	 * @param pepperoniesAmount
	 */
	public void setPepperoniesAmount(int pepperoniesAmount) {
		this.pepperoniesAmount = pepperoniesAmount;
	}

	/**
	 * 
	 * @return Amount of Anchovies
	 */
	public int getAnchoviesAmount() {
		return this.anchoviesAmount;
	}

	/**
	 * Specifies the desired amount of Anchovies
	 * 
	 * @param anchoviesAmount
	 */
	public void setAnchoviesAmount(int anchoviesAmount) {
		this.anchoviesAmount = anchoviesAmount;
	}

	/**
	 * 
	 * @return Amount of Sausages
	 */
	public int getSausagesAmount() {
		return this.sausagesAmount;
	}

	/**
	 * Specifies the desired amount of sausage
	 * 
	 * @param sausagesAmount
	 */
	public void setSausagesAmount(int sausagesAmount) {
		this.sausagesAmount = sausagesAmount;
	}

	/**
	 * 
	 * @return Size of Pizza
	 */
	public double getPizzaSize() {
		return this.size;
	}

	/**
	 * Specifies the desired size of the pizza (100% for large, 80% for medium,
	 * 60% for small)
	 * 
	 * @param size
	 */
	public void setPizzaSize(double size) {
		this.size = size;
	}

	/**
	 * Determines whether the Pizza should be cooked
	 * 
	 * @return whether Pizza is cooked
	 */
	public boolean isCooked() {
		return this.cooked;
	}

	/**
	 * Specifies whether the Pizza is cooked. If it is, the crust will be
	 * colored to show that the pizza is cooked
	 * 
	 * @param cooked
	 */
	public void setCooked(boolean cooked) {
		this.cooked = cooked;
	}

	/**
	 * Determines whether Pepperoni is desired
	 * 
	 * @return Whether there is Pepperoni on Pizza
	 */
	public boolean wantsPepperonies() {
		return this.pepperoniesDesired;
	}

	/**
	 * Specifies whether Pepperoni is desired
	 * 
	 * @param pepperoniesDesired
	 */
	public void setPepperoniesDesired(boolean pepperoniesDesired) {
		this.pepperoniesDesired = pepperoniesDesired;
	}

	/**
	 * Determines whether Sausage is desired
	 * 
	 * @return whether there is Sausage on Pizza
	 */
	public boolean wantsSausages() {
		return this.sausagesDesired;
	}

	/**
	 * Specifies whether Sausage is desired
	 * 
	 * @param sausagesDesired
	 */
	public void setSausagesDesired(boolean sausagesDesired) {
		this.sausagesDesired = sausagesDesired;
	}

	/**
	 * Determines whether Anchovies are desired
	 * 
	 * @return Whether there are Anchovies on Pizza
	 */
	public boolean wantsAnchovies() {
		return this.anchoviesDesired;
	}

	/**
	 * Specifies whether Anchovies are desired
	 * 
	 * @param anchoviesDesired
	 */
	public void setAnchoviesDesired(boolean anchoviesDesired) {
		this.anchoviesDesired = anchoviesDesired;
	}

}
