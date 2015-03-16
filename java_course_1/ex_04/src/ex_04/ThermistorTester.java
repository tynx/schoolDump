package ex_04;

/**
 * This class tests the Thermistor class. It has 2 testcases. One with somewhat
 * small values and one with somewhat high values. It always tests both scalas
 * (Celcius / Kelvin).
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class ThermistorTester {

	/**
	 * This is testcase number 1, which is testing somewhat low values.
	 */
	public static void testCase1(){
		double[] resistances = {10.0, 12.3, 192.4, -145.3};
		double[] results = {-178.68739549486935,-179.15052698142034,-184.898261427349, -1000.0};
		double[] results_k = {94.46260450513061,93.99947301857964,88.25173857265096, -1000.0};
		int i=0;
		
		Thermistor t = new Thermistor(1075,85,3969);
		
		for(i=0; i<resistances.length; i++){
			System.out.print("(Celcius) Expected: " + results[i] + "\tResult: ");
			System.out.println(t.getTemparaturFromResistanceAsCelcius(resistances[i]));
			System.out.print("(Kelvin)  Expected: " + results_k[i] + "\tResult: ");
			System.out.println(t.getTemparaturFromResistance(resistances[i]));
		}
	}

	/**
	 * This is testcase number 2, which is testing somewhat high values.
	 */
	public static void testCase2(){
		double[] resistances = {10.0, 12.3, 192.4, -145.3};
		double[] results = {99.44907339927045,95.97352275535127,55.27763086672314, -1000.0};
		double[] results_k = {372.5990733992704,369.12352275535125,328.4276308667231, -1000.0};
		int i=0;
		
		Thermistor t = new Thermistor(2045,300,8192);
		
		for(i=0; i<resistances.length; i++){
			System.out.print("(Celcius) Expected: " + results[i] + "\tResult: ");
			System.out.println(t.getTemparaturFromResistanceAsCelcius(resistances[i]));
			System.out.print("(Kelvin)  Expected: " + results_k[i] + "\tResult: ");
			System.out.println(t.getTemparaturFromResistance(resistances[i]));
		}
	}
	
	/**
	 * This function is the entry-point and just runs both test-cases.
	 * @param args not processed at this point
	 */
	public static void main(String[] args) {
		testCase1();
		System.out.println("\n");
		testCase2();
	}

}
