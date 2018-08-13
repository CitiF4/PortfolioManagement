package Service;

import Model.Portfolio;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */


public interface FundManagerService {
    void createPortfolio(Portfolio p);
    void deletePortfolio(int portfolioId);
    void deletePosition(int positionId);
    void updatePortfolio(Portfolio p);
    List<Portfolio> getPortfolios();
    Portfolio getPortfolio(int portfolioId);
    List<Portfolio> sortPortfolio();//find best portfolio
//    sort,filter,top,tail datasets
//    top,worst performing funds

}
