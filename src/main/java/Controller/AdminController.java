package Controller;

import Dao.AdminMapper;
import Dao.PositionMapper;
import Model.Fundmanager;
import Model.Portfolio;
import Model.Position;
import Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mandy on 2018/8/15.
 */

@Controller
@SessionAttributes("name")
public class AdminController {

    @Autowired
    @Qualifier("adminServiceImpl")
    AdminService adminServiceImpl;

    @RequestMapping(value = "/admin/createReport", method = RequestMethod.GET)
    @ResponseBody
    public List<Map> createReport(){
        List<Map> list = new ArrayList<Map>();
        List<Portfolio> portfolios = adminServiceImpl.setPortfolioRate();
        adminServiceImpl.sortPortfolio(portfolios);
        Portfolio bestPortfolio = portfolios.get(0);
        Portfolio worstPortfolio = portfolios.get(portfolios.size());
        Fundmanager itsBestFundmanager = adminServiceImpl.getFundmanager(bestPortfolio);
        Fundmanager itsWorstFundmanager = adminServiceImpl.getFundmanager(bestPortfolio);
        List<Portfolio> retPortfolio = new ArrayList<Portfolio>();
        retPortfolio.add(bestPortfolio);
        retPortfolio.add(worstPortfolio);
        for(int i = 0; i < retPortfolio.size(); i++){

            Map<String,Object> map = new HashMap<String, Object>();
            map.put("name", retPortfolio.get(i).getName());
            map.put("curCash", retPortfolio.get(i).getCurCash());
            map.put("initCash",retPortfolio.get(i).getInitCash());
            map.put("value", retPortfolio.get(i).getValue());
            map.put("rate", retPortfolio.get(i).getRate());
            if(i == 0){
                map.put("portfolioName", itsBestFundmanager.getName());
            }else{
                map.put("portfolioName", itsWorstFundmanager.getName());
            }
            list.add(map);

        }
        return list;

    }
}
