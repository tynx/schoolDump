package ex_12_cannonball;

import java.awt.geom.Line2D;

public class Simulation {

	public static CannonFrame cf = null;
	public static Line2D obstacle = null;
	
	public static void main(String[] args) {
		obstacle = new Line2D.Double(250,30,280,140);
		//obstacle = new Line2D.Double(250,30,350,130);
		Simulation.cf = new CannonFrame();
		Simulation.cf.setVisible(true);
	}

	

}
