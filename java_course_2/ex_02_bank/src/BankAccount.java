import java.util.UUID;

/**
 * This class creates a bank account with a balance which can 
 * be changed by deposits and withdrawals.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class BankAccount implements Cloneable{  

	/**
	 * Integer for the account number
	 */
	private int accountNumber = 0;

	/**
	 * Double for the bank account balance
	 */
	private double balance = 0.0d;

	/**
	 * This is a copy constructor
	 * @param account
	 */
	public BankAccount(BankAccount bankAccount){
		this.balance = bankAccount.balance;
		this.accountNumber = bankAccount.accountNumber;
	}

	/**
	 * Constructs a bank account with a zero balance
	 * @param anAccountNumber the account number for this account
	 */
	public BankAccount(int anAccountNumber) {   
		this.accountNumber = createAccountNumber();
	}

	/**
	 * Constructs a bank account with a given balance
	 * @param anAccountNumber the account number for this account
	 * @param initialBalance the initial balance
	 */
	public BankAccount(double initialBalance) {   
		this.accountNumber = createAccountNumber();
		this.balance = initialBalance;
	}

	/**
	 * this method creates a hashCode of a random UUID
	 * @return HashCode
	 */
	private int createAccountNumber(){
		return  UUID.randomUUID().hashCode();
	}

	/**
	 * Deposits money into the bank account.
	 * @param amount the amount to deposit
	 */
	public void deposit(double amount) {  
		this.balance += amount;
	}

	/**
	 * Withdrawsmoney from the bank account.
	 * @param amount the amount to withdraw
	 */
	public void withdraw(double amount) {   
		this.balance -= amount;
	}

	/**
	 * Gets the current balance of the bank account.
	 * @return the current balance
	 */
	public double getBalance() {   
		return this.balance;
	}

	/**
	 * This method creates an HashCode with the account number
	 * and the value of the bank account balance
	 * @return hashCode
	 */
	public int hashCode() {
		int hash = 17;
		long field = Double.doubleToLongBits(this.balance);
		int value = (int)(field ^ (field >>> 32));
		final int HASHMULTIPLIER = 37;
		
		return hash * HASHMULTIPLIER + this.accountNumber + value;	
	}

	/**
	 * This method is alternative hashCode variant
	 */
	public String hashCode2(){
		return this.accountNumber + Double.toHexString(this.balance);
	}

	/**
	 * This method creates an String with all informations about the
	 * bank account
	 * @return bank account information
	 */
	public String toString(){
		return getClass().getName() + "\t account number: " + this.accountNumber  + "\t balance: " + this.balance;
	}

	/**
	 * This method compares two bank account if they are equal by
	 * comparing the hashcodes
	 * @return boolean value
	 */
	public boolean equals(Object obj){
		if (obj == null) return false;
		if (!obj.getClass().equals(this.getClass())) return false;
		BankAccount bankAccount = (BankAccount) obj;
		
		return this.hashCode() == bankAccount.hashCode();
	}

	/**
	 * This method clone an existing bank account. if the clone failed it returns null
	 * @return clonedBank or null if the cloning failed
	 */
	public BankAccount clone() {
		try {
			return (BankAccount) super.clone();
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
