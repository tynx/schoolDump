/**
 * This class creates a saving account with a balance which can 
 * be changed by deposits and withdrawals and a interest rate
 * to calculate the interest of the saving account
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SavingsAccount extends BankAccount {  

	/**
	 * Integer with the interest rate of the saving account
	 */
	private double interestRate = 0.0d;

	/**
	 * This is a copy constructor
	 * @param CheckingAccount
	 */
	public SavingsAccount(SavingsAccount savingsAccount){
		super((BankAccount) savingsAccount);
		this.interestRate = savingsAccount.interestRate;
	}

	/**
	 * Constructs a bank account with a given interest rate
	 * @param rate the interest rate
	 */
	public SavingsAccount(double initialBalance, double rate) { 
		super(initialBalance);
		this.interestRate = rate;
	}

	/**
	 * Adds the earned interest to the account balance
	 */
	public void addInterest() {
		double interest = getBalance() * this.interestRate;
		deposit(interest); 
	}

	/**
	 * This method creates an HashCode by calling the super-methode and
	 * adding the interest rate
	 * @return hashCode
	 */
	public int hashCode(){
		int hash = super.hashCode();
		long field = Double.doubleToLongBits(this.interestRate);
		int value = (int)(field ^ (field >>> 32));
		final int HASHMULTIPLIER = 37;
		
		return hash * HASHMULTIPLIER + value;
	}

	/**
	 * This an alternive way of the hash
	 */
	public String hashCode2(){
		return super.hashCode2() + Double.toHexString(this.interestRate);
	}

	/**
	 * This method creates an String with all informations about the
	 * bank account by calling the super-method and adding the informations
	 * about the interestrate
	 * @return bank account information
	 */
	public String toString(){
		return super.toString() + "\t Interest Rate: " + this.interestRate + "\t Hashcode: " + hashCode();
	}

	/**
	 * This method compares two saving accounts if they are equal by
	 * comparing the hashcodes
	 * @return boolean value
	 */
	public boolean equals(Object obj){
		return super.equals(obj);
	}

	/**
	 * This method clone an existing checking account. if the clone failed it returns null
	 * @return clonedBank or null if the cloning failed
	 */
	public SavingsAccount clone(){
		if(super.clone() != null) return (SavingsAccount) super.clone();
		return null;
	}
}
