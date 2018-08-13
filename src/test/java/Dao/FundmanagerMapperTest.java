package Dao;

import Model.Fundmanager;
import Model.Fxrate;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by mandy on 2018/8/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml","classpath:applicationContext.xml"})
public class FundmanagerMapperTest {

//    @Autowired
//    private SqlSessionFactory sqlSessionFactory;
//    @Before
//    public void setUp() throws Exception {
//        //创建sqlSessionFactory
//        //MyBatis配置文件
//        String resource = "generatorConfig.xml";
//        //得到配置文件流
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //创建会话工厂，传入MyBatis的配置信息
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//    }
    @Autowired
    private FundmanagerMapper fundmanagerMapper;

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createFundmanager() throws Exception {
        List<Fundmanager> fmL =  fundmanagerMapper.getFundManagers();
        for(Fundmanager fundmanager : fmL){
            if(fundmanager.getId() == 9999){
                fundmanagerMapper.deleteFundmanager(9999);
                break;
            }
        }
        Fundmanager f = new Fundmanager(9999,"queen");
        fundmanagerMapper.createFundmanager(f);
        Fundmanager fundmanager = fundmanagerMapper.getFundManager(9999);
        assertEquals(fundmanager.getId(),9999);
        assertEquals(fundmanager.getName(), "queen");


    }


    @Test
    public void getFundManager() throws Exception {
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建UserMapper对象，MyBatis自动生成mapper代理
//        fundmanagerMapper userMapper = sqlSession.getMapper(fundmanagerMapper.class);
        //调用userMapper的方法
        Fundmanager fundmanager = fundmanagerMapper.getFundManager(1);
        //关闭资源
//        sqlSession.close();
        //打印客户信息
        System.out.println(fundmanager);
        assertNotNull(fundmanager.getName());
    }

    @Test
    public void updateFundmanager() throws Exception {
        Fundmanager f = new Fundmanager(1,"jokerNew");
        fundmanagerMapper.updateFundmanager(f);
        Fundmanager fundmanager = fundmanagerMapper.getFundManager(1);
        System.out.println(fundmanager);
        assertNotNull(fundmanager.getName());
    }


}