package ex_07_loop_festival_tim;

/**
 * This class provides an static way to acces the function "getDiff()".
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Numeric {

	/**
	 * This function accepts a number. this number is equal or bigger than a
	 * calculated power of 2 - 1. so:
	 * 2^m-1 <= number
	 * 
	 * after calculating m, we want to substract m from number en just return
	 * the difference.
	 * 
	 * @param number the number to which the diff should be searched
	 * @return the difference
	 */
	public static int getDiff(int number){
		// find the power (note double-precision because of floor, also number+1
		// as we have an offset given by the exercise)
		double power = Math.floor(Math.log(number+1) / Math.log(2));
		// the we calulate the power again, (note flooring changed the
		// value of that reverse operation) and then -1 because we want 0 values
		return number - (int)(Math.pow(2,power)-1);
	}
}