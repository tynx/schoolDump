package ex_15_extended_dataset;

/**
 * This class implements a dataSet with a custom Filter and Measurer.
 * The filter makes sure we only accept certain objects.
 * The Measurer makes sure which value to pick from the given object. This should
 * also make sure the right kind of object is given, otherwise an exception could
 * be thrown.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetOne extends DataSetWrapper{

	/**
	 * The filter which should be applied when adding a new value
	 */
	private final Filter filter;

	/**
	 * The measurer which allows us to get the value of object which should be
	 * taken for measuring
	 */
	private final Measurer measurer;

	/**
	 * The constructor which needs 2 arguments, if a null-value is given, then
	 * an exception will be thrown, as we cannot accept null-values for
	 * validating a given object.
	 * @param filter the filter which should be applied
	 * @param measurer the measurer which should be applied
	 */
	public DataSetOne(Filter filter, Measurer measurer) {
		if (filter == null)
			throw new NullPointerException("Filter is null!");

		if (measurer == null)
			throw new NullPointerException("Measurer is null!");

		this.filter = filter;
		this.measurer = measurer;
	}

	/**
	 * This function applies the filter and the measurer to the given object
	 * and stores the final value inside the dataset.
	 */
	public void addValue(Object object) {
		if (this.filter.accept(object)) {
			this.dataset.addValue(this.measurer.getMeasure(object));
		}
	}
}
