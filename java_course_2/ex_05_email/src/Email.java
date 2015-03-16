/**
 * This class constructs a Email with the elements sender, recipient, 
 * subject and message
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Email {
	
	/**
	 * The sender adress of the email
	 */
	private String sender = null;
	
	/**
	 * The recipient adress of the email
	 */
	private String recipient = null;
	
	/**
	 * The subject of the email
	 */
	private String subject = null;
	
	/**
	 * The message of the email
	 */
	private String message = null;
	
	/**
	 * This constructor constructs an email with the given parameters
	 * @param sender - sender email address
	 * @param recipient - recipient email address
	 * @param subject - subject of the email
	 * @param message - message of the email
	 */
	public Email(String sender, String recipient, String subject, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.message = message;
	}
	
	/**
	 * This getter method returns the sender address
	 * @return sender
	 */
	public String getSender() {
		return this.sender;
	}
	
	/**
	 * This getter method returns the recipient address
	 * @return recipient
	 */
	public String getRecipient() {
		return this.recipient;
	}
	
	/**
	 * This getter method returns the subject 
	 * @return subject
	 */
	public String getSubject(){
		return this.subject;
	}
	
	/**
	 * This method returns the message
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

}
