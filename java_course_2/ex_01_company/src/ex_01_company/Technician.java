package ex_01_company;

import java.util.Calendar;

/**
 * This class represents the employees of the type technician. He gets a fixed
 * salary. Also if he gets a bonus every 3 years. the salary is capped at
 * 10'000. 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Technician extends AbstractEmployee{

	/**
	 * The bonus he gets every 3years.
	 */
	protected int bonus = 300;

	/**
	 * The constructor which needs the name and the date, the employee
	 * joined the comopany.
	 * @param name the name of the employee
	 * @param entryDate the date he joined the company
	 */
	public Technician(String name, Calendar entryDate) {
		super(name, entryDate);
		this.fixSalary = 9000;
	}

	/**
	 * This function calculates the loyality bonus, 300 every 3 years
	 */
	@Override
	protected void calcLoyalSalary(){
		this.loyalSalary = 0.0d;
		int bonusTimes = this.timeInCompany()/36;
		this.loyalSalary = bonusTimes*300;
		if(this.loyalSalary+this.fixSalary > 10000)
			this.loyalSalary = 10000 - this.loyalSalary;
	}

	/**
	 * This function calculates the bonus of the Technician. not respected
	 */
	@Override
	protected void calcBonusSalary(){
		this.bonusSalary = 0.0d;
	}
}
