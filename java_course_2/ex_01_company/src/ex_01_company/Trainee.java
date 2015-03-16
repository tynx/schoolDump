package ex_01_company;

import java.util.Calendar;

/**
 * This class is for the employees of the type Trainee. They're are the same
 * as Vendors, with the exception of comission-bonus. they only get
 * a fraction of the comissionBonus. Also they have a lower fixed salary.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Trainee extends Vendor{

	/**
	 * This constructor excpects the name of the employee, the date he joined
	 * the company and the amount of comissions he accomplished.
	 * @param name the name
	 * @param entryDate the date he joined
	 * @param comissions the amount of comissions
	 */
	public Trainee(String name, Calendar entryDate, int comissions) {
		super(name, entryDate, comissions);
		this.fixSalary = 3000;
		this.comissionBonus = 200;
	}

	/**
	 * Calculates the loyality-bonus, not respected for Trainees
	 */
	@Override
	protected void calcLoyalSalary(){
		this.loyalSalary = 0.0d;
	}

	/**
	 * This function calculates the comission bonus.
	 */
	@Override
	protected void calcBonusSalary(){
		int years = this.timeInCompany()/12;
		if(years > 5)
			years = 5;
		this.comissionAmount = this.comissions * (years*0.2) * this.comissionBonus;
	}
}
