package Service;

import Model.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */

public interface AdminService {

    //admin view the distinct list of positions
    List<Position> queryForDistinctPositions();

    boolean validateAdmin(String name);
    void createFm(Fundmanager f);
    void updateRate(Fxrate f);
    void updatePrice(Information info);//Position don't need change price
    void getInformationByType(String type);
    void getInformationByTypeAndDate(String type, Date dateFrom, Date dateTo);
    void deleteFm(int fmId);
    List<Fundmanager> getFundManagers();
    Fundmanager getFundManager(int id);
    void updateFundManager(Fundmanager f);
    void getFmShowInfo(List<Fundmanager> fundmanagers);
    List<Portfolio> sortPortfolio();//find best portfolio above the whole fm

    //    sort,filter,top,tail datasets
   //    top,worst performing funds
}

