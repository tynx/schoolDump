package ex_03;

import java.awt.Graphics;


/**
 * This class is basically a shape. it allows an easy way to draw an house to
 * a drawable grahpic. it is basically built in "vector"-style, which means it
 * automatically scales according to the given parameter.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class House {

	/**
	 * The position on the X-Axis
	 */
	private int pos_x=0;
	
	/**
	 * The position on the Y-Axis
	 */
	private int pos_y=0;
	
	/**
	 * The width of the house
	 */
	private int width=0;
	
	/**
	 * This is the height of the house, including the roof
	 */
	private int height=0;

	/**
	 * The position (x/y) is in the very left-top-corner of the house. which is
	 * not part of the actual house, as the roof is there.
	 * 
	 * @param x The position on X-Axis
	 * @param y The Position on y-Axis
	 * @param w the width of the whole house
	 * @param h the height of the whole house
	 */
	public House(int x, int y, int w, int h){
		this.pos_x = x;
		this.pos_y = y;
		this.width = w;
		this.height = h;
	}

	/**
	 * This function draws the complete house on to a Graphics
	 * 
	 * @param g The graphics to draw on
	 */
	public void draw(Graphics g){
		
		// house
		g.drawRect(pos_x, pos_y+height/3, width, height/3*2);

		// roof
		g.drawLine(pos_x, pos_y+(height/3), pos_x+(width/2), pos_y);
		g.drawLine(pos_x+width, pos_y+(height/3), pos_x+(width/2), pos_y);

		//door
		g.drawRect(pos_x+(width/5), pos_y+(height/3*2), width/5, height/3);

		//window
		g.drawRect(pos_x+(width/5*3), pos_y+(height/3*2), width/5, height/6);
		
	}
}
