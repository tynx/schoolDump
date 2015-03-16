import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * This class creates the menu bar
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MenuBar extends JMenuBar {

	/**
	 * Not in use so far, to supress warnings
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This constructor constructs the menu bar
	 */
	public MenuBar() {
		this.add(createFileMenu());
	}

	/**
	 * This method creates the file menu
	 * @return menu
	 */
	private JMenu createFileMenu(){
		JMenu menu = new JMenu("File");
		menu.setMnemonic('F');
		menu.add(createFileSaveItem());
		menu.add(createFileExitItem());
		menu.add(createFileColorMenu());
		return menu;
	}

	/**
	 * This method creates the menu item save and adds a action listener
	 * @return item
	 */
	private JMenuItem createFileSaveItem() {
		JMenuItem item = new JMenuItem("Save", new ImageIcon("save.gif")); 
		item.setMnemonic('S');
		item.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileSaver = new JFileChooser();
				fileSaver.setDialogType(JFileChooser.SAVE_DIALOG);
				int returnValue = fileSaver.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION){
					FontViewer.frame.changeInfoLabel("Data saved to: " +fileSaver.getSelectedFile().toString());
				}
			}
		});
		return item;
	}

	/**
	 * This method creates the menu item exit and adds a action listener
	 * @return item
	 */
	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit", new ImageIcon("exit.gif"));
		item.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});      
		return item;
	}

	/**
	 * This menu creates the sub menu color
	 * @return menu
	 */
	private JMenu createFileColorMenu() {
		JMenu menu = new JMenu("Color");
		menu.add(createSetColorItem());
		menu.add(createResetColorItem());

		return menu;
	}

	/**
	 * This method creates the sub menu item set color and adds
	 * an action listener
	 * @return item
	 */
	private JMenuItem createSetColorItem() {
		JMenuItem item = new JMenuItem("Set Color");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", null);
				FontViewer.frame.setSampleColor(selectedColor);
			}
		});
		return item;
	}

	/**
	 * This method creates the sub menu item reset color and 
	 * adds an action listener
	 * @return
	 */
	private JMenuItem createResetColorItem() {
		JMenuItem item = new JMenuItem("Reset Color");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color resetedColor = null;
				FontViewer.frame.setSampleColor(resetedColor);
			}
		});
		return item;
	}
}
