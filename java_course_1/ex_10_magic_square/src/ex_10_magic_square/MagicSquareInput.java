package ex_10_magic_square;

import java.util.Scanner;

/**
 * This class asks the user for the size of the magic square and
 * prints out the result as String
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class MagicSquareInput {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = null;
		boolean running = true;
		while(running){
			System.out.print("Enter an odd integer: ");
			s = in.nextLine();

			if(s.equals("0") || s.equals("")){
				running = false;
			}else{
				int n = Integer.parseInt(s);
				if(n % 2 == 0){
					System.out.println("ODD INTEGER!");
				}else{
					MagicSquare ms = new MagicSquare(n);
					System.out.println(ms.toString());
				}
			}
		}
		in.close();
	}
}
