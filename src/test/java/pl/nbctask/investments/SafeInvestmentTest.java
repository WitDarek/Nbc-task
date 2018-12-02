package pl.nbctask.investments;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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

}
