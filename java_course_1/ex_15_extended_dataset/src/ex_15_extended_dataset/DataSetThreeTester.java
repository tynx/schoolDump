package ex_15_extended_dataset;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the DataSetThree class with the help of JUnit.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetThreeTester {

	/**
	 * This run is for testing if the dataset is capable of handling only one
	 * value.
	 */
	@Test
	public void testSingleValue() {
		final DataSetThree<String> dataset = new DataSetThree<String>();
		dataset.addValue("a");

		Assert.assertEquals("a", dataset.getMin());
		Assert.assertEquals("a", dataset.getMax());
	}

	/**
	 * This run is for testing if the dataset is capable of handling multitple
	 * comparables.
	 */
	@Test
	public void testMultipleValues() {
		final DataSetThree<String> dataset = new DataSetThree<String>();

		dataset.addValue("a");
		dataset.addValue("g");
		dataset.addValue("z");

		Assert.assertEquals("a", dataset.getMin());
		Assert.assertEquals("z", dataset.getMax());
	}
}
