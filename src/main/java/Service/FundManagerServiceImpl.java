package Service;

import Dao.PortfolioMapper;
import Dao.PositionMapper;
import Model.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
