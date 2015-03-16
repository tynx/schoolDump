package ex_01;

import java.util.ArrayList;

/**
 * This class tests the class DataSet. Its very basic.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 *
 */
public class DataSetTester {

	/**
	 * This list contains the numbers for the current case.
	 */
	private static ArrayList<Integer> currentNumbers = new ArrayList<Integer>();

	/**
	 * This int contains the expected sum of the current case
	 */
	private static int expectedSum = 0;

	/**
	 * This int contains the expected average of the current case
	 */
	private static double expectedAvg = 0;

	/**
	 * This int contains the expected minimum of the current case
	 */
	private static int expectedMin = 0;

	/**
	 * This int contains the expected maximum of the current case
	 */
	private static int expectedMax = 0;

	/**
	 * Runs the current test-case. first adds the numbers to the dataset. after
	 * that it runs the different functions and prints out the results.
	 */
	public static void runTestCase(){
		System.out.print("Adding numbers:");
		DataSetCheap ds = new DataSetCheap();
		int i = 0;
		int length = DataSetTester.currentNumbers.size();
		
		// Adding numbers for current Testcase
		for(i=0;i<length;i++){
			int currentNumber = DataSetTester.currentNumbers.get(i);
			ds.addValue(currentNumber);
			System.out.print(" " + currentNumber);
		}
		
		System.out.println("\n\nResults:\n");
		
		System.out.print("Sum: " + ds.getSum());
		System.out.println(" Expected: " + DataSetTester.expectedSum);
		
		System.out.print("Avg: " + ds.getAverage());
		System.out.println(" Expected: " + DataSetTester.expectedAvg);
		
		System.out.print("Min: " + ds.getMinimum());
		System.out.println(" Expected: " + DataSetTester.expectedMin);
		
		System.out.print("Max: " + ds.getMaximum());
		System.out.println(" Expected: " + DataSetTester.expectedMax);
	}
	
	public static void main(String[] args) {
		// WELCOME
		System.out.println("Tester for DataSet started!\n");

		// Adding some values for first run
		currentNumbers.add(5);
		currentNumbers.add(40);
		currentNumbers.add(67);
		currentNumbers.add(80);
		currentNumbers.add(12);
		currentNumbers.add(1);
		currentNumbers.add(34);

		// Expected values for first run
		expectedSum = 239;
		expectedAvg = 34.142857;
		expectedMin = 1;
		expectedMax = 80;

		// Run the test
		runTestCase();

		// Create some overview
		System.out.println("\n");

		// Reset numbers
		currentNumbers = new ArrayList<Integer>();

		// Adding some values for first run
		currentNumbers.add(76);
		currentNumbers.add(33);
		currentNumbers.add(61);
		currentNumbers.add(90);
		currentNumbers.add(68);
		currentNumbers.add(21);
		currentNumbers.add(2);
		currentNumbers.add(53);
		currentNumbers.add(122);
		currentNumbers.add(99);

		// Expected values for first run
		expectedSum = 625;
		expectedAvg = 62.5;
		expectedMin = 2;
		expectedMax = 122;

		// Run the test
		runTestCase();
	}

}
