import java.util.Arrays;

/**
 * @author whazaa
 *
 */
public class Sequence {
	private int valueSize = 0;
	private int[] values;
	
	/**
	 * This constructor allows to determines the size of the array
	 * @param size
	 */
	public Sequence (int size) {
		this.values = new int[size];
	}
	
	/**
	 * This constructor delivers to the class an array of integer values
	 * @param values
	 */
	public Sequence (int[] values){
		this.values = values;
		this.valueSize = values.length;
	}
	
	/**
	 * This method stores into the array the value val at position
	 *	pos. If the array is not large enough, you must increase its size (e.g. by doubling its length)
	 * @param pos
	 * @param value
	 */
	public void set(int pos, int value){
		int posDiff = Math.abs(this.valueSize - pos);
		//Check if the array is large enough, if not it's doubling the length
		if (pos > this.values.length || this.valueSize == this.values.length){
			this.values = Arrays.copyOf(this.values, 2*this.values.length);
		}
						
		if (this.valueSize < this.values.length) {
			for (int i = this.valueSize; i > pos; i--){
				this.values[i] = this.values[i-1];	
			}
			this.values[pos] = value;
			if(this.valueSize > pos){
				this.valueSize++;
			} else {
				this.valueSize += posDiff + 1;
			}
		}
		//System.out.println(this.valueSize);
	}
	
	/**
	 * This method checks whether two sequence objects
	 *	have the same values in the same order.
	 * @return
	 */
	public boolean equals(Sequence b){
		return Arrays.equals(this.values, b.values);
	}
	
	/**
	 * This method checks whether two sequence
	 * objects have the same values in some order, ignoring duplicates. For example, the two sequences 1
	 * 4 9 16 9 7 4 9 11 and 11 11 7 9 16 4 1 would be considered identical.
	 * @return
	 */
	public boolean sameValue(Sequence b){
		int checkDublicate = 0;
		for (int i = 0; i < this.values.length; i++){
			for (int j = 0; j < b.values.length; j++){	
				if(this.values[i] == b.values[j]){
					checkDublicate++;
					break;
				}
			}
		}
		if (checkDublicate == this.values.length){
			return true;
		}
		return false;
	}
	/**
	 * This method checks whether two
	 * sequence objects have the same values in some order, with the same multiplicities. For example, the
	 * sequences 1 4 9 16 9 7 4 9 11 is a permutation of 11 1 4 9 16 9 7 4 9, but 1 4
	 * 9 16 9 7 4 9 11 is not a permutation of 11 11 7 9 16 4 1 4 9
	 * @return
	 */
	public boolean isPermutationof(Sequence b){
		int[] sortedValuesA = this.values;
		int[] sortedValuesB = b.values;
		
		Arrays.sort(sortedValuesA);
		Arrays.sort(sortedValuesB);
		
		return Arrays.equals(sortedValuesA, sortedValuesB);	
	}
	/**
	 * This method returns a string with the sequence values, separated by
	 * commas (Hint: check the Arrays class).
	 */
	public String toString(){
		int[] valuesAsString = this.values;
		String result = Arrays.toString(valuesAsString);
		result = result.replace("[", "");
		result = result.replace("]", "");
		return result;
	}
}
