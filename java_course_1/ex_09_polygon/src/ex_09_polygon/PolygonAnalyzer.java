package ex_09_polygon;

import java.util.ArrayList;

/**
 * This class provides a way of handling multiple polygons and allows to
 * calculate various things about the polygons
 * 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class PolygonAnalyzer {

	/**
	 * The polygons are saved in here.
	 */
	private ArrayList<Polygon> polygons = new ArrayList<Polygon>();

	/**
	 * This adds a polygon to the list
	 * @param polygon the polygon to add
	 * @return whetever successful or not
	 */
	public boolean addPolygon(Polygon polygon){
		return this.polygons.add(polygon);
	}

	/**
	 * This sets a polygon at the given position in the list
	 * @param position the position at which it should be set
	 * @param polygon the polygon
	 * @return whetever successful or not
	 */
	public boolean setPolygon(int position, Polygon polygon){
		return (this.polygons.set(position, polygon) != null);
	}

	/**
	 * Removes a polygon from the list
	 * @param position which polygon
	 * @return whetever successful or not
	 */
	public boolean removePolygon(int position){
		return (this.polygons.remove(position) != null);
	}

	/**
	 * Finds the polygon with the biggest area and returns the object of it.
	 * @return the polygon with the biggest area
	 */
	public Polygon maxArea(){
		if(this.polygons.size() == 0)
			return null;
		
		int i=0;
		int max_position = 0;
		double max = this.polygons.get(0).area();
		for(i=0; i<this.polygons.size(); i++){
			if(this.polygons.get(i).area() > max){
				max = this.polygons.get(i).area();
				max_position = i;
			}
		}
		return this.polygons.get(max_position);
	}

	/**
	 * Sums up all the perimeters of all polygons and calculates the average.
	 * @return the average perimeter of all polygons
	 */
	public double averagePerimeter(){
		if(this.polygons.size() == 0)
			return 0.0;
		int i=0;
		double average = 0.0;
		for(i=0; i<this.polygons.size(); i++){
			average += this.polygons.get(i).perimeter();
		}
		return average/this.polygons.size();
	}

	/**
	 * Print out all polygons.
	 */
	public String toString(){
		int i=0;
		String asString = "Polygon\t\tSize\tPerimeter\tArea\n";
		if(this.polygons.size() == 0)
			asString ="No Polygons available!\n";
		for(i=0; i<this.polygons.size(); i++){
			asString += (i+1) + "\t\t";
			asString += this.polygons.get(i).size() + "\t";
			asString += this.polygons.get(i).perimeter() + "\t\t";
			asString += this.polygons.get(i).area() + "\n";
		}
		return asString;
	}
}
