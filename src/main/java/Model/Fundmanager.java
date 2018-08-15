package Model;

import java.util.List;

public class Fundmanager {
    private int id;

    private String name;

    private double rate;

    private double intiCash;

    private double curCash;

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

    public double getInitCash() {
        return intiCash;
    }

    public void setInitCash(double intiCash) {
        this.intiCash = intiCash;
    }

    public double getCurCash() {
        return curCash;
    }

    public void setCurCash(double curCash) {
        this.curCash = curCash;
    }
    public String toString(){
        return "name : " + this.name + " id : " + this.id;
    }
}