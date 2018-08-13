package Dao;

import Model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by mandy on 2018/8/12.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc-servlet.xml","classpath:spring-mybatis.xml","classpath:applicationContext.xml"})
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    public void getAdmin() throws Exception {
        Admin admin = adminMapper.getAdmin(9999);
        assertEquals(admin.getName(),"23");
    }

    @Test
    public void updateAdmin() throws Exception {
        Admin admin = new Admin(9999, "Third");
        assertEquals(adminMapper.updateAdmin(admin), 1);
        Admin admin1 = new Admin(9999, "23");
        adminMapper.updateAdmin(admin1);
    }

}