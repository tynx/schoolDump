import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * This class is the entry point of the programm 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Simulation {
	
	/**
	 * first test user
	 */
	public static User jerome = new User("jamij1@bfh.ch", "test123$");
	
	/**
	 * second test user
	 */
	public static User tim = new User ("lugit1@bfh.ch", "test123$");
	
	/**
	 * List which contains all mailboxes
	 */
	public static ArrayList<Mailbox> mailboxes = new ArrayList<Mailbox>();
	
	/**
	 * login frame for the login procedure
	 */
	public static LoginFrame loginFrame = null;
	
	/**
	 * frame for the mailbox 
	 */
	public static EmailFrame emailFrame = null;

	
	public static void main(String[] args) {
		Simulation.mailboxes.add(new Mailbox(jerome));
		Simulation.mailboxes.add(new Mailbox(tim));
		
		createLoginFrame();
	}
	
	/**
	 * this method creates a login frame
	 */
	public static void createLoginFrame() {
		Simulation.loginFrame = new LoginFrame();
		Simulation.loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Simulation.loginFrame.setTitle("FontViewer");
		Simulation.loginFrame.setVisible(true);
	}
	
	/**
	 * this method creates a email frame for the logged in user
	 * @param currentUser
	 */
	public static void createEmailFrame(String currentUser) {
		Simulation.emailFrame = new EmailFrame(currentUser);
		Simulation.emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Simulation.emailFrame.setTitle("FontViewer");
		Simulation.emailFrame.setVisible(true);
	}
	
	/**
	 * this method returns the emails of an user
	 * @param user
	 * @return
	 */
	public static ArrayList<Email> getEmails(String user) {
		for(int i = 0; i < Simulation.mailboxes.size(); i++) {
			if(user.equals(Simulation.mailboxes.get(i).getUser())) {
				return Simulation.mailboxes.get(i).getEmails();
			}
		}
		return null;
	}
	
	/**
	 * this method returns the password for a user
	 * @param user
	 * @return
	 */
	public static String getPasswordofUser(String user) {
		for(int i = 0; i < Simulation.mailboxes.size(); i++) {
			if(user.equals(Simulation.mailboxes.get(i).getUser())) {
				return Simulation.mailboxes.get(i).getPassword();
			}
		}
		return null;
	}
}
