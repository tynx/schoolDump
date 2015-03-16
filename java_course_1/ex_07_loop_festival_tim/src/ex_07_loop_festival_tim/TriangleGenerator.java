package ex_07_loop_festival_tim;

/**
 * This class generates all the triangles where the hypothenus is smaller than
 * the given number.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class TriangleGenerator {
	
	/**
	 * The number we don't want to overdraw
	 */
	private int number = 0;
	
	/**
	 * Constructor which just saves the number.
	 * @param number the number which should not be overdrawn
	 */
	public TriangleGenerator(int number){
		this.number = number;
	}

	private boolean isInt(double value){
		if((value == Math.floor(value)) && !Double.isInfinite(value))
			return true;
		return false;
	}
	
	/**
	 * Easy hypothenus calculation:
	 * h = sqrt(a^2+b^2) => for this calculations we round up the result
	 * @param a first length of the triangle
	 * @param b second length of the triangle
	 * @return the third length of the triangle rounded
	 */
	private double calcHypothenus(int a, int b){
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	/**
	 * We try each combination and look if the third length (hypothenus) is
	 * smaller than the given number. if so we return the combo, if not
	 * we ignore it.
	 * @return A string with all the valid combos
	 */
	public String getPythagorean(){
		boolean moreResults = true;
		String result = "{";
		int i=1, j=1;
		while(moreResults){
			if(calcHypothenus(i, j) <= this.number){
				if(this.isInt(calcHypothenus(i,j)))
					result += "(" + i + "," + j + "),";
				j++;
			}else if(j!=1){
				j=1;
				i++;
			}else{
				moreResults=false;
			}
		}
		return result + "}";
	}
}
