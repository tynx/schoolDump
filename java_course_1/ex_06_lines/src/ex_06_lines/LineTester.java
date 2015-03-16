package ex_06_lines;

/**
 * This class tests the Line-class. It does so by having three testcases. One of
 * the lines will not change troghout the testcase, the other will move up and
 * downwards. (no change of slope) Third testcase: no intersection!
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class LineTester {

	/**
	 * This function is the entry-point and just runs all test-cases.
	 * @param args not processed at this point
	 */
	public static void main(String[] args) {
		testCase1();
		System.out.println("\n");
		testCase2();
		System.out.println("\n");
		testCase3();
	}

	/**
	 * This function provides an easy way to print out 2 points, one of which
	 * is the expected point and the other the calculated point.
	 * @param expected the expected point
	 * @param intersection the calculated point
	 */
	public static void printPoints(Point expected, Point intersection){
		String expectedString = "(" + expected.x + "," + expected.y + ")";
		String intersectionString = "(" + intersection.x + "," + intersection.y + ")";
		System.out.print("Intersection expected:" + expectedString);
		System.out.println(" actual intersection: " + intersectionString);
	}

	/**
	 * This is the first testcase, which has two lines intersecting at different
	 * points as the loop increases the position of the second line.
	 */
	public static void testCase1(){
		Line l1 = new Line(1,0);
		Line l2 = null;
		Point expected = null;
		Point intersection = null;
		int i = 0;
		
		for(i=0; i<20; i++){
			expected = new Point((double)i/2,(double)i/2);
			l2 = new Line(-1,i);
			intersection = l1.getIntersection(l2);
			if(intersection != null)
				printPoints(expected, intersection);
			else
				System.out.println("Parallels found!");
		}
	}

	/**
	 * This is the second testcase, which has two lines intersecting at different
	 * points as the loop increases the position of the second line.
	 */
	public static void testCase2(){
		Line l1 = new Line(3,5);
		Line l2 = null;
		Point expected = null;
		Point intersection = null;
		int i = 0;
		
		for(i=0; i<20; i++){
			expected = new Point((0.25*i)-1.25,i*0.75+1.25);
			l2 = new Line(-1,i);
			intersection = l1.getIntersection(l2);
			if(intersection != null)
				printPoints(expected, intersection);
			else
				System.out.println("Parallels found!");
		}
	}

	/**
	 * This is the third testcase, which has two lines, which are parallels. So
	 * we should not get any point-outputs here.
	 */
	public static void testCase3(){
		Line l1 = new Line(-2.25,5);
		Line l2 = null;
		Point expected = null;
		Point intersection = null;
		int i = 0;
		
		for(i=0; i<20; i++){
			expected = new Point(0,0);
			l2 = new Line(-2.25,i);
			intersection = l1.getIntersection(l2);
			if(intersection != null)
				printPoints(expected, intersection);
			else
				System.out.println("Parallels found!");
		}
	}
}
