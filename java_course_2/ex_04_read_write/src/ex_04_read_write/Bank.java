package ex_04_read_write;

import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * This class is capable of parsing a file with accounts, stores them internally
 * in a treemap and stores them back into files in a different format.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Bank {

	/**
	 * This object helps to handle input/output
	 */
	IOHelper io = null;

	/**
	 * The accounts are stored in here. Integer=>account nr
	 */
	TreeMap<Integer, BankAccount> accounts = new TreeMap<Integer, BankAccount>();

	/**
	 * The constructor which just makes an IOHelper object
	 */
	public Bank(){
		this.io = new IOHelper();
	}

	/**
	 * This function reads a file and splits the data into single fields with
	 * delimiter 1 and delimiter 2. This function throws exception in the case
	 * of the parsing failing.
	 * @param filename the file which should be parsed
	 * @param delimiter1 the delimiter 1 (for the rows)
	 * @param delimiter2 the delimiter2 (for the fields)
	 * @throws Exception throws an ecpetion if parsing failed
	 */
	public void readAccounts(String filename, String delimiter1, String delimiter2) throws Exception{
		int i=0;
		String[] rows = this.io.getContents(filename).split(delimiter1);
		for(String row:rows){
			i++;
			try{
				this.readLine(row, delimiter2);
			}catch(Exception e){
				String msg = "Parsing failed at line " + i + " due to ";
				if(e instanceof invalidFieldProvidedException)
					throw new Exception(msg + "invalid field.", e);
				else if(e instanceof notEnoughFieldsException)
					throw new Exception(msg + "missing fields.", e);
			}
		}
	}

	/**
	 * This function splits the accounts, which were pares beforehand and splits
	 * them based on the limit into 2 files.
	 * @param baseLocation were the new files should be created
	 * @param delimiter1 the delimiter for the rows
	 * @param delimiter2 the delimiter for the fields
	 */
	public void splitAccounts(String baseLocation, String delimiter1, String delimiter2){
		String dataLow = "";
		String dataHigh = "";
		double totalHigh = 0.0d;
		double totalLow = 0.0d;
		for(Entry<Integer, BankAccount> entry : this.accounts.entrySet()) {
			BankAccount ba = entry.getValue();
			String line = "#: " + ba.accountNumber + delimiter2 +
			"Date: " + ba.creationDate + delimiter2 +
			"Balance: " + ba.currentBalance;
			if(ba.currentBalance < ReadWrite.splitBalance){
				dataLow += line + delimiter1;
				totalLow += ba.currentBalance;
			}else{
				dataHigh += line + delimiter1;
				totalHigh += ba.currentBalance;
			}
			
		}

		dataHigh += "TOTAL: " + totalHigh + "\n";
		dataLow += "TOTAL: " + totalLow + "\n";

		io.setContents(baseLocation + ReadWrite.higherAccounts, dataHigh);
		io.setContents(baseLocation + ReadWrite.lowerAccounts, dataLow);
		
	}

	/**
	 * This function parses a line for and adds the parsed account into the
	 * the treemap. if there is an error (syntax/missing fields) in the line
	 * and according exception is thrown.
	 * @param line the string to parse
	 * @param delimiter the delimiter to split for
	 * @throws notEnoughFieldsException this exception is thrown if not enough fields are given
	 * @throws invalidFieldProvidedException this exception is thrown for all other errors
	 */
	private void readLine(String line, String delimiter) throws notEnoughFieldsException, invalidFieldProvidedException{
		if(line == null || line == "")
			return;
		BankAccount ba = new BankAccount();
		String[] fields = line.split(delimiter);
		if(fields.length < 3)
			throw new notEnoughFieldsException();
		for(String field:fields){
			if(field.indexOf("Account #: ") == 0){
				String number = field.substring("Account #: ".length());
				ba.accountNumber = Integer.parseInt(number);
			}else if(field.indexOf("Balance: ") == 0){
				String number = field.substring("Balance: ".length());
				ba.currentBalance = Double.parseDouble(number);
			}else if(field.indexOf("Creation date: ") == 0){
				ba.creationDate = field.substring("Creation date: ".length());
			}else{
				throw new invalidFieldProvidedException();
			}
		}
		this.accounts.put(ba.accountNumber, ba);
	}
}
