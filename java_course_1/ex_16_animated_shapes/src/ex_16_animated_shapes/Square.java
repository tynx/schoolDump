package ex_16_animated_shapes;

import java.awt.Graphics2D;

/**
 * This class is for the Square-Shape for the animated shapes. It extends from
 * Shape, so it is just necessary to have a constructor and the draw function.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Square extends Shape implements MoveableShape{

	/**
	 * The constructor just calls the super-constructor and everything is handled
	 * there. The two parameters are to define where to start.
	 * @param x the x-position to start
	 * @param y the y-position to start
	 */
	public Square(int x, int y) {
		super(x, y);
		
	}

	/**
	 * This overwrittes the draw function, to make sure we draw an square shape.
	 * Make sure the parent-draw is called so everything else is handled (like
	 * color).
	 */
	@Override
	public void draw(Graphics2D g){
		super.draw(g);
		g.fillRect(
			(int)this.position.x-this.offset,
			(int)this.position.y-this.offset,
			this.size,
			this.size
		);
	}
}
