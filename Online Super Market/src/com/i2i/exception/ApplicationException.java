/**
 * 
 */
package com.i2i.exception;

/**
 * <h1> Application Exception </h1>
 * <p> Contains User Defined Exception by extending Exception class.
 * @author Mukilan.K
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * <p> This is a empty constructor.</p>
	 */
	public ApplicationException() {
    }
    
	/**
	 * <p> This is parameterized constructor.</p>
	 * @param message It holds the message.
	 */
    public ApplicationException(String message) {
        super(message);
    }
    
	/**
	 * <p> This is parameterized constructor.</p>
	 * @param cause It holds the cause.
	 */
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    
    /**
     * <p> This is parameterized constructor.</p>
     * @param message It holds message.
     * @param cause It holds cause.
     */
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
