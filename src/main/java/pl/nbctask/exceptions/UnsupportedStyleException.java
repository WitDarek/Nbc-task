package pl.nbctask.exceptions;

/**
 *
 * @author plewandowski
 */
public class UnsupportedStyleException extends Exception {

    /**
     * Creates a new instance of <code>UnsupportedStyleException</code> without
     * detail message.
     */
    public UnsupportedStyleException() {
    }

    /**
     * Constructs an instance of <code>UnsupportedStyleException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UnsupportedStyleException(String msg) {
        super(msg);
    }
}
