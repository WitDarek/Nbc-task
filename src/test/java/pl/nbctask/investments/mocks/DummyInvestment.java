package pl.nbctask.investments.mocks;

import java.util.HashMap;
import java.util.Map;
import pl.nbctask.enums.FundType;
import pl.nbctask.investments.Investment;

/**
 *
 * @author plewandowski
 */
public class DummyInvestment extends Investment {

    @Override
    public Map<FundType, Integer> getPercentages() {
        Map<FundType, Integer> percentages = new HashMap<>();

        percentages.put(FundType.POLISH, 20);
        percentages.put(FundType.FOREIGN, 75);
        percentages.put(FundType.MONETARY, 5);

        return percentages;
    }

}
