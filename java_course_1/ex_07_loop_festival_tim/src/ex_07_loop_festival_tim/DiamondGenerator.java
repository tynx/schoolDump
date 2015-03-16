package ex_07_loop_festival_tim;

/**
 * This class generates a diamond in ASCII-Art. It's size is defined be the
 * length of its side. basically it's a square but rotated by 45°. 
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class DiamondGenerator {

	/**
	 * The length of one side of the square
	 */
	private int size = 0;

	/**
	 * The maximum chars which are used for the filling on one line
	 */
	private String maxFilling = "";
	/**
	 * The maximum chars which are used for the background on one line (half of it)
	 */
	private String maxBackground = "";

	/**
	 * The construct is for setting up the diamond. But it's calculated only
	 * if the method "getDiamond()" is called.
	 * @param size the lenght of a side
	 * @param background with what characters the square should be filled
	 * @param filling with what characters the background should be filled
	 */
	public DiamondGenerator(int size, String background, String filling){
		// not possible to draw
		if(size < 1)
			return;
		this.size = size;
		this.maxFilling = this.fillChar(2*this.size-1, filling);
		this.maxBackground = this.fillChar(this.size-1, background);
	}

	/**
	 * This function returns a String which has the length of "amount" and is
	 * contains the character repeated in it. The last unit of the String
	 * character may be cut as the length could be overdrawn.
	 * @param amount How many single characters
	 * @param character What to repeat
	 * @return The repeated string with the right length
	 */
	private String fillChar(int amount, String character){
		String filled = "";
		int i=0;
		int numberCharacters = (int) Math.ceil(amount/(double)character.length());
		for(i=0; i<numberCharacters; i++)
			filled+=character;

		return filled.substring(0, amount);
	}

	/**
	 * Constructs the line corresponding to the line. It first fills with
	 * background, then with the filling and ends again with the background.
	 * Also a newline is added.
	 * @param line for which line-number the string should be constructed
	 * @return The line ready for printing
	 */
	private String getLine(int line){
		String stringLine = this.maxBackground.substring(line);
		stringLine += this.maxFilling.substring(0, line*2+1);
		stringLine += this.maxBackground.substring(line) + "\n";
		return stringLine;
	}

	/**
	 * Constructs the final diamond. it does so, by getting each line from
	 * "getLine()". Also we start in the middle and work our way to the top and
	 * bottom at the same time. As it is mirrored.
	 * @return The diamond ready for print.
	 */
	public String getDiamond(){
		if(this.size == 0)
			return "";
		int line=0;
		String diamond = this.maxFilling + "\n";
		for(line=size-2; line>=0; line--){
			diamond = getLine(line) + diamond + getLine(line);
		}
		return diamond;
	}

}