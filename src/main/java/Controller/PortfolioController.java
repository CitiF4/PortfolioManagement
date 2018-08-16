package Controller;

import Model.Fxrate;
import Model.Information;
import Model.Portfolio;
import Model.Position;
import Service.AdminService;
import Service.FundManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.*;

@Controller
@SessionAttributes("name")
public class PortfolioController {


    @Autowired
    @Qualifier("fundmanagerServiceImpl")
    FundManagerService fundmanagerServiceImpl;

    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminServiceImpl;


    @RequestMapping(value = "/createPortfolio", method = RequestMethod.POST)
    @ResponseBody
    public List<Portfolio> createPortfolio(HttpServletRequest request, HttpSession httpSession){
        String name = request.getParameter("portfolioName");
        double cash = Double.parseDouble(request.getParameter("portfolioCash"));
        System.out.println("name " + name + " cash: " + cash);
        String fmName = httpSession.getAttribute("name").toString();
        int fmId = fundmanagerServiceImpl.getFundmanagerIdbyName(fmName);
        System.out.println(fmId);
        fundmanagerServiceImpl.createPortfolioByName(name,cash,fmId,new Date());
        List<Portfolio> portfolios = fundmanagerServiceImpl.getPortfolios(fmId);
        return portfolios;
    }


    @RequestMapping(value="/editPortfolio")
    @ResponseBody
    public Map<String,Object> editPortfolio(HttpServletRequest request){
        String name = request.getParameter("name");
        int pId = Integer.parseInt(request.getParameter("portfolioId"));
        fundmanagerServiceImpl.updatePortfolioById(pId,name);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("newName",name);
        return map;
    }


    @RequestMapping(value="/deletePortfolio")
    @ResponseBody
    public Map<String,Object> deletePortfolio(HttpServletRequest request, HttpSession httpSession){
        int pId = Integer.parseInt(request.getParameter("id"));
        fundmanagerServiceImpl.deletePortfolio(pId);
        String name = httpSession.getAttribute("name").toString();
        List<Portfolio> portfolios= fundmanagerServiceImpl.getPortfoliosByName(name);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",portfolios);
        return map;
    }

    @RequestMapping(value="/getPositions")
    @ResponseBody
    public Map<String,Object>getPositions(HttpServletRequest request){
        int pId = Integer.parseInt(request.getParameter("portfoliosId"));
        List<Position> list = fundmanagerServiceImpl.queryForPositions(pId);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value="/queryForDistinctPositions")
    @ResponseBody
    public Map<String,Object>queryForDistinctPositions(HttpServletRequest request){

        List<Position> list = adminServiceImpl.queryForDistinctPositions();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }

    @RequestMapping(value="/createInformationForPrice")
    public void createInformationForPrice(HttpServletRequest request){
        String symbol = request.getParameter("symbol");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        String ccy = request.getParameter("ccy");

        adminServiceImpl.createInformationForPrice(symbol,type,price,ccy,new Date());
    }

    @RequestMapping(value="/queryForDistinctFXrate")
    @ResponseBody
    public Map<String,Object> queryForDistinctFXrate(HttpServletRequest request){
        List<Fxrate> list = adminServiceImpl.queryForDistinctFXrate();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list",list);
        return map;
    }



    @RequestMapping(value = "/queryForPortfolioPosition")
    @ResponseBody
    public Map<String,Object> queryForPortfolioPosition(HttpServletRequest request){
        int i = Integer.parseInt(request.getParameter("portfolioID"));
        DecimalFormat df = new DecimalFormat("0.00%");
        double valueOfPositions = 0.0;
        Portfolio pf = fundmanagerServiceImpl.getPortfolio(i);
        List<Position> ps = fundmanagerServiceImpl.queryForPositions(i);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("portfolioName",pf.getName());
        map.put("initCash",pf.getCurCash());
        map.put("restCash",pf.getCurCash());

        for (Position pst: ps) {
            List<Information> infoList = adminServiceImpl.getRecentPrice(pst.getSymbol(),pst.getType());
            valueOfPositions+=pst.getQty()*infoList.get(0).getPrice();

           double value = pst.getValue();
           double curValue =pst.getQty()*infoList.get(0).getPrice();
           pst.setCurValue(curValue);
           pst.setProfit(curValue-value);
        }
        map.put("totalValue",valueOfPositions+pf.getCurCash());
        map.put("profit",valueOfPositions+pf.getCurCash()-pf.getCurCash());
        map.put("rateOfProfit",df.format((valueOfPositions+pf.getCurCash()-pf.getCurCash())/pf.getCurCash()));
        map.put("positions",ps);


        List<Information> randomInforms = adminServiceImpl.getRecentPrice(ps.get(0).getSymbol(),ps.get(0).getType());
        map.put("information",randomInforms);

        return  map;
    }


}
