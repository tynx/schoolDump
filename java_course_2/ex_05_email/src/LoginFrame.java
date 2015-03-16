import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class creates the login Frame, where the user can 
 * login
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class LoginFrame extends JFrame {
	/**
	 * not used so far
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * the height of the frame
	 */
	private static final int FRAME_HEIGHT = 150;
	
	/**
	 * the width of the frame
	 */
	private static final int FRAME_WIDTH = 450;
	
	/**
	 * the width of the text fields
	 */
	private static final int TEXTFIELD_WIDTH = 10;
	
	/**
	 * a JLable with information for the user
	 */
	private JLabel infoLabel = null;
	
	/**
	 * a JTextField for the username
	 */
	private JTextField userField = null;
	
	/**
	 * a JTextField for the password
	 */
	private JPasswordField passwordField = null;
	
	/**
	 * a JButton which provide the login
	 */
	private JButton loginButton = null;
	
	/**
	 * This constructor constructs the login frame
	 */
	public LoginFrame() {
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.add(createLoginPanel());
		addLoginListener();
	}
	
	/**
	 * This method creates the login panel with all the needed elements
	 * @return loginPanel
	 */
	private JPanel createLoginPanel() {
		this.infoLabel = new JLabel("Please enter your e-mail adress and password and confirm with login");
		JLabel userLabel = new JLabel("e-mail adress: ");
		this.userField = new JTextField(TEXTFIELD_WIDTH);
		JLabel passwordLabel = new JLabel("password: ");
		this.passwordField = new JPasswordField(TEXTFIELD_WIDTH);
		this.loginButton = new JButton("login");
		JPanel loginPanel = new JPanel();
			
		loginPanel.add(this.infoLabel);
		loginPanel.add(userLabel);
		loginPanel.add(this.userField);
		loginPanel.add(passwordLabel);
		loginPanel.add(this.passwordField);
		loginPanel.add(this.loginButton);
			
		return loginPanel;
	}
	
	/**
	 * This method adds a LoginListener to the login Button
	 */
	private void addLoginListener() {
		LoginListener listener = new LoginListener();
		this.loginButton.addActionListener(listener);	
	}
	
	/**
	 * This getter method returns the username in the JTextField
	 * userField
	 * @return username
	 */
	public String getUser() {
		return this.userField.getText();
	}
	
	/**
	 * This getter method returns the password in the JTextField 
	 * passwordField
	 * @return
	 */
	public String getPassword() {
		String password = this.passwordField.toString();
		return password;
	}
	
	/**
	 * This method sets the text of the infolabel with the parameter
	 * loginInfo
	 * @param loginInfo
	 */
	public void setInfoLabelText(String loginInfo) {
		this.infoLabel.setText(loginInfo);
	}
}
