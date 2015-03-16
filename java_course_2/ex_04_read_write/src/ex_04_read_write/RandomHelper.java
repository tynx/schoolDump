package ex_04_read_write;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * This class is helps create random bank-accounts for the sake of creating
 * random data-files, with same format as provided by the bfh
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class RandomHelper {

	/**
	 * Random object to get some values
	 */
	Random r = new Random();

	/**
	 * if the index leads to a positive integer, we now, that number has
	 * been used.
	 */
	int usedNumbers[] = new int[1000];

	/**
	 * This function creates a date between 1970 and 2013. It prints
	 * it out as a string and returns it.
	 * @return a date in the format of a string
	 */
	private String randomDate(){
		Calendar c = Calendar.getInstance();
		c.set(this.r.nextInt(43) + 1970, this.r.nextInt(12), this.r.nextInt(30));
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(c.getTime());
	}

	/**
	 * Returns a balance between 0 and 100000
	 * @return a random balance
	 */
	private double randomBalance(){
		return this.r.nextDouble()*100000.0;
	}

	/**
	 * Gets a not used bankaccount number and returns that.
	 * This function is not performance-optimized!! if very slow
	 * execution is notable, this needs a new implementation!
	 * But as this part is optional, we don't bother to waste any more
	 * time.
	 * @return a random bank account number
	 */
	private int randomAccountNumber(){
		int number = this.r.nextInt(1000);
		while(this.usedNumbers[number] == 1)
			number = this.r.nextInt(1000);
		this.usedNumbers[number] = 1;
		return number;
	}

	/**
	 * This fuction returns a complete random bank-account objected, filled
	 * with all needed data.
	 * @return the new created bank-account object
	 */
	public BankAccount randomBankAccount(){
		BankAccount ba = new BankAccount();
		ba.accountNumber = this.randomAccountNumber();
		ba.creationDate = this.randomDate();
		ba.currentBalance = this.randomBalance();
		return ba;
	}
}
