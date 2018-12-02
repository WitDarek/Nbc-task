package pl.nbctask.investments;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author plewandowski
 */
public class AggresiveInvestmentTest {

    public AggresiveInvestmentTest() {
    }

    @Test
    public void getPercentage_ShouldReturnValuesWhichSumIsEqualTo100() {
        Investment investment = new AggresiveInvestment();

        int result = investment.getPercentages().values().stream().mapToInt(e -> e).sum();
        int expected = 100;

        assertEquals(expected, result);
    }

}
