package Dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2018/8/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml","classpath:applicationContext.xml"})
public class FxrateMapperTest {
    @Test
    public void updateFxRate() throws Exception {
    }

    @Test
    public void getFxRate() throws Exception {
    }

}