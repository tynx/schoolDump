package ex_15_extended_dataset;

/**
 * This class allows to have any kind of object, either ones which implement
 * Measurable or don't. But if they don't, it's important to give a new measurer
 * so the class is capable of handling that.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DataSetTwo extends DataSetWrapper{

	/**
	 * This is the measurer which is applied in addValue
	 */
	private Measurer measurer;

	/**
	 * Call the constructor without any Measurer, if the objects you add are all
	 * implementing Measurable.
	 */
	public DataSetTwo() {
		this.measurer = new Measurer() {
			@Override
			public int getMeasure(Object object) {
				if (object instanceof Measurable) {
					return ((Measurable) object).getMeasure();
				}
				return 0;
			}
		};
	}

	/**
	 * Call the constructor with a custom Measurer, as soon as you have object
	 * which don't implement Measurable.
	 * As we really need a Measurer, an exception is thrown when null given.
	 * @param measurer the measurer which should be applied when adding objects
	 */
	public DataSetTwo(Measurer measurer) {
		if (measurer == null)
			throw new NullPointerException("Measurer is null!");
		
		this.measurer = measurer;
	}

	/**
	 * This adds a value to the dataSet. The measurer is already set by this
	 * point.
	 */
	@Override
	public void addValue(Object object) {
		this.dataset.addValue(this.measurer.getMeasure(object));
	}
}
