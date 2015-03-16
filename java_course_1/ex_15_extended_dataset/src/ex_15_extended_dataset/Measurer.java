package ex_15_extended_dataset;

/**
 * This interfaces is for classes which should be able to act as a wrapper for
 * objects which don't implement Measurable.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public interface Measurer {

	/**
	 * This method should be capable of extracting the needed value of any given
	 * object. This interface is for use in combination with Filter. A good
	 * idea is to still check whetever we have a valid object or not, to make
	 * sure we don't run into trouble.
	 * @param object an object with a value inside
	 * @return the actual value
	 */
	public int getMeasure(Object object);
	
}
