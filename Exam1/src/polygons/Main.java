package polygons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Runs the FlexiblePolygon application.
 *
 * @author defoe.
 *         Created Oct 2, 2013.
 */
public class Main {

	/**
	 * The FlexiblePolygon application starts here.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame polygonFrame = new JFrame("Context Polygon");
		int width = 500;
		int height = 400;
		int inset = 20;
		polygonFrame.setSize(new Dimension(width, height));
		/* Retrieve input from user */
		String input = JOptionPane.showInputDialog("How many points would you like to click (3 to 19 accepted)?");
		/* Attempt to create components based on input provided by user. */
		try {
			int numPoints = Integer.parseInt(input);
			if (numPoints < FlexiblePolygon.MIN_NUMBER_OF_POINTS || numPoints > FlexiblePolygon.MAX_NUMBER_OF_POINTS){
				throw new NumberFormatException();
			}
			FlexiblePolygon polygon = new FlexiblePolygon(numPoints);
			FlexiblePolygonPanel polygonPanel = new FlexiblePolygonPanel(polygon);
			polygonPanel.setPreferredSize(new Dimension(width - inset, height - inset));
			polygonPanel.setBackground(Color.WHITE);
			polygonPanel.addMouseListener(polygonPanel);
			polygonFrame.add(polygonPanel);
			
		} catch (NumberFormatException e){
			/* Show error message and terminate application if input is unacceptable. */
			JOptionPane.showMessageDialog(null, "Must enter an integer in the range (3 to 19)", "Error", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		polygonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		polygonFrame.setVisible(true);
	}

}
