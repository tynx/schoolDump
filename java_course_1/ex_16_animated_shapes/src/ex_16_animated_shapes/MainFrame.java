package ex_16_animated_shapes;

import javax.swing.JFrame;

/**
 * This class is the main. It start the whole application and initiallizes the
 * panel for the actual animation.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MainFrame extends JFrame{

	/**
	 * To supress the warning, not used at that point
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The width of the whole window
	 */
	public static final int FRAME_WIDTH = 800;

	/**
	 * The height of the whole window
	 */
	public static final int FRAME_HEIGHT  = 700;

	/**
	 * The title of the app
	 */
	public static final String TITLE = "Animated Shapes";
	private MainPanel panel;

	/**
	 * This sets up the main frame and instancates the panel for the actual
	 * animation
	 */
	MainFrame() {
		this.setTitle(MainFrame.TITLE);
		this.panel = new MainPanel();
		this.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(this.panel);
		this.setVisible(true);
	}

	/**
	 * Start the main frame
	 * @param args are not parsed! (ignored)
	 */
	public static void main(String[] args) {
		new MainFrame();
	}
}


