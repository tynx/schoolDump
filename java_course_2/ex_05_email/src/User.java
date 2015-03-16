/**
 * This class creates a User with a email address as username
 * and a password
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class User {
	
	/**
	 * This String is the email adress to send emails
	 *  and the username to login
	 */
	private String user = null;
	
	/**
	 * This string is the password to login
	 */
	private String password = null;
	
	/**
	 * This constructor constructs a user with a username 
	 * and a password
	 * @param user
	 * @param password
	 */
	public User(String user, String password) {
		this.user = user;
		this.password = password;
	}

	/**
	 * This getter method returns the username of the user
	 * @return user
	 */
	public String getUser() {
		return this.user;
	}
	
	/**
	 * This getter method returns the password of the user
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
}
