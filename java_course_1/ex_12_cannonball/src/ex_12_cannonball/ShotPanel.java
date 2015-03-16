package ex_12_cannonball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ex_13_geometry.Geometry;

/**
 * This Panel draws the actual simulation. it handles the statistics, flying-path
 * and as well the obstacle.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class ShotPanel extends JPanel{

	/**
	 * Not used so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The offset (height of menu). kinda hacky, but no professional layouting
	 * was requested nor teached.
	 */
	private static final int OFFSET = 30;

	/**
	 * The width of one oval
	 */
	private static final int OVAL_WIDTH = 10;

	/**
	 * The height of one oval
	 */
	private static final int OVAL_HEIGHT = 5;

	/**
	 * The cannonball object, which contains all needed data for the current
	 * simulation.
	 */
	private Cannonball cannonball = null;

	/**
	 * Translated from normal points to ellipses for drawing are stored in here.
	 */
	private ArrayList<Ellipse2D> trajectory = new ArrayList<Ellipse2D>();

	/**
	 * The obstacle which should be drawn and respected for the animation
	 */
	private Line2D.Double obstacle = null;

	/**
	 * The current height of the panel
	 */
	private int height = 0;

	/**
	 * the current width of the panel
	 */
	private int width = 0;

	/**
	 * At which index of "trajectory" the ball collides with the obstacle. If -1
	 * no collision has happened in the simulation.
	 */
	private int collisionIndex = -1;

	/**
	 * Constructor of the panel
	 * @param width the width of the panel
	 * @param height the height of the panel
	 */
	public ShotPanel(int width, int height){
		this.width = width;
		this.height = height;
	}

	/**
	 * This sets an obstacle and translates it into the new "axis-system"
	 * @param obstacle
	 */
	public void setObstacle(Line2D obstacle){
		this.obstacle = new Line2D.Double(
				obstacle.getP1().getX(),
				this.height-obstacle.getP1().getY()-OFFSET,
				obstacle.getP2().getX(),
				this.height-obstacle.getP2().getY()-OFFSET
			);
	}

	/**
	 * This sets the cannonball. The trajectory is recalculated and translated so
	 * it can be understood by the paint method. Also the collisionIndex is
	 * calculated.
	 * @param ball
	 */
	public void setCannonball(Cannonball ball){
		this.cannonball = ball;
		ArrayList<Point> trajectory = this.cannonball.getTrajectory();
		this.collisionIndex = -1;
		this.trajectory = new ArrayList<Ellipse2D>();
		int i = 0;
		for(i=0; i<trajectory.size(); i++){
			double x = trajectory.get(i).x-OVAL_WIDTH/2;
			double y = height-(trajectory.get(i).y-OVAL_HEIGHT/2)-OFFSET-OVAL_HEIGHT;
			
			Ellipse2D current = new Ellipse2D.Double(x, y, OVAL_WIDTH, OVAL_HEIGHT);

			this.trajectory.add(current);

			Rectangle a = current.getBounds();
			Rectangle b = this.obstacle.getBounds();
			if((b.x < a.x+a.width) && (b.x+b.width > a.x) &&  (b.y < a.y+a.height) && (b.y+b.height > a.y))
				this.collisionIndex = i;
		}
	}

	/**
	 * Paints the background, obstacle, stats, flying-path
	 */
	@Override
	public void paint(Graphics g) {

		int i =0;

		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255,255,255));
		g2d.fillRect(0, 30, this.width, this.height);
		
		g2d.setColor(new Color(0,0,0));
		g2d.draw(this.obstacle);
		g2d.drawLine(0, height-OFFSET, this.width, height-OFFSET);

		if(this.cannonball!=null){
			g2d.drawString("Perimeter: "+this.cannonball.getPerimeter(), 100, 100);
			g2d.drawString("Length: "+this.cannonball.getLength(), 100, 115);
			g2d.drawString("Max height: "+this.cannonball.getMaxY(), 100, 130);
			g2d.drawString("Angle: "+Geometry.angle(this.obstacle)*-1, 100, 145);
		}

		for(i=0; i<this.trajectory.size(); i++){
			if(i==collisionIndex)
				g2d.setColor(new Color(255, 0, 0));
			g2d.fill(this.trajectory.get(i));
		}
	}
}
