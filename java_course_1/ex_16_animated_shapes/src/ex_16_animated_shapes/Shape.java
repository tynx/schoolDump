package ex_16_animated_shapes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class is which handles everything for a shape. This is so, for every shape
 * we want to implement we can reduce the amount of duplicate code.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Shape{

	/**
	 * The color of the shape
	 */
	private Color color = null;

	/**
	 * The direction we are going with this shape. This value should be 0-2*PI
	 */
	private double direction = 0;

	/**
	 * The size of the shape
	 */
	protected int size = 0;

	/**
	 * The current Position of the shape
	 */
	protected Position position = null;

	/**
	 * The offset (means, where the top-left corner is relative to the current
	 * position). This is calculated once, so we don't have to recalculate it
	 * every time.
	 */
	protected int offset = 0;

	/**
	 * With which speed the shape is moving. This is in pixels per draw.
	 */
	private int speed = 0;

	/**
	 * The constructor which initiallizes the whole shape with all according
	 * values. Most of them are random (like the color).
	 * @param x The x-part of the start position
	 * @param y The y-part of the start position
	 */
	public Shape(int x, int y){
		this.position = new Position(x, y);
		// We want a color which is <128,128,128 so the contrast is fine
		this.color = new Color(
			(int)(Math.random()*128),
			(int)(Math.random()*128),
			(int)(Math.random()*128)
		);
		this.size = (int)(Math.random()*4+8)*2; //Size between 16-24 but NOT ODD
		this.offset = (int)(this.size/2);
		this.direction = Math.random()*2*Math.PI;
		this.speed = (int)(Math.random()*4+1);
	}

	/**
	 * This recalculates the position of the shape (one tick further)
	 */
	public void updatePosition(){
		this.position.x += Math.cos(this.direction)*this.speed;
		this.position.y += Math.sin(this.direction)*this.speed;
	}

	/**
	 * This functions figures out if the current shape is out of bounds, where
	 * (0,0) are the minimum and (width,height) are the max which are allowed.
	 * @param width
	 * @param height
	 * @return
	 */
	public boolean isOutside(int width, int height) {
		if(
			this.position.x > width || this.position.x < 0
			||
			this.position.y > height || this.position.y < 0
		) return true;
		return false;
	}

	/**
	 * This functions determines if the given Position is in range of the object.
	 * @param p the position to check for
	 * @return true if the position is within the shape
	 */
	public boolean isInRange(Position p) {
		if(
			p.x > this.position.x - this.offset && p.x < this.position.x + this.offset
			&&
			p.y > this.position.y - this.offset && p.y < this.position.y + this.offset
		) return true;
		return false;
	}

	/**
	 * This functions just sets the color to draw but nothing actually draws.
	 * This means, this class MUST be extended and a draw function has to be
	 * written.
	 * @param g The graphics to draw on
	 */
	public void draw(Graphics2D g){
		g.setColor(this.color);
	}

	/**
	 * This function allows to manually override the position. This can be used
	 * to move the object according to the mouse-movement.
	 * @param x the x-part of the new position
	 * @param y the y-part of the new position
	 * @return
	 */
	public void setCustomPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}

}

