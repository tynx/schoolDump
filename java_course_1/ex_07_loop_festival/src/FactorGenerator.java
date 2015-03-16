
public class FactorGenerator {

	private int n;
	
	/**
	 * This Integer Array stores the 8 smallest prime Numbers to make a frame for our programm
	 * because it exists infinitly prime numbers
	 */
	private final int[] primeNumber = {
		2, 
		3, 
		5, 
		7, 
		11, 
		13, 
		17, 
		19
	};
	
	public FactorGenerator(int n){
		this.n = n;
	}
	
	public boolean hasMoreFactors(){
		for(int i = 0; i < this.primeNumber.length; i++){
			while (this.n % this.primeNumber[i] == 0){
				return true;
			}
		}
		return false;
	}
	public int nextFactor(){
		int result = 0;
		for(int i = 0; i < this.primeNumber.length; i++){
			while (this.n % this.primeNumber[i] == 0){
				result = primeNumber[i];		
			}
		}
		return result;
	}
}
