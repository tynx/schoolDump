package ex_01_company;

import java.util.Calendar;

/**
 * This class is for employees of the type Vendor. They get their salary
 * based on a fixed salary and also on how much comissoins they accomplished.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Vendor extends AbstractEmployee{

	/**
	 * The bonus they get for every comission
	 */
	protected int comissionBonus = 0;

	/**
	 * The sum of comission to be added to the fixed salary
	 */
	protected double comissionAmount = 0.0d;

	/**
	 * The amount of comissions they accomplished
	 */
	protected int comissions = 0;

	/**
	 * This constructor needs the name, the date they joined, and the amount
	 * of comissions they accomplished.
	 * @param name the name of the employee
	 * @param entryDate the date he joined
	 * @param comissions the amount of comissions he accomplished
	 */
	public Vendor(String name, Calendar entryDate, int comissions) {
		super(name, entryDate);
		this.comissions = comissions;
		this.fixSalary = 6000;
		this.comissionBonus = 200;
	}

	/**
	 * This calculates the loyality-salary. not respected for vendors
	 */
	@Override
	protected void calcLoyalSalary(){
		this.loyalSalary = 0.0d;
	}

	/**
	 * This function calculates the bonus based on the comissions
	 */
	@Override
	protected void calcBonusSalary(){
		this.bonusSalary = this.comissions * this.comissionBonus;
	}
}
