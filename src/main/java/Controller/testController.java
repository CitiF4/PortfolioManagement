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
