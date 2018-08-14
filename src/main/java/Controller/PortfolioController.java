package Controller;

import Model.Portfolio;
import Model.Position;
import Service.AdminService;
import Service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class PortfolioController {


    @Autowired
    @Qualifier("fundmanagerServiceImpl")
    FundManagerService fundmanagerServiceImpl;

    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminServiceImpl;


    @RequestMapping(value = "/createPortfolio")
    public void createPortfolio(HttpServletRequest request){

        String name = request.getParameter("portfolio_name");
        double cash = Double.parseDouble(request.getParameter("portfolio_cash"));
        int fmId= 1;
//        int fmId = Integer.parseInt((String)request.getSession().getAttribute("id"));

        fundmanagerServiceImpl.createPortfolioByName(name,cash,fmId,new Date());
    }


    @RequestMapping(value="editPortfolio")
    public Map<String,Object> editPortfolio(HttpServletRequest request){
        String name = request.getParameter("name");
        int pId = Integer.parseInt(request.getParameter("portfolioId"));
        fundmanagerServiceImpl.updatePortfolioById(pId,name);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("newName",name);
        return map;
    }


    @RequestMapping(value="deletePortfolio")
    public Map<String,Object> deletePortfolio(HttpServletRequest request){
        int pId = Integer.parseInt(request.getParameter("id"));
        fundmanagerServiceImpl.deletePortfolio(pId);
        List<Portfolio> list= fundmanagerServiceImpl.getPortfolios();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value="getPositions")
    public Map<String,Object>getPositions(HttpServletRequest request){
        int pId = Integer.parseInt(request.getParameter("portfoliosId"));
        List<Position> list = fundmanagerServiceImpl.queryForPositions(pId);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value="queryForDistinctPositions")
    public Map<String,Object>queryForDistinctPositions(HttpServletRequest request){

        List<Position> list = adminServiceImpl.queryForDistinctPositions();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }




}
