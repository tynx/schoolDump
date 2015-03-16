import java.util.ArrayList;

/**
 * This class creates a mailbox with a user and the possibility to hold 
 * and reveive emails
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Mailbox {
	
	/**
	 * This ArrayList stores the received emails
	 */
	private ArrayList<Email> emails = new ArrayList<Email>();
	
	/**
	 * This user is authentification with the mailbox
	 */
	private User user = null;
	
	/**
	 * This constructor constructs a mailbox with a given user
	 * @param user
	 */
	public Mailbox(User user) {
		this.user = user;
	}
	
	/**
	 * This method stores a received email in this mailbox
	 * @param email
	 */
	public void receiveEmail(Email email) {
		this.emails.add(email);
	}
	
	/**
	 * This getter method returns the user of this mailbox
	 * @return user
	 */
	public String getUser() {
		return this.user.getUser();
	}
	
	/**
	 * This getter method returns the password from the
	 * user of this mailbox
	 * @return password
	 */
	public String getPassword() {
		return this.user.getPassword();
	}

	/**
	 * This getter method returns the stored emails
	 * @return emails
	 */
	public  ArrayList<Email> getEmails() {
		return emails;
	}

}
