package pl.nbctask.investments;

import pl.nbctask.model.InvestmentFund;
import pl.nbctask.model.Report;
import pl.nbctask.enums.FundType;
import pl.nbctask.investments.SafeInvestment;
import pl.nbctask.investments.Investment;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static junit.framework.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Test;
import pl.nbctask.exceptions.MandatoryFundInvestmentException;

/**
 *
 * @author plewandowski
 */
public class SafeInvestmentTest {

    public SafeInvestmentTest() {
    }

    @Test
    public void getPercentage_ShouldReturnValuesWhichSumIsEqualTo100() {
        Investment investment = new SafeInvestment();

        int result = investment.getPercentages().values().stream().mapToInt(e -> e).sum();
        int expected = 100;

        assertEquals(expected, result);
    }

    @Test
    @Ignore
    public void testCalculate() throws MandatoryFundInvestmentException {

        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
//        InvestmentFund polish3 = new InvestmentFund(7L, "Fundusz polski 3", FundType.POLISH);

        InvestmentFund foregin1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);
        InvestmentFund foregin2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foregin3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);

        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);

        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, foregin1, foregin2, foregin3, monetary1).collect(Collectors.toList());

        Investment safeInvestment = new SafeInvestment();
        Report report = safeInvestment.calculate(10001, investmentFunds);

        System.out.println(report);
    }

}
