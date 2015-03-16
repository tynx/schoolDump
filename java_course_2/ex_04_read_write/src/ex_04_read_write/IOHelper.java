package ex_04_read_write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * This class helps to read and write the files for the programm. This reduces
 * the amount of coded needed in Bank drastically.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class IOHelper {

	/**
	 * This function reads out the whole file provided and returns the content
	 * a string,
	 * @param filename the file to read
	 * @return the content of the file
	 */
	public String getContents(String filename){
		StringBuilder dataBuilder = new StringBuilder();
		File file = new File(filename);
		try{
			 Scanner scanner = new Scanner(file);
			 while (scanner.hasNextLine()) {
				dataBuilder.append(scanner.nextLine() + "\n");
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return dataBuilder.toString();
	}

	/**
	 * This funciton sets the content of a file. it does not append, but
	 * overwrittes all the previous content.
	 * @param filename the file to write to
	 * @param data the data to write into the file
	 */
	public void setContents(String filename, String data){
		try {
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.print(data);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
