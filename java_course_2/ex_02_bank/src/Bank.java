import java.util.*;

/**
 * This class creates a Bank where you can add Bankaccounts
 * It's possible to clone the an existing Bank
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Bank implements Cloneable{

	/**
	 * ArrayList with the Bankaccounts
	 */
	private ArrayList<BankAccount> accounts;

	/**
	 * This is a copy Constructor
	 * @param bank the bank to copy
	 */
	public Bank(Bank bank){
		this.accounts = bank.accounts;
	}

	/**    
	 * Constructs a bank with no bank accounts.
	 */
	public Bank() {
		this.accounts = new ArrayList<BankAccount>();
	}

	/**
	 * Adds an account to this bank.
	 * @param a the account to add
	*/
	public void addAccount(BankAccount a) {
		accounts.add(a);
	}

	/**
	 * this method creates an hashcode by adding the hashcodes of
	 * the bank accounts
	 * @return the hash code of the bank
	 */
	public int hashCode(){
		int hash = 17;
		int value = this.accounts.size();
		final int HASHMULTIPIER = 54;
		
		return hash * HASHMULTIPIER + value;
	}

	/**
	 * this method creates a Stringbuilder with all informations about the bank
	 * and the bank accounts
	 * @return bankInformations all informations about the bank
	 */
	public String toString() {
		StringBuilder bankInformations = new StringBuilder();
		bankInformations.append("Number of bank accounts: \t" + this.accounts.size() + "\n\n");
		for(int i = 0; i < this.accounts.size(); i++){
			bankInformations.append(this.accounts.get(i).toString() + "\n");
		}
		return bankInformations.toString();
	}

	/**
	 * This method compares if two banks are equal by comparing the ArrayLists of the 
	 * the two banks
	 * @return a boolean value if the two banks are equal
	 */
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Bank bank = (Bank) obj;
		
		return this.accounts.equals(bank.accounts);
	}

	/**
	 * This method clone an existing bank. if the clone failed it returns null
	 * @return clonedBank or null if the cloning failed
	 */
	public Bank clone() {
		try {
			Bank clonedBank = (Bank)super.clone();
			clonedBank.accounts = this.accounts;
			return clonedBank;
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
