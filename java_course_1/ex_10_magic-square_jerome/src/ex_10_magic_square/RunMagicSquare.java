package ex_10_magic_square;

import java.util.*;

public class RunMagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s = null;
		int n = 0;
		
		do {
			System.out.println("Enter an odd integer:");
			s = in.nextLine();
			if(!s.equals("")) n = Integer.parseInt(s);
		} while (n % 2 == 0);
		in.close();
		
		MagicSquare square = new MagicSquare(n);
		System.out.println(square.arraytoString());
	}

}
