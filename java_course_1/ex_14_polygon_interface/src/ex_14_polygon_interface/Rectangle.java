package ex_14_polygon_interface;

import static java.lang.Math.*;

/**
 * This class is for the rectangle polygon. It callculates the area, the perimeter 
 * and the circumscribed radius of the rectangle. It implements the interface Polygon. 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Rectangle implements Polygon {

	/**
	 * The length of the site a
	 */
	private double a = 0.0;
	
	/**
	 * The length of the site b
	 */
	private double b = 0.0;
	
	/**
	 * This cunstructor creates the rectangle with the params p1 and p2 
	 * 
	 * @param p1 the position of a first point
	 * @param p2 the position of a second point
	 */
	public Rectangle(Point p1, Point p2){
		this.a = abs(p1.x - p2.x);
		this.b = abs(p1.y - p2.y);
	}
	
	/**
	 * This methode calculate the area of a rectangle by multiply site a and site b
	 * 
	 * @return the area of the rectangle
	 */
	@Override
	public double area() {
		return this.a * this.b;
	}

	/**
	 * This methode calculates the perimeter of a rectangle by adding all sites 
	 * 
	 * @return the area of the rectangle
	 */
	@Override
	public double perimeter() {
		return 2*(this.a + this.b);
	}

	/**
	 * This methode calculate the circumscribed radius of a rectangle
	 * 
	 * @return the radius of the circumscribed circle
	 */
	@Override
	public double circumscribedRadius() {
		double x = pow(this.a, 2) + pow(this.b, 2);
		return 0.5*sqrt(x);
	}
	
	
}
