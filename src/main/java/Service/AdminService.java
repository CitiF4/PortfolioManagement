package Service;

import Model.*;
import org.springframework.stereotype.Service;

import java.sql.Date;

//import java.util.Date;



import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */

public interface AdminService {

    //admin view the distinct list of positions
    List<Information> queryForDistinctPositions();


    void createFundManagerByName(String name);
    List<Fxrate> getRateForSpecifiedCCY(String ccy);
    void updatePortfolioFmId(Portfolio p);

    boolean validateAdmin(String name);

    void uploadFXrate(String base,String term,double rate,Date date);

    List<Fxrate> queryForDistinctFXrate();

    List<Information> getRecentPrice(String symbol, String type);

    void createInformationForPrice(String symbol, String type, double price, String ccy, java.util.Date date);

    void createFm(Fundmanager f);
    void updateRate(Fxrate f);
    void updatePrice(Information info);//Position don't need change price
    void getInformationByType(String type);
    void deleteFm(int fmId);
    List<Fundmanager> getFundManagers();
    Fundmanager getFundManager(int id);
    void updateFundManager(Fundmanager f);
    void getFmShowInfo(List<Fundmanager> fundmanagers);
    List<Portfolio> setPortfolioRate();
    void sortPortfolio(List<Portfolio> portfolios);
    Fundmanager getFundmanager(Portfolio portfolio);
    List<Portfolio> getPortfolios();
}

