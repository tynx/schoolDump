package ex_15_extended_dataset;

/**
 * This class is capable of handling any kind of comparables. It stores the max
 * and min of all given inputs.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetThree<TYPE extends Comparable<TYPE>>{

	/**
	 * The min value
	 */
	private TYPE min = null;

	/**
	 * The max value
	 */
	private TYPE max = null;

	/**
	 * This adds a value, but does not store it. If it's a new minimum given
	 * it will be saved as min. same counts for max.
	 * @param value the value to check if a new min/max
	 */
	public void addValue(final TYPE value) {
		if (this.min == null) {
			this.min = value;
			this.max = value;
		}else if (value.compareTo(min) < 0) {
			this.min = value;
		}else if (value.compareTo(max) > 0) {
			this.max = value;
		}
	}

	/**
	 * Returns the current minimum given
	 * @return the minimum
	 */
	public TYPE getMin() {
		return min;
	}

	/**
	 * Returns the current maximum given
	 * @return the maximum
	 */
	public TYPE getMax() {
		return max;
	}
}
