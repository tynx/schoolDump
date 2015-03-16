package ex_04_robot_game;

/**
 * This class contains all the constants for the RobotGame.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Settings {

	/**
	 * The width of a single field on the grid
	 */
	public static final int FIELD_SIZE_X = 50;

	/**
	 * The height of a single field on the grid
	 */
	public static final int FIELD_SIZE_Y = 50;

	/**
	 * The amount of fields on the x-axis of the grid
	 */
	public static final int FIELDS_COUNT_X = 10;

	/**
	 * The amount of fields on the y-axis of the grid
	 */
	public static final int FIELDS_COUNT_Y = 10;

	/**
	 * The overall window-width resulting out of the previous settings
	 */
	public static final int WINDOW_SIZE_X = Settings.FIELD_SIZE_X*Settings.FIELDS_COUNT_X;

	/**
	 * The overall window-height resulting out of the previous settings
	 */
	public static final int WINDOW_SIZE_Y = Settings.FIELD_SIZE_Y*Settings.FIELDS_COUNT_Y;

	/**
	 * The number of robots on the grid
	 */
	public static final int ROBOT_AMOUNT = 20;

	/**
	 * The size of the robots.
	 */
	public static final int ROBOT_SIZE = 30;

	/**
	 * The x-offset, needed to center the robot in a field of the grid
	 */
	public static final int ROBOT_DRAW_OFFSET_X = (Settings.FIELD_SIZE_X-Settings.ROBOT_SIZE)/2;

	/**
	 * The y-offset, needed to center the robot in a field of the grid
	 */
	public static final int ROBOT_DRAW_OFFSET_Y = (Settings.FIELD_SIZE_Y-Settings.ROBOT_SIZE)/2;

	/**
	 * The FPS of the game. Meaning how many frames per second should be drawn
	 */
	public static final int FPS = 25;

	/**
	 * The file, in which the serialized object should be saved.
	 */
	public static final String SAVEFILE = "/tmp/gameData.ser";
}
