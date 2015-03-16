package ex_04_robot_game;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * This class is the entry-point of the class. it contains the main()-method
 * as well as it handles all the threads (drawing/robots). Also it handles
 * the storing/retstoring of the current game-state.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class RobotGame extends JFrame implements WindowListener{

	/**
	 * The UID generated for this class
	 */
	private static final long serialVersionUID = -6191928734186029751L;

	/**
	 * If the game is currently running, or trying to quit.
	 */
	private static boolean running = true;

	/**
	 * The data of the game itself. all the roboters and the grid are stored
	 * in here.
	 */
	private GameData gameData = null;

	/**
	 * The component which is there to provide a surface to draw on.
	 */
	private RobotGameComponent robotGameComponent = null;

	/**
	 * All the started Threads are in here. We need to save them in order
	 * to be able to figure out the state of them at closing time of the game.
	 */
	private ArrayList<Thread> robotThreads = new ArrayList<Thread>();

	/**
	 * Main-Method. Does nothing else than making a new RobotGame-object.
	 * @param args NOT PARSED AND IGNORED!
	 */
	public static void main(String[] args) {
		new RobotGame();
	}

	/**
	 * Whetever the game is currently running or not.
	 * @return true if the game is running
	 */
	public static boolean isRunning(){
		return running;
	}

	/**
	 * The constructor which handles the whole initialization of the game. It
	 * loads (if possible) the state of a previous run. Otherwise it starts a
	 * complete new run. It sets the properties for the frame, as well as adding
	 * the component, for drawing. It starts all the threads for the roboters.
	 * Also it creates a Timer, which is necessary so a redraw of the game
	 * happens as often as needed (configured by FPS).
	 */
	public RobotGame(){
		File f = new File(Settings.SAVEFILE);
		if(f.exists() && !f.isDirectory()){
			try {
				this.readStateFromFile();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				// If we got an io, the file may be corrupt, then lets start a
				// new run.
				if(this.gameData == null)
					this.gameData = new GameData();
			}
		}else{
			this.gameData = new GameData();
		}
		this.robotGameComponent =  new RobotGameComponent(this.gameData);
		this.setLayout(new BorderLayout());
		this.add(this.robotGameComponent, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.addWindowListener(this);
		// Start the threads
		for(Robot r : this.gameData.getRobots()){
			Thread t = new Thread(r);
			r.setId(t.getId());
			this.robotThreads.add(t);
			t.start();
		}
		// start the timer for drawing
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				robotGameComponent.repaint();
			}
		};
		new Timer((int)(1000/Settings.FPS), taskPerformer).start();
	}

	/**
	 * This method writes the state of the gameData into the file by serializing
	 * it.
	 */
	private void writeStateToFile(){
		try{
			FileOutputStream fileOut = new FileOutputStream(Settings.SAVEFILE);
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(this.gameData);
			outStream.close();
			fileOut.close();
		}catch(IOException i){
			i.printStackTrace();
		}
	}

	/**
	 * This method loads the state of gameData by reading out the file and
	 * deserializing it. If something is wrong with the file, we throw a
	 * IOException so, we can create a new state later on.
	 * @throws IOException if the file is corrupt
	 */
	private void readStateFromFile() throws IOException{
		try{
			FileInputStream fileIn =new FileInputStream(Settings.SAVEFILE);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this.gameData = (GameData) in.readObject();
			in.close();
			fileIn.close();
		}catch(ClassNotFoundException e){
			System.out.println("GameData Class not found!");  
			e.printStackTrace();
		}
	}

	/**
	 * This method is called when the user hits the close button. Before
	 * actually exiting out of the application, we want to store the current
	 * state of the game. For that, we wait for all threads to quit their
	 * movement. We can do that by setting the "running"-attribute to false.
	 * All Thread will realize that, and stop executing their movements. As
	 * soon as no action is going anymore, the states is serialized and stored
	 * in the file.
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("We received closing signal. Going to wait for robots to quit.");
		RobotGame.running = false;
		boolean waitForThreads = true;
		int i = 0;
		// We want to wait for all threads to stop, before exiting
		while(waitForThreads){
			for(i=0;i<this.robotThreads.size(); i++){
				if(!this.robotThreads.get(i).isAlive())
					this.robotThreads.remove(i);
			}
			// All Threads are gone: save the state and jump out of the wait-loop
			if(this.robotThreads.size() == 0){
				System.out.println("All the threads are gone. Making dump of objects.");
				this.writeStateToFile();
				waitForThreads = false;
			}
		}
		// If we reach this point, there is nothing left to do, then actually
		// exit.
		System.out.println("Quitting for good!");
		System.exit(0);
	}

	// NOT USED!
	@Override
	public void windowActivated(WindowEvent arg0){ }

	// NOT USED!
	@Override
	public void windowClosed(WindowEvent arg0){ }

	// NOT USED!
	@Override
	public void windowDeactivated(WindowEvent arg0){ }

	// NOT USED!
	@Override
	public void windowDeiconified(WindowEvent arg0){ }

	// NOT USED!
	@Override
	public void windowIconified(WindowEvent arg0){ }

	// NOT USED!
	@Override
	public void windowOpened(WindowEvent arg0){ }
}
