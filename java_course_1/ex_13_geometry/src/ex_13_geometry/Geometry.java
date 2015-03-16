package ex_13_geometry;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 * This class calculates various geometric-stuff.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Geometry {

	/**
	 * By bruteforcing, figured out this is the highest possible precision
	 * without overflowing of vars.
	 */
	private final static int PRECISION = 200;

	/**
	 * This function calculates the angle between the given line and the X-Axis
	 * @param line the line to which the angle should be calculated
	 * @return the angle in degrees
	 */
	public static double angle(final Line2D.Double line) {
		double result = Math.atan2(line.y2 - line.y1, line.x2 - line.x1);
		return result*180/Math.PI;
	}

	/**
	 * Calculates the middle-point of a line.
	 * @param line the line in which to search for the middle-point
	 * @return the center/middle of a line
	 */
	public static Point2D.Double middle(final Line2D.Double line) {
		Point2D.Double result = new Point2D.Double();
		result.x = (line.x1 + line.x2) / 2.0;
		result.y = (line.y1 + line.y2) / 2.0;
		return result;
	}

	/**
	 * DONT USE!
	 * Not implemented, not documented, nothing done.
	 * @param e
	 * @return
	 */
	public static double perimeter1(Ellipse2D.Double e){
		// Not implemented as we are group 4a => perimeter1 is optional for us
		return 0.0;
	}

	/**
	 * This method is an approximation for calculating the perimeter of a ellipse
	 * This method uses the formula of Gauss-Kummer. For more detailed
	 * information, please visit:
	 * http://www.mathsisfun.com/geometry/ellipse-perimeter.html
	 * @param e The elipse to calc the perimeter
	 * @return the calculated perimeter
	 */
	public static double perimeter2(Ellipse2D.Double e){

		int i=0;
		double a=0.0, b=0.0, h=0.0, result=1.0;
		Rectangle r = e.getBounds();

		if(r.width > r.height){
			a = r.width;
			b = r.height;
		}else{
			a = r.height;
			b = r.width;
		}

		a/=2;
		b/=2;

		h = Math.pow(a-b, 2) / Math.pow(a+b, 2);

		for(i=1; i<PRECISION; i++){
			if(i>170)
				System.out.println("i:" + i + " val:" + getHalfIntegerFactorial(i));
			result += Math.pow(getHalfIntegerFactorial(i), 2)*Math.pow(h, i);
		}
		return result*(a+b)*Math.PI;
	}

	/**
	 * This calculates the Half-IntegerFactorial of any given number. Its been
	 * optimized so it can handle big numbers. stil just double tho!!
	 * @param n the amount of following factorials
	 * @return the calculated factorialsum
	 */
	public static double getHalfIntegerFactorial(int n){
		int i =0;
		double result = 1.0;
		for(i=1; i<=n; i++)
			result *= 1.0/2.0-i+1;
		for(i=1; i<=n; i++)
			result /= i;

		return result;
	}

}
