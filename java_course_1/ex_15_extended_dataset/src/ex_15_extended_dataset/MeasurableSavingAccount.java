package ex_15_extended_dataset;

/**
 * This class extends the SavingAccount which only is usable in this exercise with
 * the help of a Measurer. This class however implements Measurable and gets rid
 * of the use of a Measurer.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MeasurableSavingAccount extends SavingAccount implements Measurable{

	/**
	 * Call parent-super. We don't want to change the behaviour in any way
	 * @param balance the start-balance to start with
	 * @param interest the intereset which should be added.
	 */
	public MeasurableSavingAccount(double balance, double interest) {
		super(balance, interest);
	}

	/**
	 * This functions returns the current balance fo the saving-account.
	 * This is the wrapper so we can get rid of Measurer.
	 */
	@Override
	public int getMeasure() {
		return (int)this.getBalance();
	}
	
}
