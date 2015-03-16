package ex_06_lines;

/**
 * This class is able to store a linear function and provides an easy way
 * to get according X/Y-Values as well as the possibility to find the
 * intersection with another linear-function/line.
 * The class saves the function in the format: y=a*x+b
 * where a and b are properties of the class.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Line {

	/**
	 * the multiplicator of x, basically the slope of the line
	 */
	private double a = 0.0;

	/**
	 * the offset on the y-axe.
	 */
	private double b = 0.0;

	/**
	 * This constructors calculates the line based of a point and its direction.
	 * @param p is the starting-point
	 * @param a is the direction/slope of the line
	 */
	public Line(Point p, double a){
		this.a = a;
		this.b = p.y-this.a*p.x;
	}

	/**
	 * This constructor takes the 2 arguments for the normal-form of a linear
	 * function: y=a*x+b.
	 * @param a the a parameter of the function
	 * @param b the b parameter of the function
	 */
	public Line(double a, double b){
		this.a = a;
		this.b = b;
	}

	/**
	 * This constructor just takes the offset on the y-axe. this is useful
	 * for lines which are parallel to the x-axe.
	 * @param a
	 */
	public Line(double b){
		this.b = b;
	}

	/**
	 * This function allows you to get a value on the Y-axe according to the
	 * given X-value.
	 * @param x where to get the Y-value
	 * @return the Y-value for the given X-value
	 */
	public double getY(double x){
		return this.a*x+this.b;
	}

	/**
	 * This function allows you to get a value on the X-axe according to the
	 * given Y-value.
	 * @param y where to get the X-value
	 * @return the X-value for the given Y-value
	 */
	public double getX(double y){
		return (y-this.b)/this.a;
	}

	/**
	 * This function determines whetever the slope/direction, multiplication of
	 * X is the same as in the other line. In case they have the same slope,
	 * they are parallel and thus don't have an intersection.
	 * @param a the slope/direction to compare to
	 * @return whetever both lines have the same slope/direction
	 */
	public boolean sameSlope(double a){
		return (this.a == a) ? true : false;
	}

	/**
	 * This functions figures out, if the lines do have an common intersection.
	 * @param other the other line to check with
	 * @return whetever they have an intersection or not
	 */
	public boolean intersects(Line other){
		if(other.sameSlope(this.a))
			return false;
		return true;
	}

	/**
	 * This functions figures out where two lines cross each other and creating
	 * and intersection. It checks beforehand if we got an parallel line and in
	 * case of that returns a null object. so check for that before using the
	 * point-object.
	 * @param other the other line to check with
	 * @return the point where the two lines cross each other
	 */
	public Point getIntersection(Line other){
		if(!this.intersects(other))
			return null;
		double same_x = (-(this.b - other.b))/(this.a-other.a);
		return new Point(same_x, this.a*same_x+this.b);
	}
}
