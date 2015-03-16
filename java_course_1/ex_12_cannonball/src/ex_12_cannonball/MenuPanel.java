package ex_12_cannonball;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This Panel puts the user-input related stuff (called menu) together.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MenuPanel extends JPanel{

	/**
	 * Not used so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Maximal input length of all the textFields
	 */
	private static final int LENGTH_INPUT = 10;

	/**
	 * The field for entering the angle
	 */
	private JTextField angleField = null;

	/**
	 * The field for entering the velocity
	 */
	private JTextField velocityField = null;

	/**
	 * The field for entering the interval
	 */
	private JTextField intervalField = null;

	/**
	 * The button for starting a new simulation
	 */
	private JButton shootButton = null;

	/**
	 * Constructor which creates the menu and adds the events
	 */
	public MenuPanel(){
		createMenu();
		addEventListener();
	}
	
	/**
	 * Creates the text fields and the label
	 */
	private void createMenu(){
		
		JLabel angleLabel = new JLabel("Angle (0 < angle < 90): ");
		this.angleField = new JTextField(LENGTH_INPUT);
		this.add(angleLabel);
		this.add(this.angleField);
		
		JLabel velocityLabel = new JLabel("Velocity: ");
		this.velocityField = new JTextField(LENGTH_INPUT);
		this.add(velocityLabel);
		this.add(this.velocityField);
		
		JLabel intervalLabel = new JLabel("Interval: ");
		this.intervalField  = new JTextField(LENGTH_INPUT);
		this.add(intervalLabel);
		this.add(this.intervalField);
		
		this.shootButton = new JButton("Shot");
		add(this.shootButton);
	}

	/**
	 * creates the button shoot and and a new Actionlistener
	 */
	private void addEventListener(){
		AddShootListener shoot = new AddShootListener();
		this.shootButton.addActionListener(shoot);
		shoot.addAngleReference(this.angleField);
		shoot.addVelocityReference(this.velocityField);
		shoot.addIntervalReference(this.intervalField);
	}

}
