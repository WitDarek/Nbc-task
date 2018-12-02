package pl.nbctask.model;

/**
 *
 * @author plewandowski
 */
public class ReportRow {

    private InvestmentFund investmentFund;
    private int amount;

    public ReportRow(InvestmentFund investmentFund, int amount) {
        this.investmentFund = investmentFund;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ReportRow{" + "investmentFund=" + investmentFund + ", amount=" + amount + '}';
    }

}
