
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * This class creates the sample panel with the two parts 
 * text label and image label
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SettingPanel extends JPanel {

	/**
	 * Not in use so far
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This combo box is for choosing another font
	 */
	private JComboBox<String> fontComboBox = null;

	/**
	 * This check box is for choosing the font style italic
	 */
	private JCheckBox italicCheckBox = null;

	/**
	 * This check box is for choosing the font style bold
	 */
	private JCheckBox boldCheckBox = null;

	/**
	 * This slider is for changing the font size
	 */
	private JSlider sizeSlider = null;

	/**
	 * This constructor constructs the setting panel 
	 */
	public SettingPanel() {
		createSettingPanel();
		addEventListener();
	}

	/**
	 * This method creates the setting panel
	 */
	private void createSettingPanel() {
		this.setLayout(new GridLayout(3, 1));
		this.add(createFontPanel());
		this.add(createStylePanel());
		this.add(createSizePanel());
	}

	/**
	 * This method creates the combo box for choosing 
	 * a new font 
	 * @return fontPanel which contains a combo box
	 */
	private JPanel createFontPanel() {
		this.fontComboBox = new JComboBox<String>();
		this.fontComboBox.addItem("Serif");
		this.fontComboBox.addItem("SansSerif");
		this.fontComboBox.addItem("Monospaced");
		
		JPanel fontPanel = new JPanel();
		fontPanel.add(this.fontComboBox);
		
		return fontPanel;
	}

	/**
	 * This method creates the check boxes for choosing
	 * an other font style
	 * @return stylePanel which contains check boxes
	 */
	private JPanel createStylePanel() {
		this.italicCheckBox = new JCheckBox("Italic");
		this.boldCheckBox = new JCheckBox("Bold");
		
		JPanel stylePanel = new JPanel();
		stylePanel.add(this.italicCheckBox);
		stylePanel.add(this.boldCheckBox);
		stylePanel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));
		
		return stylePanel;
	}

	/**
	 * This method creates a slider for changing the font size
	 * @return sizePanel which contains a slider
	 */
	private JPanel createSizePanel() {
		this.sizeSlider = new JSlider();
		this.sizeSlider.setMinorTickSpacing(10);
		this.sizeSlider.setMajorTickSpacing(20);
		this.sizeSlider.setMaximum(72);
		this.sizeSlider.setMinimum(10);
		this.sizeSlider.setPaintLabels(true);
		this.sizeSlider.setPaintTicks(true);
		
		JPanel sizePanel = new JPanel();
		sizePanel.add(this.sizeSlider);
		sizePanel.setBorder(new TitledBorder(new EtchedBorder(), "Size"));
		return sizePanel;
	}

	/**
	 * Creates a new addChangeListener
	 */
	private void addEventListener(){
		AddChangeListener listener = new AddChangeListener();
		this.fontComboBox.addActionListener(listener);
		this.italicCheckBox.addChangeListener(listener);
		this.boldCheckBox.addChangeListener(listener);
		this.sizeSlider.addChangeListener(listener);
	}

	/**
	 * This method returns the current selected font
	 * @return the selected font as String
	 */
	public String getFontName() {
		return (String) this.fontComboBox.getSelectedItem();
	}

	/**
	 * This method returns if the check box is selected
	 * @return a boolean value if the check box is selected or not
	 */
	public boolean checkStyleItalic() {
		return this.italicCheckBox.isSelected();
	}

	/**
	 * This method returns if the check box is selected
	 * @return a boolean value if the check box is selected or not
	 */
	public boolean checkStyleBold() {
		return this.boldCheckBox.isSelected();
	}

	/**
	 * This method returns the current font size
	 * @return a int value
	 */
	public int getFontSize() {
		return this.sizeSlider.getValue();
	}
}
