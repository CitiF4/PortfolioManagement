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
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "type",required = false) String type) {
        System.out.println("i am login" + name + ";" + type);
        if (name == null) {
            return "login";
        } else {
            if (type.equals("admin") && adminServiceImpl.validateAdmin(name)) {
                System.out.println("this is a admin!!");
                return "admin";
            } else if (type.equals("fundManager") && fundManagerServiceImpl.validateFm(name)) {
                System.out.println("this is a fm2!!");

                return "fundManager";


            } else {
                return "login";
            }
        }
    }

    @RequestMapping("/getFundManager")
    @ResponseBody
    public  List<Fundmanager> loginProcessFm(){
        List<Fundmanager> fundmanagers = adminServiceImpl.getFundManagers();
        System.out.println(fundmanagers.size());
        adminServiceImpl.getFmShowInfo(fundmanagers);
        return fundmanagers;

    }

    @RequestMapping("/getPortfolios")
    @ResponseBody
    public  List<Portfolio> loginProcessAd(){
        List<Portfolio> portfolios = fundManagerServiceImpl.getPortfolios();
        fundManagerServiceImpl.getPortShowInfo(portfolios);
        return portfolios;

    }
}
