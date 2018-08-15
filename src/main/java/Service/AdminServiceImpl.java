package Service;

import Dao.*;
import Model.*;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mandy on 2018/8/11.
 */

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private FundmanagerMapper fundManagerMapper;

    @Autowired
    private FxrateMapper fxrateMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private InformationMapper informationMapper;


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PortfolioMapper portfolioMapper;
    public boolean validateAdmin(String name) {
        Admin admin = adminMapper.getAdminByName(name);

        if( admin!= null){
            return true;
        }
        return false;
    }

    public List<Fxrate> queryForDistinctFXrate(){
        return fxrateMapper.queryForDistinctFXrate();
    }
    public void createInformationForPrice(String symbol, String type, double price, String ccy, java.util.Date date){
        informationMapper.createInformationForPrice(symbol,type,price,ccy,date);
    };

    public List<Information> getRecentPrice(String symbol,String type){return informationMapper.getRecentPrice(symbol,type);}

    public void uploadFXrate(String base,String term,double rate,Date date){fxrateMapper.uploadFXrate(base,term,rate,date);};


    public List<Position> queryForDistinctPositions(){
        return  positionMapper.queryForDistinctPositions();
    }

    public void createFm(Fundmanager f) {
        fundManagerMapper.createFundmanager(f);
    }

    public void updateRate(Fxrate f) {
        fxrateMapper.updateFxRate(f);
    }

    public void updatePrice(Information information) {
        informationMapper.updateInformation(information);
    }

    public void getInformationByType(String type) {
        informationMapper.getInformationOfSameType(type);
    }

    public void getInformationByTypeAndDate(String type, Date dateFrom, Date dateTo) {
        informationMapper.getInformationPeriod(type,dateFrom,dateTo);
    }

    public void deleteFm(int fmId) {
        fundManagerMapper.deleteFundmanager(fmId);
    }

    public List<Fundmanager> getFundManagers() {
        return fundManagerMapper.getFundManagers();

    }

    public Fundmanager getFundManager(int id) {
        return fundManagerMapper.getFundManager(id);
    }

    public void updateFundManager(Fundmanager f) {
        fundManagerMapper.updateFundmanager(f);
    }

    public void getFmShowInfo(List<Fundmanager> fundmanagers) {
        for(Fundmanager fundmanager : fundmanagers){
            int id = fundmanager.getId();
            Fundmanager f = fundManagerMapper.addPorfolioByfmId(id);
            List<Portfolio> portfolios = f.getPortfolios();
            double[]db = addCashAndValueForPortfolios(portfolios);
            fundmanager.setInitCash(db[1]);
            fundmanager.setCurCash(db[0]);
            fundmanager.setValue(db[2]);
            fundmanager.setRate(db[2]/db[1]);
        }
    }

    public List<Portfolio> setPortfolioRate() {
        List<Portfolio> portfolios = adminMapper.getPortfolios();
        addCashAndValueForPortfolios(portfolios);
        return portfolios;
    }


    public void sortPortfolio(List<Portfolio> portfolios) {
        Collections.sort(portfolios, new Comparator<Portfolio>() {
            public int compare(Portfolio o1, Portfolio o2) {
                if(o1.getRate() - o2.getRate() != 0){
                    return 0;
                }else{
                    if(o1.getRate() - o2.getRate() > 0) {
                        return -1;
                    }else return 1;
                }
            }
        });
    }

    public Fundmanager getFundmanager(Portfolio portfolio) {
        return fundManagerMapper.getFundManager(portfolio.getFmid());
    }

    public List<Portfolio> getPortfolios() {
        return adminMapper.getPortfolios();
    }

    public double[] addCashAndValueForPortfolios(List<Portfolio> portfolios){

        double pCash = 0.0;
        double pInitCash = 0.0;
        double pValue = 0.0;
        for(Portfolio portfolio : portfolios){
            double initCash = portfolio.getInitCash();
            Portfolio portfolioT = portfolioMapper.addPositionByPortId(portfolio.getId());
            portfolio.setPositions(portfolioT.getPositions());
            List<Position> positions = portfolio.getPositions();
            double value = 0.0;
            double cash = initCash;
            for(Position position : positions){
                value += informationMapper.getRecentPrice(position.getSymbol(),position.getType()).get(0).getPrice()*position.getQty();
                cash -= position.getValue();
            }
//            portfolio.setValue(value);
//            portfolio.setCurCash(cash);
//            portfolio.setRate(value/portfolio.getInitcash());
            pCash += cash;
            pInitCash += portfolio.getInitCash();
            pValue += value;
        }
        double[] db = {pCash,pInitCash,pValue};
        return db;
    }
}
