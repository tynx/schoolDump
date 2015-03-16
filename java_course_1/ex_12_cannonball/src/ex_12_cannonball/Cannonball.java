package ex_12_cannonball;

import java.util.ArrayList;

/**
 * This class calculates the curve/flight-path of a canonball.
 * There is an interval which decides how precise the path is caluclated. For
 * every path there are 2 parameteres: strengh/velocity and the angle
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Cannonball {

	/**
	 * The position we should the ball. normally 0,0
	 */
	private Point startPosition = new Point();

	/**
	 * The velocity on the X-Axis
	 */
	private double velocityX = 0.0;

	/**
	 * The velocity on the Y-Axis
	 */
	private double velocityY = 0.0;

	/**
	 * The single points of the flying-path
	 */
	private ArrayList<Point> trajectory = new ArrayList<Point>();

	/**
	 * The constructor, which takes the start on the X-Axis as parameter
	 * @param x where the ball should be shot on the X-Axis
	 */
	public Cannonball(Double x){
		this.startPosition.x = x;
	}

	/**
	 * Stores the single points of flying (in depence of deltaT (precision)) in
	 * the array-list.
	 * @param alpha the angle to shot
	 * @param velocity the speed to shot
	 * @param deltaT the precision
	 * @return the list of points of the flying-path
	 */
	public ArrayList<Point> shoot(double alpha, double velocity, double deltaT){
		
		this.velocityX = velocity * Math.cos(alpha*(Math.PI/180));
		this.velocityY = velocity * Math.sin(alpha*(Math.PI/180));
		
		boolean flying = true;

		this.trajectory.add(this.startPosition);
		int steps = 1;
		while(flying){
			double multiplier = deltaT*steps;
			double currentVelocityY = this.velocityY-9.81*multiplier;
			
			Point currentPoint = new Point();
			currentPoint.x = this.startPosition.x+this.velocityX*multiplier;
			currentPoint.y = this.startPosition.y+currentVelocityY*multiplier;
			
			
			if(currentPoint.y < 0)
				flying = false;
			else
				this.trajectory.add(currentPoint);
			steps ++;
		};
		return this.trajectory;
	}

	/**
	 * Returns all previous calculated points. be sure to call shoot before using
	 * this function!
	 * @return the list of points of the flying-path
	 */
	public ArrayList<Point> getTrajectory(){
		return this.trajectory;
	}

	/**
	 * Calculates the perimeter of the flying-path/curve. this is just an
	 * approxiamation. the lower deltaT the preciser this value will be.
	 * Make sure to call shoot before using this function! 
	 * @return the perimeter of the flying-path
	 */
	public double getPerimeter(){
		if(this.trajectory.size() < 1)
			return 0.0;
		int i=0;
		double perimeter = 0.0;
		for(i=1; i<this.trajectory.size(); i++){
			double diffX = this.trajectory.get(i).x - this.trajectory.get(i-1).x;
			double diffY = this.trajectory.get(i).y - this.trajectory.get(i-1).y;
			perimeter += Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		}
		return perimeter;
	}

	/**
	 * This returns the length on the X-Axis of the shoot. Make sure to call
	 * shoot before using this function!
	 * @return the length of the shot
	 */
	public double getLength(){
		if(this.trajectory.size() < 1)
			return 0.0;
		return this.trajectory.get(this.trajectory.size()-1).x - this.trajectory.get(0).x;
	}

	/**
	 * This function returns the highest point in the flying-path. This is an
	 * approximation, so the lower deltaT the preciser this value will be.
	 * @return the highest point of the flying-path
	 */
	public double getMaxY(){
		if(this.trajectory.size() < 1)
			return 0.0;
		int i=0;
		double max = 0.0;
		for(i=0; i<this.trajectory.size(); i++)
			if(this.trajectory.get(i).y > max)
				max = this.trajectory.get(i).y;
		return max;
	}
}
