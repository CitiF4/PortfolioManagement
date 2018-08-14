package Service;

import Dao.PortfolioMapper;
import Dao.PositionMapper;
import Model.Portfolio;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private PortfolioMapper portfolioMapper;

    public void updatePortfolioById(int id,String name){
        portfolioMapper.updatePortfolioById(id,name);
    }
    public void createPortfolioByName(String name, double cash, int fmId, Date date){portfolioMapper.createPortfolioByName(name,cash,fmId,new Date());}

    public List<Position> queryForPositions(int pId){return positionMapper.queryForPositions(pId);}

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
}
