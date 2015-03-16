import javax.swing.JFrame;


public class FontViewer {

	public static FontViewerFrame frame = null;
	
	public static void main(String[] args) {
		FontViewer.frame = new FontViewerFrame();
		FontViewer.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FontViewer.frame.setTitle("FontViewer");
		FontViewer.frame.setVisible(true);
	}

}
