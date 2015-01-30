import java.awt.Color;

/**
 * The class containing the MAIN method, which creates a visible JFrame.
 * JavaEyes is a Swing application that is a Java-based implementation
 * of the familiar "Xeyes" program, available on many Unix-based systems.
 *
 * @author David Mutchler and many others before him.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class JavaEyes {
	
	/**
	 * The default color for the eye.
	 */
	public static final Color DEFAULT_EYE_COLOR = Color.white;
	
	/**
	 * The default color for the eyeball.
	 */
	public static final Color DEFAULT_EYEBALL_COLOR = Color.black;
	
	/**
	 * The application starts here in MAIN;
	 * it creates a new JFrame for JavaEyes and makes it visible.
	 *
	 * @param args Array of command-line arguments (which are ignored)
	 */
	public static void main(String[] args) {
		System.out.println("Starting JavaEyes.");
		
		JavaEyesFrame frame = new JavaEyesFrame();
		frame.setVisible(true);
	}
}
