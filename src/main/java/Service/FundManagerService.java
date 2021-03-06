package Service;

import Model.Information;
import Model.Portfolio;
import Model.Position;
import javafx.geometry.Pos;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Dong on 2018/8/10.
 */


public interface FundManagerService {
    boolean validateFm(String name);
    void createPortfolio(Portfolio p);

    void updatePosition(Position p);

    List<Position> getSamePositionsFromPortfolio(String symbol,String type,int portfolioID);

    List<Portfolio> getPortFolioByFundManagerID(int fmID);
    void createPositionWithoutID(Position p);
    void createPosition(Position p);
    void createPortfolioByName(String name, double cash, int fmId, Date date);
    List<Position>queryForPositions(int pId);
    void deletePortfolio(int portfolioId);
    void deletePosition(int positionId);
    void updatePortfolio(Portfolio p);
    void updatePortfolioById(int id,String name);
    List<Portfolio> getPortfoliosByName(String fmName);
    Portfolio getPortfolio(int portfolioId);
    List<Information> getInformations();
    List<Information> getInformation(String type, Date date);
    void getPortShowInfo(List<Portfolio> portfolios);
    List<Portfolio> getPortfolios(int fid);
    int getFundmanagerIdbyName(String name);
    Set<String> getSymbolsByType(String type);
//    sort,filter,top,tail datasets
//    top,worst performing funds

}
