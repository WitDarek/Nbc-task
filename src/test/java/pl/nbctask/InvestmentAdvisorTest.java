package pl.nbctask;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pl.nbctask.enums.InvestmentStyle;
import pl.nbctask.exceptions.UnsupportedStyleException;
import pl.nbctask.model.InvestmentFund;

/**
 *
 * @author plewandowski
 */
public class InvestmentAdvisorTest {

    public InvestmentAdvisorTest() {
    }

    @Test(expected = UnsupportedStyleException.class)
    public void calculateInvestment_ShouldThrowExceptionIfStyleIsUnsupported() throws Exception {
        List<InvestmentFund> investmentFunds = new ArrayList<>();

        InvestmentAdvisor.calculateInvestment(10000, investmentFunds, InvestmentStyle.DUMMY);
    }

}
