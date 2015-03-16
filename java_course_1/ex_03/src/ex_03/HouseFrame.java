package ex_03;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


/**
 * This is the Frame which is initialized on starting the programm(main). with
 * the help of the HouseDrawer some houses are initialized/drawn instantly.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class HouseFrame extends JFrame{

	/**
	 * for removing the warning (for now...)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This contains all the objects of the houses to be drawn
	 */
	public List<House> houses = new ArrayList<House>();

	/**
	 * Makes new object of HousFrame and initializes the houses via HouseDrawer.
	 * @param args not processed!
	 */
	public static void main(String[] args) {
		HouseFrame hf = new HouseFrame();
		hf.setVisible(true);
		HouseDrawer hd = new HouseDrawer(hf);
		hd.setup();
	}

	/**
	 * This constructor sets some basic settings about the Frame which will be
	 * shown to the user afterwards.
	 */
	public HouseFrame(){
		setTitle("HouseDrawer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,500);
	}

	/**
	 * Overriding the paint method, so we can make sure, our houses get drawn.
	 * Also we want to make sure, we call the super-function.
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int i = 0;
		for (i=0; i<this.houses.size(); i++){
			this.houses.get(i).draw(g);
		}
	}
}
