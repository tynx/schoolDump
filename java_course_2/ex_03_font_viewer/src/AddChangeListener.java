import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class handles actions and changes in the setting panel
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class AddChangeListener implements ActionListener, ChangeListener {

	/**
	 * This method calls the method setSampleChanges() to change the font settings
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
		FontViewer.frame.setSampleChanges();
	}

	/**
	 * This method class the method setSampleChanges() to change the font settings
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		FontViewer.frame.setSampleChanges();
	}
}
