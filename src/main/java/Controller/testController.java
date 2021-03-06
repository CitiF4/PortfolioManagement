package Controller;

import Model.Fundmanager;
import Model.Information;
import Model.Portfolio;
import Model.Position;
import Service.AdminService;
import Service.AdminServiceImpl;
import Service.FundManagerService;
import Service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mandy on 2018/8/13.
 */

@Controller
public class testController {

    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminServiceImpl;

    @Autowired
    @Qualifier("InformationServiceImpl")
    InformationService informationServiceImpl;

    @Autowired
    @Qualifier("fundmanagerServiceImpl")
    FundManagerService fundmanagerServiceImpl;


    @RequestMapping(value = "/test")

//    public ModelAndView test(){
//
//
//        List<Position> lll = adminServiceImpl.queryForDistinctPositions();
//        for (Position p:lll
//             ) {
//            System.out.println(p.getSymbol()+"  "+p.getType());
//        }
//
//
//        Fundmanager f = adminServiceImpl.getFundManager(9999);
//        System.out.println("==========================================");
//        ModelAndView modelAndView = new ModelAndView();
//
//        // 添加数据
//        modelAndView.addObject("id",f.getId());
//        modelAndView.addObject("name",f.getName());
//        System.out.println(f.toString());
//        modelAndView.setViewName("test");
//        return modelAndView;
//    }

    public String test() {

        List<Portfolio> pfList = adminServiceImpl.getPortfolios();
        for (Portfolio p: pfList
        ) {
            p.setRate(p.getCurCash()/p.getInitCash());
        }

        adminServiceImpl.sortPortfolio(pfList);
        for (Portfolio p: pfList
        ) {
            System.out.println(p.getRate());
        }
        System.out.println("login1111111111111");
        return "login";
    }
    /*public ModelAndView test(){


        //adminServiceImpl.createInformationForPrice("bbbb","cccc",50.09,"USD",new Date());
        List<Information> lll = adminServiceImpl.getRecentPrice("FTSE","equities");
        for (Information i :lll
             ) {
            System.out.println(i.getSymbol()+"   ==="+i.getPrice()+"   "+i.getDate());
        }



        Fundmanager f = adminServiceImpl.getFundManager(9999);
        System.out.println("==========================================");
        ModelAndView modelAndView = new ModelAndView();

        // 添加数据
        modelAndView.addObject("id",f.getId());
        modelAndView.addObject("name",f.getName());
        System.out.println(f.toString());
        modelAndView.setViewName("test");
        return modelAndView;
>>>>>>> Stashed changes

    }
*/
    @RequestMapping("/getPortfolio/{id}")
    @ResponseBody
    public Portfolio getPortfolio (@PathVariable int id){
        Portfolio portfolio = fundmanagerServiceImpl.getPortfolio(id);
        return portfolio;

    }

    @RequestMapping("/getInformation/{productType}/{date}")
    @ResponseBody
    public String getProduct (@PathVariable String productType, @PathVariable String date){
        return null;

    }

    @RequestMapping("/deleteInformation/{infoId}")
    @ResponseBody
    public String deleteInformation(@PathVariable int infoId){
        informationServiceImpl.deleteInformation(infoId);
        return null;
    }


}
