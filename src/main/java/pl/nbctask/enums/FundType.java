package pl.nbctask.enums;

/**
 *
 * @author plewandowski
 */
public enum FundType {
    POLISH("Fundusz polski"),
    FOREIGN("Fundusz zagraniczny"),
    MONETARY("Fundusz monetarny");

    private String name;

    private FundType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
