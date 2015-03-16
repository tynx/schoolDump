package ex_04_robot_game;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class handles the whole grid. It provides a 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Grid implements Serializable{
	/**
	 * UID, generated for this class
	 */
	private static final long serialVersionUID = 8092635459405319605L;

	/**
	 * This is the lock of the grid. Roboters need to lock the whole grid before
	 * access it in any way. This is to make sure, 2 roboters cannot reserve
	 * the same position on the grid.
	 */
	private Lock lock = new ReentrantLock();

	/**
	 * The width of a field in the grid
	 */
	private int fieldWidth = Settings.FIELD_SIZE_X;

	/**
	 * The height of a field in the grid
	 */
	private int fieldHeight = Settings.FIELD_SIZE_Y;

	/**
	 * The amount of fields on the x-axis
	 */
	private int numX = Settings.FIELDS_COUNT_X;

	/**
	 * The amount of fields on the y-axis
	 */
	private int numY = Settings.FIELDS_COUNT_Y;

	/**
	 * The grid-fields represented as booleans. false means the field/position
	 * on the grid is free. true means, that a roboter is in that position
	 * and the field is occupied.
	 */
	private boolean [][] fields = new boolean[this.numX][this.numY];

	/**
	 * Empty constructor, we don't need to do anything.
	 */
	public Grid(){ }

	/**
	 * This function locks the whole grid. This is necessary(!) before ANY
	 * interactions with a grid-object. Every function may return biased
	 * information if multiple threads are accessing it parallel.
	 */
	public void lockGrid(){
		lock.lock();
	}

	/**
	 * This function unlocks the grid and gives possible access to other
	 * threads.
	 */
	public void unlockGrid(){
		lock.unlock();
	}

	/**
	 * This function tells whetever the Position is occupied by a roboter or
	 * not.
	 * @param p the position on the grid to check
	 * @return true if the space is already occupied
	 */
	public boolean isUsedSpace(GridPosition p){
		return this.fields[p.getX()][p.getY()];
	}

	/**
	 * This function reserves a position on the grid.
	 * @param p the position on the grid to set to occupied
	 */
	public void reserveSpace(GridPosition p){
		this.fields[p.getX()][p.getY()] = true;
	}

	/**
	 * This function sets a position on the grid as free.
	 * @param p the position on the grid to set to free
	 */
	public void freeSpace(GridPosition p){
		this.fields[p.getX()][p.getY()] = false;
	}

	/**
	 * Returns a list of all free spaces on the grid. This is particullary handy
	 * for the case of initialization of roboters. They may choose a complete 
	 * random position on the grid.
	 * @return a list of all free spaces on the grid
	 */
	public ArrayList<GridPosition> getFreeSpaces(){
		ArrayList<GridPosition> freeSpaces = new ArrayList<GridPosition>();
		int i=0;
		int j=0;
		for(i=0; i<this.fields.length; i++){
			for(j=0; j<this.fields[0].length; j++){
				if(this.fields[i][j] == false)
					freeSpaces.add(new GridPosition(i, j));
			}
		}
		return freeSpaces;
	}

	/**
	 * Returns a list of all free spaces around a particular point on the grid.
	 * The point itself is not added to the list. Also if the position around
	 * could end in "outofboundry"-area, it will be ignored as well.
	 * @param p the position to search around
	 * @return all the free spaces around the position given
	 */
	public ArrayList<GridPosition> getAdjacentFreeSpaces(GridPosition p){
		ArrayList<GridPosition> freeSpaces = new ArrayList<GridPosition>();
		int i=0, j=0;
		for(i=(p.getX()>0) ? p.getX()-1 : p.getX(); i<p.getX()+2; i++){
			if(i>this.numX-1)
				continue;
			for(j=( p.getY()>0 ) ? p.getY()-1 : p.getY(); j<p.getY()+2; j++){
				if(j>this.numY-1)
					continue;
				if(this.fields[i][j] == false)
					freeSpaces.add(new GridPosition(i,j));
			}
		}
		return freeSpaces;
	}

	/**
	 * This function draws the grid. Basically some horizontal and some vertical
	 * lines.
	 * @param g the surface to draw on.
	 */
	public void draw(Graphics g){
		int i=0;
		g.setColor(new Color(0,0,0));
		for(i=1; i<=this.numX; i++){
			g.drawLine(
				i*this.fieldWidth,
				0,
				i*this.fieldWidth,
				this.numY*this.fieldHeight
			);
		}
		for(i=1; i<=this.numY; i++){
			g.drawLine(
				0,
				i*this.fieldHeight,
				this.numX*this.fieldWidth,
				i*this.fieldHeight
			);
		}
		
	}
}
