package ex_08_sequence_tim;

import java.util.Arrays;


/**
 * This class provide the possibility to add new elements to an
 * given array and to compere two arrays in diffrent ways
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 *
 */
public class Sequence {
	private int valueSize = 0;
	private int[] values;
	
	/**
	 * This constructor allows to determines the size of the array
	 * @param size
	 */
	public Sequence(int size){
		this.values = new int[size];
	}
	
	/**
	 * This constructor delivers to the class an array of integer values
	 * @param values
	 */
	public Sequence(int[] values){
		this.values = values;
		this.valueSize = this.getSize();
	}

	/**
	 * This method stores into the array the value val at position
	 *	pos. If the array is not large enough, you must increase its
	 *  size (e.g. by doubling its length)
	 * @param pos
	 * @param value
	 */

	/**
	 * This methode return the size of the array
	 * @return the length of the array
	 */
	public int getSize(){
		return this.values.length;
	}
	
	/**
	 * this methode returns the element with the given 
	 * position in the array
	 * @param position
	 * @return the element with the given position
	 */
	public int get(int position){
		if(position<this.getSize() && position > -1)
			return values[position];
		return Integer.MIN_VALUE;
	}
	/**
	 * This methode set a given value on a given position
	 * @param position
	 * @param value
	 * @return 
	 */
	public void set(int pos, int value){
		int posDiff = Math.abs(this.valueSize - pos);
		//Check if the array is large enough, if not it's doubling the length
		if (pos > this.getSize() || this.valueSize == this.getSize()){
			this.values = Arrays.copyOf(this.values, 2*this.values.length);
		}
						
		if (this.valueSize < this.getSize()) {
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
	}
	/**
	 * This method checks whether two sequence objects
	 *	have the same values in the same order.
	 *  @param Object Sequence
	 * @return
	 */
	public boolean equals(Sequence other){
		int i=0;
		if(this.getSize() != other.getSize())
			return false;
		for(i=0; i<this.getSize(); i++){
			if(this.get(i) != other.get(i))
				return false;
		}
		return true;
	}
	/**
	 * This method checks whether two sequence
	 * objects have the same values in some order.
	 * @param Object Sequence
	 * @return boolean
	 */
	public boolean sameValues(Sequence other){
		boolean found = false;
		int i=0, j=0;
		for(i=0; i<this.getSize(); i++){
			found = false;
			for(j=0; j<other.getSize(); j++){
				if(this.get(i) == other.get(j)){
					found = true;
					break;
				}
			}
			if(!found)
				return false;
		}
		return true;
	}
	
	/**
	 *  This method checks whether two sequence objects
	 *  have the same values in some order, with the same multiplicities.
	 * @param Object Sequence
	 * @return boolean
	 */
	public boolean isPermutationOf(Sequence other){
		boolean[] usedPositions = new boolean[this.getSize()];
		boolean found = false;
		int i=0, j=0;
		
		for(i=0; i<this.getSize(); i++){
			found = false;
			for(j=0; j<other.getSize(); j++){
				if(usedPositions[i] == false && this.get(i) == other.get(j)){
					usedPositions[i] = true;
					found = true;
					break;
				}
			}
			if(!found)
				return false;
		}
		return true;
	}
	/**
	 * This methode store the elements of the Array into a String 
	 * @return the values of the array seperated by ","
	 */
	public String toString(){
		String asString = "";
		int i=0;
		for(i=0; i<this.getSize(); i++){
			if(i != 0)
				asString += ", ";
			asString += "" +this.get(i);
		}
		return asString;
	}
}
