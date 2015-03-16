package ex_16_animated_shapes;

import java.awt.Graphics2D;

/**
 * This interface is used for all object which should be drawn on to the game-
 * panel.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public interface MoveableShape {

	/**
	 * Whetever the Shape is outside of the given area
	 * @param width the width of the area
	 * @param height the height of the area
	 * @return true if outside of area
	 */
	public boolean isOutside(int width, int height);

	/**
	 * Whetever the given Point/Position is within the area of the shape
	 * @param p the position
	 * @return true if the position was within the area of the shape
	 */
	public boolean isInRange(Position p);

	/**
	 * This allows to reset the position of a shape at any given time
	 * @param x the x-part of the new position
	 * @param y the y-part of the new position
	 */
	public void setCustomPosition(int x, int y);

	/**
	 * One movement-tick is triggered by this method
	 */
	public void updatePosition();

	/**
	 * The draw of a shape is done via this method
	 * @param g the surface to draw on
	 */
	public void draw(Graphics2D g);
}
