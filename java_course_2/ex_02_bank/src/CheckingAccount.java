/**
 * This class creates a checking account with a balance which can 
 * be changed by deposits and withdrawals and a transaction count
 * to calculate additional fees
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class CheckingAccount extends BankAccount implements Cloneable {  

	/**
	 * Integer with a static value of free transactions
	 */
	private static final int FREE_TRANSACTIONS = 3;

	/**
	 * Double with a static value of an transaction fee
	 */
	private static final double TRANSACTION_FEE = 2.0d;

	/**
	 * Integer for counting the transactions
	 */
	private int transactionCount;

	/**
	 * This is a copy constructor
	 * @param CheckingAccount
	 */
	public CheckingAccount(CheckingAccount checkingAccount){
		super((BankAccount) checkingAccount);
	}

	/**
	 * Constructs a checking account with a given balance
	 * @param initialBalance the initial balance
	 */
	public CheckingAccount(double initialBalance) {  
		// construct superclass
		super(initialBalance);
	}

	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		this.transactionCount++;
		// now add amount to balance 
		super.deposit(amount); 
	}

	/**
	 * Withdraws money from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {  
		this.transactionCount++;
		// now subtract amount from balance 
    	super.withdraw(amount); 
	}

	/**
	 * Deducts the accumulated fees and resets the transaction count
	 */
	public void deductFees() {  
		if (this.transactionCount > FREE_TRANSACTIONS) {  
			double fees = TRANSACTION_FEE * (this.transactionCount - FREE_TRANSACTIONS);
			super.withdraw(fees);
		}
		this.transactionCount = 0;
	}

	/**
	 * This method creates an HashCode by calling the super-methode and
	 * adding the transaction count
	 * @return hashCode
	 */
	public int hashCode(){
		int hash = super.hashCode();
		final int HASHMULTIPLIER = 37;
		
		return hash * HASHMULTIPLIER + this.transactionCount;
	}

	/**
	 * Alternative way of hashcode
	 */
	public String hashCode2(){
		return super.hashCode2() + Integer.toHexString(this.transactionCount);
	}
	/**
	 * This method creates an String with all informations about the
	 * bank account by calling the super-methode and adding the informations
	 * about the transaction count
	 * @return bank account information
	 */
	public String toString(){
		return super.toString() + "\t Transactions: " + this.transactionCount + "\t Hashcode: " + hashCode();
	}

	/**
	 * This method compares two checking accounts if they are equal by
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
	public CheckingAccount clone(){
		if(super.clone() != null) return (CheckingAccount) super.clone();
		return null;
	}
}
