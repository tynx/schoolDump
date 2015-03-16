package ex_01_company;

import java.util.Calendar;

/**
 * This class is for creating some random employees and print out their 
 * information. For every type there are two rounds.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
abstract public class AbstractEmployee {

	/**
	 * The name of the employee
	 */
	private String name = null;

	/**
	 * The name that should be printed (containing also the function)
	 */
	private String displayName = null;

	/**
	 * The date when the employee joined the company.
	 */
	private Calendar entryDate = null;

	/**
	 * The calculated salary will be saved in here.
	 */
	protected double salary = 0.0d; 

	/**
	 * The fix salary which will be added to salary once
	 */
	protected double fixSalary = 0.0d;

	/**
	 * this is the bonus part, salary based on perfomance
	 */
	protected double bonusSalary = 0.0d;

	/**
	 * This is the loyality part, salary based on the loyality for the company
	 */
	protected double loyalSalary = 0.0d;

	/**
	 * The contstructor just sets the internal vars and concats (via
	 * setDisplayName) the displayName.
	 * @param name
	 * @param entryDate
	 */
	public AbstractEmployee(String name, Calendar entryDate){
		this.name = name;
		this.entryDate = entryDate;

		this.setDisplayName();
	}
	

	/**
	 * This concats the name and the type the employee is
	 */
	protected void setDisplayName(){
		this.displayName = this.name + ", " + this.getClass().getSimpleName();
	}

	/**
	 * This function returns the amount of months the employee has worked in the
	 * company.
	 * @return the months he spent in the company.
	 */
	public int timeInCompany(){
		int diffYear = Calendar.getInstance().get(Calendar.YEAR) - this.entryDate.get(Calendar.YEAR);
		int diffMonth = diffYear * 12 + Calendar.getInstance().get(Calendar.MONTH) - this.entryDate.get(Calendar.MONTH);
		return diffMonth;
	}

	/**
	 * Every subclass has to calculate the bonus
	 */
	protected abstract void calcBonusSalary();

	/**
	 * Every subclass has to calculate the loyality
	 */
	protected abstract void calcLoyalSalary();
	
	/**
	 * This function has to be overwritten so the salary is actually calculated.
	 */
	protected final void calcSalary(){
		this.calcBonusSalary();
		this.calcLoyalSalary();
		this.salary = this.fixSalary + this.bonusSalary + this.loyalSalary;
	}

	/**
	 * This function returns the calculated salary. if the salary equals 0.0
	 * then calcSalary is involved, as this means the salary has no been
	 * calculated.
	 * @return the calculated salary
	 */
	public double getSalary(){
		if(salary == 0.0)
			this.calcSalary();
		return this.salary;
	}

	/**
	 * Returns the name and the function of the employee.
	 * @return the displayName of the employee
	 */
	public String getDisplayName(){
		return this.displayName;
	}

	/**
	 * Returns the date when the company joined the company.
	 * @return the date of entry
	 */
	public Calendar getEntryDate(){
		return this.entryDate;
	}
}
