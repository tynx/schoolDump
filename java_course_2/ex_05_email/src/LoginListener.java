import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a Login Listener which implements the 
 * ActionListener Interface
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class LoginListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(checkLogin() == false) {
			Simulation.loginFrame.setInfoLabelText("Your login failed, please try again!");
		}
	}
	
	/**
	 * This method checks if the username and password exists and are correct
	 * @return boolean value
	 */
	private boolean checkLogin() {
		for(int i=0; i < Simulation.mailboxes.size(); i++) {
			if(Simulation.loginFrame.getUser().equals(Simulation.mailboxes.get(i).getUser())) {
				Simulation.loginFrame.dispose();
				Simulation.createEmailFrame(Simulation.mailboxes.get(i).getUser());
				return true;
			} 
		}
		return false;
	}


}
