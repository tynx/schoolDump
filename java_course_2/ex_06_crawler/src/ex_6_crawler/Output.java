package ex_6_crawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is for handling the output in the format requested by the BFH
 * for the web-crawler. It is structure which basically replaces filenames with
 * folders. Also we need the open/close/reopen files quite a lot. This class
 * provides an easy way of handling fileWriters. The function:
 * setCurrentOutputPath handles everything needed.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Output {

	/**
	 * The current filewriter. As soon as something shoudld be written, its
	 * written to this filewriter.
	 */
	private FileWriter fw = null;

	/**
	 * The constructor just makes sure the root-directory is existing by 
	 * creating it, in case it doesnt exist.
	 */
	public Output(){
		this.createDirectory(Crawler.DATA_DIRECTORY);
	}

	/**
	 * Sets the currentOutputPath, meaning that internally the fileWriter
	 * is adapted.
	 * @param path the new location to write to.
	 * @throws IOException if something went wrong with the file-management
	 */
	public void setCurrentOutputPath(String path) throws IOException{
		if(fw != null)
			fw.close();
		this.createDirectory(Crawler.DATA_DIRECTORY + path);
		File file = new File(Crawler.DATA_DIRECTORY + path + "/" + Crawler.LINK_FILENAME);
		if (!file.exists())
			file.createNewFile();
		this.fw = new FileWriter(file, true);
	}

	/**
	 * This function appends a single line to a file. based on the indationLevel
	 * it adds tabs to create indation.
	 * @param line the data which should be written
	 * @param indationLevel the indation for the given data
	 * @throws IOException if writing failed
	 */
	public void appendLine(String line, int indationLevel) throws IOException{
		String indation = this.repeatChar('\t', indationLevel);
		if(this.fw != null)
			this.fw.write(indation + line + "\n");
	}

	/**
	 * This function appends a header line to a file. Meaning that the header
	 * given is underlined in ascii-art.
	 * @param header the header to write
	 * @param indationLevel the indation-level
	 * @throws IOException if writing failed
	 */
	public void appendHeader(String header, int indationLevel) throws IOException{
		this.appendLine(header, indationLevel);
		this.appendLine(this.repeatChar('=', header.length()), indationLevel);
	}

	/**
	 * This method appends a total-line, meaning that it adds the "total"
	 * writing in front of given toal.
	 * @param total the total
	 * @param indationLevel the indation level
	 * @throws IOException if writing failed
	 */
	public void appendTotal(int total, int indationLevel) throws IOException{
		this.appendLine("Total links: " + total, indationLevel);
	}

	/**
	 * This method repeats a character and builds a string based on how many
	 * times the character should be repeated.
	 * @param ch the character to repeat
	 * @param amount the amount of times the character should be repeated
	 * @return the repeated character as string
	 */
	private String repeatChar(char ch, int amount){
		StringBuilder result = new StringBuilder();
		int i=0;
		for(i=0; i<amount; i++)
			result.append(ch);
		return result.toString();
	}

	/**
	 * This method creates a directory for given path. If the directory already
	 * exists, it will do nothing.
	 * @param path the directory to create
	 */
	private void createDirectory(String path){
		File dir = new File(path);
		if (!(dir.exists() && dir.isDirectory())){
			System.out.println("Trying to create directory \"" + path + "\".");
			dir.mkdir();
		}
	}
}
