package ex_15_extended_dataset;

/**
 * FROM EX_01 (SERIE 1)
 * This allows to make calculations for a saving-account. Which means it
 * calculates the interest for you. its pretty generic, so negativ intereset
 * is possible too.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SavingAccount {
	
	/**
	 * The interest, which start with 1 (if multiplicated by 1 => no interest)
	 */
	private double interest = 1.0;

	/**
	 * This is the current balance
	 */
	private double balance = 0.0;

	/**
	 * The Constructor sets the basic values
	 * @param balance the balance to start with
	 * @param interest the interest for the given balance
	 */
	public SavingAccount(double balance, double interest){
		this.interest += interest;
		this.balance = balance;
	}

	/**
	 * this adds the interest. it does so by multiplying the current balance
	 * with the stored interest.
	 */
	public void addInterest(){
		this.balance *= this.interest;
	}

	/**
	 * the current balance with all interests
	 * @return the balance
	 */
	public double getBalance(){
		return this.balance;
	}
}