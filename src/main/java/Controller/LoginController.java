package Controller;

import Model.Fundmanager;
import Model.Portfolio;
import Service.AdminService;
import Service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by mandy on 2018/8/14.
 */

@Controller
public class LoginController {

    @Autowired
    AdminService adminServiceImpl;

    @Autowired
    FundManagerService fundManagerServiceImpl;

    @RequestMapping(value = "/login")
    public ModelAndView loginProcess(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "type") String type) {
        System.out.println("i am login" + name + ";" + type);
        ModelAndView mdv = new ModelAndView();
        if(name == null){
            mdv.setViewName("login");
        }else{
            if(type.equals("admin") && adminServiceImpl.validateAdmin(name)){
                System.out.println("this is a admin!!");
                mdv.setViewName("admin");
                List<Fundmanager> fundmanagers = adminServiceImpl.getFundManagers();
                adminServiceImpl.getFmShowInfo(fundmanagers);
                mdv.addObject("list",fundmanagers);
            }else if(type.equals("fundManager") && fundManagerServiceImpl.validateFm(name)){
                mdv.setViewName("fundmanager");
                List<Portfolio> portfolios = fundManagerServiceImpl.getPortfolios();
                fundManagerServiceImpl.getPortShowInfo(portfolios);
                mdv.addObject("list","portfolios");

            }else {
                mdv.setViewName("error");
            }

        }
        return mdv;
    }
}
