import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;


public class InfoPanel extends JPanel{

	/**
	 * Not in use so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * label for the informations about the font settings
	 */
	private JLabel infoLabel = null;

	/**
	 * This constructor constructs the info panel
	 */
	public InfoPanel() {
		createInfoPanel();
	}

	/**
	 * This method creates the info panel
	 */
	private void createInfoPanel() {
		this.infoLabel = new JLabel("Welcome", SwingConstants.CENTER);
		this.add(infoLabel);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
	}

	/**
	 * This method set the Text into the info label
	 * @param info new info message
	 */
	public void changeInfoLabel(String info) {
		this.infoLabel.setText(info);
	}
}
