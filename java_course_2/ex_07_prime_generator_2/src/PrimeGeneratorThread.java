import java.util.ArrayList;

	/**
 	* This class is handling the PrimeGenerator-Threads. 
 	* @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 	* @author jerome jamin (jerome.jamin@gmail.com)
 	*/
	public class PrimeGeneratorThread extends Thread {
			private int min = 0;
			private int max = 0;
			private int delay = 0;
			private long time = 0;
			ArrayList<Integer> primes = new ArrayList<Integer>();
			

			/**
			 * Constructs the thread object
			 * @param min
			 * @param max
			 * @param name
			 * @param delay
			 */
			public PrimeGeneratorThread(int min, int max, String name, int delay) {
				super(name);
				this.min = min;
				this.max = max;
				this.delay = delay;
			}
			
			/**
			 * The thread run method. It calculates prime-numbers and saves the highest
			 * one into highestPrime. For every cycle there is a wait function, to mix
			 * up the results and make them random.
			 */
			public void run() {
				long startTime = 0;
				long endTime = 0;
				
				try {	
					startTime = getTime();
					for(int i = this.min; i <= this.max; i++) {
						if(isPrime(i)) {
							this.primes.add(i);
						}
						if(this.delay > 0) Thread.sleep(this.delay);
					}
					endTime = getTime();
					this.time = endTime - startTime;
				} catch (InterruptedException ex) { 
					System.out.println(getName() + " interrupted"); 
				}
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
		public static boolean isPrime(int number) {
			//start at 2 because 1 is always divideable, stop at square-root of number
			for(int i = 2; i*i<=number; i++) {
				if(number % i == 0) return false;
			}
			return true;
		}

		/**
		 * This getter method returns the current Time in ns
		 * @return time in ns
		 */
		private long getTime() {
			return System.currentTimeMillis();
		}
		
		/**
		 * This getter method returns a List of all calculated prime numbers
		 * @return primes - list of prime numbers
		 */
		public ArrayList<Integer> getPrimes(){
			return this.primes;
		}
		
		/**
		 * This getter method returns the time which was needed for calculating
		 * the prime numbers in ns
		 * @return time in ns
		 */
		public long getCalcTime() {
			return this.time;
		}
		
		/**
		 * This method returns the name of the thread
		 * @return name
		 */
		public String getThreadName() {
			return super.getName();
		}
	}