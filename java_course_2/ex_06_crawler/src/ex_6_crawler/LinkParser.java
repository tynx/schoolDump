package ex_6_crawler;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This class is for handling the parsing part of a site. it should be extended
 * by other classes. it is no functional otherwise, as there is now way
 * to modify the content from outside.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class LinkParser {

	/**
	 * All the parsed links are stored in here
	 */
	private ArrayList<String> parsedLinks = new ArrayList<String>();

	/**
	 * All the parsed HTML-Tags are stored in here.
	 */
	private ArrayList<String> parsedTags = new ArrayList<String>();

	/**
	 * The content which should be parsed is stored in here
	 */
	protected String content = null;

	/**
	 * This function parses the content given internally. The results are
	 * saved in the lists (parsedLinks and parsedTags).
	 */
	protected void parseContent(){
		Pattern hrefPattern = Pattern.compile(Crawler.A_TAG_REGEX);
		Matcher tagmatch = hrefPattern.matcher(this.content);
		while (tagmatch.find()) {
			if(tagmatch.groupCount() == 2){
				this.parsedTags.add(tagmatch.group(1));
				this.parsedLinks.add(tagmatch.group(2));
			}
		}
	}

	/**
	 * Returns the list of parsed links
	 * @return the list of links
	 */
	protected ArrayList<String> getLinks(){
		return this.parsedLinks;
	}

	/**
	 * Returns the list of parsed HTML-Tags
	 * @return the list of tags
	 */
	protected ArrayList<String> getTags(){
		return this.parsedTags;
	}
}
