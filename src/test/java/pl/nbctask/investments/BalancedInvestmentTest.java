package pl.nbctask.investments;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author plewandowski
 */
public class BalancedInvestmentTest {
    
    public BalancedInvestmentTest() {
    }

    @Test
    public void getPercentage_ShouldReturnValuesWhichSumIsEqualTo100() {
        Investment investment = new BalancedInvestment();

        int result = investment.getPercentages().values().stream().mapToInt(e -> e).sum();
        int expected = 100;

        assertEquals(expected, result);
    }
    
}
