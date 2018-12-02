/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.nbctask.investments.mocks;

import java.util.HashMap;
import java.util.Map;
import pl.nbctask.enums.FundType;
import pl.nbctask.investments.Investment;

/**
 *
 * @author plewandowski
 */
public class DividedInvestment extends Investment {

    @Override
    public Map<FundType, Integer> getPercentages() {
        Map<FundType, Integer> percentages = new HashMap<>();

        percentages.put(FundType.POLISH, 50);
        percentages.put(FundType.MONETARY, 50);

        return percentages;
    }

}
