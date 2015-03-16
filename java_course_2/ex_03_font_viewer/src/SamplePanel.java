import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class creates the sample panel with the two parts 
 * text label and image label
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SamplePanel extends JPanel {

	/**
	 * Not in use so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * label for the text, which is editable
	 */
	private JLabel textLabel = null;

	/**
	 * label for the picture
	 */
	private JLabel imageLabel = null;

	/**
	 * Constructor which constructs the sample panel
	 */
	public SamplePanel() {
		createSamplePanel();
	}

	/**
	 * This method creates the sample panel
	 */
	private void createSamplePanel() {
		this.setLayout(new GridLayout(2, 1));
		this.textLabel = new JLabel("Big Java", SwingConstants.CENTER);
		this.add(this.textLabel);
		this.imageLabel = new JLabel(new ImageIcon("BigJava.jpg"));
		this.add(this.imageLabel);
	}

	/**
	 * This method changes the font, the style and the size of the text label
	 * @param font new font 
	 * @param style new style of the font
	 * @param size new size of the font
	 */
	public void changeSettings(String font, int style, int size) {
		this.textLabel.setFont(new Font(font, style, size));
	}

	/**
	 * This method changes the background color of the sample panel
	 * @param color which was selected in the ColorChooser Dialog
	 */
	public void changeColor(Color color){
		this.setBackground(color);
	}
}
