package ex_14_polygon_interface;

import java.util.ArrayList;

/**
 * This class tests our polygon calculation
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 *
 */

public class PolygonTester {
	
	/**
	 * This ArrayList contains all polygon for the current testcase
	 */
	private static ArrayList<Polygon> polygons = new ArrayList<Polygon>();
	
	/**
	 * This ArrayList contains all expected results for the area
	 */
	private static ArrayList<Double> expectedArea = new ArrayList<Double>();
	
	/**
	 * This ArrayList contains all expected results for the perimeter
	 */
	private static ArrayList<Double> expectedPerimeter = new ArrayList<Double>();
	
	/**
	 * This ArrayList contains all expected results for the radius
	 */
	private static ArrayList<Double> expectedRadius = new ArrayList<Double>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testcase1();
	}
		
	/**
	 * This test case adds a rectangle or a triangle to the arraylist polygons and add
	 * the expected result to the specific arraylist and prints out the results by 
	 * calling the methode printpolygon()
	 */
	public static void testcase1() {
		System.out.println("===================== Testcase 1: ===================== \n");
		
		//adding some Rectangles	
		polygons.add(new Rectangle(new Point(1.0,1.0), new Point(9.0,8.0)));
		expectedArea.add(56.0);
		expectedPerimeter.add(30.0);
		expectedRadius.add(5.32);
		
		polygons.add(new Rectangle(new Point(5.0,3.0), new Point(20.0,25.0)));
		expectedArea.add(330.0);
		expectedPerimeter.add(74.0);
		expectedRadius.add(13.31);
		
		polygons.add(new Rectangle(new Point(0.0,0.0), new Point(40.0,12.0)));
		expectedArea.add(480.0);
		expectedPerimeter.add(104.0);
		expectedRadius.add(20.88);
		
		polygons.add(new Triangle(new Point(0.0,0.0), new Point(10.0,0.0), new Point(6.0, 10.0)));
		expectedArea.add(50.0);
		expectedPerimeter.add(32.43);
		expectedRadius.add(6.28);
		
		polygons.add(new Triangle(new Point(4.0,3.0), new Point(24.0,6.0), new Point(15.0,20.0)));
		expectedArea.add(153.50);
		expectedPerimeter.add(57.12);
		expectedRadius.add(11.1);
		
			
		for(int i = 0; i < polygons.size(); i++){
			printPolygon(polygons.get(i), expectedArea.get(i), expectedPerimeter.get(i), expectedRadius.get(i));
		}
	}
	
	/**
	 * This methode formates the output of our testcase
	 * @param p The current Polygon
	 * @param expectedArea 
	 * @param expectedPerimeter
	 * @param expectedRadius
	 */
	public static void printPolygon(Polygon p, double expectedArea, double expectedPerimeter, double expectedRadius){
		System.out.printf("Area:\t\t %.2f\t\t Expected:\t" + expectedArea + "\n",  p.area());
		System.out.printf("Perimeter:\t %.2f\t\t Expected:\t" + expectedPerimeter + "\n", p.perimeter());
		System.out.printf("Radius:\t\t %.2f\t\t Expected:\t" + expectedRadius + "\n\n" , p.circumscribedRadius());
	}
}