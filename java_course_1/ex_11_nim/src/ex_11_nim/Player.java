package ex_11_nim;

import java.util.UUID;

/**
 * This class represents a gamer in the game of NIM. There are 3 kind of players:
 * - human (keyboard-inputs)
 * - stupid (random moves)
 * - smart/clever (calculated moves)
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Player {

	/**
	 * What kind of PlayerType.
	 */
	public static enum PlayerType{HUMAN, STUPID, SMART};

	/**
	 * What the type of this object is.
	 */
	private PlayerType type = null;

	/**
	 * A unique (hopefully) ID.
	 */
	private int id = 0;

	/**
	 * Returns the smartness of a PC-Player. Biased return-value for Human!
	 * @return smartness of PC-Player.
	 */
	public String smartness(){
		return (this.type == PlayerType.SMART) ? "smart" : "stupid";
	}

	/**
	 * Constructor which expects to have the type given. Also generates random
	 * ID for the player (via UUID).
	 * @param type what kind of player
	 */
	public Player(PlayerType type){
		this.type = type;
		id = UUID.randomUUID().hashCode();
	}

	/**
	 * Returns the id of the player
	 * @return
	 */
	public int getID(){
		return this.id;
	}

	/**
	 * Returns the id in form of a hex-code, so its better readable
	 * @return
	 */
	public String getIDAsString(){
		return Integer.toHexString(this.id);
	}

	/**
	 * Whetever the Player is Human or not.
	 * @return true if is human
	 */
	public boolean isHuman(){
		return (this.type == PlayerType.HUMAN) ? true : false;
	}

	/**
	 * Returns the Smartness of a PC in form of a string. Biased output if player
	 * is Human!!!
	 * @return smart or stupid.
	 */
	public String getSmartnessAsString(){
		if(this.isHuman())
			return "";
		return (this.type == PlayerType.SMART) ? "smart" : "stupid";
	}

	/**
	 * Random next move for stupid PC.
	 * @param leftMarbles how many marbles can be removed max
	 * @return an amount of marbles to remove
	 */
	private int randomMove(int leftMarbles){
		return (int)(Math.random()*(((leftMarbles/2)-1)+1))+1;
	}

	/**
	 * Calculates the highest possible power between 0 and "end".
	 * @param end of the range to search in
	 * @return integer with max power (2^x)
	 */
	private int maxPower(int end){
		int max = 0;
		while(Math.pow(2, max) <= end){
			max ++;
		}
		return max-1;
	}

	/**
	 * Checks if a smart move is possible or not.
	 * @param leftMarbles the amount of marbles which can be removed max.
	 * @return whetever there is a clever move
	 */
	private boolean smartMovePossible(int leftMarbles){
		if(Math.pow(2,this.maxPower(leftMarbles))-1 == leftMarbles)
			return false;
		return true;
	}

	/**
	 * This method automaticall tries to make the best possible move. if none is
	 * possible, it falls back to random.
	 * @param leftMarbles how many marbles can be removed max
	 * @return the amount of marbles which should be removed
	 */
	private int smartMove(int leftMarbles){
		
		if(!this.smartMovePossible(leftMarbles)){
			return this.randomMove(leftMarbles);
		}else{
			int max = this.maxPower(leftMarbles);
			return (int) (leftMarbles - (Math.pow(2,max)-1));
		}
		
	}

	/**
	 * This is for PC. This function handles a complete move for a PC. If smart
	 * a smart move is performed, if stupid random kicks in.
	 * @param leftMarbles the amount of marbles which can be removed max
	 * @return the amount of marbles which should be removed
	 */
	private int calculateMove(int leftMarbles){
		if (this.type == PlayerType.STUPID)
			return this.randomMove(leftMarbles);
		else
			return this.smartMove(leftMarbles);
		
	}

	/**
	 * This is for human. It asks the user for the next move.
	 * @param leftMarbles the amount for marbles which can be removed max
	 * @return the amount of marbles which should be removed (what user entered)
	 */
	private int askMove(int leftMarbles){
		int n = 0;
		boolean valid = false;
		while(!valid){
			System.out.print("Enter an integer between 1 and " + (int)leftMarbles/2 + ": ");
			n = Integer.parseInt(NimSimulator.in.nextLine());
			if(n>0 && n<=leftMarbles/2)
				valid = true;
			else
				System.out.println("invalid input!");
		}
		return n;
	}

	/**
	 * Perform a complete move no matter what kind of Player we have and return
	 * the final amount of marbles to remove.
	 * @param leftMarbles the amount of marbles which are left in the pile
	 * @return the final decision on how many marbles should be removed by this
	 * player
	 */
	public int move(int leftMarbles){
		if(this.type == PlayerType.HUMAN){
			return askMove(leftMarbles);
		}else{
			return calculateMove(leftMarbles);
		}
	}
}
