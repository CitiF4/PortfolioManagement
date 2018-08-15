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
import java.util.Date;
import java.util.List;

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
    public void updatePortfolioById(int id,String name){
        portfolioMapper.updatePortfolioById(id,name);
    }

    public void createPortfolioByName(String name, double cash, int fmId, Date date){portfolioMapper.createPortfolioByName(name,cash,fmId,new Date());}
    public List<Position> queryForPositions(int pId){return positionMapper.queryForPositions(pId);}


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

    public List<Portfolio> getPortfolios() {

        return portfolioMapper.getPortfolios();
    }

    public Portfolio getPortfolio(int portfolioId) {

        return portfolioMapper.getPorfolio(portfolioId);
    }


    public List<Portfolio> sortPortfolio() {

        return null;
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

    public List<Information> getInformation(String type, String dateS) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return informationMapper.getInformationPeriod(type,date,date);
    }

    public void getPortShowInfo(List<Portfolio> portfolios) {
        for(Portfolio portfolio : portfolios){
            double initCash = portfolio.getInitcash();
            Portfolio portfolioT = portfolioMapper.addPositionByPortId(portfolio.getId());
            portfolio.setPositions(portfolioT.getPositions());
            List<Position> positions = portfolio.getPositions();
            double value = 0.0;
            double cash = initCash;
            for(Position position : positions){
                value += position.getValue();
                cash -= position.getValue();
            }
            portfolio.setValue(value);
            portfolio.setCash(cash);


        }
    }

    public List<Information> getInformation(String type) {
        return informationMapper.getInformationOfSameType(type);
    }
}
