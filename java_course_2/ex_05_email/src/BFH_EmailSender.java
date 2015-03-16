import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
   This class sends an e-mail to the BFH e-mail server
   (hermes.bfh.ch).

   Author: jean-paul.dubois@bfh.ch
*/
public class BFH_EmailSender {

	private static final String SERVER = "147.87.244.55";

	/**
     Sends an e-mail.
     @param user the user name of the e-mail sender (e.g. doj1)
     @param passwd its password
     @param recipient the address of the e-mail recipient (e.g. doj1@bfh.ch)
     @param subject the e-mail subject
     @param text the e-mail text
	 */
	public static void send(String passwd, Email email) {		
		// Get system properties
		Properties properties = System.getProperties();

		// Account authenticator
		Authenticator authenticator = new Authenticator(email.getSender(), passwd);
    
		// Setup mail server
		properties.setProperty("mail.smtp.host", SERVER);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.submitter", 
				authenticator.getPasswordAuthentication().getUserName());

		// Get the default Session object.
		Session session = Session.getInstance(properties, authenticator);

		// Create a default MimeMessage object.
		MimeMessage message = new MimeMessage(session);

		// Set the RFC 822 "From" header field using the 
		// value of the InternetAddress.getLocalAddress method.
		try {
			message.setFrom(new InternetAddress(email.getSender()));

			// Set the "Subject" header field.
			message.setSubject(email.getSubject());

			// Set the "To" header field.
			message.setRecipients(javax.mail.Message.RecipientType.TO, email.getRecipient());
			
			// Set the given String as this part's content,
			// with a MIME type of "text/plain".
			message.setText(email.getMessage());
      
			// Send message
			Transport.send(message);
		} catch (AddressException ex) {
			System.out.println("Address exception: " + ex.getMessage());
		} catch (MessagingException ex) {
			System.out.println("Messaging exception: " + ex.getMessage());
		}
	}
  
	private static class Authenticator extends javax.mail.Authenticator {

		private PasswordAuthentication authentication;

		public Authenticator(String user, String passwd) {
			String[] splitedUser = user.split("@");
			authentication = new PasswordAuthentication(splitedUser[0], passwd);
			System.out.println(splitedUser[0]);
			System.out.println(passwd);
		}
		protected PasswordAuthentication getPasswordAuthentication() {
			return authentication;
		}
	}
} 
