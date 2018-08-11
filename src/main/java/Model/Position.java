package Model;

import java.math.BigDecimal;
import java.util.Date;

public class Position {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.qty
     *
     * @mbggenerated
     */
    private Integer qty;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.symbol
     *
     * @mbggenerated
     */
    private String symbol;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.price
     *
     * @mbggenerated
     */
    private BigDecimal price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.country
     *
     * @mbggenerated
     */
    private String country;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.type
     *
     * @mbggenerated
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.portfolioID
     *
     * @mbggenerated
     */
    private Integer portfolioid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column position.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.id
     *
     * @return the value of position.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.id
     *
     * @param id the value for position.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.qty
     *
     * @return the value of position.qty
     *
     * @mbggenerated
     */
    public Integer getQty() {
        return qty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.qty
     *
     * @param qty the value for position.qty
     *
     * @mbggenerated
     */
    public void setQty(Integer qty) {
        this.qty = qty;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.symbol
     *
     * @return the value of position.symbol
     *
     * @mbggenerated
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.symbol
     *
     * @param symbol the value for position.symbol
     *
     * @mbggenerated
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.price
     *
     * @return the value of position.price
     *
     * @mbggenerated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.price
     *
     * @param price the value for position.price
     *
     * @mbggenerated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.country
     *
     * @return the value of position.country
     *
     * @mbggenerated
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.country
     *
     * @param country the value for position.country
     *
     * @mbggenerated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.type
     *
     * @return the value of position.type
     *
     * @mbggenerated
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.type
     *
     * @param type the value for position.type
     *
     * @mbggenerated
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.portfolioID
     *
     * @return the value of position.portfolioID
     *
     * @mbggenerated
     */
    public Integer getPortfolioid() {
        return portfolioid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.portfolioID
     *
     * @param portfolioid the value for position.portfolioID
     *
     * @mbggenerated
     */
    public void setPortfolioid(Integer portfolioid) {
        this.portfolioid = portfolioid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column position.date
     *
     * @return the value of position.date
     *
     * @mbggenerated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column position.date
     *
     * @param date the value for position.date
     *
     * @mbggenerated
     */
    public void setDate(Date date) {
        this.date = date;
    }
}