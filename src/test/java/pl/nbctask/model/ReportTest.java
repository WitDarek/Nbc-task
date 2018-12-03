package pl.nbctask.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import pl.nbctask.enums.FundType;

/**
 *
 * @author pawlewan
 */
public class ReportTest {

    public ReportTest() {
    }

    @Test
    public void reportsShouldBeEqualIrrevelantToTheOrderOfReportRows() {
        InvestmentFund polish1 = new InvestmentFund(1L, "Fundusz polski 1", FundType.POLISH);
        InvestmentFund polish2 = new InvestmentFund(2L, "Fundusz polski 2", FundType.POLISH);

        List<InvestmentFund> investmentFunds = Stream.of(polish1, polish2).collect(Collectors.toList());

        Report report = new Report();
        report.addReportRow(new ReportRow(polish1, 20));
        report.addReportRow(new ReportRow(polish2, 20));

        Report reportWithDifferentOrder = new Report();
        reportWithDifferentOrder.addReportRow(new ReportRow(polish2, 20));
        reportWithDifferentOrder.addReportRow(new ReportRow(polish1, 20));
        
       
        Assert.assertEquals(report, reportWithDifferentOrder);
    }

}
