package ex_04;

/**
 * This class helps calculating the temparature which a Thermistor measures.
 * At this point it only allows to calculate the temparature based on the given
 * resistance.
 * It supports both scalas (Celcius and Kelvin)
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class Thermistor {
	
	/**
	 * The offset which is used for converting the Kelvin to Celcius
	 */
	private double kelvinOffset = 273.15;
	
	/**
	 * The base resistance of the Thermistor
	 */
	private double baseResistance = 0.0;
	
	/**
	 * The base temparatur of the Thermistor
	 */
	private double baseTemparatur = 0.0;
	
	/**
	 * Based on the material the materialConstant
	 */
	private double materialConstant = 0.0;

	/**
	 * The constructor takes the Thermistor-specific properties and stores them
	 * internally.
	 * @param baseResistance the base resistance of the Thermistor
	 * @param baseTemparatur the base temparatur of the Thermistor
	 * @param materialConstant the material constant
	 */
	public Thermistor(double baseResistance, double baseTemparatur, double materialConstant){
		this.baseResistance = baseResistance;
		this.baseTemparatur = baseTemparatur;
		this.materialConstant = materialConstant;
		
	}

	/**
	 * This function returns the Temparatur based on the given resistance. If
	 * the given resistance leads to a value which is "NaN" this functions
	 * returns -1000.0. As this is a invalid value you have to check for it.
	 * @param currentResistance the resistance measured by the Thermistor
	 * @return The temparature as Kelvin
	 */
	public double getTemparaturFromResistance(double currentResistance){
		if((currentResistance/this.baseResistance) < 0.0)
			return -1000.0;
		double ln = Math.log(currentResistance/this.baseResistance);
		double top = this.baseTemparatur * this.materialConstant;
		double bottom = this.baseTemparatur * ln + this.materialConstant;
		return top/bottom;
	}

	/**
	 * This function returns the Temparatur based on the given resistance. If
	 * the given resistance leads to a value which is "NaN" this functions
	 * returns -1000.0. As this is a invalid value you have to check for it. 
	 * @param currentResistance the resistance measured by the Thermistor
	 * @return The temparature as Celcius
	 */
	public double getTemparaturFromResistanceAsCelcius(double currentResistance){
		if(this.getTemparaturFromResistance(currentResistance) == -1000.0)
			return -1000.0;
		return this.getTemparaturFromResistance(currentResistance)-this.kelvinOffset;
	}
}
