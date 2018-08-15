package Service;

import Dao.*;
import Model.*;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

/**
 * Created by mandy on 2018/8/11.
 */

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private FundmanagerMapper fundManagerMapper;

    @Autowired
    private FxrateMapper fxrateMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private PortfolioMapper portfolioMapper;
    public boolean validateAdmin(String name) {
        Admin admin = adminMapper.getAdminByName(name);

        if( admin!= null){
            return true;
        }
        return false;
    }

    public List<Position> queryForDistinctPositions(){
        return  positionMapper.queryForDistinctPositions();
    }

    public void createFm(Fundmanager f) {
        fundManagerMapper.createFundmanager(f);
    }

    public void updateRate(Fxrate f) {
        fxrateMapper.updateFxRate(f);
    }

    public void updatePrice(Information information) {
        informationMapper.updateInformation(information);
    }

    public void getInformationByType(String type) {
        informationMapper.getInformationOfSameType(type);
    }

    public void getInformationByTypeAndDate(String type, Date dateFrom, Date dateTo) {
        informationMapper.getInformationPeriod(type,dateFrom,dateTo);
    }

    public void deleteFm(int fmId) {
        fundManagerMapper.deleteFundmanager(fmId);
    }

    public List<Fundmanager> getFundManagers() {
        return fundManagerMapper.getFundManagers();

    }

    public Fundmanager getFundManager(int id) {
        return fundManagerMapper.getFundManager(id);
    }

    public void updateFundManager(Fundmanager f) {
        fundManagerMapper.updateFundmanager(f);
    }

    public void getFmShowInfo(List<Fundmanager> fundmanagers) {
        for(Fundmanager fundmanager : fundmanagers){
            int id = fundmanager.getId();
            Fundmanager f = fundManagerMapper.addPorfolioByfmId(id);
            List<Portfolio> portfolios = f.getPortfolios();
            double[]db = addCashAndValueForPortfolios(portfolios);
            fundmanager.setTotalcash(db[1]);
            fundmanager.setCash(db[0]);
            fundmanager.setValue(db[2]);
        }
    }
    public List<Portfolio> sortPortfolio() {
        List<Portfolio> portfolios = positionMapper.getPortfolios();
        for(Portfolio portfolio : portfolios){

        }
        return null;
    }
    public double[] addCashAndValueForPortfolios(List<Portfolio> portfolios){

        double pCash = 0.0;
        double pInitCash = 0.0;
        double pValue = 0.0;
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
            pCash += cash;
            pInitCash += portfolio.getInitcash();
            pValue += value;
        }
        double[] db = {pCash,pInitCash,pValue};
        return db;
    }
}
