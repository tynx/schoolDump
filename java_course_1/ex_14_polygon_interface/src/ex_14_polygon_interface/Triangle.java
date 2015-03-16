package ex_14_polygon_interface;

import static java.lang.Math.*;

/**
 * This class is for the triangle polygon. It callculates the area, the perimeter 
 * and the circumscribed radius of the triangle. It implements the interface Polygon. 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Triangle implements Polygon {

	/**
	 * The length of the site a
	 */
	private double a = 0.0;
	
	/**
	 * The length of the site b
	 */
	private double b = 0.0;
	
	/**
	 * The length of the site c
	 */
	private double c = 0.0;
	
	
	/**
	 * This cunstructor creates the Triangle with the params pA, pB, pC and fill the
	 * instance variables by calling the methode getDistance() 
	 * the methode getDistance
	 * 
	 * @param pA the position of the point A
	 * @param pB the position of the point B
	 * @param pC the position of the point C
	 */
	public Triangle(Point pA, Point pB, Point pC){
		this.a = getDistance(pB, pC);
		this.b = getDistance(pA, pC);
		this.c = getDistance(pA, pB);
	}
	
	/**
	 * This methode calculate the distance between two points by using pythagoras
	 *  
	 * @param p1 Corner of the triangle
	 * @param p2 Corner of the triangle
	 * @return the length of the distance
	 */
	private double getDistance(Point p1, Point p2){
		double dx = abs(p1.x-p2.x);
		double dy = abs(p1.y-p2.y);
		return sqrt(pow(dx, 2) + pow(dy, 2));
	}
	
	/**
	 * This methode calculate the area of triangle by using the formula of Heron
	 * 
	 * @return the area of the triangle
	 */
	@Override
	public double area() {
		double s  = (this.a + this.b + this.c) / 2;
		double x = s*(s-this.a)*(s-this.b)*(s-this.c);
		return sqrt(x);
	}

	/**
	 * This methode calculate the perimeter of an triangle by adding the sites of
	 * the triangle
	 * 
	 * @return the perimeter of the triangle
	 */
	@Override
	public double perimeter() {
		return (this.a + this.b + this.c);
	}

	/**
	 * This methode calculate the circumscribed radius of a triangle with the following 
	 * formula:  a*b*c / 4*area
	 * 
	 * @return the radius of the circumscribed circle
	 */
	@Override
	public double circumscribedRadius() {
		double top = this.a*this.b*this.c;
		double bottom = 4*area();
		return top/bottom;
	}
}
