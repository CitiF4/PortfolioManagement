package Service;

import Model.Portfolio;

import java.util.List;

/**
 * Created by Dong on 2018/8/10.
 */
public interface FundManagerService {
    void create(Portfolio p);
    void deletePortfolio(String portfolioId);
    void deletePosition(String positionId);
    void update(Portfolio p);
    List<Portfolio> getPortfolio(List<String> portfolioId);
    List<Portfolio> sortPortfolio();//find best portfolio
//    sort,filter,top,tail datasets
//    top,worst performing funds

}
