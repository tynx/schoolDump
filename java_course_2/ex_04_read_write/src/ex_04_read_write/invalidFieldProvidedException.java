package ex_04_read_write;

/**
 * This class is an exception for the class Bank, which reads a file. This
 * exception is thrown if an invalid field is provided.
 * 
 * @author tim luginbuehl (lugtim@gmail.com // tynx.ch)
 * @author jerome jamin (jerome.jamin@gmail.com)
 */
public class invalidFieldProvidedException extends Exception{

	/**
	 * To supress warnings, not used at this point.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Just overrite the super constructor and call it
	 */
	public invalidFieldProvidedException(){
		super();
	}

	/**
	 * Just everrite the super constructor and call it
	 * @param message the error message
	 */
	public invalidFieldProvidedException(String message){
		super(message);
	}
}
