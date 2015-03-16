package ex_04_robot_game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * This class handles the drawing of the game.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class RobotGameComponent extends JComponent{

	/**
	 * The UID generated for this class
	 */
	private static final long serialVersionUID = -7044989108394318799L;

	/**
	 * All the data of the game is saved in here. These objects are needed to
	 * actually draw the robots/grid
	 */
	private GameData gameData = null;

	/**
	 * The constructor which expect a populated gameData-object
	 * @param gameData the objects to draw
	 */
	public RobotGameComponent(GameData gameData){
		// Set window-size
		this.setPreferredSize(new Dimension(
			Settings.WINDOW_SIZE_X,
			Settings.WINDOW_SIZE_Y
		));
		this.gameData = gameData;
	}

	/**
	 * This method is called according to the FPS configured. It draws the grid
	 * and all the roboters with their current position on the grid.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.gameData.getGrid().draw(g);
		for(Robot r : this.gameData.getRobots()){
			g.setColor(r.getColor());
			g.fillOval(
				(int)r.getDrawPositionX(),
				(int)r.getDrawPositionY(),
				Settings.ROBOT_SIZE,
				Settings.ROBOT_SIZE
			);
		}
	}
}
