package ex_15_extended_dataset;

/**
 * This interface is used for Filters. It has only one method, which is for
 * filtering out certain objects.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public interface Filter {

	/**
	 * This method should accept any sort of object, checks whetever this object
	 * should be accepted based on rules.
	 * @param object the object to validate
	 * @return whetever it is a valid object or not
	 */
	boolean accept(Object object);
}
