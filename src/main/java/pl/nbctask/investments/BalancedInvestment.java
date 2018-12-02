package pl.nbctask.investments;

import java.util.HashMap;
import java.util.Map;
import pl.nbctask.enums.FundType;

/**
 *
 * @author plewandowski
 */
public class BalancedInvestment extends AbstractInvestment {

    @Override
    public Map<FundType, Integer> getPercentages() {
        Map<FundType, Integer> percentages = new HashMap<>();

        percentages.put(FundType.POLISH, 30);
        percentages.put(FundType.FOREIGN, 60);
        percentages.put(FundType.MONETARY, 10);

        return percentages;
    }
}
