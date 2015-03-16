package ex_12_cannon_ball;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CannonballView extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT  = 600;
	private static final String title = "the battlefield";
	
	private JLabel angleLabel;
	private JTextField angleField;
	private JLabel velocityLabel;
	private JTextField velocityField;
	private JLabel intervalLabel;
	private JTextField intervalField;
	private JButton shootButton;
	private JComponent component;
	
	public CannonballView(){
		createTextField();
		createButton();
		createPanel();
		//Problem
		createComponent();
		setTitle(title);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	/**
	 * Creates the text fields and the label
	 */
	private void createTextField(){
		final int WIDTH = 10;
		this.angleLabel = new JLabel("Angle (0 < angle < 90): ");
		this.velocityLabel = new JLabel("Velocity: ");
		this.intervalLabel = new JLabel("Time-Interval: ");
		
		this.angleField = new JTextField(WIDTH);
		this.velocityField = new JTextField(WIDTH);
		this.intervalField  = new JTextField(WIDTH);
	}
	/**
	 * creates the button shoot and and a new Actionlistener
	 */
	private void createButton(){
		this.shootButton = new JButton("shoot");
		ActionListener shoot = new AddShootListener();
		this.shootButton.addActionListener(shoot);
	}
	/**
	 * Creates the Panel shootPanel and add the text fields and the button to the panel
	 * finally it adds the pannel to the frame
	 */
	private void createPanel(){
		JPanel shootPanel = new JPanel();
		shootPanel.add(this.angleLabel);
		shootPanel.add(this.angleField);
		shootPanel.add(this.velocityLabel);
		shootPanel.add(this.velocityField);
		shootPanel.add(this.intervalLabel);
		shootPanel.add(this.intervalField);
		shootPanel.add(this.shootButton);
		this.add(shootPanel);
	}
	/**
	 * Creates the Jcomponent in which the shootline should be draw in
	 */
	private void createComponent(){
		//Problem
		this.add(component);
	}

	/**
	 * This class get the data from the textfield and create a new Object cannonball
	 *
	 */
	public class AddShootListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			Cannonball cannon = new Cannonball();
			double angle = Double.parseDouble(angleField.getText());
			double velocity = Double.parseDouble(velocityField.getText());
			double interval = Double.parseDouble(intervalField.getText());
				
			if(angle >= 90.0) angleField.setText("0 < angle < 90 !!!");
			else { 
				cannon.shoot(angle, velocity, interval);
				//Problem
				component = new CannonballDraw(cannon.getCoordinates());
				component.repaint();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame battlefield = new CannonballView();
		battlefield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		battlefield.setVisible(true);
	}
}
