package pizza;

import javax.swing.JFrame;

/**
 * Runs the PizzaMaker program
 * 
 */


public class Main {
	
	/**
	 * PizzaMaker frame WIDTH
	 */
	public static final int WIDTH = 350;
	/**
	 * PizzaMaker frame HEIGHT
	 */
	public static final int HEIGHT = 700;
	
	
	/**
	 * The program starts here
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new PizzaMakerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Main.WIDTH, Main.HEIGHT);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
