package ex_11_nim;

/**
 * This class is for implementing a Pile of marbles. Basically it just stores
 * the amount of removed marbles. Also its capable of reseting the pile.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Pile {

	/**
	 * The amount of marbles to start with
	 */
	private int marbles = 0;

	/**
	 * The amount of marbles which have been removed
	 */
	private int removedMarbles = 0;

	/**
	 * Constructor which stores the amount to start with
	 * @param marbles how many marbles to start with
	 */
	public Pile(int marbles){
		this.marbles = marbles;
	}

	/**
	 * Returns the amount of marbles which are currently in the pile
	 * @return
	 */
	public int getCountMarbles(){
		return this.marbles - this.removedMarbles;
	}

	/**
	 * This removes marbles from the pile. In this implementation it validates
	 * also for the game NIM. (more than 0, less than half)
	 * @param amount how many marbes should be removed
	 * @return true whenever the marbles where removed and it was a legal move
	 */
	public boolean removeMarbles(int amount){
		if(amount > 0 && amount <= (int)(this.marbles/2)+1){
			this.removedMarbles += amount;
			return true;
		}
		return false;
	}

	/**
	 * This function resets the pile and starts again with the starting-amount of
	 * marbles.
	 * @return
	 */
	public boolean reset(){
		this.removedMarbles = 0;
		return true;
	}

	/**
	 * Checks whetever the pile doesn't have any marbles anymore.
	 * @return whetever the pile has no more marbles
	 */
	public boolean empty(){
		if(this.getCountMarbles()==0)
			return true;
		return false;
	}
}
