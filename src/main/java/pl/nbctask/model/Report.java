package pl.nbctask.model;

import pl.nbctask.model.ReportRow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author plewandowski
 */
public class Report {

    private List<ReportRow> reportRows = new ArrayList<>();
    private int unnasignedAmount = 0;

    public Report addReportRow(ReportRow reportRow) {
        reportRows.add(reportRow);
        return this;
    }

    public void setUnnasignedAmount(int value) {
        unnasignedAmount = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        reportRows.forEach(row -> {
            sb.append(row);
            sb.append("\n");
        });

        sb.append("unnasignedAmount ");
        sb.append(unnasignedAmount);

        return sb.toString();
    }

  
}
