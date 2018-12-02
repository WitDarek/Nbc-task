package pl.nbctask.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.investmentFund);
        hash = 97 * hash + this.amount;
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
        if (!Objects.equals(this.investmentFund, other.investmentFund)) {
            return false;
        }
        return true;
    }

}
