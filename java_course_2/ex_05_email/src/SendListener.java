import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class creates a Login Listener which implements the 
 * ActionListener Interface
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SendListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(checkRecipient() == false) {
			String password = Simulation.getPasswordofUser(Simulation.emailFrame.getCurrentUser());
			BFH_EmailSender.send(password, createEmail());
		} 
	}
	
	/**
	 * This method checks if the recipient is a "local" user or if it's a "real" email address.
	 * @return boolean value
	 */
	private boolean checkRecipient() {
		for(int i=0; i < Simulation.mailboxes.size(); i++) {
			if (Simulation.emailFrame.getRecipient().equals(Simulation.mailboxes.get(i).getUser())) {
				Simulation.mailboxes.get(i).receiveEmail(createEmail());
				return true;
			} 
		}
		return false;
	}
	
	/**
	 * This method creates a email
	 * @return email
	 */
	private Email createEmail() {
		Email email = new Email(Simulation.emailFrame.getCurrentUser(), Simulation.emailFrame.getRecipient(), 
				Simulation.emailFrame.getSubject(), Simulation.emailFrame.getMessage());
		return email;
	}
}
