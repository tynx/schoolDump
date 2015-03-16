package ex_08_sequence_tim;



/**
 * This class tests the class Sequence.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 *
 */
public class SequenceTester {

	public static void sysout(String message){
		System.out.println(message);
	}
	/**
	 * This is the first testcase, where we define a given array and insert a value
	 * in a given position. After that we compare the array with another array in
	 * diffrent ways
	 */
	public static void testCase1(){
		//Define the two test arrays
		int [] values = {1,2,3,4,66,45,23,21};
		int [] values2 = {1,2,3,4,45,23,21};
		
		//Create the two test objects
		Sequence testSeq = new Sequence(values);
		Sequence testSeq2 = new Sequence(values2);
	
		//Check if the two arrays are equal
		sysout("Check if the two arrays are equal");
		sysout("Result: " + testSeq.equals(testSeq2));
		sysout("Expected: false");
		sysout(testSeq.toString());
		sysout(testSeq2.toString() + "\n");
		
		//Add at position 4 in values2 the value 66 and check if equal
		sysout("Add at position 4 in values2 the value 66 and check if equal");
		sysout("Array values2 before adding a values: " + testSeq2.toString());
		testSeq2.set(4, 66);
		sysout("Array values2 after adding a values: " + testSeq2.toString() + "\n");
		
		//Check again if equal
		sysout("Check again if equal");
		sysout("Result: " + testSeq.equals(testSeq2));
		sysout("Expected: false");
		sysout(testSeq.toString());
		sysout(testSeq2.toString() + "\n");
		
		//Check if the two arrays have the same values in some order
		sysout("Check if the two arrays have the same values in some order");
		sysout("Result: " + testSeq.sameValues(testSeq2));
		sysout("Expected: false" + "\n");
		
		//Check if the two arrays have the same values in some order,  with the same multiplicities
		sysout("Check if the two arrays have the same values in some order,  with the same multiplicities");
		sysout("Result: " + testSeq.isPermutationOf(testSeq2));
		sysout("Expected: false" + "\n");
	}
	
	/**
	 * This is the second testcase, where we define an array size and set some elements with our set methode. 
	 * After that we compare the array with another array in diffrent ways
	 */
	public static void testCase2(){
		//Define the length of the two test arrays
		int valuesLength = 10;
		int valuesLength2 = 15;
				
		//Create the two test objects
		Sequence testSeq = new Sequence(valuesLength);
		Sequence testSeq2 = new Sequence(valuesLength2);
		
		//Check if the two arrays are equal
		sysout("Check if the two arrays are equal");
		sysout(testSeq.toString());
		sysout(testSeq2.toString());
		sysout("Result: " + testSeq.equals(testSeq2));
		sysout("Expected: false" + "\n");
		
		//Add some numbers to the arrays
		sysout("Add some values to the arrays");
		sysout("Array 1: ");
		testSeq.set(5, 45);
		sysout("Add 45 at pos 5: " + testSeq.toString());
		testSeq.set(11,66);
		sysout("Add 66 at pos 11: " + testSeq.toString());
		testSeq.set(11, 39);
		sysout("Add 39 at pos 11: " + testSeq.toString() + "\n");
		testSeq2.set(6, 45);
		testSeq2.set(13, 39);
		testSeq2.set(16, 66);
		sysout("To the second array we add the same Values on diffrent positions:");
		sysout(testSeq2.toString() + "\n");
		
		//Check if equal
		sysout("Check if equal");
		sysout("Result: " + testSeq.equals(testSeq2));
		sysout("Expected: false" + "\n");
		
		//Check if the two arrays have the same values in some order
		sysout("Check if the two arrays have the same values in some order");
		sysout("Result: " + testSeq.sameValues(testSeq2));
		sysout("Expected: true" + "\n");
		
		//Check if the two arrays have the same values in some order,  with the same multiplicities
		sysout("Check if the two arrays have the same values in some order,  with the same multiplicities");
		sysout("Result: " + testSeq.isPermutationOf(testSeq2));
		sysout("Expected: true" + "\n");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sysout("Test Case 1: \n");
		testCase1();
		sysout("Test Case 2: \n");
		testCase2();
	}

}
