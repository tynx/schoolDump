package ex_04_robot_game;

import java.io.Serializable;

/**
 * This class is for storing a position on the grid. 2 attributes, according
 * setters and getters and that's it.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class GridPosition implements Serializable{

	/**
	 * The UID generated for this class
	 */
	private static final long serialVersionUID = 8386356651309226289L;

	/**
	 * The x-position on the grid
	 */
	private int posX = 0;

	/**
	 * the y-position on the grid
	 */
	private int posY = 0;

	/**
	 * Empty constructor, in case the coordinates will be added later on
	 */
	public GridPosition(){ }

	/**
	 * Constructor with coordinates as parameters. this allows to initialize a
	 * complete GridPosition object without calling the setters.
	 * @param x the x-coordinate of the position
	 * @param y the y-coordinate of the position
	 */
	public GridPosition(int x, int y){
		this.posX = x;
		this.posY = y;
	}

	/**
	 * Sets the x-coordinate of the position
	 * @param x x-coordinate of the position
	 */
	public void setX(int x){
		this.posX = x;
	}

	/**
	 * Returns the x-coordinate of the position
	 * @return x-coordinate of the position
	 */
	public int getX(){
		return this.posX;
	}

	/**
	 * Sets the y-coordinate of the position
	 * @param y y-coordinate of the position
	 */
	public void setY(int y){
		this.posY = y;
	}

	/**
	 * Returns the x-ccordinate of the position
	 * @return y-coordinate of the position
	 */
	public int getY(){
		return this.posY;
	}
}
