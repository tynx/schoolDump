package ex_10_magic_square;
/**
 * This class creates a Magic Square for any given size
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MagicSquare {

	/**
	 * The size of magic-square which is requests 
	 */
	private int size = 0;

	/**
	 * once calculated, all the values are stored inside here
	 */
	private int[][] numbers;

	/**
	 * This is the constructor, which calculates the whole magic-square and saves
	 * it internaly in the array. 
	 * @param n is the size of the magic square (odd number NEEDED!)
	 */
	public MagicSquare(int n){
		this.size = n;
		if(n%2!=1) // we don't have an odd number
			return;
		this.numbers = new int[n][n];

		int row = n-1;
		int column = n/2;
		int k = 0;
		for(k=1; k<=n*n; k++){
			this.numbers[row][column] = k;
			if(this.numbers[(row+1)%n][(column+1)%n]!=0){
				row --;
			}else{
				column = (column + 1) % n;
				row = (row + 1) % n;
			}
		}
	}

	/**
	 * This method transforms the array into a nice readable string.
	 * @return MagicSquare as String
	 */
	public String toString(){
		StringBuilder output = new StringBuilder();
		for(int i = 0; i<this.size; i++){
			for(int j=0; j<this.size; j++){
				output.append(this.numbers[i][j] + "\t");
			}
			output.append("\n");
		}
		return output.toString();
	}
}
