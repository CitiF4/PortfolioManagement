package Service;

import Dao.FundmanagerMapper;
import Model.Fundmanager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by mandy on 2018/8/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml", "classpath:applicationContext.xml"})
public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    private FundmanagerMapper fundmanagerMapper;

    @Test
    public void createFm() throws Exception {
        Fundmanager f = new Fundmanager(10000,"test");
        adminServiceImpl.createFm(f);
    }

    @Test
    public void updateRate() throws Exception {
    }

    @Test
    public void updatePrice() throws Exception {
    }

    @Test
    public void deleteFm() throws Exception {
    }

    @Test
    public void getFundManagers() throws Exception {
    }

    @Test
    public void updateFundManager() throws Exception {
    }

    @Test
    public void sortPortfolio() throws Exception {
    }

    @Test
    public void test_getFmShowInfo() {
        List<Fundmanager> fundManagers = fundmanagerMapper.getFundManagers();
        adminServiceImpl.getFmShowInfo(fundManagers);
        for (Fundmanager fundmanager : fundManagers) {
            System.out.println("Fundmanger: " + fundmanager.getName() + " Cash: " + fundmanager.getCurCash() + " InitCash" + fundmanager.getInitCash() + " Value: " + fundmanager.getValue());
        }
    }
}