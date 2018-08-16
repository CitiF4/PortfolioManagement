package Service;

import Dao.FundmanagerMapper;
import Dao.InformationMapper;
import Dao.PortfolioMapper;
import Dao.PositionMapper;
import Model.Fundmanager;
import Model.Information;
import Model.Portfolio;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mandy on 2018/8/11.
 */

@Service
public class FundManagerServiceImpl implements FundManagerService {

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private FundmanagerMapper fundmanagerMapper;

    @Autowired
    private PortfolioMapper portfolioMapper;

    @Autowired
    private InformationMapper informationMapper;


    public List<Portfolio> getPortFolioByFundManagerID(int fmID){return portfolioMapper.getPortFolioByFundManagerID(fmID);}

    public void updatePosition(Position p){positionMapper.updatePosition(p);}
    public List<Position> getSamePositionsFromPortfolio(String symbol,String type,int portfolioID){return positionMapper.getSamePositionsFromPortfolio(symbol,type,portfolioID);}

    public void updatePortfolioById(int id,String name){
        portfolioMapper.updatePortfolioById(id,name);
    }

    public void createPositionWithoutID(Position p){ positionMapper.createPositionWithoutID(p);}

    public void createPortfolioByName(String name, double cash, int fmId, Date date){
        double initCash = cash;
        portfolioMapper.createPortfolioByName(name,cash,initCash,fmId,new Date());}
    public List<Position> queryForPositions(int pId){return positionMapper.queryForPositions(pId);}

    public void createPosition(Position p){positionMapper.createPosition(p);}

    public boolean validateFm(String name) {
        Fundmanager f = fundmanagerMapper.getFundManagerByName(name);
        if(f != null){
            return true;
        }
        return false;
    }

    public void createPortfolio(Portfolio p) {
        portfolioMapper.createPortfolio(p);
    }

    public void deletePortfolio(int portfolioId) {
        portfolioMapper.deletePortfolio(portfolioId);
    }

    public void deletePosition(int positionId) {
        positionMapper.deletePosition(positionId);
    }

    public void updatePortfolio(Portfolio p) {
        portfolioMapper.updatePortfolio(p);
    }

    public List<Portfolio> getPortfoliosByName(String fmName) {

        int id = fundmanagerMapper.getFundManagerByName(fmName).getId();
        return fundmanagerMapper.getPortfolio(id);
    }

    public Portfolio getPortfolio(int portfolioId) {

        return portfolioMapper.getPorfolio(portfolioId);
    }


    public List<Information> getInformations() {
        List<Information> bInfo = informationMapper.getInformationOfSameType("Bonds");
        List<Information> fInfo = informationMapper.getInformationOfSameType("Future");
        List<Information> eInfo = informationMapper.getInformationOfSameType("Equity");
        List<Information> tInfo = informationMapper.getInformationOfSameType("EFTs");
        bInfo.addAll(fInfo);
        bInfo.addAll(eInfo);
        bInfo.addAll(tInfo);
        return bInfo;
    }

    public List<Information> getInformation(String type, Date date) {
        return informationMapper.getInformationPeriod(type,date);
    }

    public void getPortShowInfo(List<Portfolio> portfolios) {
        for(Portfolio portfolio : portfolios){
            double initCash = portfolio.getInitCash();
            Portfolio portfolioT = portfolioMapper.addPositionByPortId(portfolio.getId());
            portfolio.setPositions(portfolioT.getPositions());
            List<Position> positions = portfolio.getPositions();
            double currentValue = 0.0;
            double value = 0.0;
            double cash = initCash;
            for(Position position : positions){
                cash -= position.getValue();
                List<Information> recentPrice = informationMapper.getRecentPrice(position.getSymbol(), position.getType());
                currentValue += recentPrice.get(0).getPrice()*position.getQty();
                value += position.getValue();
            }
            portfolio.setValue(value);
            portfolio.setCurrentValue(currentValue);
            portfolio.setCurCash(cash);
            portfolio.setRate((currentValue - value)/portfolio.getInitCash());

        }
    }

    public List<Portfolio> getPortfolios(int fmid) {
        return fundmanagerMapper.getPortfolio(fmid);
    }

    public int getFundmanagerIdbyName(String name) {

        return fundmanagerMapper.getFundmanagerIdByName(name);
    }

    public Set<String> getSymbolsByType(String type) {
        List<Information> informations = informationMapper.getInformationOfSameType(type);
        Set<String> symbols = new HashSet<String>();
        for(Information information : informations){
            symbols.add(information.getSymbol());
        }

        return symbols;
    }

    public List<Information> getInformation(String type) {
        return informationMapper.getInformationOfSameType(type);
    }
}
