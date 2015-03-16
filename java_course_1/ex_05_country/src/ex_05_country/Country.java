/**
 * 
 */
package ex_05_country;

/**
 * This class analyse the type of article (le, la, l', les) from a country name in French with the help 
 * of the last char from the country name. The class notice the countries with a special last char.
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Country {
	
	/**
	 * This is the current country name as String
	 */
	private String countryName = "";
	
	private String article = null;
	
	/**
	 * This are countries with the article "male" while they have a female ending stored in a final String Array
	 */
	private final String[] exceptionsCountriesMale = {
			"Belize",
			"Cambodge",
			"Mexique",
			"Mozambique",
			"Zaire",
			"Zimbabwe"
		};
	
	/**
	 * This are countrie which are singular but with an plural ending stored in a final String Array
	 */
	private final String[] exceptionsCountriesPlural = {
			"Laos",
			"Honduras"
		};
	
	/**
	 * This are all vocals stored in a final Charakter Array
	 */
	private final char[] vocals = {'a', 'e', 'é', 'i', 'î', 'o', 'u', 'y'};
	
	/**
	 * The constructor takes the country name and store it internally
	 * @param countryName 
	 */
	public Country(String countryName) {
		this.countryName = countryName.toLowerCase();
	}

	private boolean isException(){
		int i = 0;
		for(i=0; i<this.exceptionsCountriesMale.length; i++){
			if (this.countryName.equals(this.exceptionsCountriesMale[i])) 
				return true;
		}
		
		for (i=0; i<this.exceptionsCountriesPlural.length; i++) {
			if (this.countryName.equals(this.exceptionsCountriesPlural[i]))
				return true;
		}

		return false;
	}
	
	/**
	 * This function analyse the article of the country name with the help of the last char.
	 * The function tests on the endings 'e' and 's' and compare the result with the special
	 * endings.
	 * @return the article of the country name
	 */
	public void setArticle() {
		int lastCharPosition = this.countryName.length()-1;
		
		if(this.isException())
			this.article = "le";
		
		for(int i = 0; i < this.vocals.length; i++) {
			if (this.countryName.indexOf(vocals[i]) == 0) {
				article = "l\'";
				return;
			}
		}
		
		if(this.countryName.indexOf('e') == lastCharPosition){
			this.article = "la";
		}else if (this.countryName.indexOf('s') == lastCharPosition) {
			this.article = "les";
		}else {
			this.article = "le";
		}
	}
	
	/**
	 * This function call the function checkArticle() to get the article and check the vocals with the
	 * function checkVocal, if the article is singular. 
	 * @return the countryName with the article
	 */
	public String getArticle() {		
		if(this.article == null)
			this.setArticle();
		return this.article;
	}
	
	public String getCountryFormatted(){
		String countryFormatted = this.article;
		if(!(this.article.indexOf('\'') == this.article.length()-1))
			countryFormatted += ' ';
		countryFormatted += this.countryName.substring(0, 1).toUpperCase();
		countryFormatted += this.countryName.substring(1);
		return countryFormatted;
		
		
	}
}
