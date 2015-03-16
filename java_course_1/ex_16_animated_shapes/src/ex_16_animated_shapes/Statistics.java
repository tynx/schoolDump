package ex_16_animated_shapes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This class is which handles everything about the statistics. The update should
 * be called atleast once every 100ms. Otherwise points well be lost with this
 * implementation. It doesn't matter if it's called more than once every 100ms.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Statistics {

	/**
	 * How often points should be added (once every 100ms)
	 */
	private static int updateInterval = 100;

	/**
	 * The current sum of Points
	 */
	private int currentPoints=0;

	/**
	 * The current record of points
	 */
	private int maxPoints=0;

	/**
	 * When the last update happened
	 */
	private long lastUpdate = 0;

	/**
	 * Constructor which is currently not used.
	 */
	public Statistics(){};

	/**
	 * This updates the statistics. Atleast if the last call was 100ms away.
	 * @param number the amount of points should be added
	 * @return whetever the update happened or not
	 */
	public boolean update(int number){
		if(System.currentTimeMillis()- Statistics.updateInterval < this.lastUpdate)
			return false;

		this.lastUpdate = System.currentTimeMillis();
		this.currentPoints += number;
		if(this.currentPoints > this.maxPoints)
			this.maxPoints = this.currentPoints;
		return true;
	}

	/**
	 * This function draws the statistics on the panel. if the record is being
	 * broken, it apperas in red.
	 * @param g the graphics to draw on
	 */
	public void draw(Graphics2D g){
		if(this.maxPoints == this.currentPoints && this.currentPoints != 0)
			g.setColor(new Color(255,0,0));
		else
			g.setColor(new Color(0,0,0));

		g.drawString("Current: " + this.currentPoints, 20, 20);
		g.drawString("Max: " + this.maxPoints, 150, 20);
	}

	/**
	 * This function simply resets the current points, but not the record.
	 */
	public void reset(){
		this.currentPoints = 0;
		this.lastUpdate = 0;
	}
}
