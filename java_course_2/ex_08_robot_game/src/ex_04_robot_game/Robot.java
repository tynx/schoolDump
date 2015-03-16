package ex_04_robot_game;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class simulates a robot. The roboter should be run as a thread. It
 * calculates with the help of the Grid-class the moves it should make.
 * The calculation of the move is pure randomness, but still it's made sure,
 * that 2 roboters don't collide. Even if that means, he stays where is he is.
 * That is the case, if there is no free place to move to.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Robot implements Runnable, Serializable {

	/**
	 * The UID generated for this class
	 */
	private static final long serialVersionUID = -6636581692276345098L;

	/**
	 * The ID of the thread. This is used for printing log-messages
	 */
	private long threadId = -1L;

	/**
	 * The position of the robot on the grid
	 */
	private GridPosition gp = null;

	/**
	 * The grid it moves on
	 */
	private Grid grid = null;

	/**
	 * The color, the robot is drawn
	 */
	private Color color = null;

	/**
	 * A Random-object, as this used quite often in this class (just a shortcut)
	 */
	private Random random = new Random();

	/**
	 * The constructor. It generates a random color for the robot, as well as
	 * a random position on the grid.
	 * @param g the Grid to move on
	 */
	public Robot(Grid g){
		this.grid = g;
		this.initPosition();
		this.initColor();
	}

	/**
	 * This initializes the position. First the grid is locked, then a complete
	 * random of all the free spaces is selected and the robot places itself
	 * there. 
	 */
	private void initPosition(){
		this.grid.lockGrid();
		ArrayList<GridPosition> spaces = this.grid.getFreeSpaces();
		GridPosition p = spaces.get(this.random.nextInt(spaces.size()));
		this.gp = new GridPosition(p.getX(), p.getY());
		this.grid.reserveSpace(this.gp);
		this.grid.unlockGrid();
	}

	/**
	 * Creates a random color. As the background is quite bright, and we want
	 * a good enough contrast to actually see the root, we only select values
	 * between 0-190 instead of 0-255.
	 */
	private void initColor(){
		int red = this.random.nextInt(190);
		int green = this.random.nextInt(190);
		int blue = this.random.nextInt(190);
		this.color = new Color(red,green,blue);
	}

	/**
	 * Returns the color of the robot
	 * @return color of the robot
	 */
	public Color getColor(){
		return this.color;
	}

	/**
	 * Returns the x-coordinate in form of pixels, instead of only the
	 * grid-position, which is not usable for drawing on the Component.
	 * @return the x-coordinate in pixels
	 */
	public double getDrawPositionX(){
		return this.gp.getX()*Settings.FIELD_SIZE_X+Settings.ROBOT_DRAW_OFFSET_X;
	}

	/**
	 * Returns the y-coordinate in form of pixels, instead of only the
	 * grid-position, which is not usable for drawing on the Component.
	 * @return the y-coordinate in pixels
	 */
	public double getDrawPositionY(){
		return this.gp.getY()*Settings.FIELD_SIZE_Y+Settings.ROBOT_DRAW_OFFSET_Y;
	}

	/**
	 * This method allows to set the ID of the thread. As this ID should be
	 * unique, the method only allows to set the value once.
	 * @param id the id of the thread the robot is running in
	 */
	public void setId(long id){
		if(this.threadId == -1L)
			this.threadId = id;
	}

	/**
	 * This function returns a random Position around the current position on
	 * the grid. If the adjacent spaces around the current position are all
	 * occupied, this function returns null.
	 * @return a random adjacent position or null, if none is free
	 */
	private GridPosition getRandomAdjacentPosition(){
		ArrayList<GridPosition> spaces = this.grid.getAdjacentFreeSpaces(this.gp);
		if(spaces.size() != 0){
			GridPosition p = spaces.get(this.random.nextInt(spaces.size()));
			return new GridPosition(p.getX(), p.getY());
		}
		return null;
	}

	/**
	 * This method handles a complete move of a robot.
	 */
	private void move(){
		GridPosition newP= this.getRandomAdjacentPosition();
		if(newP!=null){
			this.grid.reserveSpace(newP);
			this.grid.freeSpace(this.gp);
			this.gp.setX(newP.getX());
			this.gp.setY(newP.getY());
			System.out.println("Thread " + this.threadId + ": Robot made a move.");
		}else{
			System.out.println("Thread " + this.threadId + ": Robot couldn't make a move.");
		}
	}

	/**
	 * The run-method should be called with the help of the Thread-Class, as 
	 * this method is never-ending as long as the RobotGame is running. It makes
	 * a move waits some miliseconds, and then again makes a move, until the
	 * game is stopped.
	 */
	@Override
	public void run() {
		System.out.println("Thread " + this.threadId + ": Robot is started.");
		while(RobotGame.isRunning()){
			// try to lock the grid, so no interfearence is happening
			try{
				this.grid.lockGrid();
				this.move();
			}finally{ // ALWAYS unlock!
				this.grid.unlockGrid();
			}
			try {
				Thread.sleep(this.random.nextInt(250)+500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread " + this.threadId + ": Robot is quitting.");
	}
}
