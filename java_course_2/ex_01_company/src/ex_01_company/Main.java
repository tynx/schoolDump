package ex_01_company;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * This class is for creating some random employees and print out their 
 * information. For every type there are two rounds.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Main {

	/**
	 * This function does with the help of the other methods in this class
	 * test the different kind of employees.
	 * @param args IGNORED!
	 */
	public static void main(String[] args) {
		Company c = new Company(new Random().nextInt(8000000)+1000000, 160);
		Random r = new Random();
		ArrayList<AbstractEmployee> employees = new ArrayList<AbstractEmployee>();
		
		employees.add(new Manager(randomName(), randomDate(), c));
		employees.add(new Manager(randomName(), randomDate(), c));
		employees.add(new Vendor(randomName(), randomDate(), r.nextInt(20)));
		employees.add(new Vendor(randomName(), randomDate(), r.nextInt(20)));
		employees.add(new Trainee(randomName(), randomDate(), r.nextInt(20)));
		employees.add(new Trainee(randomName(), randomDate(), r.nextInt(20)));
		employees.add(new Administrator(randomName(), randomDate(), c, r.nextInt(40)));
		employees.add(new Administrator(randomName(), randomDate(), c, r.nextInt(40)));
		employees.add(new Technician(randomName(), randomDate()));
		employees.add(new Technician(randomName(), randomDate()));
		int i=0;
		for(i=0; i<employees.size(); i++){
			printEmployee(employees.get(i));
		}
	}

	/**
	 * Returns a random name containing a first name and a lastname.
	 * @return a random name
	 */
	public static String randomName(){
		String[] lastNames = {
				"Nydegger",
				"Jamin",
				"Luginbühl",
				"Müller",
				"Meyer",
				"Schäfer",
				"Hofer"
			};
		String[] firstNames = {
				"Christian",
				"Jerome",
				"Tim",
				"Lukas",
				"Adrian",
				"Pascal",
				"Nicola"
			};
		Random r = new Random();
		return firstNames[r.nextInt(firstNames.length)] + " " + lastNames[r.nextInt(lastNames.length)];
	}

	/**
	 * Returns a date within the range 1990-2013.
	 * @return
	 */
	public static Calendar randomDate(){
		Calendar c = Calendar.getInstance();
		Random r = new Random();
		c.set(r.nextInt(23) + 1990, r.nextInt(12), r.nextInt(30));
		return c;
	}

	/**
	 * This function prints the employee in a nice ascii table.
	 * @param e the employee to print
	 */
	public static void printEmployee(AbstractEmployee e){
		int width=41;
		StringBuilder line = new StringBuilder();
		int i=0;
		line.append("+");
		for(i=0; i<width; i++){
			line.append("-");
		}
		line.append("+\n");
		StringBuilder output = new StringBuilder();
		output.append(line.toString());
		output.append("| ");
		output.append(e.getDisplayName());
		for(i=e.getDisplayName().length()+1; i<width; i++){
			output.append(" ");
		}
		output.append("|\n");
		output.append(line.toString());

		SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");

		output.append("| Date entry:        | ");
		output.append(format1.format(e.getEntryDate().getTime()));
		output.append("         |\n");
		output.append("| Time in Company:   | ");
		DecimalFormat df = new DecimalFormat( "00" );
		output.append(df.format(e.timeInCompany()/12) + " Years ");
		output.append(df.format(e.timeInCompany()%12) + " Months |\n");
		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
		output.append("| Salary:            | ");
		output.append(df2.format(e.getSalary()));
		for(i=df2.format(e.getSalary()).length()+2; i<width/2; i++){
			output.append(" ");
		}
		output.append(" |\n");
		
		output.append(line);
		System.out.print(output.toString());
	}
}
