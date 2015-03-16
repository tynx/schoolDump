/**
 * 
 */
package ex_12_cannon_ball;

import static java.lang.Math.*;

import java.awt.Graphics2D;
import java.awt.List;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

/**
 * @author whazaa
 *
 */
public class Cannonball {
	
	//Gravity
	private static final double g = 9.81;
	private double vX = 0.0;
	private double vY = 0.0;
	private double xAxis = 0.0;
	private double yAxis = 0.0;
	private double duration = 0.0;
	private ArrayList<Point2D.Double> coordinates = new ArrayList<Point2D.Double>();
	
	/**
	 * This constructor allows to determines the value of the X-axis
	 * @param x
	 */
	public Cannonball(double x){
		this.xAxis = x;
	}
	/**
	 * This constructor determines the initial position
	 */
	public Cannonball(){
	}

	/**
	 * This methode determines the X-velocity and the Y-velocity and fills the position of the Cannonball, 
	 * depending on the timeinterval, into an ArrayList.
	 * @param alpha
	 * @param vStart
	 * @param deltaT
	 */
	public void shoot(double alpha, double vStart, double deltaT){
		this.vX = vStart * cos(toRadians(alpha));
		this.vY = vStart * sin(toRadians(alpha));
		
		do{		
			getVy(deltaT);
			this.coordinates.add(calcPoint(deltaT));
			this.duration += deltaT;
		} while(this.coordinates.get(this.coordinates.size()-1).y > 0.0);
	}
	
	/**
	 * This methode updates the Y-Velocity.
	 * @param deltaT
	 */
	private void getVy(double deltaT){
		this.vY -= g*deltaT;
	}
	
	/**
	 * This methode calculate the current position of the Cannonball and stores the 
	 * coordinates in an object. If the position of the Y-axis is negativ or 0.0, the methode
	 * set the position of the X-Axis to the position, when y is equal 0.0
	 * @param time
	 * @return
	 */
	private Point2D.Double calcPoint(double time){
		this.yAxis += roundPos(this.vY*time); 

		//Check if the shoot cross the y-Axis
		if(this.yAxis <= 0.0 && this.duration != 0.0){
			time -= (this.yAxis) / this.vY;
			this.yAxis = 0.0;
		}
		this.xAxis += roundPos(this.vX*time);
		return new Point2D.Double(this.xAxis, this.yAxis);
	}
	
	/**
	 * This methode round the positions on 4 digits
	 * @param value
	 * @return
	 */
	private double roundPos(double value){
		double valueRounded = value * 10000.0;
		return round(valueRounded) / 10000.0;
	}
	
	/**
	 * This methode returns the ArrayList with the coordinates
	 * @return
	 */
	public ArrayList<Point2D.Double> getCoordinates(){
		return this.coordinates;
	}
}