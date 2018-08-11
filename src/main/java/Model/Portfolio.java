package Model;

import java.math.BigDecimal;
import java.util.Date;

public class Portfolio {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolio.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolio.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolio.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolio.cash
     *
     * @mbggenerated
     */
    private BigDecimal cash;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column portfolio.FMid
     *
     * @mbggenerated
     */
    private Integer fmid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolio.id
     *
     * @return the value of portfolio.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolio.id
     *
     * @param id the value for portfolio.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolio.name
     *
     * @return the value of portfolio.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolio.name
     *
     * @param name the value for portfolio.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolio.date
     *
     * @return the value of portfolio.date
     *
     * @mbggenerated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolio.date
     *
     * @param date the value for portfolio.date
     *
     * @mbggenerated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolio.cash
     *
     * @return the value of portfolio.cash
     *
     * @mbggenerated
     */
    public BigDecimal getCash() {
        return cash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolio.cash
     *
     * @param cash the value for portfolio.cash
     *
     * @mbggenerated
     */
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column portfolio.FMid
     *
     * @return the value of portfolio.FMid
     *
     * @mbggenerated
     */
    public Integer getFmid() {
        return fmid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column portfolio.FMid
     *
     * @param fmid the value for portfolio.FMid
     *
     * @mbggenerated
     */
    public void setFmid(Integer fmid) {
        this.fmid = fmid;
    }
}