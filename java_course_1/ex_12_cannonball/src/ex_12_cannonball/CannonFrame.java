package ex_12_cannonball;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * This Frame is for putting all panels together. there is a menu for all the
 * user-input and a drawable-area for the canonball-flying-path.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class CannonFrame extends JFrame{

	/**
	 * Not used so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The width of the whole window
	 */
	private static final int FRAME_WIDTH = 800;

	/**
	 * The height of the whole window
	 */
	private static final int FRAME_HEIGHT  = 700;

	/**
	 * how high the menu panel should be
	 */
	private static final int MENU_HEIGHT = 30;

	/**
	 * The title of the app
	 */
	private static final String TITLE = "the battlefield";

	/**
	 * The shot-panel, for drawing the cannonball
	 */
	public ShotPanel shootPanel = null;

	/**
	 * The menu-panel, for drawing all the user-related input stuff
	 */
	private MenuPanel menuPanel = null;

	/**
	 * Constructor which sets up the whole window and all the other panels which
	 * are needed. it also layouts them.
	 */
	public CannonFrame(){
		setTitle(TITLE);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.shootPanel = new ShotPanel(FRAME_WIDTH, FRAME_HEIGHT-MENU_HEIGHT);
		this.shootPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT-MENU_HEIGHT));
		this.shootPanel.setObstacle(Simulation.obstacle);
		this.add(shootPanel, BorderLayout.SOUTH);
		
		this.menuPanel = new MenuPanel();
		this.menuPanel.setPreferredSize(new Dimension(FRAME_HEIGHT, MENU_HEIGHT));
		this.add(menuPanel, BorderLayout.NORTH);
	}

	/**
	 * This restarts a simulation. It does so by firing the ball and repainting
	 * the shot-panel.
	 * @param angle at which angle the shot should be released
	 * @param velocity at which speed the shot should be released
	 * @param interval at which precision the shot should be rendered/calculated
	 */
	public void shoot(double angle, double velocity, double interval){
		Cannonball c = new Cannonball(0.0);
		c.shoot(angle, velocity, interval);
		this.shootPanel.setCannonball(c);
		this.shootPanel.repaint();
	}
}
