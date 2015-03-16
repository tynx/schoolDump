package ex_6_crawler;

import java.util.ArrayList;

/**
 * This class is the entry-point of the crawler. It contains the output-object
 * which all site-objects refer to, to save their gathered data. It contains
 * all the settings for the other classes. It start the recursion. Also
 * it holds an list of all processed links, so a site is not processed twice.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Crawler {

	/**
	 * The root directory, where all the files should be stored
	 */
	public static final String DATA_DIRECTORY = "/tmp/data/";

	/**
	 * The name of the file, the according links should be stored in
	 */
	public static final String LINK_FILENAME = "links.txt";

	/**
	 * The root url to start with
	 */
	public static final String ROOT_URL = "http://www.ti.bfh.ch/informatik";

	/**
	 * Blocked domains, we don't want to process any site, which is from one of
	 * these hosters.
	 */
	public static final String[] BLOCKED_DOMAINS = {"youtube.com", "twitter.com", "facebook.com", "google.com", "adobe.com", "bit.ly"};

	/**
	 * The regex used to parse the links. (a hrefs), see linkParser
	 */
	public static final String A_TAG_REGEX = "(<a\\shref=[\\'\\\"]*((?:http:\\/\\/|https:\\/\\/)+[^\\'\\\"\\s]*).*?>).*?<\\/a>";

	/**
	 * The amount of allowed recursion before quitting.
	 */
	public static final int RECURSION_LIMIT = 2;

	/**
	 * All the processed links are stored in here
	 */
	private static ArrayList<String> processedLinks = new ArrayList<String>();

	/**
	 * The output object, which can be accessed by all the sites.
	 */
	public static Output out = new Output();

	/**
	 * The entry point of the program. Starts the recursion.
	 * @param args IGNORED!
	 */
	public static void main(String[] args) {
		new Site(Crawler.ROOT_URL);
	}

	/**
	 * Adds a link to the list of processed links.
	 * @param link the link to add
	 */
	public static void addProcessedLink(String link){
		Crawler.processedLinks.add(link);
	}

	/**
	 * Determines if a link was already being processed or not
	 * @param link the link to check
	 * @return true if the link has been processed
	 */
	public static boolean isProcessedLink(String link){
		boolean processed = false;
		for(String processedLink : Crawler.processedLinks)
			if(processedLink.equals(link))
				processed = true;
		return processed;
	}

	/**
	 * Determines if a link is blocked by the given settings.
	 * @param link the link to check
	 * @return true if the link has been blocked
	 */
	public static boolean isBlockedLink(String link){
		boolean blocked = false;
		int i=0;
		for(i=0; i<Crawler.BLOCKED_DOMAINS.length; i++){
			if(link.indexOf(Crawler.BLOCKED_DOMAINS[i]) != -1)
				blocked = true;
		}
		return blocked;
	}
}
