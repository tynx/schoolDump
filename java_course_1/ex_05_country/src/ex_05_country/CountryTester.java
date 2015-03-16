/**
 * 
 */
package ex_05_country;

/**
 * @author tim
 *
 */
public class CountryTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Country country = new Country("France");
			
			System.out.println(country.getArticle());
			System.out.println(country.getCountryFormatted());
	}

}
