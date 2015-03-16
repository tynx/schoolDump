package ex_09_polygon;

import java.util.ArrayList;

/**
 * This class provides a way of calculating different attributes of an polygon.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Polygon {

	/**
	 * The points are saved in here
	 */
	private ArrayList<Point> points = new ArrayList<Point>();

	/**
	 * normal constructor
	 */
	public Polygon(){ }

	/**
	 * Constructor with a list of points
	 * @param points
	 */
	public Polygon(ArrayList<Point> points){
		this.points = points;
	}

	/**
	 * Calculates the distance between the points
	 * @param p1 First point
	 * @param p2 Second point
	 * @return distance of the points
	 */
	private double distance(Point p1, Point p2){
		double dx = Math.abs(p1.x - p2.x);
		double dy = Math.abs(p1.y - p2.y);
		return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
	}

	/**
	 * Adds a Point to the polygon
	 * @param point the point to add
	 * @return whetever successful or not
	 */
	public boolean addPoint(Point point){
		return this.points.add(point);
	}

	/**
	 * Sets a Point at the given position
	 * @param position the position in the list
	 * @param point the point to be set
	 * @return whetever successful or not
	 */
	public boolean setPoint(int position, Point point){
		return (this.points.set(position, point) != null);
	}

	/**
	 * Removes a Point from the polygon
	 * @param position the point to delete
	 * @return whetever successful or not
	 */
	public boolean removePoint(int position){
		return (this.points.remove(position) != null);
	}

	/**
	 * Returns the size of the polygons (points)
	 * @return the number of points
	 */
	public double size(){
		return (double)this.points.size();
	}

	/**
	 * Calculates the perimeter of the polygon
	 * @return the perimeter of the polygon
	 */
	public double perimeter(){
		double perimeter = 0.0;
		int i=0;
		for(i=0; i<this.points.size(); i++){
			perimeter += this.distance(this.points.get(i), this.points.get((i+1)%this.points.size()));
		}
		
		return perimeter;
	}

	/**
	 * Calculates the area of the polygon. Used formula:
	 * 1/2(x[0]*y[1]+x[1]*y[2]+...+x[n-1]*y[0]-y[0]*x[1]-y[1]*x[2]-....-y[n-1]*x[0])
	 * @return the area of the polygon
	 */
	public double area(){
		int i=0;
		double area = 0.0;
		for(i=0; i<this.points.size(); i++){
			area += this.points.get((i+1)%this.points.size()).x * this.points.get(i).y;
		}
		for(i=0; i<this.points.size(); i++){
			area -= this.points.get(i).x * this.points.get((i+1)%this.points.size()).y;
		}
		return (area/2);
	}
}
