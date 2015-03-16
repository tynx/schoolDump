package ex_07_prime_generator_01;

import java.util.ArrayList;

/**
 * This class is handling the PrimeGenerator-Threads. It itself calculates the
 * sequence of primes for the given stdin-argument. 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class PrimeGenerator {

	/**
	 * Number of concurrent Threads that should be started
	 */
	public static final int NUM_THREADS = 10;

	/**
	 * The maximum of the delay per prime-calculation for the threads in ms.
	 */
	public static final int MAX_DELAY_THREADS = 5;

	/**
	 * All the Thread-objects are saved in here
	 */
	private ArrayList<PrimeGeneratorThread> generators = new ArrayList<PrimeGeneratorThread>();

	/**
	 * Entry point. args are parsed for the given maximum prime to find
	 * @param args first arguemtn should be the max to search for
	 */
	public static void main(String args[]){
		if(args.length != 1){
			System.err.println("Invalid arguments!");
			System.exit(-1);
		}
		new PrimeGenerator(Integer.parseInt(args[0]));
	}

	/**
	 * The constructor, which does the work. it starts the threads, starts
	 * the calculation, stops the threads and prints out the results.
	 * @param maximum
	 */
	public PrimeGenerator(int maximum){
		this.startThreads();

		int currentValue = 1;
		while(currentValue < maximum){
			if(this.isPrime(currentValue))
				System.out.print(currentValue + " ");
			currentValue +=1;
		}

		System.out.println("\n\nMAIN THREAD DONE!\nInterupting running Threads:");
		this.interuptThreads();
		this.waitForThreads();
		System.out.println("\n\nAll Threads are gone. The results:");
		this.printHighestPrimes();
	}

	/**
	 * Makes objects of the GeneratorThreads and starts the threads.
	 */
	private void startThreads(){
		int i=0;
		for(i=0; i<PrimeGenerator.NUM_THREADS; i++){
			PrimeGeneratorThread t = new PrimeGeneratorThread("Thread " + i);
			t.start();
			this.generators.add(t);
		}
	}

	/**
	 * Goes through all the threads and sends the interupt signal.
	 */
	private void interuptThreads(){
		for(Thread t : this.generators)
			t.interrupt();
	}

	/**
	 * This method blocks until all the threads are not alive anymore
	 */
	private void waitForThreads(){
		int interupted = 0;
		while(interupted != this.generators.size()){
			interupted = 0;
			for(Thread t : this.generators)
				if(!t.isAlive())
					interupted ++;
		}
	}

	/**
	 * This method goes trough all the object and prints out the max prime found.
	 */
	private void printHighestPrimes(){
		for(PrimeGeneratorThread t : this.generators){
			System.out.print(t.getName());
			System.out.println(" has the sequence until: " + t.getHighestPrime());
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
	private boolean isPrime(int number){
		int i = 0;
		// start at 2 because 1 is always divideable, stop at square-root of number
		for (i=2; i*i<=number; i++)
			if(number % i == 0)
				return false;
		return true;
	}
}