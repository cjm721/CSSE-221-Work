import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;

/**
 * The JFrame which is the primary window for JavaEyes.
 * It is the frame that holds a Java-based implementation
 * of the familiar "Xeyes" program,
 * available on many Unix-based systems.
 *
 * @author David Mutchler and many others before him.
 *         Created November 2004, updated August 2005 and September 2008.
 */
public class JavaEyesFrame extends JFrame {
	
	private static final Dimension DEFAULT_FRAME_SIZE = new Dimension(300, 500);
																// in pixels
	private static final String DEFAULT_FRAME_TITLE = "JavaEyes";
	private static final LayoutManager DEFAULT_LAYOUT_MANAGER = new FlowLayout();
	
	/**
	 * Initialize the JFrame by:
	 *   <ul>
	 *   <li> Set the JFrame's size, title, and layout manager to the defaults; </li>
	 *   <li> Make the application exit when the JFrame is closed; </li>
	 *   <li> Create and add the square panel, three buttons, and eyes; </li>
	 *   <li> Ask the eyes to respond to mouse motion. </li>
	 *   </ul>
	 */
	public JavaEyesFrame() {
		
		// Standard initialization
		this.initialize();
		
		// Create an animated panel that contains an orbiting square,
		// buttons to start and stop the orbiting square,
		// and a button to quit the application.
		AnimatedPanel animationPanel = new AnimatedPanel(JavaEyesFrame.DEFAULT_FRAME_SIZE.width);
		StartButton startButton = new StartButton("Move the Square", animationPanel);
		StopButton stopButton = new StopButton("Stop the Square", animationPanel);
		QuitButton quitButton = new QuitButton("Quit");
		
		// Construct the Eye objects
		// and tell them to respond to mouse motion in this frame.
		Eye eye1 = new Eye(new Color(255,0,255),new Color(0,255,0));
		Eye eye2 = new Eye();
		Eye eye3 = new Eye();
		Eye eye4 = new Eye(new Color(0,255,0), new Color(255,128,0));
		
		this.addMouseMotionListener(eye1);
        this.addMouseMotionListener(eye2);
        this.addMouseMotionListener(eye3);
        this.addMouseMotionListener(eye4);
        
		// Add the buttons to the frame first (so they are at the top)
        // then the eyes (in the middle)
        // then the animation panel (added last, so that it is at the bottom).
		this.add(startButton);
		this.add(stopButton);
		this.add(quitButton);
		
		this.add(eye1);
		this.add(eye2);
		this.add(eye3);
		this.add(eye4);
		
		for(int i = 0; i < 99; i++){
			Eye temp = new Eye();
			this.addMouseMotionListener(temp);
			this.add(temp);
		}
		
        this.add(animationPanel);
	}

	/**
	 * Initialize the frame's size, title and layout to the defaults.
	 * Tell the application to close when the frame is closed.
	 */
	protected void initialize() {
		this.setSize(JavaEyesFrame.DEFAULT_FRAME_SIZE.width,
				JavaEyesFrame.DEFAULT_FRAME_SIZE.height);
		this.setTitle(JavaEyesFrame.DEFAULT_FRAME_TITLE);
		this.setLayout(JavaEyesFrame.DEFAULT_LAYOUT_MANAGER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
