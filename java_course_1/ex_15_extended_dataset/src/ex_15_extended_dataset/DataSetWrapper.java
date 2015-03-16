package ex_15_extended_dataset;

/**
 * This class provides a wrapper to the DataSet used in previous chapters.
 * The only difference basically is: the addValue method, as this can handle now
 * object. The handling itself is handled by the classes which extend this class.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetWrapper {

	/**
	 * The dataset-object itself, for which this class plays the wrapper
	 */
	protected DataSet dataset = new DataSet();

	/**
	 * This function has to be implemented by every class which extends by this
	 * class. It needs to be capable of handling object. Measurers/Filter may be
	 * needed.
	 * @param object the object with the value inside.
	 */
	public void addValue(Object object) {
	}

	/**
	 * Returns the sum of the dataSet
	 * @return the sum
	 */
	public int getSum() {
		return dataset.getSum();
	}

	/**
	 * Returns the average of the dataSet
	 * @return the average
	 */
	public double getAverage() {
		return dataset.getAverage();
	}

	/**
	 * Returns the minimum of the dataSet
	 * @return the minimum
	 */
	public int getMinimum() {
		return dataset.getMinimum();
	}

	/**
	 * Returnst the maximum of the dataSet
	 * @return the maximum
	 */
	public int getMaximum() {
		return dataset.getMaximum();
	}
}
