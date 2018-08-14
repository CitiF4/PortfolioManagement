package Model;

import java.util.List;

public class Fundmanager {
    private int id;

    private String name;

    private double rate;

    private double Totalcash;

    private double cash;

    private List<Portfolio> portfolios;

    private double value;
    public Fundmanager(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalcash() {
        return Totalcash;
    }

    public void setTotalcash(double totalcash) {
        Totalcash = totalcash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    public String toString(){
        return "name : " + this.name + " id : " + this.id;
    }
}