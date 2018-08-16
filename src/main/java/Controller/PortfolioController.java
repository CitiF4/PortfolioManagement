package Controller;

import Model.*;
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


    @RequestMapping(value = "/createFundmanager", method = RequestMethod.POST)
    @ResponseBody
    public List<Map> createFundmanager(HttpServletRequest request){
        String name = request.getParameter("name");

        adminServiceImpl.createFundManagerByName(name);
        int fmId = fundmanagerServiceImpl.getFundmanagerIdbyName(name);
        Fundmanager fm = new Fundmanager(fmId,name);
        List<Fundmanager> fmlist = new ArrayList<Fundmanager>();
        fmlist.add(fm);
        adminServiceImpl.getFmShowInfo(fmlist);
        List<Map> resultlist = new ArrayList<Map>();
        for(Fundmanager fundmanager : fmlist){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("name",fundmanager.getName());
            map.put("curCash",fundmanager.getCurCash());
            map.put("value",fundmanager.getValue());
            map.put("rate",fundmanager.getRate());
            map.put("initCash",fundmanager.getInitCash());
            resultlist.add(map);
        }
        return resultlist;

    }

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
        map.put("FXrate",list);
        return map;
    }

    //买入position
    @RequestMapping(value = "buyProduct")
    @ResponseBody
    public Map<String, Object> buyProduct(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        String symbol = request.getParameter("symbol");
        int qty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");
        int pID = Integer.parseInt(request.getParameter("portfolioId"));
        double cash = fundmanagerServiceImpl.getPortfolio(pID).getCurCash();
        List<Information> infos = adminServiceImpl.getRecentPrice(symbol,type);
        double price = infos.get(0).getPrice();
        String ccy = infos.get(0).getCcy();

        List<Information> infoList = adminServiceImpl.getRecentPrice(symbol,type);
        if(infoList.size()>0){
            ccy = infoList.get(0).getCcy();
        }
        List<Fxrate> fxrateList = adminServiceImpl.getRateForSpecifiedCCY(ccy);

        //若无相应币种记录，默认为1
        double rate = 1.0;
        if (fxrateList.size()>0){
            rate = fxrateList.get(0).getRate();
        }

        double neededCash = price*qty*rate;

        if (cash<neededCash){
            return map;
        }else {
            Portfolio pf = fundmanagerServiceImpl.getPortfolio(pID);
            pf.setCurCash(cash-neededCash);
            fundmanagerServiceImpl.updatePortfolio(pf);
            Position ps = new Position();
            ps.setQty(qty);
            ps.setSymbol(symbol);
            ps.setPrice(price);
            ps.setCcy(ccy);
            ps.setType(type);
            ps.setPortfolioid(pID);
            java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
            ps.setDate(currentDate);
            ps.setValue(qty*price*rate);
            ps.setProfit(0);
            fundmanagerServiceImpl.createPositionWithoutID(ps);
            map = queryForPortfolioPosition_InnerMethod(pID);
            return map;
        }
    }




    @RequestMapping(value = "/queryForPortfolioPosition/{id}")
    @ResponseBody
    public Map<String,Object> queryForPortfolioPosition(@PathVariable("id") int id){
        DecimalFormat df = new DecimalFormat("0.00%");
        double valueOfPositions = 0.0;
        Portfolio pf = fundmanagerServiceImpl.getPortfolio(id);
        List<Position> ps = fundmanagerServiceImpl.queryForPositions(id);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("portfolioName",pf.getName());
        map.put("initCash",pf.getInitCash());
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
        map.put("id",pf.getId());


        List<Information> randomInforms = adminServiceImpl.getRecentPrice(ps.get(0).getSymbol(),ps.get(0).getType());
        map.put("information",randomInforms);

        return  map;
    }
    //供内部使用
    public Map<String,Object> queryForPortfolioPosition_InnerMethod(int portfolioID){

        DecimalFormat df = new DecimalFormat("0.00%");
        double valueOfPositions = 0.0;
        Portfolio pf = fundmanagerServiceImpl.getPortfolio(portfolioID);
        List<Position> ps = fundmanagerServiceImpl.queryForPositions(portfolioID);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("portfolioName",pf.getName());
        map.put("initCash",pf.getInitCash());
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

    //卖出position
    @RequestMapping(value = "sellProduct")
    @ResponseBody
    public Object sellProduct(HttpServletRequest request){
        int pID = Integer.parseInt(request.getParameter("portfolioId"));
        String symbol = request.getParameter("symbol");
        int sellQty = Integer.parseInt(request.getParameter("qty"));
        String type = request.getParameter("type");

        String ccy = "";
        List<Information> infoList = adminServiceImpl.getRecentPrice(symbol,type);
        if(infoList.size()>0){
            ccy = infoList.get(0).getCcy();
        }
        List<Fxrate> fxrateList = adminServiceImpl.getRateForSpecifiedCCY(ccy);

        //若无相应币种记录，默认为1
        double rate = 1.0;
        if (fxrateList.size()>0){
            rate = fxrateList.get(0).getRate();
        }


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
                        pf.setCurCash(ps.getQty()*infos.get(0).getPrice()*rate+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        fundmanagerServiceImpl.deletePosition(ps.getId());
                    }else if(sellQty==ps.getQty()){
                        sellQty = sellQty-ps.getQty();
                        pf.setCurCash(ps.getQty()*infos.get(0).getPrice()*rate+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        fundmanagerServiceImpl.deletePosition(ps.getId());
                        sellQty = 0;
                        break;
                    }else {
                        int restQty = ps.getQty()-sellQty;
                        ps.setQty(restQty);
                        ps.setValue(restQty*ps.getPrice()*rate);
                        ps.setProfit(restQty*(infos.get(0).getPrice()-ps.getPrice())*rate);

                        fundmanagerServiceImpl.updatePosition(ps);

                        pf.setCurCash(sellQty*infos.get(0).getPrice()*rate+pf.getCurCash());
                        fundmanagerServiceImpl.updatePortfolio(pf);
                        sellQty=0;
                        break;
                    }

                }
            }
            Map<String,Object> map = new HashMap<String, Object>();
            map = queryForPortfolioPosition_InnerMethod(pID);
            return map;
        }

    }

   // admin 生成报告
    @RequestMapping(value = "generateReport")
    @ResponseBody
    public Map<String,Object> generateReport(HttpServletRequest request){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++=");
        List<Portfolio> pfList = adminServiceImpl.getPortfolios();

        //将所有position中所有的剩余价值取出来相加得总价值
        for (Portfolio pf: pfList) {
            double valueInPositions=0.0;
            List<Position> psList = fundmanagerServiceImpl.queryForPositions(pf.getId());
            for(Position ps:psList){
                valueInPositions+=ps.getValue()+ps.getProfit();
            }
            pf.setCurCash(pf.getCurCash()+valueInPositions);
        }


        for (Portfolio pf: pfList
        ) {
            pf.setRate(pf.getCurCash()/pf.getInitCash());
        }

        adminServiceImpl.sortPortfolio(pfList);

        Portfolio bestPortfolio = pfList.get(0);
        Portfolio worstPortfolio = pfList.get(pfList.size()-1);

        Fundmanager bestFM = adminServiceImpl.getFundmanager(bestPortfolio);
        Fundmanager worstFM = adminServiceImpl.getFundmanager(worstPortfolio);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("bestPortfolioName",bestPortfolio.getName());
        map.put("worstPortfolioName",worstPortfolio.getName());
        map.put("itsBestFundManagerName",bestFM.getName());
        map.put("itsWorstFundManagerName",worstFM.getName());

        return map;
    }

    @RequestMapping(value = "getRecentPrice")
    @ResponseBody
    public Map<String,Object> getREecentPrice(HttpServletRequest request){
        String symbol = request.getParameter("symbol");
        String type = request.getParameter("type");
        List<Information> infos = adminServiceImpl.getRecentPrice(symbol,type);

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("recentPrice",infos);
        return  map;
    }

    // admin删除FM
    @RequestMapping(value = "fireFundManager")
    public void fireFundManager(HttpServletRequest request) {


        int fmId = Integer.parseInt(request.getParameter("id"));
        List<Portfolio> pfList = fundmanagerServiceImpl.getPortFolioByFundManagerID(fmId);
        adminServiceImpl.deleteFm(fmId);

        //将所有position中所有的剩余价值取出来相加得总价值
        for (Portfolio pf : pfList
                ) {
            double valueInPosition = 0.0;
            List<Position> psList = fundmanagerServiceImpl.queryForPositions(pf.getId());
            for (Position ps : psList) {
                valueInPosition += ps.getValue() + ps.getProfit();
            }
            pf.setCurCash(pf.getCurCash()+valueInPosition);
        }
        for (Portfolio pf : pfList
                    ) {
                pf.setRate(pf.getCurCash() / pf.getInitCash());
            }

            adminServiceImpl.sortPortfolio(pfList);

            //赚钱比率最高的portfolio
            Portfolio pf = pfList.get(0);

            for (Portfolio p : pfList
                    ) {
                p.setFmid(pf.getFmid());
                adminServiceImpl.updatePortfolioFmId(p);
            }
    }






    @RequestMapping("/getSymbols")
    @ResponseBody
    public Map<String,Set> getSymbols(@RequestParam("type") String type){
        Map<String,Set> map = new HashMap<String, Set>();
        Set<String> set = fundmanagerServiceImpl.getSymbolsByType(type);
        map.put("symbol",set);
        return map;
    }




}
