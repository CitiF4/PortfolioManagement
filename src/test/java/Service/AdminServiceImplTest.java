package Service;

import Model.Fundmanager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by mandy on 2018/8/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml", "classpath:applicationContext.xml"})
public class AdminServiceImplTest {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

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

}