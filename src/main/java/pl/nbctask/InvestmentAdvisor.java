package pl.nbctask;

import pl.nbctask.model.InvestmentFund;
import pl.nbctask.model.Report;
import pl.nbctask.enums.InvestmentStyle;
import pl.nbctask.exceptions.UnsupportedStyleException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author plewandowski
 */
public abstract class InvestmentAdvisor {

    public static Report calculateInvestments(Integer amount,
            List<InvestmentFund> funds,
            InvestmentStyle style) throws UnsupportedStyleException{
        
        switch (style) {
            case AGGRESIVE: {
                break;
            }
            case BALANCED: {
                break;
            }
            case SAVE: {
                break;
            }
            default:{
                throw new UnsupportedStyleException(style + " is not supported");
            } 
        }

        return null;
    }
}
