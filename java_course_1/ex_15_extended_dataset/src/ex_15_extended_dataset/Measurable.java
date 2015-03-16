package ex_15_extended_dataset;

/**
 * This interface makes sure that every class which implements it has a method
 * which returns the value which should be made countable.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public interface Measurable {

	/**
	 * The current value of the Measurable
	 * @return the value
	 */
	public int getMeasure();
}
