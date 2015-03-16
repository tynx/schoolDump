import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;

/**
 * This Frame is for putting all panels together. The GUI has 4 Parts: A menubar,
 * a sample panel, a infopanel and a setting panel.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class FontViewerFrame extends JFrame {

	/**
	 * Not used so far, for supressing warnings
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The width of the sample panel
	 */
	private static final int SAMPLE_WIDTH = 400;

	/**
	 * The height of the sample panel
	 */
	private static final int SAMPLE_HEIGHT = 300;

	/**
	 * The sample panel for presenting the font and the image
	 */
	private SamplePanel samplePanel = null;

	/**
	 * The info panel for information about the actual settings
	 */
	private InfoPanel infoPanel = null;

	/**
	 * The setting panel for editing the sample panel
	 */
	private SettingPanel settingPanel = null;

	/**
	 * The menu bar for save, exit and editing the background color
	 */
	private MenuBar menuBar = null;
	
	/**
	 * Constructor which sets up the whole window and all the other panels which
	 * are needed. it also layouts them.
	 */
	public FontViewerFrame() {
		this.menuBar = new MenuBar();
		this.setJMenuBar(this.menuBar);

		this.samplePanel = new SamplePanel();
		this.samplePanel.setPreferredSize(new Dimension(SAMPLE_WIDTH, SAMPLE_HEIGHT));
		this.add(this.samplePanel, BorderLayout.NORTH);

		this.infoPanel = new InfoPanel();
		this.add(this.infoPanel, BorderLayout.CENTER);

		this.settingPanel = new SettingPanel();
		this.add(this.settingPanel, BorderLayout.SOUTH);

		this.pack();
	}
	
	/**
	 * This method analyse changes in the setting panel, change this changes in the
	 * sample panel and repaint the sample panel
	 */
	public void setSampleChanges(){
		String fontName = null;
		int fontStyle = 0;
		int fontSize = 0;
		
		//Get font name
		fontName = this.settingPanel.getFontName();
		
		//Get font style
		if(this.settingPanel.checkStyleItalic()) fontStyle += Font.ITALIC;
		if(this.settingPanel.checkStyleBold()) fontStyle += Font.BOLD;
		
		//Get font size
		fontSize = this.settingPanel.getFontSize();
		
		this.samplePanel.changeSettings(fontName, fontStyle, fontSize);
		changeInfoLabel("Font size: " + fontSize);
		this.samplePanel.repaint();
	}
	
	/**
	 * This method change the background color of the sample panel and repaint
	 * the sample panel
	 * @param color which is choosed in the ColorChoose Dialog
	 */
	public void setSampleColor(Color color){
		this.samplePanel.changeColor(color);
		this.samplePanel.repaint();
	}
	
	/**
	 * This method calls the method changeInfoLabel in the class InfoPanel and
	 * change the vlaue
	 * @param info
	 */
	public void changeInfoLabel(String info) {
		this.infoPanel.changeInfoLabel(info);
	}
}
