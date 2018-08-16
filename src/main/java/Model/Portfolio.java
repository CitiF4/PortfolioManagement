package Model;

import java.sql.Date;
import java.util.List;

public class Portfolio {


    private double rate;
    private double value;
    private int id;
    private String name;

    private Date date;

    private double curCash;

    private int fmid;

    private List<Position> positions;

    private double initCash;

    private double currentValue;

    public Portfolio(Integer id, String name, Date date, Double cash, Integer fmid, Double initCash) {

        this.id = id;
        this.name = name==null?"":name;
        this.date = date;
        this.curCash = cash==null?0:cash;
        this.fmid = fmid;
        this.initCash = initCash==null?0:initCash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCurCash() {
        return curCash;
    }

    public void setCurCash(double curCash) {
        this.curCash = curCash;
    }


    public int getFmid() {
        return fmid;
    }

    public void setFmid(int fmid) {
        this.fmid = fmid;
    }


    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
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

    public void setId(int id) {
        this.id = id;
    }

    public double getInitCash() {
        return initCash;
    }

    public void setInitCash(double initCash) {
        this.initCash = initCash;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public String tooString(){
        return "name :" + name + " cash :" + curCash;
    }


}