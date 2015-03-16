package ex_16_animated_shapes;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * This class is a panel which implements the animated shapes. it implements a
 * mouslistener and a mousmotionlistener for reacting to user-input
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MainPanel extends JPanel implements MouseListener, MouseMotionListener{

	/**
	 * To supress warning
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This list contains all current shapes on the map
	 */
	private ArrayList<MoveableShape> shapes = new ArrayList<MoveableShape>();

	/**
	 * If a shape is dragged, the index of that shape will be saved in here
	 */
	private int currentDragShapeIndex = -1;

	/**
	 * The statistics are saved in here
	 */
	private Statistics statistics = new Statistics();

	/**
	 * This is the constructor which sets up the panel.
	 */
	public MainPanel() {
		this.setDoubleBuffered(false);
		this.setBackground(Color.WHITE);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		// Timer which is called every 50ms (25fps)
		new Timer(40, paintTimer).start();
	}

	/**
	 * This function restarts the animation. expect for some values in the
	 * satistics everything is removed (like the current record)
	 */
	public void restart(){
		this.shapes.clear();
		this.statistics.reset();
	}

	/**
	 * This randomly adds a shape at the given position
	 * @param x the x-part of the position
	 * @param y the y-part of the position
	 * @return whetever the adding was a succes or not
	 */
	public boolean addShape(int x, int y){
		if(Math.random()*2 > 1)
			return this.shapes.add(new Circle(x, y));
		else
			return this.shapes.add(new Square(x, y));
	}

	/**
	 * This function paints all the shapes and all the statistics.
	 */
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		this.statistics.update(this.shapes.size());
		this.statistics.draw(g2d);
		int i = 0;
		for(i=0; i<this.shapes.size(); i++){
			if(!this.shapes.get(i).isOutside(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT)
				|| this.currentDragShapeIndex == i
			){
				if(this.currentDragShapeIndex != i)
					this.shapes.get(i).updatePosition();
				this.shapes.get(i).draw(g2d);
			}else{
				this.restart();
			}
		}
	}

	/**
	 * This is the time class, which makes sure the repaint-function is called
	 */
	Action paintTimer = new AbstractAction() {
		/**
		 * To supress warning
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * This just calls the paint method every time an event comes in
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	};

	/**
	 * This function is called as soon as the user presses the mouse-button.
	 * In case this happens on top of a shape, the dragging is activated.
	 * Otherwise this function does nothing
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		int i = 0;
		while(this.currentDragShapeIndex == -1 && i<this.shapes.size()){
			if(this.shapes.get(i).isInRange(new Position(e.getX(), e.getY())))
				this.currentDragShapeIndex = i;
			i++;
		}
	}

	/**
	 * This function is calles as soon as the user releases the mouse-button.
	 * If the dragging was going on (valid dragindex) the dragging is
	 * deactivated.
	 * If the dragging wasnt activated, a new shape is created.
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.currentDragShapeIndex == -1)
			this.addShape(e.getX(), e.getY());
		this.currentDragShapeIndex = -1;
		
	}

	/**
	 * This function is for dragging. if the dragging is activated then the
	 * current shape is moved by the position of the mouse.
	 */
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.currentDragShapeIndex != -1)
			this.shapes.get(this.currentDragShapeIndex).setCustomPosition(e.getX(), e.getY());
	}

	/**
	 * Not used!
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 * Not used!
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * Not used!
	 */
	@Override
	public void mouseExited(MouseEvent e) {	}

	/**
	 * Not used!
	 */
	@Override
	public void mouseMoved(MouseEvent e) {}
}
