package ex_04_robot_game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores all the information about the grid an the robots. This
 * wrapper is for making it easier to serialize all the needed data.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class GameData implements Serializable{

	/**
	 * UID, generated for this class
	 */
	private static final long serialVersionUID = 6012023518727530930L;

	/**
	 * All the robots are stored in here
	 */
	private ArrayList<Robot> robots = new ArrayList<Robot>();

	/**
	 * The grid is stored in here
	 */
	private Grid grid = null;

	/**
	 * If the constructor is called (meaning the object wasnt created via de-
	 * serialization), we create a new grid and robots
	 */
	public GameData(){
		this.grid = new Grid();
		int i=0;
		for(i=0; i<Settings.ROBOT_AMOUNT; i++){
			this.robots.add(new Robot(this.grid));
		}
	}

	/**
	 * Returns the current grid-object
	 * @return grid-object
	 */
	public Grid getGrid(){
		return this.grid;
	}

	/**
	 * Returns all the robots created for the game.
	 * @return arraylist of the robots
	 */
	public ArrayList<Robot> getRobots(){
		return this.robots;
	}
}
