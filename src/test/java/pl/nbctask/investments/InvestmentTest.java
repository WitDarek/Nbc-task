package pl.nbctask.investments;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.nbctask.enums.FundType;
import pl.nbctask.exceptions.MandatoryFundInvestmentException;
import pl.nbctask.investments.mocks.DividedInvestment;
import pl.nbctask.investments.mocks.SingleInvestment;
import pl.nbctask.model.InvestmentFund;

/**
 *
 * @author plewandowski
 */
public class InvestmentTest {

    public InvestmentTest() {
    }

    @Test(expected = MandatoryFundInvestmentException.class)
    public void calculate_ShouldThrowExceptionWhenLessInvestmentFundsIsGivenThanDefiniedInPercentageDivision()
            throws MandatoryFundInvestmentException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);

        List<InvestmentFund> investmentFunds = Stream.of(polish1).collect(Collectors.toList());

        Investment investment = new DividedInvestment();

        investment.calculate(10, investmentFunds);
    }

    @Test(expected = MandatoryFundInvestmentException.class)
    public void calculate_ShouldThrowExceptionWhenMoreInvestmentFundsIsGivenThanDefiniedInPercentageDivision() 
            throws MandatoryFundInvestmentException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund foregin1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);

        List<InvestmentFund> investmentFunds = Stream.of(polish1, foregin1).collect(Collectors.toList());

        Investment investment = new SingleInvestment();

        investment.calculate(10, investmentFunds);
    }

}
