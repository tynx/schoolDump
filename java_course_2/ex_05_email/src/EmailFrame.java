import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * This class creates the JFrame for the Email GUI
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class EmailFrame extends JFrame {
	/**
	 * Not in use so far
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The height of the frame
	 */
	private static final int FRAME_HEIGHT = 450;
	
	/**
	 * the width of the frame
	 */
	private static final int FRAME_WIDTH = 450;
	
	/**
	 * the width of the text fields
	 */
	private static final int TEXTFIELD_WIDTH = 10;
	
	/**
	 * the recipient JTextField
	 */
	private JTextField recipientField = null;
	
	/**
	 * the subject JTextField
	 */
	private JTextField subjectField = null;
	
	/**
	 * The message JTextField
	 */
	private JTextField messageField = null;
	
	/**
	 * the current User JLabel
	 */
	private JLabel currentUserLabel = null;
	
	/**
	 * the send JButton
	 */
	private JButton sendButton = null;
	
	/**
	 * The logout JButton
	 */
	private JButton logoutButton = null;
	
	/**
	 * This String stores the current logged in user
	 */
	public String currentUser = null;

	/**
	 * This constructor creates the email gui
	 * @param currentUser which is current logged in
	 */
	public EmailFrame(String currentUser) {
		this.currentUser = currentUser;
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(new GridLayout(0,1));
		this.add(createInboxPanel());
		this.add(createEmailWritePanel());
		this.add(createControlPanel());
		addSendListener();
		addLogoutListener();
	}
	
	/**
	 * This method creates a JPanel with the Inbox of the current logged in user
	 * @return inboxPanel which contains the Inbox
	 */
	private JPanel createInboxPanel() {
		this.currentUserLabel = new JLabel("inbox of " + this.currentUser);
		JPanel inboxPanel = new JPanel();
		JTable inboxTable = new JTable(createInboxContent(), createTableColumnNames());
		
		inboxPanel.setLayout(new GridLayout(0,1));
		inboxPanel.add(this.currentUserLabel);
		inboxPanel.add(new JScrollPane(inboxTable));
		
		return inboxPanel;
	}
	
	/**
	 * This method creates a JPanel with the components to write an new email
	 * @return writePanel which contains the formula elements
	 */
	private JPanel createEmailWritePanel() {
		JLabel recipientLabel = new JLabel("recipient: ");
		this.recipientField = new JTextField(TEXTFIELD_WIDTH);
		JLabel subjectLabel = new JLabel("subject: ");
		this.subjectField = new JTextField(TEXTFIELD_WIDTH);
		JLabel messageLabel = new JLabel("message: ");
		this.messageField = new JTextField(TEXTFIELD_WIDTH);
		JPanel writePanel = new JPanel();
		
		writePanel.setLayout(new GridLayout(0,2));
		writePanel.add(recipientLabel);
		writePanel.add(this.recipientField);
		writePanel.add(subjectLabel);
		writePanel.add(this.subjectField);
		writePanel.add(messageLabel);
		writePanel.add(this.messageField);
		
		return writePanel;
	}
	
	/**
	 * This method creates a JPanel with the possibility to logout and send
	 * emails
	 * @return controlPanel which contains two JButtons
	 */
	private JPanel createControlPanel() {
		this.sendButton = new JButton("send");
		this.logoutButton = new JButton("logout");
		JPanel controlPanel = new JPanel();
		
		controlPanel.add(this.sendButton);
		controlPanel.add(this.logoutButton);
		return controlPanel;
	}
	
	/**
	 * This method creates the content of the inbox table
	 * @return tableContent which is a String array 
	 */
	private String[][] createInboxContent() {
		ArrayList<Email> emails = Simulation.getEmails(this.currentUser);
		
		if(emails != null) {
			String[][] tableContent = new String[emails.size()][4];
			for(int i = 0; i < emails.size(); i++) {
					tableContent[i][0] = emails.get(i).getSender();
					tableContent[i][1] = emails.get(i).getRecipient();
					tableContent[i][2] = emails.get(i).getSubject();
					tableContent[i][3] = emails.get(i).getMessage();
			}
			return tableContent;
		}
		return null;
	}
	
	/**
	 * This method creates the column names of the table
	 * @return tableColumnNames which is a String array
	 */
	private String[] createTableColumnNames() {
		String[] tableColumnNames = {
			"sender", "recipient", "subject", "message"
		};
		return tableColumnNames;
	}
	
	/**
	 * This method adds a SendListener to the sendButton
	 */
	private void addSendListener() {
		SendListener listener = new SendListener(); 
		this.sendButton.addActionListener(listener);
	}
	
	/**
	 * This method adds a LogoutButton to the logoutButton
	 */
	private void addLogoutListener() {
		LogoutListener listener = new LogoutListener();
		this.logoutButton.addActionListener(listener);
	}
	
	/**
	 *  This getter method returns the content of the recipientField
	 * @return content of the recipientField
	 */
	public String getRecipient() {
		return this.recipientField.getText();
	}
	
	/**
	 * This getter method returns the content of the subjectField
	 * @return content of the SubjectField
	 */
	public String getSubject() {
		return this.subjectField.getText();
	}
	
	/**
	 * This getter method returns the content of the messageField
	 * @return content of the messageField
	 */
	public String getMessage() {
		return this.messageField.getText();
	}
	
	/**
	 * This getter method returns the current logged in user
	 * @return currentUser
	 */
	public String getCurrentUser() {
		return this.currentUser;
	}
}
