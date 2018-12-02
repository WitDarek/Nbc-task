package pl.nbctask.exceptions;

/**
 *
 * @author plewandowski
 */
public class InvestedAmountException extends Exception {

    /**
     * Creates a new instance of <code>InvestedAmountException</code> without
     * detail message.
     */
    public InvestedAmountException() {
    }

    /**
     * Constructs an instance of <code>InvestedAmountException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InvestedAmountException(String msg) {
        super(msg);
    }
}
