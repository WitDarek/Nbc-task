package pl.nbctask.model;

import java.util.Objects;

/**
 *
 * @author plewandowski
 */
public class ReportRow {

    private InvestmentFund investmentFund;
    private int amount;
    private float percentage;

    public ReportRow(InvestmentFund investmentFund, int amount) {
        this.investmentFund = investmentFund;
        this.amount = amount;
    }

    public ReportRow(InvestmentFund investmentFund, int amount, float percentage) {
        this.investmentFund = investmentFund;
        this.amount = amount;
        this.percentage = percentage;
    }

    public int getAmount() {
        return amount;
    }

    public InvestmentFund getInvestmentFund() {
        return investmentFund;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "ReportRow{" + "investmentFund=" + investmentFund + ", amount=" + amount + ", percentage=" + percentage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.investmentFund);
        hash = 53 * hash + this.amount;
        hash = 53 * hash + Float.floatToIntBits(this.percentage);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportRow other = (ReportRow) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if (Float.floatToIntBits(this.percentage) != Float.floatToIntBits(other.percentage)) {
            return false;
        }
        if (!Objects.equals(this.investmentFund, other.investmentFund)) {
            return false;
        }
        return true;
    }

}
