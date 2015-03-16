package ex_01;

/**
 * This class provides an easy way to calculate "statistics" about a set of
 * integer-nubmers. it allows you to add dynamically integers.
 * But attention: this is the cheap implementation, as our prof doesn't approve
 * ArrayList.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetCheap {

	/**
	 * This is the current number of integers that have been added.
	 */
	private int amount=0;
	
	/**
	 * This is the current total of all integers combined.
	 */
	private int total=0;
	
	/**
	 * This is the current minimum.
	 */
	private int min;

	/**
	 * This is the current maximum.
	 */
	private int max=0;

	/**
	 * This function adds another value to the dataset. it automatically
	 * does some calculations before adding it. this means, that the maximum
	 * and minimum is calculated right in this function.
	 * @param value the new value that should be added to the dataset
	 */
	public void addValue(int value){
		if(this.amount == 0 || value > this.max){
			this.max = value;
		}
		if(this.amount == 0 || value < this.min){
			this.min = value;
		}
		this.amount ++;
		this.total += value;
	}

	/**
	 * This function returns the sum of all numbers in the dataset added.
	 * @return returns the sum
	 */
	public int getSum(){
		return this.total;
	}
	
	/**
	 * This function returns the average-value of the values in the dataset.
	 * @return the average of all values
	 */
	public double getAverage(){
		if(this.amount == 0)
			return 0;
		
		return (double)this.getSum()/this.amount;
	}
	
	/**
	 * This function returns the smallest value in the dataset. If no
	 * value was added to the dataset, it returns a 0;
	 * @return returns the smallest value
	 */
	public int getMinimum(){
		return this.min;
	}

	/**
	 * This function returns the maximum of the values in the dataset. If no
	 * value was added to the dataset, it returns a 0;
	 * @return the maximum value
	 */
	public int getMaximum(){
		return this.max;
	}
}
