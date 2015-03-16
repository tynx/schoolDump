package ex_12_cannonball;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
/**
 * This class handles the button-event fired when pressing shoot in the menupanel
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class AddShootListener implements ActionListener {

	/**
	 * The reference to the angleField so we can set the new values for the
	 * simulation
	 */
	JTextField angleField = null;
	/**
	 * The reference to the velocityField so we can set the new values for the
	 * simulation
	 */
	JTextField velocityField = null;
	/**
	 * The reference to the intervalField so we can set the new values for the
	 * simulation
	 */
	JTextField intervalField = null;
	
	/**
	 * This function reads out the values and fires a new simulation
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
			double angle = 0.0;
			double velocity = 0.0;
			double interval = 0.0;

			angle = Double.parseDouble(angleField.getText());
			velocity = Double.parseDouble(velocityField.getText());
			interval = Double.parseDouble(intervalField.getText());
			Simulation.cf.shoot(angle, velocity, interval);
	}

	/**
	 * Set the reference for the angleField
	 * @param angle the TextField object
	 */
	public void addAngleReference(JTextField angle){
		this.angleField = angle;
	}

	/**
	 * Set the reference for the velocityField
	 * @param velocity the TextField object
	 */
	public void addVelocityReference(JTextField velocity){
		this.velocityField = velocity;
	}

	/**
	 * Set the reference for the intervalField
	 * @param interval the TextField object
	 */
	public void addIntervalReference(JTextField interval){
		this.intervalField = interval;
	}
}
