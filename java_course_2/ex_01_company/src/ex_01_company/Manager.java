package ex_01_company;

import java.util.Calendar;

/**
 * This class is for managers. They don't have a fixed salary and the
 * salary is calculated based on the shares the company currently has.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Manager extends AbstractEmployee{

	/**
	 * This is the percentage the managers get off of the share.
	 */
	private final static double managerPortion = 1.5;

	/**
	 * The company-object is stored in here and contions the current shares.
	 */
	protected Company company = null;

	/**
	 * This constructor sets all the necessary properties and calls the super-
	 * constructor.
	 * @param name the name of the manager
	 * @param entryDate the entry date of the manager
	 * @param company the company-object for knowing the shares
	 */
	public Manager(String name, Calendar entryDate, Company company) {
		super(name, entryDate);
		this.company = company;
		this.fixSalary = 0.0d;
	}

	/**
	 * This function calculates the loyalityBonus. Not repsected for manager.
	 */
	@Override
	protected void calcLoyalSalary(){
		this.loyalSalary = 0.0d;
	}

	/**
	 * Calculates the bonus of the manager. He gets a percentage of the
	 * shares of the company
	 */
	@Override
	protected void calcBonusSalary(){
		this.bonusSalary = this.company.getShare() * (Manager.managerPortion/100);
	}
}
