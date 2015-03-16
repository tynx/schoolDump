
import java.util.*;
/**
   A class that runs some loop exercises
*/
public class LoopTraining {

	public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);
		  String s = null;
		  do {
			  System.out.print("Enter a integer: ");
			  s = in.nextLine();
			  
			  if (!s.equals("")) {
				  int n = Integer.parseInt(s);
	
				  FactorGenerator factorGen = new FactorGenerator(n);
				  System.out.println("The prime factors of " + n + " are:");
				  
				  while (factorGen.hasMoreFactors()){				 
					  System.out.println(factorGen.nextFactor());
				  }
				  /*
				  PrimeGenerator primeGen = new PrimeGenerator();
				  System.out.println("The prime numbers <= " + n + " are:");
				  int prime = primeGen.nextPrime();
				  
				  while (prime <= n) {
					  System.out.println(prime);
					  prime = primeGen.nextPrime();
				  }
	
				  // Print a diamond with side length of n
				  DiamondGenerator diamondGen = new DiamondGenerator(n / 3);
				  System.out.println("A diamond with size length: " + n / 3);
				  System.out.print(diamondGen.getDiamond());
	
				  // Print all prime numbers <= n
				  // (Tricky): Print the difference between n and m, where
				  // m is the last "power of two - 1" value that is <= n.
				  System.out.println("The difference between " + n + 
				   " and the previous power of two minus 1 is: " +
				   Numeric.getDiff(n));
			 */ }
	    } while (!s.equals(""));
		  in.close();
	}
}
