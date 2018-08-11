package Service;

import Model.Fundmanager;
import Model.Fxrate;
import Model.Portfolio;

import javax.swing.text.Position;
import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */
public interface AdminService {
    void createFm(Fundmanager f);
    void updateRate(Fxrate f);
    void updatePrice(Position p);
    void deleteFm(String fmId);
    List<Fundmanager> getFundManagers();
    void updateFundManager(String fmId);
    List<Portfolio> sortPortfolio();//find best portfolio above the whole fm

    //    sort,filter,top,tail datasets
   //    top,worst performing funds
}
