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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.Port;
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


    @RequestMapping(value = "/createPortfolio")
    public void createPortfolio(HttpServletRequest request){

        String name = request.getParameter("portfolio_name");
        double cash = Double.parseDouble(request.getParameter("portfolio_cash"));
        int fmId= 1;
//        int fmId = Integer.parseInt((String)request.getSession().getAttribute("id"));

        fundmanagerServiceImpl.createPortfolioByName(name,cash,fmId,new Date());
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

    @RequestMapping(value="queryForDistinctPositionsAndFXrate")
    public Map<String,Object>queryForDistinctPositionsAndFXrate(HttpServletRequest request){

        List<Information> psList = adminServiceImpl.queryForDistinctPositions();
        List<Fxrate> fxList = adminServiceImpl.queryForDistinctFXrate();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("Position",psList);
        map.put("FXrate",fxList);
        return map;
    }

    @RequestMapping(value="/queryForDistinctPositions")
    @ResponseBody
    public Map<String,Object>queryForDistinctPositions(HttpServletRequest request){

        List<Information> list = adminServiceImpl.queryForDistinctPositions();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("Position",list);
        return map;
    }

    @RequestMapping(value="createInformationForPrice")
    public void createInformationForPrice(HttpServletRequest request){
        String symbol = request.getParameter("symbol");
        String type = request.getParameter("type");
        double price = Double.parseDouble(request.getParameter("price"));
        String ccy = request.getParameter("ccy");

        adminServiceImpl.createInformationForPrice(symbol,type,price,ccy,new Date());
    }

    @RequestMapping(value="queryForDistinctFXrate")
    @ResponseBody
    public Map<String,Object> queryForDistinctFXrate(HttpServletRequest request){
        List<Fxrate> list = adminServiceImpl.queryForDistinctFXrate();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("FXrate",list);
        return map;
    }



    @RequestMapping(value = "queryForPortfolioPosition")
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

    @RequestMapping(value = "sellProduct")
    public String sellProduct(HttpServletRequest request){
        int pID = Integer.parseInt(request.getParameter("portfolioID"));
        String symbol = request.getParameter("symbol");
        int sellQty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");

        Portfolio pf = fundmanagerServiceImpl.getPortfolio(pID);
        List<Information> infos = adminServiceImpl.getRecentPrice(symbol,type);
        List<Position> pslist= fundmanagerServiceImpl.getSamePositionsFromPortfolio(symbol,type,pID);
        int numberOfShares=0;
        for (Position ps:pslist
             ) {
            numberOfShares+=ps.getQty();
        }
        if(sellQty>numberOfShares){
            return "no";
        }else {
            while (sellQty>0){
                for (Position ps : pslist) {
                    if(sellQty>ps.getQty()){
                        sellQty = sellQty-ps.getQty();
                        pf.setCurCash(ps.getQty()*infos.get(0).getPrice()+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        fundmanagerServiceImpl.deletePosition(ps.getId());
                    }else if(sellQty==ps.getQty()){
                        sellQty = sellQty-ps.getQty();
                        pf.setCurCash(ps.getQty()*infos.get(0).getPrice()+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        fundmanagerServiceImpl.deletePosition(ps.getId());
                        break;
                    }else {
                        int restQty = ps.getQty()-sellQty;
                        ps.setQty(restQty);
                        ps.setValue(restQty*ps.getPrice());
                        ps.setProfit(restQty*(infos.get(0).getPrice()-ps.getPrice()));

                        fundmanagerServiceImpl.updatePosition(ps);

                        pf.setCurCash(sellQty*infos.get(0).getPrice()+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        sellQty=0;
                        break;
                    }

                }
            }
            return "yes";

        }

    }




    public Map<String,Object> fireFundManager(HttpServletRequest request){

        int fmId = Integer.parseInt(request.getParameter("id"));
        List<Portfolio> pfList = fundmanagerServiceImpl.getPortFolioByFundManagerID(fmId);
        adminServiceImpl.deleteFm(fmId);

        return null;
    }

    @RequestMapping(value = "buyProduct")
    public String buyProduct(HttpServletRequest request){
        String symbol = request.getParameter("symbol");
        int qty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");
        int pID = Integer.parseInt(request.getParameter("portfolioID"));

        double cash = fundmanagerServiceImpl.getPortfolio(pID).getCurCash();
        List<Information> infos = adminServiceImpl.getRecentPrice(symbol,type);
        double price = infos.get(0).getPrice();
        String ccy = infos.get(0).getCcy();

        double neededCash = price*qty;

        if (cash<neededCash){
            return "no";
        }else {
            Portfolio pf = fundmanagerServiceImpl.getPortfolio(pID);
            pf.setCurCash(cash-neededCash);
            Position ps = new Position();
            ps.setQty(qty);
            ps.setSymbol(symbol);
            ps.setPrice(price);
            ps.setCcy(ccy);
            ps.setType(type);
            ps.setPortfolioid(pID);
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            ps.setDate(currentDate);
            ps.setValue(qty*price);
            ps.setProfit(0);
            fundmanagerServiceImpl.createPositionWithoutID(ps);
            return "yes";
        }
    }





    /*private boolean purchaseJudge(double cash,int qty,String symbol,String type){
        double neededCash = adminServiceImpl.getRecentPrice(symbol,type).get(0).getPrice()*qty;
        if (cash>=neededCash){
            return true;
        }else {
            return false;
        }
    }*/
}
