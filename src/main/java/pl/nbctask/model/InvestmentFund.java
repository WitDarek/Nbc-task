package pl.nbctask.model;

import pl.nbctask.enums.FundType;
import java.util.Objects;

/**
 *
 * @author plewandowski
 */
public class InvestmentFund {
    
    private Long id;
    private String name;
    private FundType fundType;

    public InvestmentFund(Long id, String name, FundType fundType) {
        this.id = id;
        this.name = name;
        this.fundType = fundType;
    }   

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FundType getFundType() {
        return fundType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.fundType);
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
        final InvestmentFund other = (InvestmentFund) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (this.fundType != other.fundType) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InvestmentFund{" + "id=" + id + ", name=" + name + ", fundType=" + fundType + '}';
    }
    
}
