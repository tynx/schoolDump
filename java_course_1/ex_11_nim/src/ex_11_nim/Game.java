package ex_11_nim;
/**
 * This class handles a complete game of NIM.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Game {

	/**
	 * All participating players are stored in here. As this game only allows
	 * 2 player to compete against each other => a static array.
	 */
	Player[] players = new Player[2];

	/**
	 * The pile of balls
	 */
	Pile pile = null;

	/**
	 * The current position in the array of the user whichs turn it is
	 */
	int currentPlayerPosition = -1;
	
	
	/**
	 * This constructor is for a normal game of NIM.
	 * normal game => 1 human & 1 pc (random smart/stupid)
	 * @param pileSize how many balls should be added into the pile
	 */
	public Game(int pileSize){
		this.addPlayer(Player.PlayerType.HUMAN);
		if((int)Math.random()*2 == 1)
			this.addPlayer(Player.PlayerType.SMART);
		else
			this.addPlayer(Player.PlayerType.STUPID);
		this.pile = new Pile(pileSize);
	}

	/**
	 * This constructor adds the given players and sets the pile. so all
	 * parameters of the game can be configured by this constructor.
	 * @param players the player, array has to have the length of 2!
	 * @param pileSize how many balls should be added into the pile
	 */
	public Game(Player[] players, int pileSize){
		if(players.length != 2)
			return;
		this.players = players;
		this.pile = new Pile(pileSize);
	}

	/**
	 * This method adds a player to the array. It automatically determines at
	 * which location the user should be added. If it returns false, that means
	 * all slots are used already!
	 * @param type what kind of player (human/smart/stupid)
	 * @return whetever a slot was free or not
	 */
	public boolean addPlayer(Player.PlayerType type){
		if(this.players[0] == null)
			this.players[0] = new Player(type);
		else if(this.players[1] == null)
			this.players[1] = new Player(type);
		else
			return false;
		return true;
	}

	/**
	 * This function randomly selects a user, which can/has to start the game.
	 * @return
	 */
	private void setStartPlayer(){
		int randomPosition = (int)(Math.random()*2);
		currentPlayerPosition = randomPosition;
	}

	/**
	 * Changes the player which has the turn
	 */
	private void nextPlayer(){
		this.currentPlayerPosition = (this.currentPlayerPosition + 1) % 2;
	}

	/**
	 * This method runs a whole game of NIM. It also prints statistics. Basically
	 * it manages the whole game.
	 * @return
	 */
	public void runGame(){
		boolean running = true;
		this.pile.reset();
		this.setStartPlayer();
		while(running){
			int marbles = this.players[this.currentPlayerPosition].move(this.pile.getCountMarbles());
			if(this.pile.removeMarbles(marbles))
				printStat(this.players[this.currentPlayerPosition], marbles);
				this.nextPlayer();
			if(this.pile.empty())
				running = false;
			
		}
		System.out.print("Game is over! Winner is Player with ID: ");
		System.out.println(this.players[this.currentPlayerPosition].getIDAsString());
	}

	/**
	 * Prints statistics, so its easier to play (not remember everything)
	 * @param player the player with the last move
	 * @param move what the move was (how many balls removed)
	 * @return
	 */
	private void printStat(Player player, int move){
		StringBuilder sb = new StringBuilder();
		sb.append("Player (");
		if(player.isHuman())
			sb.append("Human");
		else
			sb.append("Computer/" + player.getSmartnessAsString());
		sb.append(") with ID " + player.getIDAsString());
		sb.append(" takes " + move + " from Pile (left: " + this.pile.getCountMarbles() + ")");
		System.out.println(sb.toString());
	}
}
