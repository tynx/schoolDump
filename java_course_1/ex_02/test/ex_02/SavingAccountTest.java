package ex_02;

import org.junit.Test;
import org.junit.Assert;

/**
 * This a JUnit test for the SavingAccount
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class SavingAccountTest {
	
	/**
	 * This function allows an easy way to test the SavingAccount with different
	 * values
	 * @param startBalance the balance to start with
	 * @param interest the interest that should be applied to the balance
	 * @param rounds the number of times the interest should be applied
	 */
	private void test(double startBalance, double interest, int rounds){
		SavingAccount sa = new SavingAccount(startBalance, interest);
		int i=0;
		for(i=0; i<rounds; i++){
			sa.addInterest();
		}
		
		Assert.assertEquals(startBalance*Math.pow(interest+1.0, rounds),sa.getBalance(),0.00001);
		
		System.out.println("Current testcaseBalance: " + (startBalance*Math.pow(interest+1.0, rounds)));
	}
	
	@Test
	public void negativeBalanceSmallInterestOneRound(){
		test(-1000, 0.01, 1);
	}

	@Test
	public void negativeBalanceSmallInterestTenRound(){
		test(-1000, 0.01, 10);
	}

	@Test
	public void negativeBalanceNegativeInterestOneRound(){
		test(-1000, -0.2, 1);
	}

	@Test
	public void negativeBalanceNegativeInterestTenRound(){
		test(-1000, -0.1, 10);
	}
	
	@Test
	public void negativeBalanceBigInterestOneRound(){
		test(-1000, 2, 1);
	}

	@Test
	public void negativeBalanceBigNegativeInterestTenRound(){
		test(-1000, -3, 10);
	}
	
	@Test
	public void negativeBigBalanceSmallInterestOneRound(){
		test(-10000000, 0.01, 1);
	}

	@Test
	public void negativeBigBalanceSmallInterestTenRound(){
		test(-10000000, 0.01, 10);
	}

	@Test
	public void negativeBigBalanceNegativeInterestOneRound(){
		test(-10000000, -0.2, 1);
	}
	
	@Test
	public void negativeBigBalanceNegativeInterestTenRound(){
		test(-10000000, -0.1, 10);
	}

	@Test
	public void positiveBalanceSmallInterestOneRound(){
		test(1000, 0.01, 1);
	}

	@Test
	public void positiveBalanceSmallInterestTenRound(){
		test(1000, 0.01, 10);
	}

	@Test
	public void positiveBalanceNegativeInterestOneRound(){
		test(1000, -0.2, 1);
	}

	@Test
	public void positiveBalanceNegativeInterestTenRound(){
		test(1000, -0.1, 10);
	}
	
	@Test
	public void positiveBalanceBigInterestOneRound(){
		test(1000, 2, 1);
	}

	@Test
	public void positiveBalanceBigNegativeInterestTenRound(){
		test(1000, -3, 10);
	}
	
	@Test
	public void positiveBigBalanceSmallInterestOneRound(){
		test(10000000, 0.01, 1);
	}

	@Test
	public void positiveBigBalanceSmallInterestTenRound(){
		test(10000000, 0.01, 10);
	}

	@Test
	public void positiveBigBalanceNegativeInterestOneRound(){
		test(10000000, -0.2, 1);
	}
	
	@Test
	public void positiveBigBalanceNegativeInterestTenRound(){
		test(Double.MAX_VALUE, -0.1, 10);
	}
	

}
