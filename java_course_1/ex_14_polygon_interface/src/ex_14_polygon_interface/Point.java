package ex_14_polygon_interface;

/**
 * This class is a very basic class for storing the x/y-values of a point. There
 * is no manipulation of the values at all.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Point {

	/**
	 * X-Coordinate values of the Point
	 */
	public double x = 0.0;

	/**
	 * Y-Coordinate values of the Point
	 */
	public double y = 0.0;

	/**
	 * The constructor without any params
	 */
	public Point(){}

	/**
	 * The constructor which allows to set point-coordinates while creating
	 * the object.
	 * @param position_x
	 * @param position_y
	 */
	public Point(double position_x, double position_y){
		this.x = position_x;
		this.y = position_y;
	}
}