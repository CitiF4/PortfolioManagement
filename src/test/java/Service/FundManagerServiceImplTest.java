package Service;

import Dao.PortfolioMapper;
import Dao.PositionMapper;
import Model.Portfolio;
import Model.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2018/8/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml", "classpath:applicationContext.xml"})

public class FundManagerServiceImplTest {

    @Autowired
    private  FundManagerService fundManagerServiceImpl;

    @Autowired
    private PortfolioMapper portfolioMapper;

    @Test
    public void getPortShowInfo() throws Exception {
        List<Portfolio> portfolios = portfolioMapper.getPortfolios();
        fundManagerServiceImpl.getPortShowInfo(portfolios);
        for(Portfolio portfolio : portfolios){
            System.out.println("Portfolio : " + portfolio.getId() + " cash: " + portfolio.getCash() + " value: " + portfolio.getValue() + " initCash: " + portfolio.getInitcash());
        }
    }

}