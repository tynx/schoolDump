import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a Logout Listener which implements the 
 * ActionListener Interface
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class LogoutListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Simulation.emailFrame.dispose();
		Simulation.createLoginFrame();		
	}

}
