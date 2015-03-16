package ex_04_read_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.Scanner;

/**
 * This class manages the transfomation process. With the help of different
 * Classes, a file is parsed, splitted and written back into 2 files.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class ReadWrite {

	/**
	 * Where the split-limit is
	 */
	public static final int splitBalance = 50000;

	/**
	 * The file provided by the bfh
	 */
	public static final String defaultDataFile = "accounts.txt";

	/**
	 * The base of the path, where all the files are stored
	 */
	public static final String baseLocation = "data/";

	/**
	 * The prefix for the different runs
	 */
	public static final String runPrefix = "run_";

	/**
	 * The name of the file with the lower accounts
	 */
	public static final String lowerAccounts = "lower.txt";

	/**
	 * The name of the file with the higher accounts
	 */
	public static final String higherAccounts = "higher.txt";

	/**
	 * The input stream, for the user input (STDIN)
	 */
	public static Scanner in = new Scanner(System.in);

	/**
	 * The main function, which runs as long until a file is converted
	 * @param args IGNORED!
	 */
	public static void main(String[] args) {
		boolean running = true;
		while(running){
			try {
				ReadWrite.doRun();
				running = false;
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
		ReadWrite.in.close();
	}

	/**
	 * This is for one run. If the rading/writing/parsing fails, an according
	 * exception is thrown.
	 * @throws Exception if parsing/reading/writing failed
	 */
	public static void doRun() throws Exception{
		String dataFile = ReadWrite.askDataFile();
		
		if(dataFile == null || dataFile == "")
			return;
		
		String runBaseLocation = ReadWrite.baseLocation + ReadWrite.runPrefix + ReadWrite.getRun(ReadWrite.runPrefix, "") + "/";
		File dir = new File(runBaseLocation);
		dir.mkdir();
		
		Bank b = new Bank();
		b.readAccounts(dataFile, "\n", "\t");
		b.splitAccounts(runBaseLocation, "\n", " \\ ");
		
		System.out.println("done");
	}

	/**
	 * This function asks the user which file to parse. if no file is provided
	 * the standard file will be parsed (provided by bfh)
	 * @return the path and the file to parse
	 */
	public static String askDataFile(){
		System.out.println("Default dataFile?[y/n]");
		String answer = ReadWrite.in.nextLine();
		if(answer.equals("y"))
			return ReadWrite.baseLocation + ReadWrite.defaultDataFile;
		
		File baseFolder = new File(ReadWrite.baseLocation);
		File[] listOfFiles = baseFolder.listFiles(); 

		for (int i = 0; i < listOfFiles.length; i++){
			if (listOfFiles[i].isFile()){
				String name = listOfFiles[i].getName();
				System.out.println(" - " + name);
			}
		}
		System.out.println("enter index or [c] to create new one:");
		answer = ReadWrite.in.nextLine();
		if(answer.equals("c"))
			return ReadWrite.createAccountsFile();
		else{
			return ReadWrite.baseLocation + "accounts_" + Integer.parseInt(answer) + ".txt";
		}
	}

	/**
	 * This method creates a random new accounts-file
	 * @return the string of the new file
	 */
	public static String createAccountsFile(){
		RandomHelper rh = new RandomHelper();
		String data = "";
		
		int i = 0;
		for(i=(new Random()).nextInt(50)+50; i>-1; i--){
			BankAccount ba = rh.randomBankAccount();
			data += "Account #: " + ba.accountNumber + "\t" +
			"Balance: " + ba.currentBalance + "\t" +
			"Creation date: " + ba.creationDate + "\n";
		}

		String name = ReadWrite.baseLocation + "accounts_" + ReadWrite.getRun("accounts_", ".txt") + ".txt";
		try {
			PrintWriter writer = new PrintWriter(name, "UTF-8");
			writer.print(data);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return name;
	}

	/**
	 * This function determines the next free name for a folder or file.
	 * Basically it figures out in which run we are.
	 * @param prefix the prefix of the file/folder
	 * @param suffix the suffix of the file/folder
	 * @return the number of the run
	 */
	public static int getRun(String prefix, String suffix){
		int i=0;
		File f = new File(ReadWrite.baseLocation + prefix + i + suffix);
		while(f.exists()){
			i++;
			f = new File(ReadWrite.baseLocation + prefix + i + suffix);
		}
		return i;
	}

}
