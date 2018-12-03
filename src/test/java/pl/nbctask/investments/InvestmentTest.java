package pl.nbctask.investments;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pl.nbctask.enums.FundType;
import pl.nbctask.exceptions.InvestedAmountException;
import pl.nbctask.exceptions.MandatoryFundInvestmentException;
import pl.nbctask.investments.mocks.DividedInvestment;
import pl.nbctask.investments.mocks.DummyInvestment;
import pl.nbctask.investments.mocks.SingleInvestment;
import pl.nbctask.model.InvestmentFund;
import pl.nbctask.model.Report;
import pl.nbctask.model.ReportRow;

/**
 *
 * @author plewandowski
 */
public class InvestmentTest {

    public InvestmentTest() {
    }

    @Test(expected = MandatoryFundInvestmentException.class)
    public void calculate_ShouldThrowExceptionWhenLessInvestmentFundsIsGivenThanDefiniedInPercentageDivision()
            throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);

        List<InvestmentFund> investmentFunds = Stream.of(polish1).collect(Collectors.toList());

        Investment investment = new DividedInvestment();

        investment.calculate(10, investmentFunds);
    }

    @Test(expected = MandatoryFundInvestmentException.class)
    public void calculate_ShouldThrowExceptionWhenMoreInvestmentFundsIsGivenThanDefiniedInPercentageDivision()
            throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund foregin1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);

        List<InvestmentFund> investmentFunds = Stream.of(polish1, foregin1).collect(Collectors.toList());

        Investment investment = new SingleInvestment();

        investment.calculate(10, investmentFunds);
    }

    @Test
    public void calculate_ShouldNotInvestMoneyIfAmountIsTooLow() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
        InvestmentFund foregin1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);
        InvestmentFund foregin2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foregin3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);
        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);
        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, foregin1, foregin2, foregin3, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        for (InvestmentFund investmentFund : investmentFunds) {
            ReportRow reportRow = new ReportRow(investmentFund, 0, 0f);
            expected.addReportRow(reportRow);
        }
        expected.setUnnasignedAmount(1);

        Investment investment = new DummyInvestment();

        Report result = investment.calculate(1, investmentFunds);

        assertEquals(expected, result);
    }

    @Test(expected = InvestedAmountException.class)
    public void calculate_ShouldThrowExceptionIfAmountIsNotPositive() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
        InvestmentFund foregin1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);
        InvestmentFund foregin2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foregin3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);
        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);
        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, foregin1, foregin2, foregin3, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        for (InvestmentFund investmentFund : investmentFunds) {
            ReportRow reportRow = new ReportRow(investmentFund, 0, 0f);
            expected.addReportRow(reportRow);
        }
        expected.setUnnasignedAmount(0);

        Investment investment = new DummyInvestment();

        Report result = investment.calculate(-1, investmentFunds);

        assertEquals(expected, result);
    }

    @Test
    public void calculate_ShouldInvestCorrectly1() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
        InvestmentFund foreign1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);
        InvestmentFund foreign2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foreign3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);
        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);
        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, foreign1, foreign2, foreign3, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        expected.addReportRow(new ReportRow(polish1, 1000, 10.0f));
        expected.addReportRow(new ReportRow(polish2, 1000, 10.0f));
        expected.addReportRow(new ReportRow(foreign1, 2500, 25.0f));
        expected.addReportRow(new ReportRow(foreign2, 2500, 25.0f));
        expected.addReportRow(new ReportRow(foreign3, 2500, 25.0f));
        expected.addReportRow(new ReportRow(monetary1, 500, 5.0f));
        expected.setUnnasignedAmount(0);

        Investment investment = new DummyInvestment();

        Report result = investment.calculate(10000, investmentFunds);

        assertEquals(expected, result);
    }

    @Test
    public void calculate_ShouldInvestCorrectly2() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
        InvestmentFund foreign1 = new InvestmentFund(3L, "Fundusz zagraniczny 1", FundType.FOREIGN);
        InvestmentFund foreign2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foreign3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);
        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);
        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, foreign1, foreign2, foreign3, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        expected.addReportRow(new ReportRow(polish1, 1000, 10.0f));
        expected.addReportRow(new ReportRow(polish2, 1000, 10.0f));
        expected.addReportRow(new ReportRow(foreign1, 2500, 25.0f));
        expected.addReportRow(new ReportRow(foreign2, 2500, 25.0f));
        expected.addReportRow(new ReportRow(foreign3, 2500, 25.0f));
        expected.addReportRow(new ReportRow(monetary1, 500, 5.0f));
        expected.setUnnasignedAmount(1);

        Investment investment = new DummyInvestment();

        Report result = investment.calculate(10001, investmentFunds);

        assertEquals(expected, result);
    }

    @Test
    public void calculate_ShouldInvestCorrectly3() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);
        InvestmentFund polish3 = new InvestmentFund(3L, "Fundusz polski 3", FundType.POLISH);
        InvestmentFund foreign2 = new InvestmentFund(4L, "Fundusz zagraniczny 2", FundType.FOREIGN);
        InvestmentFund foreign3 = new InvestmentFund(5L, "Fundusz zagraniczny 3", FundType.FOREIGN);
        InvestmentFund monetary1 = new InvestmentFund(6L, "Fundusz pieniężny 1", FundType.MONETARY);
        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2, polish3, foreign2, foreign3, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        expected.addReportRow(new ReportRow(polish2, 666, 6.66f));
        expected.addReportRow(new ReportRow(polish1, 668, 6.68f));
        expected.addReportRow(new ReportRow(polish3, 666, 6.66f));
        expected.addReportRow(new ReportRow(foreign2, 3750, 37.5f));
        expected.addReportRow(new ReportRow(foreign3, 3750, 37.5f));
        expected.addReportRow(new ReportRow(monetary1, 500, 5.0f));
        expected.setUnnasignedAmount(0);

        Investment investment = new DummyInvestment();

        Report result = investment.calculate(10000, investmentFunds);

        assertEquals(expected, result);
    }

    @Test
    public void calculate_ShouldInvestCorrectly4() throws MandatoryFundInvestmentException, InvestedAmountException {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund monetary1 = new InvestmentFund(4L, "Fundusz monetarny 1", FundType.MONETARY);

        List<InvestmentFund> investmentFunds = Stream.of(polish1, monetary1).collect(Collectors.toList());

        Report expected = new Report();
        expected.addReportRow(new ReportRow(polish1, 5000, 50.0f));
        expected.addReportRow(new ReportRow(monetary1, 5000, 50.0f));

        expected.setUnnasignedAmount(0);

        Investment investment = new DividedInvestment();

        Report result = investment.calculate(10000, investmentFunds);

        assertEquals(expected, result);
    }
}
