package Controller;

import Model.Fundmanager;
import Model.Portfolio;
import Service.AdminService;
import Service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mandy on 2018/8/14.
 */

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    AdminService adminServiceImpl;

    @Autowired
    FundManagerService fundManagerServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginProcess(@RequestParam(value = "name", required = false) String name,@RequestParam(value = "type",required = false) String type,HttpSession httpSession) {
        System.out.println("i am login" + name + ";" + type);
        if (name == null) {
            return "login";
        } else {
            if (type.equals("admin") && adminServiceImpl.validateAdmin(name)) {
                System.out.println("this is a admin!!");
                httpSession.setAttribute("name",name);
                return "admin";
            } else if (type.equals("fundManager") && fundManagerServiceImpl.validateFm(name)) {
                System.out.println("this is a fm2!!");
                httpSession.setAttribute("name",name);
                return "fundManager";


            } else {
                return "login";
            }
        }
    }

    @RequestMapping("/getFundManager")
    @ResponseBody
    public  List<Map> loginProcessFm(){
        List<Fundmanager> fundmanagers = adminServiceImpl.getFundManagers();
        adminServiceImpl.getFmShowInfo(fundmanagers);
        List<Map> list = new ArrayList<Map>();

        for(Fundmanager fundmanager : fundmanagers){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("name",fundmanager.getName());
            map.put("curCash",fundmanager.getCurCash());
            map.put("value",fundmanager.getValue());
            map.put("rate",fundmanager.getRate());
            map.put("initCash",fundmanager.getInitCash());
            list.add(map);
        }

        return list;
    }

    @RequestMapping("/getPortfolios")
    @ResponseBody

    public  List<Map> loginProcessAd(HttpSession httpSession){

        String name = httpSession.getAttribute("name").toString();
        List<Portfolio> portfolios = fundManagerServiceImpl.getPortfoliosByName(name);
        fundManagerServiceImpl.getPortShowInfo(portfolios);
        List<Map> list = new ArrayList<Map>();

        for(Portfolio portfolio : portfolios){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id", portfolio.getId());
            map.put("name",portfolio.getName());
            map.put("curCash",portfolio.getCurCash());
            map.put("value",portfolio.getValue());
            map.put("rate",portfolio.getRate());
            map.put("initCash",portfolio.getInitCash());
            list.add(map);
        }

        return list;

    }

    @RequestMapping(value = "/toDetailPage",method = RequestMethod.POST)
    public String getDetail(@RequestParam("id") int id){
        System.out.println("Details" + id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("portfolios");
        modelAndView.addObject("id",id);
//        return modelAndView;
        return "portfolios";
    }
}
