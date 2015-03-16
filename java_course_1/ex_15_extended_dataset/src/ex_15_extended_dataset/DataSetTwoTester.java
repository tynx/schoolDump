package ex_15_extended_dataset;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the DataSetTwo class with the help of JUnit.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetTwoTester {

	/**
	 * The measurer for handling objects of type SavingAccount
	 */
	private Measurer savingAccountMeasurer = new Measurer(){
		public int getMeasure(Object object){
			if(object instanceof SavingAccount)
				return (int) ((SavingAccount)object).getBalance();
			return 0;
		}
	};

	/**
	 * The measurer which is capable of handling any kind of object implementing
	 * Measurable and in addition also objects of type SavingAccount.
	 */
	private Measurer mixedAccountMeasurer = new Measurer(){
		public int getMeasure(Object object){
			if(object instanceof SavingAccount)
				return (int) ((SavingAccount)object).getBalance();
			if(object instanceof Measurable)
				return (int) ((Measurable)object).getMeasure();
			return 0;
		}
	};

	/**
	 * Set of values (part 1)
	 */
	int[] values1 = {100, 1500, 2700, 3750, 50};

	/**
	 * Set of values (part 2)
	 */
	int[] values2 = {200, 500, 2000, 5000, 70};

	/**
	 * fills a given dataSet with the given values. Based on the measurable
	 * parameter it decides to create SavingAccount Objects or
	 * MeasurableSavingAccount Objects.
	 * @param dataSet the dataSet to fill
	 * @param values the values itself
	 * @param measurable whetever the objects should be measurable
	 */
	private void fillDataSet(DataSetTwo dataSet, int[] values, boolean measurable){
		int i=0;
		for(i=0; i<values.length; i++){
			if(measurable)
				dataSet.addValue(new MeasurableSavingAccount(values[i], 0));
			else
				dataSet.addValue(new SavingAccount(values[i], 0));
		}
	}

	/**
	 * This run is for testing if the dataset is capable of handling any kind
	 * of object given the right Measurer.
	 */
	@Test
	public void testWithMeasurer(){
		DataSetTwo dataSet = new DataSetTwo(savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values1, false);
		Assert.assertEquals(1620.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(8100, dataSet.getSum());
		Assert.assertEquals(50, dataSet.getMinimum());
		Assert.assertEquals(3750, dataSet.getMaximum());
		
		dataSet = new DataSetTwo(savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values2, false);
		Assert.assertEquals(1554.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(7770, dataSet.getSum());
		Assert.assertEquals(70, dataSet.getMinimum());
		Assert.assertEquals(5000, dataSet.getMaximum());
	}

	/**
	 * This run is for testing if the dataset is capable of handling any kind
	 * of object if they implement Measurable.
	 */
	@Test
	public void testWithoutMeasurerAndMeasurable(){
		DataSetTwo dataSet = new DataSetTwo();
		this.fillDataSet(dataSet, this.values1, true);
		Assert.assertEquals(1620.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(8100, dataSet.getSum());
		Assert.assertEquals(50, dataSet.getMinimum());
		Assert.assertEquals(3750, dataSet.getMaximum());
		
		dataSet = new DataSetTwo();
		this.fillDataSet(dataSet, this.values2, true);
		Assert.assertEquals(1554.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(7770, dataSet.getSum());
		Assert.assertEquals(70, dataSet.getMinimum());
		Assert.assertEquals(5000, dataSet.getMaximum());
	}

	/**
	 * This run is for testing if the dataset is capable of handly any kind
	 * of object whatsoever given the right Measurer.
	 */
	@Test
	public void testWithMixedObjects(){
		DataSetTwo dataSet = new DataSetTwo(this.mixedAccountMeasurer);
		this.fillDataSet(dataSet, this.values1, true);
		this.fillDataSet(dataSet, this.values2, false);
		Assert.assertEquals(1587.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(15870, dataSet.getSum());
		Assert.assertEquals(50, dataSet.getMinimum());
		Assert.assertEquals(5000, dataSet.getMaximum());

	}
}
