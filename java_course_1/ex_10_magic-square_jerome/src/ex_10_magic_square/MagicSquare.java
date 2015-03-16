/**
 * 
 */
package ex_10_magic_square;


/**
 * @author whazaa
 *
 */
public class MagicSquare {

	private int number = 0;
	private int[][] square;
	
	/**
	 * The Constructor constructs the square
	 * @param n
	 */
	public MagicSquare(int n){
		this.number = n;
		this.square = new int[this.number][this.number];
		constructMagicSquare();
	}
	
	private void constructMagicSquare(){
		int row = this.number -1;
		int column = this.number/2;
		this.square[row][column] = 1;
		
		for(int k = 2; k <= Math.pow(this.number, 2); k++){
			if(this.square[(row + 1) % this.number][(column + 1) % this.number] == 0){
				row = (row + 1) % this.number;
				column = (column + 1) % this.number;
			} 
			else{
				row = (row - 1) % this.number;
			}
			this.square[row][column] = k;
		}
	}
	
	public String arraytoString(){
		StringBuffer arrayToString = new StringBuffer();
		
		for(int i = 0; i < this.number; i++){
			for(int j = 0; j < this.number; j++){
					arrayToString.append(this.square[i][j] + "\t");
					if(j == this.number - 1) arrayToString.append("\n");
			}
		}
		return arrayToString.toString();
	}
}
