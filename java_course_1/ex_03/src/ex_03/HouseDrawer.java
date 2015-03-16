package ex_03;

/**
 * This helper class setups/draws some houses
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class HouseDrawer {

	/**
	 * Store the frame locally
	 */
	private HouseFrame frame = null;
	
	/**
	 * Constructor which needs a frame to add the houses to
	 * @param frame the frame to which the houses should be added to
	 */
	public HouseDrawer(HouseFrame frame){
		this.frame = frame;
	}
	
	/**
	 * This setups basic 3 houses.
	 */
	public void setup(){
		this.frame.houses.add(new House(50,50,100,150));
		this.frame.houses.add(new House(100,100,300,250));
		this.frame.houses.add(new House(10,200,50,75));
	}
}
