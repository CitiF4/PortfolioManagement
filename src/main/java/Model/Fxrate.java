package Model;

import java.math.BigDecimal;

public class Fxrate {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fxrate.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fxrate.base
     *
     * @mbggenerated
     */
    private String base;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fxrate.term
     *
     * @mbggenerated
     */
    private String term;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column fxrate.rate
     *
     * @mbggenerated
     */
    private BigDecimal rate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fxrate.id
     *
     * @return the value of fxrate.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fxrate.id
     *
     * @param id the value for fxrate.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fxrate.base
     *
     * @return the value of fxrate.base
     *
     * @mbggenerated
     */
    public String getBase() {
        return base;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fxrate.base
     *
     * @param base the value for fxrate.base
     *
     * @mbggenerated
     */
    public void setBase(String base) {
        this.base = base == null ? null : base.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fxrate.term
     *
     * @return the value of fxrate.term
     *
     * @mbggenerated
     */
    public String getTerm() {
        return term;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fxrate.term
     *
     * @param term the value for fxrate.term
     *
     * @mbggenerated
     */
    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column fxrate.rate
     *
     * @return the value of fxrate.rate
     *
     * @mbggenerated
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column fxrate.rate
     *
     * @param rate the value for fxrate.rate
     *
     * @mbggenerated
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}