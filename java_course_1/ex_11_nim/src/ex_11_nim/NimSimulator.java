package ex_11_nim;

import java.util.Scanner;

/**
 * This class handles the games of NIM while runtime. It lets the user choose
 * the oponent. It also lets the user restart a game.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class NimSimulator {

	/**
	 * It's here, otherwise we'll run into closed IN-Stream. The fuck JAVA?
	 */
	public static Scanner in = new Scanner(System.in);

	/**
	 * The main method which runs the whole program.
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean running = true;
		Player[] p = new Player[2];
		
		p[0] = new Player(Player.PlayerType.HUMAN);
		
		System.out.println("Welcome to NIM.\nSelect smartness of PC[c/s]:");
				
		String smartness = NimSimulator.in.nextLine();
		if(smartness.equals("s"))
			p[1] = new Player(Player.PlayerType.STUPID);
		else if(smartness.equals("c"))
			p[1] = new Player(Player.PlayerType.SMART);
		else // make random
			p[1] = new Player(Player.PlayerType.STUPID);
		
		System.out.println("Size of Pile:");
		
		int pileSize = Integer.parseInt(NimSimulator.in.nextLine());
		
		while(running){
			
			Game g = new Game(p,pileSize);
			g.runGame();
			System.out.println("Again? [y/N]:");
			
			String again = NimSimulator.in.nextLine();
			if(!again.equals("y"))
				running = false;
		}
		
		System.out.println("Goodbaayy\n");
	}

}
