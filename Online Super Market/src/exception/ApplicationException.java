/**
 * 
 */
package exception;

/**
 * <p> Contains User Defined Exception by extending Exception class.
 * @author Mukilan.K
 *
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException() {
        
    }
    
    public ApplicationException(String message) {
        super(message);
    }
    
    public ApplicationException(Throwable cause) {
        super(cause);
    }
    
    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
