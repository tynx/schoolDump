package ex_13_geometry;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class is for testing the Geometry-class with the help of JUnit.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class GeometryTest{

	@Test
	public void testAngle() {

		// y is constant => 0
		testAngle(5, 0, 20, 0, 0.0);
		testAngle(10, 15, 50, 15, 0.0);

		// x is constant => 90 or -90
		testAngle(0, 10, 0, 50, 90.0);
		testAngle(0, 50, 0, 10, -90.0);

		//other
		testAngle(0, 0, -10, 10, 135.0);
		testAngle(0, 0, -10, -10, -135.0);
		testAngle(0, 0, 20, 20, 45.0);
		testAngle(0, 0, 20, -20, -45.0);
	}

	private void testAngle(final double x1, final double y1, final double x2, final double y2, final double expectedAngle) {
		 Assert.assertEquals(expectedAngle, Geometry.angle(new Line2D.Double(x1, y1, x2, y2)), 0.00001);
	}

	@Test
	public void testMiddle() {
		testMiddle(1, 4, 3, 7, 2, 5.5);
		testMiddle(-31, -2, 3, -4, -14, -3);
	}

	private void testMiddle(final double x1, final double y1, final double x2, final double y2, final double expectedX, final double expectedY) {
		Assert.assertEquals(new Point2D.Double(expectedX, expectedY), Geometry.middle(new Line2D.Double(x1, y1, x2, y2)));
	}

	@Test
	public void testPerimeter2() {
		// http://www.mathsisfun.com/geometry/ellipse-perimeter.html
		testPerimeter2(10, 10, 62.832);
		testPerimeter2(10, 5, 48.442);
		testPerimeter2(10, 3, 43.859);
		testPerimeter2(10, 1, 40.639);
		testPerimeter2(10, 0, 39.988);
	}

	private void testPerimeter2(final double a, final double b, final double expectedValue) {
		final double perimeter = Geometry.perimeter2(new Ellipse2D.Double(0, 0, 2 * a, 2 * b));
		Assert.assertEquals(expectedValue, perimeter, 0.1);
	}
}
