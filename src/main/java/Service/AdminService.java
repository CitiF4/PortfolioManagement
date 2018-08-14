package Service;

import Model.Fundmanager;
import Model.Fxrate;
import Model.Portfolio;
import Model.Position;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */

public interface AdminService {

    //admin view the distinct list of positions
    List<Position> queryForDistinctPositions();

    void createFm(Fundmanager f);
    void updateRate(Fxrate f);
    void updatePrice(Position p);
    void deleteFm(int fmId);
    List<Fundmanager> getFundManagers();
    Fundmanager getFundManager(int id);
    void updateFundManager(Fundmanager f);
    List<Portfolio> sortPortfolio();//find best portfolio above the whole fm

    //    sort,filter,top,tail datasets
   //    top,worst performing funds
}

