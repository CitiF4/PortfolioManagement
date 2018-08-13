package Service;

import Dao.*;
import Model.*;
import Model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createFm(Fundmanager f) {
        fundManagerMapper.createFundmanager(f);
    }

    public void updateRate(Fxrate f) {
        fxrateMapper.updateFxRate(f);
    }

    public void updatePrice(Position p) {
        positionMapper.updatePosition(p);
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

    public List<Portfolio> sortPortfolio() {
        List<Portfolio> portfolios = positionMapper.getPortfolios();
        for(Portfolio portfolio : portfolios){

        }
        return null;
    }
}
