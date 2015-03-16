package ex_07_loop_festival_tim;

/**
 * This class generates all the primes. It does so by providing one at a time
 * when the function "nextPrime()" is called. No boundaries except MAX_INT.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class PrimeGenerator {

	/**
	 * the last prime we have found. start searching from there.
	 */
	private int lastPrime = 1;

	public PrimeGenerator(){
		
	}

	/**
	 * Figures out if the given number is a prime by trying to divide it by each
	 * smaller number there is.
	 * As we want performance: only the smaller numbers until (and with) square-
	 * root of the numbers are checked. pretty simple maths.
	 * 
	 * @param number the number to check if is a prime
	 * @return true whenever it is a prime
	 */
	private boolean isPrime(int number){
		boolean isPrime = true;
		int i = 0;
		// start at 2 because 1 is always divideable, stop at square-root of number
		for (i=2; i<=Math.sqrt(number); i++){
			if(number % i == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	/**
	 * Goes trough every integer and checks whetever it is a prime or not. if so
	 * it gets returned. 
	 * @return the next found prime
	 */
	public int nextPrime(){
		this.lastPrime++;
		while(!this.isPrime(this.lastPrime)){
			this.lastPrime++;
		}
		return this.lastPrime;
	}
}