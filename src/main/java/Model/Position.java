package Model;

import java.sql.Date;

public class Position {

    private int id;

    private int qty;

    private String symbol;

    private double price;

    private String ccy;

    private String type;

    private int portfolioid;

    private Date date;

    private double value;

    private double profit;
    public Position(Integer id, Integer qty, String symbol, double price, String ccy, String type, Integer portfolioid, Date date, double value, double profit) {
        this.id = id;
        this.qty = qty;
        this.symbol = symbol;
        this.price = price;
        this.ccy = ccy;
        this.type = type;
        this.portfolioid = portfolioid;
        this.date = date;
        this.value=value;
        this.profit = profit;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public int getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(int portfolioid) {
        this.portfolioid = portfolioid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}