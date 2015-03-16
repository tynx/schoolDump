package ex_6_crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is for processing a site. it downloads its content, parses it
 * and instanciates other site-object. with this recursion were crawling the
 * web.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Site extends LinkParser{

	/**
	 * All meta-data of the site stored in the url object.
	 */
	private URL url = null;

	/**
	 * The current level of recursion.
	 */
	private int recursionLevel = 0;

	/**
	 * This is the constructor used to start the crawling. It expects a link
	 * which basically represents the root-link.
	 * @param link the link to start on
	 */
	public Site(String link){
		this.initSite(link, 0);
	}

	/**
	 * The constructor which is normally only called by the class itself. It
	 * is used to control the recursion (break after a certain amount of
	 * recursion)
	 * @param link the link for the according page/site
	 * @param recursionLevel the current recursionLevel
	 */
	public Site(String link, int recursionLevel){
			this.initSite(link, recursionLevel);
	}

	private void initSite(String link, int recursionLevel){
		if(recursionLevel > Crawler.RECURSION_LIMIT)
			return;
		this.recursionLevel = recursionLevel;
		try {
			this.url = new URL(link);
			if(Crawler.isProcessedLink(this.url.toExternalForm()) ||
					Crawler.isBlockedLink(this.url.toExternalForm())){
				System.out.println("Following link has been ignored: " + link);
			}else{
				Crawler.addProcessedLink(this.url.toExternalForm());
				this.processSite();
				
			}
		} catch (MalformedURLException e) {
			System.err.println("Something went wrong while parsing link: " + link);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Something went wrong while processing Site: " + link);
			e.printStackTrace();
		}
	}

	/**
	 * This function processes a site. meaning it downloads the content of the
	 * given link via the internal url-object. after downloading the content
	 * is parsed for given "<a href>"s. For details see LinkParser.
	 * After downloading and parsing, all the a-s are saved in the according
	 * file, as well as the child-sites are created (recursion).
	 *
	 * @throws IOException If something goes wrong writing the gathered data
	 * into the files.
	 */
	private void processSite() throws IOException{
		this.downloadSite();
		this.parseContent();
		Crawler.out.setCurrentOutputPath(this.url.getHost());
		Crawler.out.appendHeader(this.url.toExternalForm(), this.recursionLevel);
		int i=0;
		for(i=0; i<this.getLinks().size(); i++){
			
		}
		for(String link : this.getLinks()){
			Crawler.out.setCurrentOutputPath(this.url.getHost());
			Crawler.out.appendLine(link, this.recursionLevel);
			new Site(link, this.recursionLevel+1);
		}
		Crawler.out.setCurrentOutputPath(this.url.getHost());
		Crawler.out.appendTotal(this.getLinks().size(), this.recursionLevel);
	}

	/**
	 * This method downloads a site/page based on the url-object of this class.
	 * The received data is stored in content, which is innherited by linkParser
	 * @throws IOException If the download goes wrong
	 */
	private void downloadSite() throws IOException{
		StringBuilder sb = new StringBuilder();
		InputStreamReader inputReader = new InputStreamReader(this.url.openStream());
		BufferedReader br = new BufferedReader(inputReader);
		String read =  br.readLine();
		while(read != null) {
			sb.append(read);
			read = br.readLine();
		}
		this.content = sb.toString();
	}
}
