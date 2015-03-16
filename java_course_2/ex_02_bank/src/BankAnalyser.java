
public class BankAnalyser {
	
	public static void main(String[] args) {
		runTestCaseOne();
		sysout("\n\n");
		runTestCaseTwo();
		sysout("\n\n");
		runTestCaseThree();
	}

	public static void sysout(String message){
		System.out.println(message);
	}
	
	public static void runTestCaseOne(){
		CheckingAccount bobChecking = new CheckingAccount(1000.0);
		CheckingAccount timChecking = new CheckingAccount(3200.0);
		CheckingAccount peterChecking = new CheckingAccount(1000.0);
		
		sysout("========================== testcase 1 ==========================");
		sysout("comparing two Checking Accounts:");
		sysout(bobChecking.toString() + "\n" + timChecking.toString());
		sysout("Are the two accounts equal?: " + bobChecking.equals(timChecking));
		
		sysout("\ncomparing two Checking Accounts with the same balance:");
		sysout(bobChecking.toString() + "\n" + peterChecking.toString());
		sysout("Are the two accounts equal?: " + bobChecking.equals(peterChecking));
		
		sysout("\ncloning a Checking Account and comparing the original with the clone:");
		CheckingAccount clonedCheckingAccount = timChecking.clone();
		sysout(timChecking.toString() + "\n" + clonedCheckingAccount.toString());
		sysout("Are the two accounts equal?: " + timChecking.equals(clonedCheckingAccount));
		
		sysout("\ncopying a Checking Account with a Copy Constructor:");
		CheckingAccount copiedCheckingAccount = new CheckingAccount(peterChecking);
		sysout(peterChecking.toString() + "\n" + copiedCheckingAccount.toString());
		sysout("Are the two accounts equal?: " + peterChecking.equals(copiedCheckingAccount));
	}
	
	public static void runTestCaseTwo(){
		SavingsAccount bobSaving = new SavingsAccount(5400.0, 0.05);
		SavingsAccount lisaSaving = new SavingsAccount(23000.0, 0.03);
		SavingsAccount peterSaving = new SavingsAccount(5400.0, 0.05);
		
		sysout("========================== testcase 2 ==========================");
		sysout("comparing two Saving Accounts:");
		sysout(bobSaving.toString() + "\n" + lisaSaving.toString());
		sysout("Are the two accounts equal?: " + bobSaving.equals(lisaSaving));
		
		sysout("\ncomparing two Saving Accounts with the same balance and initial rate:");
		sysout(bobSaving.toString() + "\n" + peterSaving.toString());
		sysout("Are the two accounts equal?: " + bobSaving.equals(peterSaving));
		
		sysout("\ncloning a Saving Account and comparing the original with the clone:");
		SavingsAccount clonedSavingAccount = lisaSaving.clone();
		sysout(lisaSaving.toString() + "\n" + clonedSavingAccount.toString());
		sysout("Are the two accounts equal?: " + lisaSaving.equals(clonedSavingAccount));
		
		sysout("\ncopying a Saving Account with a Copy Constructor:");
		SavingsAccount copiedSavingAccount = new SavingsAccount(bobSaving);
		sysout(bobSaving.toString() + "\n" + copiedSavingAccount.toString());
		sysout("Are the two accounts equal?: " + bobSaving.equals(copiedSavingAccount));
	}
	
	public static void runTestCaseThree(){
		Bank bankA = new Bank();
		Bank bankB = new Bank();
		
		CheckingAccount bobChecking = new CheckingAccount(6500.0);
		CheckingAccount lisaChecking = new CheckingAccount(2300.0);
		SavingsAccount bobSaving = new SavingsAccount(23500.0, 0.04);
		SavingsAccount lisaSaving = new SavingsAccount(45550.0, 0.03);
		
		bankA.addAccount(bobChecking);
		bankA.addAccount(bobSaving);
		bankA.addAccount(lisaSaving);
		
		bankB.addAccount(lisaChecking);
		bankB.addAccount(lisaSaving);
		bankB.addAccount(bobSaving);
		bankB.addAccount(bobChecking);
		
		sysout("========================== testcase 3 ==========================");
		sysout("comparing two Banks:");
		sysout(bankA.toString() + "\n" + bankB.toString());
		sysout("Are the two banks equal?: " + bankA.equals(bankB));
		
		sysout("\n\ncloning a bank and comparing the original with the clone:");
		Bank clonedBank = bankB.clone();
		sysout(bankB.toString() + "\n" + clonedBank.toString());
		sysout("Are the two banks equal?: " + bankB.equals(clonedBank));
		
		sysout("\n\ncopying a bank with a Copy Constructor:");
		Bank copiedBank = new Bank(bankA);
		sysout(bankA.toString() + "\n" + copiedBank.toString());
		sysout("Are the two accounts equal?: " + bankA.equals(copiedBank));	
	}
}
