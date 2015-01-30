package animatedShapes;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Frame for the Animation.
 * 
 * @author Steve Chenoweth & Delvin Defoe. Created Oct 24, 2012.
 */
public class AnimatedFrame extends JFrame {

	private JButton recolorShapeButton;
	private AnimatedPanel animatedPanel;
	/**
	 * Width of this frame.
	 */
	public static int FRAME_WIDTH = 800;

	/**
	 * Height of this frame.
	 */
	public static int FRAME_HEIGHT = 600;

	/**
	 * Constructs a few components and add them to this frame.
	 * 
	 */
	public AnimatedFrame() {
		this.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Animated Shapes, by CJ Miller");
		this.setLayout(new BorderLayout());

		this.recolorShapeButton = new JButton("Recolor Shapes");
		this.add(this.recolorShapeButton, BorderLayout.NORTH);

		this.animatedPanel = new AnimatedPanel();
		this.add(this.animatedPanel, BorderLayout.CENTER);

		this.add(createButtonsPanel(), BorderLayout.SOUTH);
		
		this.recolorShapeButton.addActionListener(new RecolorShapeListener(
				this.animatedPanel));
		this.setVisible(true);
	}

	/**
	 * Creates a panel with buttons to create different animated shapes
	 *
	 * @return
	 * 			a panel with buttons to create different animated shapes.
	 */
	public JPanel createButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		String[] shapesNames = { "Triangle", "Rectangle", "Circle" };
		for (String s : shapesNames) {
			JButton addShapeButton = new JButton("Add " + s);
			addShapeButton.addActionListener(new AddShapeListener(
					this.animatedPanel));
			buttonsPanel.add(addShapeButton);
		}
		return buttonsPanel;

	}

}
