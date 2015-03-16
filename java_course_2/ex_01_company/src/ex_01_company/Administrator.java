package ex_01_company;

import java.util.Calendar;

/**
 * This class represents the employees of the type administrator. This employee
 * gets the salary based on a fixed salary. If he has excessHours: these are
 * payed. Also if he's in the company >10years he gets a bonus of 500.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Administrator extends AbstractEmployee{

	/**
	 * The company object
	 */
	protected Company company = null;

	/**
	 * The number of excessHours he has worked
	 */
	protected int excessHours = 0;

	/**
	 * The constructor, which wants the name, the entryDate, the company and
	 * the number of excessHours.
	 * @param name the name of the administrator
	 * @param entryDate the date he joined the company
	 * @param c the company
	 * @param excessHours the amount of excessHours he has worked
	 */
	public Administrator(String name, Calendar entryDate, Company c, int excessHours) {
		super(name, entryDate);
		this.excessHours = excessHours;
		this.company = c;
		this.fixSalary = 5000;
	}

	/**
	 * This function calculates the bonus of an administrator, which is basically
	 * the excess hours.
	 */
	@Override
	protected void calcBonusSalary(){
		double hour = this.fixSalary/this.company.getHoursPerMonth();
		this.bonusSalary += hour*this.excessHours;
	}

	/**
	 * this function calculates the bonus of the loyalSalary. every year
	 * 3% of the salary + 500 after 10 years
	 */
	@Override
	protected void calcLoyalSalary(){
		int years = this.timeInCompany()/12;
		if(years > 9)
			this.loyalSalary += 500;
		this.loyalSalary += years*0.03*this.fixSalary;
	}
}
