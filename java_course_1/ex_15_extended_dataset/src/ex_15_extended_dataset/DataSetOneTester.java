package ex_15_extended_dataset;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class tests the DataSetOne class with the help of JUnit.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetOneTester {

	/**
	 * Filter which only allows objects of the class SavingAccount
	 */
	private Filter savingAccountFilter = new Filter(){
		@Override
		public boolean accept(Object object){
			return object instanceof SavingAccount;
		}
	};

	/**
	 * Filter which only allows objects of the class SavingAccount which have a
	 * balance higher than 1000.
	 */
	private Filter savingAccount1000Filter = new Filter(){
		@Override
		public boolean accept(Object object){
			if(object instanceof SavingAccount && ((SavingAccount)object).getBalance() > 1000)
				return true;
			return false;
		}
	};

	/**
	 * Returns the balance of a SavingAccount object. It double-checks if the
	 * given object is of type SavingAccount.
	 */
	private Measurer savingAccountMeasurer = new Measurer(){
		public int getMeasure(Object object){
			if(object instanceof SavingAccount)
				return (int) ((SavingAccount)object).getBalance();
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
	 * fills a given dataSet with the given values.
	 * @param dataSet the dataSet to fill
	 * @param values the values itself
	 */
	private void fillDataSet(DataSetOne dataSet, int[] values){
		int i=0;
		for(i=0; i<values.length; i++){
			dataSet.addValue(new SavingAccount(values[i], 0));
		}
	}

	/**
	 * This is the first test. The filter which accepts all savingAccounts is
	 * applied. To rounds (values 1 / 2)
	 */
	@Test
	public void runTest1(){
		DataSetOne dataSet = new DataSetOne(savingAccountFilter, savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values1);
		Assert.assertEquals(1620.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(8100, dataSet.getSum());
		Assert.assertEquals(50, dataSet.getMinimum());
		Assert.assertEquals(3750, dataSet.getMaximum());
		
		dataSet = new DataSetOne(savingAccountFilter, savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values2);
		Assert.assertEquals(1554.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(7770, dataSet.getSum());
		Assert.assertEquals(70, dataSet.getMinimum());
		Assert.assertEquals(5000, dataSet.getMaximum());
	}

	/**
	 * This is the first test. The filter which accepts only savingAccounts with a
	 * balance higher than 100 is applied. To rounds (values 1 / 2)
	 */
	@Test
	public void runTest2(){
		DataSetOne dataSet = new DataSetOne(savingAccount1000Filter, savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values1);
		Assert.assertEquals(2650.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(7950, dataSet.getSum());
		Assert.assertEquals(1500, dataSet.getMinimum());
		Assert.assertEquals(3750, dataSet.getMaximum());
		
		dataSet = new DataSetOne(savingAccount1000Filter, savingAccountMeasurer);
		this.fillDataSet(dataSet, this.values2);
		Assert.assertEquals(3500.0, dataSet.getAverage(), 0.001);
		Assert.assertEquals(7000, dataSet.getSum());
		Assert.assertEquals(2000, dataSet.getMinimum());
		Assert.assertEquals(5000, dataSet.getMaximum());
	}
}
