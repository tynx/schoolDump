package ex_12_cannon_ball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class CannonballDraw extends JComponent {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Point2D.Double> coordinates = new ArrayList<Point2D.Double>();
	
	public CannonballDraw(ArrayList<Point2D.Double> coordinates){
		this.coordinates = coordinates;
	}

	/**
	 * This methode draws the shoot-line with ellipses
	 * @param g
	 */
	public void paintComponent (Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < this.coordinates.size(); i++){
			Ellipse2D.Double ellipse = new Ellipse2D.Double(this.coordinates.get(i).x, this.coordinates.get(i).y, 2.5, 1.5);
			g2.draw(ellipse);
		}
	}
}
