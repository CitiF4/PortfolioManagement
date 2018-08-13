package Controller;

import Model.Fundmanager;
import Service.AdminService;
import Service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by mandy on 2018/8/13.
 */

@Controller
public class testController {

    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminServiceImpl;

    @RequestMapping(value = "/test")
    public ModelAndView test(){
        Fundmanager f = adminServiceImpl.getFundManager(9999);
        System.out.println("==========================================");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test");
        // 添加数据
        modelAndView.addObject("id",f.getId());
        modelAndView.addObject("name",f.getName());
        System.out.println(f.toString());
        return modelAndView;
    }
}
