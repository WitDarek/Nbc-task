package pl.nbctask;

import pl.nbctask.model.InvestmentFund;
import pl.nbctask.model.Report;
import pl.nbctask.enums.InvestmentStyle;
import pl.nbctask.exceptions.UnsupportedStyleException;
import java.util.List;
import pl.nbctask.exceptions.InvestedAmountException;
import pl.nbctask.exceptions.MandatoryFundInvestmentException;
import pl.nbctask.investments.AggresiveInvestment;
import pl.nbctask.investments.BalancedInvestment;
import pl.nbctask.investments.Investment;
import pl.nbctask.investments.SafeInvestment;

/**
 *
 * @author plewandowski
 */
public abstract class InvestmentAdvisor {

    public static Report calculateInvestment(Integer amount,
            List<InvestmentFund> funds,
            InvestmentStyle style) throws UnsupportedStyleException, MandatoryFundInvestmentException, InvestedAmountException {

        Investment investment;

        switch (style) {
            case AGGRESIVE: {
                investment = new AggresiveInvestment();
                break;
            }
            case BALANCED: {
                investment = new BalancedInvestment();
                break;
            }
            case SAFE: {
                investment = new SafeInvestment();
                break;
            }
            default: {
                throw new UnsupportedStyleException(style + " is not supported");
            }
        }

        return investment.calculate(amount, funds);
    }
}
