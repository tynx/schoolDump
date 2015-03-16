package ex_07_loop_festival_tim;

/**
 * This class generates all the factors for a specific number. for example: 90 as
 * number then the factors would be 2,3,3,5. This is done y simply finding the
 * the next divideable number of the current number.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class FactorGenerator{

	/**
	 * The number we want the factors for
	 */
	private int number = 0;

	/**
	 * The constructor which just stores the number locally
	 * @param n the number which the factors are searched for
	 */
	public FactorGenerator(int n){
		this.number=n;
	}

	/**
	 * Returns true as long as there are more factors are available
	 * @return true whenever there are factors left
	 */
	public boolean hasMoreFactors(){
		return (this.number > 1) ? true : false;
	}

	/**
	 * Calculates and returns the next factor.
	 * @return the next factor
	 */
	public int nextFactor(){
		int i=0;
		// start with 2 as 1 is always a dividend
		for(i=2; i<=this.number; i++){
			if(this.number%i == 0){
				this.number /= i;
				return i;
			}
		}
		return 0;
	}
}