package ex_01;

import java.util.ArrayList;

/**
 * This class provides an easy way to calculate "statistics" about a set of
 * integer-nubmers. it allows you to add dynamically integers.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 *
 */
public class DataSet{

	/**
	 * This array-list stores all the added values and is used to calculate
	 * the "statistics" about the values.
	 */
	private ArrayList<Integer> numbers = new ArrayList<Integer>();

	/**
	 * This function adds an integer to the dataset.
	 * @param value: the value to add
	 * @return returns whetever the adding was successful
	 */
	public boolean addValue(int value){
		return this.numbers.add(value);
	}

	/**
	 * This function returns the sum of all numbers in the dataset added.
	 * @return returns the sum
	 */
	public int getSum(){
		int i=0;
		int sum = 0;
		int length = this.numbers.size();
		for(i=0; i<length;i++){
			sum += this.numbers.get(i);
		}
		return sum;
	}
	
	/**
	 * This function returns the average-value of the values in the dataset.
	 * @return the average of all values
	 */
	public double getAverage(){
		if(this.numbers.size() == 0)
			return 0;
		return (double)this.getSum()/this.numbers.size();
	}
	
	/**
	 * This function returns the smallest value in the dataset. If no
	 * value was added to the dataset, it returns a 0;
	 * @return returns the smallest value
	 */
	public int getMinimum(){
		if(this.numbers.size() == 0)
			return 0;
		int i=0;
		int min = this.numbers.get(0);
		int length = this.numbers.size();
		// go trough array list and find smallest number
		for(i=0; i<length;i++){
			if(min > this.numbers.get(i))
				min = this.numbers.get(i);
		}
		return min;
	}

	/**
	 * This function returns the maximum of the values in the dataset. If no
	 * value was added to the dataset, it returns a 0;
	 * @return the maximum value
	 */
	public int getMaximum(){
		if(this.numbers.size() == 0)
			return 0;
		int i=0;
		int max = this.numbers.get(0);
		int length = this.numbers.size();
		// go trough array and find biggest number
		for(i=0; i<length;i++){
			if(max < this.numbers.get(i))
				max = this.numbers.get(i);
		}
		return max;
	}
}
