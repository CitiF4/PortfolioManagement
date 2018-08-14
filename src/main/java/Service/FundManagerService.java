package Service;

import Model.Portfolio;
import Model.Position;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */


public interface FundManagerService {
    void createPortfolio(Portfolio p);


    void createPortfolioByName(String name, double cash, int fmId, Date date);
    List<Position>queryForPositions(int pId);
    void deletePortfolio(int portfolioId);
    void deletePosition(int positionId);
    void updatePortfolio(Portfolio p);
    void updatePortfolioById(int id,String name);
    List<Portfolio> getPortfolios();
    Portfolio getPortfolio(int portfolioId);
    List<Portfolio> sortPortfolio();//find best portfolio
//    sort,filter,top,tail datasets
//    top,worst performing funds

}
