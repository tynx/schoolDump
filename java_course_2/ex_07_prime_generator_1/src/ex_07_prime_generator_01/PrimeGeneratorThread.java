package ex_07_prime_generator_01;

/**
 * This class
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class PrimeGeneratorThread extends Thread {

	/**
	 * the current highest prime found in this object/thread
	 */
	private int highestPrime = 0;

	/**
	 * Construct the thread object
	 * @param name the thread name
	 */
	public PrimeGeneratorThread(String name) {
		super(name);
	}

	/**
	 * The thread run method. It calculates prime-numbers and saves the highest
	 * one into highestPrime. For every cycle there is a wait function, to mix
	 * up the results and make them random.
	 */
	public void run() {
		int currentValue = 1;
		try{
			while(!this.isInterrupted()){
				if(this.isPrime(currentValue))
					this.highestPrime = currentValue;
				currentValue+=2;
				Thread.sleep((int)(Math.random() * PrimeGenerator.MAX_DELAY_THREADS));
			}
		} catch (InterruptedException e) {
			System.out.print(this.getName() + " ");
		}
	}

	/**
	 * @return the current highest prime number calculated
	 */
	public int getHighestPrime() {
		return this.highestPrime;
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
		int i = 0;
		// start at 2 because 1 is always divideable, stop at square-root of number
		for (i=2; i*i<=number; i++)
			if(number % i == 0)
				return false;
		return true;
	}
}
