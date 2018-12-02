package pl.nbctask.exceptions;

/**
 *
 * @author plewandowski
 */
public class MandatoryFundInvestmentException extends Exception {

    /**
     * Creates a new instance of <code>MandatoryFundInvestmentException</code>
     * without detail message.
     */
    public MandatoryFundInvestmentException() {
    }

    /**
     * Constructs an instance of <code>MandatoryFundInvestmentException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MandatoryFundInvestmentException(String msg) {
        super(msg);
    }
}
