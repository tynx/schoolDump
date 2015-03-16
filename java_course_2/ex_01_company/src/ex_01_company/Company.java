package ex_01_company;

/**
 * This class stores all needed information about the company. There are the
 * shares of the company and the amount of hours an employee has to work for
 * any given month.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Company {

	/**
	 * The shares of the company
	 */
	private int shares = 0;

	/**
	 * The amount of hours, the employees have to work within a month
	 */
	private int hoursPerMonth = 0;

	/**
	 * The constructor which expect all properties of the company set
	 * @param shares the shares of the company
	 * @param hoursPerMonth the amount of hours to work within a motn
	 */
	public Company(int shares, int hoursPerMonth){
		this.shares = shares;
		this.hoursPerMonth = hoursPerMonth;
	}

	/**
	 * Returns the shares of the company
	 * @return the shares
	 */
	public int getShare(){
		return this.shares;
	}

	/**
	 * Returns the hours an employee has work within a mont
	 * @return the hours
	 */
	public int getHoursPerMonth(){
		return this.hoursPerMonth;
	}
}
