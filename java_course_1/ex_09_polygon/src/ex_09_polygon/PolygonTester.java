package ex_09_polygon;

public class PolygonTester {
	public static void main(String[] args) {

		testCase1();
		testCase2();
		testCase3();
	}
	
	public static void printPolygon(Polygon p, double expectedSize, double expectedArea, double expectedPerimeter){
		System.out.println("Size:\t\t" + p.size() + " (Expected: " + expectedSize + ")");
		System.out.println("Area:\t\t" + p.area() + " (Expected: " + expectedArea + ")");
		System.out.println("Perimeter:\t" + p.perimeter() + " (Expected: " + expectedPerimeter + ")\n");
	}

	public static void printAnalyzer(PolygonAnalyzer pa, double expectedArea, double expectedPerimeter){
		System.out.println("\nInitialized PolygonAnalyzer as following:");
		System.out.println(pa.toString());
		System.out.println("Max Area:\t\t" + pa.maxArea().area() + " (Expected: " + expectedArea + ")");
		System.out.println("Acerage Perimeter:\t" + pa.averagePerimeter() + " (Expected: " + expectedPerimeter + ")");
	}
	
	public static void testCase1(){
		System.out.println("\tTESTCASE 1\nTesting single Polygons:");
		
		Polygon p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,2));
		p.addPoint(new Point(2,2));
		p.addPoint(new Point(2,0));
		printPolygon(p, 4, 4, 8);

		p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,3));
		p.addPoint(new Point(4,3));
		
		printPolygon(p, 3, 6, 12);

		p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,8));
		p.addPoint(new Point(8,8));
		p.addPoint(new Point(8,0));
		printPolygon(p, 4, 64, 32);
		
		p = new Polygon();
		p.addPoint(new Point(2,0));
		p.addPoint(new Point(2-Math.sqrt(2),Math.sqrt(2)));
		p.addPoint(new Point(2,2*Math.sqrt(2)));
		p.addPoint(new Point(2+Math.sqrt(2),Math.sqrt(2)));
		printPolygon(p, 4, 4, 8);
		
	}
	
	public static void testCase2(){
		System.out.println("\n\n\tTESTCASE 2\nTesting PolygonAnalyzer:");

		PolygonAnalyzer pa = new PolygonAnalyzer();
		
		Polygon p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,2));
		p.addPoint(new Point(2,2));
		p.addPoint(new Point(2,0));
		pa.addPolygon(p);

		p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,3));
		p.addPoint(new Point(4,3));
		pa.addPolygon(p);

		p = new Polygon();
		p.addPoint(new Point(0,0));
		p.addPoint(new Point(0,8));
		p.addPoint(new Point(8,8));
		p.addPoint(new Point(8,0));
		pa.addPolygon(p);
		
		p = new Polygon();
		p.addPoint(new Point(2,0));
		p.addPoint(new Point(2-Math.sqrt(2),Math.sqrt(2)));
		p.addPoint(new Point(2,2*Math.sqrt(2)));
		p.addPoint(new Point(2+Math.sqrt(2),Math.sqrt(2)));
		pa.addPolygon(p);
	
		printAnalyzer(pa, 64, 15);
	}
	
	public static void testCase3(){
		System.out.println("\n\n\tTESTCASE 3\nTesting more complex Polygons:");
		
		int i=0, length=1000;
		Polygon p = new Polygon();
		p.addPoint(new Point(0,0));
		
		for(i=0; i<length; i++){
			p.addPoint(new Point(i,((i%2==0) ? 1 : 2)));
			p.addPoint(new Point(i,((i%2==0) ? 2 : 1)));
		}
		
		p.addPoint(new Point(length-1, 0));
		printPolygon(p, length*2+2, (length-1)*2 - ((length-2)/2), 2*length+length);
		
		int pointsPerLine = 10000;
		
		p = new Polygon();
		p.addPoint(new Point(0,0));
		
		for(i=1; i<=pointsPerLine; i++){
			p.addPoint(new Point(0,3.0/pointsPerLine*i));
		}
		for(i=0; i<=pointsPerLine; i++){
			p.addPoint(new Point(4.0/pointsPerLine*i,3));
		}

		printPolygon(p, pointsPerLine*2+2,6,12);
	}
}
